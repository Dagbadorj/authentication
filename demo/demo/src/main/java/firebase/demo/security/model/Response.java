package firebase.demo.security.model;

import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.util.Key;

public class Response extends TokenResponse {

    @Key("expires_in")
    private Integer expiresInSeconds;
}