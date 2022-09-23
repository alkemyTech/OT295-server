package com.alkemy.ong.auth.security;


import com.alkemy.ong.auth.jwt.JwtRequestFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    //WHITE LIST ALLOWS FULL ACCESS TO SUBSEQUENT ENDPOINTS
    private static final String[] AUTH_WHITELIST = {
            // -- Swagger UI v2
            "/v2/api-docs", "/swagger-resources", "/swagger-resources/**", "/configuration/ui",
            "/configuration/security", "/swagger-ui.html", "/webjars/**",
            // -- Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**", "/swagger-ui/**",
            // other public endpoints of your API may be appended to this array
            // -- interface from db
            "/h2-console/**",
            "/auth/**"
    };
    //USE THIS ARRAY TO INCLUDE ALL RELATED ADMIN ROLE ENDPOINTS
    private static final String[] ADMIN_ENDPOINTS_LIST = {
            "/users"
    };
    //USE THIS ARRAY TO INCLUDE ALL RELATED USER ROLE ENDPOINTS
    private static final String[] USER_ENDPOINTS_LIST = {

    };
    //USE THIS ARRAY TO INCLUDE ALL RELATED ADMIN/USER ROLE ENDPOINTS (WHEN BOTH ARE ABLE TO USE IT)
    private static final String[] ADMIN_USER_ENDPOINTS_LIST = {

    };


    private final JwtRequestFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(ADMIN_ENDPOINTS_LIST).hasRole(RoleType.ADMIN.name())
                .antMatchers(AUTH_WHITELIST).permitAll()
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
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(STATELESS)
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        http.headers().frameOptions().disable();

        return http.build();
    }

}
