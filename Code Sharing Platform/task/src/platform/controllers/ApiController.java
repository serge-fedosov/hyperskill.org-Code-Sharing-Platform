package platform.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/code")
    public Map<String, String> code() {
        Map<String, String> response = new HashMap<>();
        response.put("code", "public static void main(String[] args) {\r\n" +
                "    SpringApplication.run(CodeSharingPlatform.class, args);\r\n" +
                "}");
        return response;
    }
}
