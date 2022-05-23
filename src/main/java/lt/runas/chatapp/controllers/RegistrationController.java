package lt.runas.chatapp.controllers;

import lt.runas.chatapp.models.User;
import lt.runas.chatapp.services.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public String register (@RequestBody User user){
        registrationService.registerUser(user);
        return null;
    }
}
