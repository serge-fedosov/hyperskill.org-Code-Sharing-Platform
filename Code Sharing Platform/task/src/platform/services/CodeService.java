package platform.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import platform.dto.CodeDTO;
import platform.models.Code;
import platform.repositories.CodeRepository;
import platform.util.NotFoundException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class CodeService {

    private final CodeRepository codeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CodeService(CodeRepository codeRepository, ModelMapper modelMapper) {
        this.codeRepository = codeRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public Code loadCode(String uuid) {
        Optional<Code> optionalCode = codeRepository.findByUuid(uuid);

        if (optionalCode.isEmpty()) {
            throw new NotFoundException("Not found");
        }

        Code code = optionalCode.get();

        if (code.isRestrictions()) {
            int views = code.getViews();

            if (views > 0) {
                views--;
                code.setViews(views);

                if (views == 0) {
                    codeRepository.delete(code);
                }
            }

            int time = code.getTime();
            if (time > 0) {
                LocalDateTime dateFrom = code.getDateFrom();
                LocalDateTime dateNow = LocalDateTime.now();
                long differ = ChronoUnit.SECONDS.between(dateFrom, dateNow);
                int newTime = time - (int) differ;
                code.setDateFrom(dateNow);
                code.setTime(newTime);

                if (newTime < 1) {
                    codeRepository.delete(code);
                    codeRepository.flush();
                    throw new NotFoundException("Not found");
                }
            }
        }

        return code;
    }

    @Transactional
    public void saveCode(Code code) {
        code.setDate(LocalDateTime.now());
        code.setDateFrom(LocalDateTime.now());
        code.setUuid(UUID.randomUUID().toString());
        code.setRestrictions(code.getViews() > 0 || code.getTime() > 0);
        code.setViewsRestriction(code.getViews() > 0);
        code.setTimeRestriction(code.getTime() > 0);
        codeRepository.save(code);
    }

    public List<CodeDTO> loadLatest() {
        return codeRepository.findTop10ByTimeRestrictionFalseAndViewsRestrictionFalseOrderByIdDesc().stream().map(code -> modelMapper.map(code, CodeDTO.class)).collect(Collectors.toList());
    }
}
