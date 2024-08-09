package ru.netology.sqlhibernatesecurity.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    private final PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    private final User.UserBuilder userBuilder = User.builder().passwordEncoder(encoder::encode);

    @Bean
    UserDetailsService userAuthentication() {
        UserDetails admin = userBuilder.username("admin").password("qwerty").authorities("READ", "WRITE", "DELETE").build();
        UserDetails user = userBuilder.username("user").password("12345").authorities("WRITE").build();
        UserDetails guest = userBuilder.username("guest").password("123").authorities("READ").build();

        return new InMemoryUserDetailsManager(admin, user, guest);
    }

    @Bean
    public SecurityFilterChain filters(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/persons/by-name").permitAll()
                        .requestMatchers("/persons/by-city").hasAuthority("WRITE")
                        .requestMatchers("/persons/by-age").hasAuthority("READ")
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults())
                .formLogin(withDefaults());

        return http.build();
    }
}