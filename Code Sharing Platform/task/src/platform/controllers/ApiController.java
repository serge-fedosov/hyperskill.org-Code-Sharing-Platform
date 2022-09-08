package platform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import platform.dto.CodeDTO;
import platform.models.Code;
import platform.services.CodeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final CodeService codeService;

    @Autowired
    public ApiController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/code/{id}")
    public CodeDTO getCode(@PathVariable int id) {
        return codeService.getCode(id);
    }

    @GetMapping("/code/latest")
    public List<CodeDTO> getLatest() {
        return codeService.getLatest();
    }

    @PostMapping("/code/new")
    public Map<String, String> postCode(@RequestBody Code code) {
        codeService.setCode(code);

        Map<String, String> response = Map.of("id", String.valueOf(code.getId()));

        return response;
    }
}
