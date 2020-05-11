package com.greenfoxacademy.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
    private UserDetailsService userDetailsService;
    private JwtRequestFilter jwtRequestFilter;
    private AccessDeniedHandler accessDeniedHandler;
    private static final String ENVIRONMENT = System.getenv("ENVIRONMENT");

    @Autowired
    public SecurityConfigurer(@Qualifier("my") UserDetailsService userDetailsService, JwtRequestFilter jwtRequestFilter, AccessDeniedHandler accessDeniedHandler) {
        this.userDetailsService = userDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
        this.accessDeniedHandler = accessDeniedHandler;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        if (ENVIRONMENT.equals("Test")) {
            auth.inMemoryAuthentication()
                    .withUser("admin")
                    .password("111")
                    .roles("ADMIN")
                    .and()
                    .withUser("user")
                    .password("222")
                    .roles("USER");
        } else if (ENVIRONMENT.equals("Production")) {
            auth.userDetailsService(userDetailsService);
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /*@Autowired
    public void setUserDetailsService(@Qualifier("my") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void setJwtRequestFilter(JwtRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/welcome").hasRole("ADMIN")
                .antMatchers( "/api/recipe").hasAnyRole("USER", "ADMIN")
                .antMatchers("/authenticate").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
