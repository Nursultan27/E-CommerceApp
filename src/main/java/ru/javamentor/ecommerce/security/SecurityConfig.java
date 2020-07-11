package ru.javamentor.ecommerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private PasswordEncoder passwordEncoder;
    private UserDetailsService myUserDetailsService;

    @Autowired
    public SecurityConfig(@Qualifier("userServiceImpl") UserDetailsService myUserDetailsService, PasswordEncoder passwordEncoder) {
        this.myUserDetailsService = myUserDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth
                .inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder.encode("123"))
//                .roles(ApplicationUserRole.USER.name())
                .roles("USER")

                .and()
                .withUser("admin")
                .password(passwordEncoder.encode("123"))
//                .roles(ApplicationUserRole.ADMIN.name());
                .roles("USER");*/


        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
                /* cockie will be inaccessible to client side's crypt.
                 So if client tries to access these cockies with some
                 js, then it'll be able to do
                 GO AHEAD AND READ THIS CLASS TO HAVE FULL UNDERSTANDING, HOW IT WORKS

                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()); */

        /*http.formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/", true)
                .and()
                .rememberMe()
                    .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
                    .key("smthVerySecured");

        http.logout()
                    .logoutUrl("/logout")
                    .permitAll()

//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID","remember-me")
                    .logoutSuccessUrl("/login");


        http.authorizeRequests()
                .antMatchers("/registration").anonymous()
                .antMatchers("/login").anonymous();*/

        http.authorizeRequests()
                .antMatchers("/login").anonymous()
                .antMatchers("/registration").anonymous()
                .anyRequest().authenticated()

            .and().formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/", true)

        .and().logout()
                .permitAll()
                .logoutSuccessUrl("/login")

        .and().csrf().disable();
    }
}
