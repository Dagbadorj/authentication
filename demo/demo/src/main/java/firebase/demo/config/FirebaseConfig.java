package firebase.demo.config;


import com.google.firebase.FirebaseApp;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseOptions;
import firebase.demo.DemoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;


@Configuration
public class FirebaseConfig {
    private static final Logger logger= LoggerFactory.getLogger(FirebaseConfig.class);

    @Value("${firebase.config.path}")
    private String configPath;

    @PostConstruct
    public void init() throws IOException {
        ClassLoader classloader = DemoApplication.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classloader.getResource("serviceAccountKey.json")).getFile());
        FileInputStream serviceAccount;
        serviceAccount = new FileInputStream(file.getAbsolutePath());
        FirebaseOptions options;
        options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://socialauth-c58df-default-rtdb.firebaseio.com/")
                .build();

        FirebaseApp.initializeApp(options);
        logger.info("App name: {}", FirebaseApp.getInstance().getName());
    }
}
