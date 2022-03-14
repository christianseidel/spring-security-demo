package de.neuefische.securitydemo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admingreet")
public class SecondGreetingController {

    @GetMapping
    public String adminGreeting() {
        return "Hallo Admin";
    }

}
