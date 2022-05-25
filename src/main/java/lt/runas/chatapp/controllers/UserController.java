package lt.runas.chatapp.controllers;

import lt.runas.chatapp.dto.ConversationResponse;
import lt.runas.chatapp.models.Conversation;
import lt.runas.chatapp.models.User;
import lt.runas.chatapp.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register (@RequestBody User user){
        userService.registerUser(user);
        return new ResponseEntity<>("User Registration Successful", OK);
    }

    //PostMapping???
    @GetMapping("/conversations/new/{contactUsername}")
    public ResponseEntity<Void> newConversation (@PathVariable String contactUsername){
        userService.startNewConversation(contactUsername);
        return new ResponseEntity<>(CREATED);
    }

    @GetMapping("/conversations")
    public ResponseEntity<List<ConversationResponse>> getConversationsList (){
        return ResponseEntity.status(OK)
                .body(userService.getConversationsList());
    }

}
