package firebase.demo.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import firebase.demo.Auth;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class AuthService {
    public String createAuth(Auth auth) throws ExecutionException, InterruptedException {
        Firestore dbFirestore= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("auth_user").document(auth.getDocumentId()).set(auth);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
    public Auth getAuth(String documentId)throws  ExecutionException, InterruptedException {
        Firestore dbFirestore= FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("auth_user").document(documentId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Auth auth;
        if(document.exists()){
            auth = document.toObject(Auth.class);
            return auth;
        }
        return null;
    }
    public String updateAuth(Auth auth)throws  ExecutionException, InterruptedException{
        Firestore dbFirestore= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("auth_user").document(auth.getName()).set(auth);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
    public String deleteAuth(String documentId)throws  ExecutionException, InterruptedException{
        Firestore dbFirestore= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("auth_user").document(documentId).delete();
        return "Successfully deleted "+ documentId;
    }
}
