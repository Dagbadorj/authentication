package firebase.demo.controller;


import firebase.demo.dto.MessageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/hi")
    public ResponseEntity<MessageDto> getAns(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(new MessageDto("Hello mr."+username+". How is your day sir!"));
    }
}
