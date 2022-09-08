package platform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import platform.services.CodeService;

@Controller
public class WebController {

    private final CodeService codeService;

    public WebController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/code")
    public String code(Model model) {
        model.addAttribute("code", codeService.getCode());
        return "code";
    }

    @GetMapping("/code/new")
    public String codeNew() {
        return "new";
    }
}
