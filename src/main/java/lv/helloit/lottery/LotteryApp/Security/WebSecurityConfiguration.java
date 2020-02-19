//package lv.helloit.lottery.LotteryApp.Security;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//@Configuration
//@RequiredArgsConstructor
//@EnableWebSecurity
//public class WebSecurityConfiguration {
//    LotteryAuthenticationProvider lotteryAuthenticationProvider;
//
//    @Autowired
//    public WebSecurityConfiguration(LotteryAuthenticationProvider lotteryAuthenticationProvider) {
//        this.lotteryAuthenticationProvider = lotteryAuthenticationProvider;
//    }
//
//    protected void configure(HttpSecurity http) throws Exception {
//
//
//        http.authorizeRequests()
//                .antMatchers("/homePage").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
//                .antMatchers("/userPage").access("hasRole('ROLE_USER')")
//                .antMatchers("/adminPage").access("hasRole('ROLE_ADMIN')")
//                .and()
//                .formLogin().loginPage("/loginPage")
//                .defaultSuccessUrl("/homePage")
//                .failureUrl("/loginPage?error")
//                .usernameParameter("username").passwordParameter("password")
//                .and()
//                .logout().logoutSuccessUrl("/loginPage?logout");
//
//    }
//}
//
