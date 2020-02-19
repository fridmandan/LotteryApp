package lv.helloit.lottery.LotteryApp.Security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class LotteryAuthenticationProvider extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        authenticationMgr.inMemoryAuthentication()
                .withUser("user").password("user").authorities("ROLE_USER")
                .and()
                .withUser("admin").password("admin").authorities("ROLE_USER", "ROLE_ADMIN");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.authorizeRequests()
                .antMatchers("/register", "/status" , "/").permitAll()
                .antMatchers("/admin/**", "/stats")
                .hasAuthority("ROLE_ADMIN")
                .and()
                .formLogin().loginPage("/admin-loginPage")
                .defaultSuccessUrl("/admin-page")
                .failureUrl("/admin-page?error=true")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().permitAll();

    }
}

