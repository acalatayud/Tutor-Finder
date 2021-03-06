package ar.edu.itba.paw.webapp.config;

import ar.edu.itba.paw.webapp.auth.CorsFilter;
import ar.edu.itba.paw.webapp.auth.JwtAuthorizationFilter;
import ar.edu.itba.paw.webapp.auth.StatelessSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
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
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

@Configuration
@EnableWebSecurity
@ComponentScan("ar.edu.itba.paw.webapp.auth")
public class WebAuthConfig extends WebSecurityConfigurerAdapter {

    @Value("classpath:jwtsign.key")
    private Resource jwtSignKey;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationEntryPoint entryPoint;

    @Autowired
    private StatelessSuccessHandler statelessSuccessHandler;

    @Autowired
    private JwtAuthorizationFilter authorizationFilter;

    private byte[] jwtSignKeyBytes;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public HttpSessionRequestCache httpSessionRequestCache() {
        return new HttpSessionRequestCache();
    }

    @Bean
    CorsFilter corsFilter() {
        return new CorsFilter();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedHeader(CorsConfiguration.ALL);
        configuration.addAllowedMethod(CorsConfiguration.ALL);
        configuration.addAllowedOrigin(CorsConfiguration.ALL);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.userDetailsService(userDetailsService)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .addFilterBefore(corsFilter(), UsernamePasswordAuthenticationFilter.class)
                    .addFilterAfter(authorizationFilter, CorsFilter.class)
                .exceptionHandling()
                    .authenticationEntryPoint(entryPoint)
                    .accessDeniedPage("/403")
                .and().authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/api/user/password_reset/**").anonymous()
                    .antMatchers(HttpMethod.POST, "/api/authenticate/**", "/api/user", "/api/user/password_reset/**").anonymous()
                    .antMatchers(HttpMethod.POST, "/api/conversations/**", "/api/courses/*/contact", "/api/courses/*/comments", "/api/courses/*/reservations").authenticated()
                    .antMatchers(HttpMethod.GET, "/api/conversations/**", "/api/courses/*/files/**", "/api/user", "/api/user/reservations/**").authenticated()
                    .antMatchers(HttpMethod.POST,"api/user/upgrade").hasRole("USER")
                    .antMatchers(HttpMethod.GET, "/api/user/requests/**", "/api/user/courses", "/api/user/schedule", "/api/subjects/available").hasRole("PROFESSOR")
                    .antMatchers(HttpMethod.DELETE, "/api/user/requests/**", "/api/courses/*/files/**", "/api/courses/*", "/api/user/schedule").hasRole("PROFESSOR")
                    .antMatchers(HttpMethod.PUT, "/api/user/requests/**", "/api/courses/*", "/api/courses/*/files/**", "/api/user/").hasRole("PROFESSOR")
                    .antMatchers(HttpMethod.POST, "/api/courses", "/api/user/schedule").hasRole("PROFESSOR")
                    .anyRequest().permitAll()
                .and().formLogin()
                    .usernameParameter("username").passwordParameter("password")
                    .loginProcessingUrl("/api/authenticate")
                    .successHandler(statelessSuccessHandler)
                    .failureHandler(new SimpleUrlAuthenticationFailureHandler())
                .and().csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean(name="jwtSignKey")
    public byte[] getJwtSignKey() {

        if (jwtSignKeyBytes != null && jwtSignKeyBytes.length > 0) {
            return jwtSignKeyBytes;
        }

        final StringWriter stringWriter = new StringWriter();
        try {
            Reader reader = new InputStreamReader(jwtSignKey.getInputStream());
            char[] data = new char[1024];
            int read;
            while ((read = reader.read(data)) != -1) {
                stringWriter.write(data,0, read);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        jwtSignKeyBytes = stringWriter.toString().getBytes();
        return jwtSignKeyBytes;
    }

}
