package platform.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import platform.dto.CodeDTO;
import platform.models.Code;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CodeService {

    private final ModelMapper modelMapper;
    private static int count = 0;
    private final static ArrayList<Code> codes = new ArrayList<>();

    public CodeService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CodeDTO getCode(int id) {
        return modelMapper.map(codes.get(id - 1), CodeDTO.class);
    }

    public void setCode(Code code) {
        count++;

        code.setId(count);
        code.setDate(LocalDateTime.now());
        codes.add(code);
    }

    public List<CodeDTO> getLatest() {
        List<CodeDTO> result = new ArrayList<>();

        int count = 0;
        for (int i = codes.size(); i > 0 && count < 10; i--, count++) {
            result.add(modelMapper.map(codes.get(i - 1), CodeDTO.class));
        }

        return result;
    }
}
