package firebase.demo.security.model;

import javax.annotation.Nullable;

public record Credential(
        @Nullable
        String client_id,
        @Nullable
        String client_secret,
        @Nullable
        String refresh_token,
        @Nullable
        String grant_type,
        @Nullable
        String access_token,
        @Nullable
        String userEmail
) {

}