package firebase.demo.security.model;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class TokenModel extends AbstractAuthenticationToken {
    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public TokenModel(String token) {
        super(null);
        this.token=token;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    public String getToken() {
        return token;
    }
}
