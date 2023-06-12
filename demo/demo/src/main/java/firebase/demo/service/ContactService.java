//package firebase.demo.service;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.io.IOException;
//
//@Service
//public class ContactService {
//
//    private final GmailApiService gmailAPIService;
//
//    public ContactService(GmailApiService gmailAPIService) {
//        this.gmailAPIService = gmailAPIService;
//    }
//
//    public void submitContactRequest(
//            String subject,
//            String description,
//            MultipartFile file) {
//
//        try {
//
//            gmailAPIService.sendMessage(
//                    subject,
//                    description,
//                    file
//            );
//
//        } catch (IOException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
//                    "Not able to process request.");
//        }
//
//    }
//
//}