//package firebase.demo.controller;
////
////import firebase.demo.service.AuthService;
////import firebase.demo.Auth;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////
////import java.util.concurrent.ExecutionException;
////
////
////@RestController
////public class Controller {
////    public AuthService service;
////
////    @Autowired
////    public Controller(AuthService service){
////        this.service=service;
////    }
////
////    @PostMapping("/create")
////    public String createAuth(@RequestBody Auth auth) throws  InterruptedException, ExecutionException{
////        return service.createAuth(auth);
////    }
////    @GetMapping("/get")
////    public Auth getAuth(@RequestParam String documentId) throws  InterruptedException, ExecutionException{
////        return service.getAuth(documentId);
////    }
////    @PutMapping("/update")
////    public String updateAuth(@RequestBody Auth auth) throws  InterruptedException, ExecutionException{
////        return service.updateAuth(auth);
////    }
////    @PutMapping("/delete")
////    public String deleteAuth(@RequestParam String documentId) throws  InterruptedException, ExecutionException{
////        return service.deleteAuth(documentId);
////    }
////    @GetMapping("/test")
////    public ResponseEntity<String> testGetEndpoint(){
////        return ResponseEntity.ok("Test get endpoint is working");
////    }
////}
//
//
//import firebase.demo.service.ContactService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping(path = "/contact")
//public class ContactController {
//
//    private final ContactService contactService;
//
//    @PostMapping(path = "/request")
//    public void submitContactRequest(
//            @RequestParam("subject") String subject,
//            @RequestParam("description") String description,
//            @RequestBody MultipartFile file) {
//        contactService.submitContactRequest(subject, description, file);
//    }
//
//}