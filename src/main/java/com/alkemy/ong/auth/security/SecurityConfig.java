package com.alkemy.ong.auth.security;

import com.alkemy.ong.auth.jwt.JwtRequestFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtRequestFilter jwtFilter;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new CustomAuthenticationEntryPoint();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .cors()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth/login")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/auth/register")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/auth/me")
                .hasRole(RoleType.USER.name())
                .antMatchers(HttpMethod.GET, "/organization/public")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/organization/public")
                .hasRole(RoleType.ADMIN.name())
                .antMatchers(HttpMethod.POST, "/contacts")
                .hasRole(RoleType.ADMIN.name())
                .antMatchers(HttpMethod.GET, "/contacts")
                .hasRole(RoleType.ADMIN.name())
                .antMatchers(HttpMethod.GET, "/users")
                .hasRole(RoleType.ADMIN.name())
                .antMatchers(HttpMethod.PUT, "/slides/{id:[\\d+]}")
                .hasRole(RoleType.ADMIN.name())
                .antMatchers(HttpMethod.POST, "/news")
                .hasRole(RoleType.ADMIN.name())
                .antMatchers(HttpMethod.PUT, "/news")
                .hasRole(RoleType.ADMIN.name())
                .antMatchers(HttpMethod.POST, "/members")
                .hasAnyRole(RoleType.USER.name())
                .antMatchers( "/categories/**")
                .hasRole(RoleType.ADMIN.name())
                .antMatchers(HttpMethod.POST, "/testimonials/**")
                .hasAnyRole(RoleType.ADMIN.name())
                .antMatchers(HttpMethod.PUT, "/members")
                .hasRole(RoleType.ADMIN.name())
                .antMatchers(HttpMethod.GET,"/comments/post/{id:[\\d+]}")
                .hasRole(RoleType.USER.name())
                .antMatchers(HttpMethod.GET, "/comments")
                .hasRole(RoleType.ADMIN.name())
                .antMatchers(HttpMethod.DELETE, "/members")
                .hasRole(RoleType.ADMIN.name())
                .antMatchers(HttpMethod.DELETE, "/comments/{id:[\\d+]}")
                .hasAnyRole(RoleType.ADMIN.name(),RoleType.USER.name())
                .antMatchers("/h2-console/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler())
                .authenticationEntryPoint(authenticationEntryPoint());

        http.headers().frameOptions().disable();

    }


}
