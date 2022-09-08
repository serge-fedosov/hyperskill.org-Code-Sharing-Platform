package platform.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import platform.dto.CodeDTO;
import platform.models.Code;
import platform.repositories.CodeRepository;
import platform.util.CodeNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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

    public CodeDTO getCode(int id) {
        Optional<Code> code = codeRepository.findById(id);

        if (code.isEmpty()) {
            throw new CodeNotFoundException();
        }

        return modelMapper.map(code.get(), CodeDTO.class);
    }

    @Transactional
    public void setCode(Code code) {
        code.setDate(LocalDateTime.now());
        codeRepository.save(code);
    }

    public List<CodeDTO> getLatest() {
        return codeRepository.findTop10ByOrderByIdDesc().stream().map(code -> modelMapper.map(code, CodeDTO.class)).collect(Collectors.toList());
    }
}
