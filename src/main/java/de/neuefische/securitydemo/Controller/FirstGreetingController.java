package de.neuefische.securitydemo.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class FirstGreetingController {

    @GetMapping("/api/greet")
    public String basicGreeting() {
        return "Hi, was geht!";
    }

}
