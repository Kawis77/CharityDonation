package pl.coderslab.charity.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.coderslab.charity.service.CustomDetailUserService;

@Configuration
public class SeciurityConfiguration extends WebSecurityConfigurerAdapter {


    private CustomDetailUserService customDetailUserService;

    public SeciurityConfiguration(CustomDetailUserService customDetailUserService) {
        this.customDetailUserService = customDetailUserService;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(customDetailUserService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/form/category").permitAll()
                .antMatchers("/form/quantity").permitAll()
                .antMatchers("/form/institution").permitAll()
                .antMatchers("/form/donationdetails").permitAll()
                .antMatchers("/form/endform/{id}").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/users/").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/")
                .and()
                .logout().logoutSuccessUrl("/login")
                .and()
                .csrf()
                .disable();
    }
}
