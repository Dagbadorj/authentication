//package firebase.demo.controller;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseAuthException;
//import com.google.firebase.auth.FirebaseToken;
//import firebase.demo.service.AuthService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
////@RestController
////@RequestMapping("/auth")
//public class AuthController {
//
//    public AuthService service;
//
//    @GetMapping("/google")
//    public String googleLogin(String idToken) {
//        try {
//            FirebaseToken token = FirebaseAuth.getInstance().verifyIdToken(idToken);
//            String uid = token.getUid();
//            // Perform additional logic with the authenticated user
//            return "Successfully authenticated with Google";
//
//        } catch (FirebaseAuthException e) {
//            e.printStackTrace();
//            return "Google authentication failed";
//        }
//    }
//
//    // Other authentication endpoints and logic
//
//}
