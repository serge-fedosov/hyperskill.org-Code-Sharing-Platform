package platform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import platform.services.CodeService;

@Controller
public class WebController {

    private final CodeService codeService;

    @Autowired
    public WebController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/code/{uuid}")
    public String loadCode(@PathVariable String uuid, Model model) {
        model.addAttribute("code", codeService.loadCode(uuid));
        return "code";
    }

    @GetMapping("/code/latest")
    public String loadLatest(Model model) {
        model.addAttribute("codes", codeService.loadLatest());
        return "codes";
    }

    @GetMapping("/code/new")
    public String saveCode() {
        return "new";
    }
}
