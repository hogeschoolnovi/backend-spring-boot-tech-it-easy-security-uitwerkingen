package nl.novi.techiteasy1121.config;

import nl.novi.techiteasy1121.filter.JwtRequestFilter;
import nl.novi.techiteasy1121.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/*  Deze security is niet de enige manier om het te doen.
    In de andere branch van deze github repo staat een ander voorbeeld
 */
@Configuration
//@EnableWebSecurity
public class SpringSecurityConfig {

    public final CustomUserDetailsService customUserDetailsService;

    private final JwtRequestFilter jwtRequestFilter;

    public SpringSecurityConfig(CustomUserDetailsService customUserDetailsService, JwtRequestFilter jwtRequestFilter) {
        this.customUserDetailsService = customUserDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    // PasswordEncoderBean. Deze kun je overal in je applicatie injecteren waar nodig.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    // Authenticatie met customUserDetailsService en passwordEncoder
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }



    // Authorizatie met jwt
    @Bean
    protected SecurityFilterChain filter (HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .httpBasic().disable()
                .authorizeRequests()
                // Wanneer je deze uncomments, staat je hele security open. Je hebt dan alleen nog een jwt nodig.
//                .antMatchers("/**").permitAll()
                .antMatchers(HttpMethod.POST, "/users").permitAll()
                .antMatchers(HttpMethod.GET,"/users").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/cimodules").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/cimodules/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/remotecontrollers").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/remotecontrollers/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/televisions").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/televisions/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/wallbrackets").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/wallbrackets/**").hasRole("ADMIN")
                // Je mag meerdere paths tegelijk definieren
                .antMatchers("/cimodules", "/remotecontrollers", "/televisions", "/wallbrackets").hasAnyRole("ADMIN", "USER")
                .antMatchers("/authenticated").authenticated()
                .antMatchers("/authenticate").permitAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}