package platform.controllers;

import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    @Autowired
    public ApiController(CodeService codeService, ModelMapper modelMapper) {
        this.codeService = codeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/code/{uuid}")
    public CodeDTO loadCode(@PathVariable String uuid) {
        return modelMapper.map(codeService.loadCode(uuid), CodeDTO.class);
    }

    @GetMapping("/code/latest")
    public List<CodeDTO> loadLatest() {
        return codeService.loadLatest();
    }

    @PostMapping("/code/new")
    public Map<String, String> saveCode(@RequestBody Code code) {
        codeService.saveCode(code);
        return Map.of("id", String.valueOf(code.getUuid()));
    }
}
