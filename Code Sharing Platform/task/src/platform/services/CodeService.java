package platform.services;

import org.springframework.stereotype.Service;
import platform.models.Code;

import java.time.LocalDateTime;

@Service
public class CodeService {

    private static Code code = new Code("test", LocalDateTime.now());

    public Code getCode() {
        return CodeService.code;
    }

    public void setCode(Code code) {
        code.setDate(LocalDateTime.now());
        CodeService.code = code;
    }
}
