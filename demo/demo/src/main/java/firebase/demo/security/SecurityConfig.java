package firebase.demo.security;

import firebase.demo.security.token.FirebaseEntryPoint;
import firebase.demo.security.token.FirebaseFilter;
import firebase.demo.security.token.FirebaseProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@Configuration
public class SecurityConfig{

    FirebaseEntryPoint entryPoint;

    @Autowired
    FirebaseProvider provider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeRequests().anyRequest().authenticated();
        http.exceptionHandling().authenticationEntryPoint(entryPoint);
        http.addFilterBefore(new FirebaseFilter(), BasicAuthenticationFilter.class);
        http.authenticationProvider(provider);
        return http.build();
    }
}