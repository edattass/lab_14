package org.aeh.lab13.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // BCRYPT KULLANILIYOR
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/register", "/login").permitAll() // HERKES ERİŞEBİLİR
                        .anyRequest().authenticated() // DİĞER TÜM İSTEKLER İÇİN GİRİŞ GEREKİYOR
                )
                .formLogin(login -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/", true) // GİRİŞ BAŞARILI OLURSA ANASAYFAYA YÖNLENDİR
                        .failureUrl("/login?error=true") // HATA OLURSA GİRİŞ SAYFASINA GERİ DÖN
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true") // ÇIKIŞ YAPILINCA GİRİŞ SAYFASINA YÖNLENDİR
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                );

        return http.build();
    }
}
