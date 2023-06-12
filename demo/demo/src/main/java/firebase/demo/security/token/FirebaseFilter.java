package firebase.demo.security.token;

import firebase.demo.security.model.TokenModel;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class FirebaseFilter extends OncePerRequestFilter {

    private static final Logger logger= LoggerFactory.getLogger(FirebaseFilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        try {
            String token = getToken((HttpServletResponse) req);
            if (token != null) SecurityContextHolder.getContext().setAuthentication(new TokenModel(token));
        }catch (Exception e){
            logger.error("Fail in do filter:", e.getMessage());
        }
        chain.doFilter(req,res);
    }
    private String getToken(HttpServletResponse request){
        String header = request.getHeader("Authorization");
        if(header!=null && header.startsWith("Bearer ")) return header.replace("Bearer ", "");
        return  null;
    }
}
