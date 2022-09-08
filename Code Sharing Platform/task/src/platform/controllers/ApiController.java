package platform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import platform.models.Code;
import platform.services.CodeService;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final CodeService codeService;

    @Autowired
    public ApiController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/code")
    public Code getCode() {
        return codeService.getCode();
    }

    @PostMapping("/code/new")
    public String postCode(@RequestBody Code code) {
        codeService.setCode(code);
        return "{}";
    }
}
