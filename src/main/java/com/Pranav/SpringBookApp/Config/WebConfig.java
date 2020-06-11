package com.Pranav.SpringBookApp.Config;

import com.Pranav.SpringBookApp.Service.CustomerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebConfig  extends WebSecurityConfigurerAdapter {

  @Autowired
    CustomerDetailService customerDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(customerDetailService) ;

    }

    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
       return super.authenticationManager();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
       // http.csrf().disable();
       // http.httpBasic().and().authorizeRequests().antMatchers("/customerRel/**").permitAll().anyRequest().
         //       authenticated().and().formLogin().permitAll();

     // http.authorizeRequests().antMatchers("/user/**").authenticated().anyRequest().permitAll().and()
     // .authorizeRequests().antMatchers("/customerRel/**").authenticated().anyRequest().hasAnyRole("ADMIN").and()
       //       .formLogin().permitAll();
 //  http.httpBasic().and().authorizeRequests().antMatchers("/customerRel/**").hasAnyRole("ADMIN").
   //        anyRequest().authenticated().and().formLogin().permitAll();


//     http
//               .httpBasic()
//             .and()
//           .authorizeRequests()
//          .antMatchers("/user/**").permitAll().and()
//                .authorizeRequests()
//                .antMatchers("/customerRel/**").hasAnyRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//              .formLogin()
//               .permitAll();

//        http
//                .authorizeRequests()
//                .antMatchers("/index.html").permitAll()
//                .antMatchers("/profile/**").authenticated()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/management/**").hasAnyRole("ADMIN", "MANAGER")
//                .antMatchers("/api/public/test1").hasAuthority("ACCESS_TEST1")
//                .antMatchers("/api/public/test2").hasAuthority("ACCESS_TEST2")
//                .antMatchers("/api/public/users").hasRole("ADMIN")
//                .and()
//                .formLogin().permitAll();

        http
                .authorizeRequests()
                .antMatchers("/profile/**").authenticated()
                .antMatchers("/customerRel/**").hasAnyRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/api/public/test1").hasAuthority("ACCESS_TEST1")
                .antMatchers("/api/public/test2").hasAuthority("ACCESS_TEST2")
                .antMatchers("/api/public/users").hasRole("ADMIN")
                .and()
                .formLogin().permitAll();

    }


    @Bean
    public PasswordEncoder passwordEncoder()
    {
         return NoOpPasswordEncoder.getInstance();
    }



}
