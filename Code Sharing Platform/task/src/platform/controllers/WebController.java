package platform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import platform.services.CodeService;

@Controller
public class WebController {

    private final CodeService codeService;

    public WebController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/code/{id}")
    public String code(@PathVariable int id, Model model) {
        model.addAttribute("code", codeService.getCode(id));
        return "code";
    }

    @GetMapping("/code/latest")
    public String codeLatest(Model model) {
        model.addAttribute("codes", codeService.getLatest());
        return "codes";
    }

    @GetMapping("/code/new")
    public String codeNew() {
        return "new";
    }
}
