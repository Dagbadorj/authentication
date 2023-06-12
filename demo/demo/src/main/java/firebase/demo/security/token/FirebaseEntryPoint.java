package firebase.demo.security.token;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.slf4j.Logger;

import java.io.IOException;

public class FirebaseEntryPoint implements AuthenticationEntryPoint {

    private static final Logger logger= LoggerFactory.getLogger(FirebaseEntryPoint.class);
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse res, AuthenticationException authException) throws IOException, ServletException {
        logger.error("fail in commence");
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "unauthorized 401");
    }
}
