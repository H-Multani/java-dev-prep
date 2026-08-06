package com.example.springsec01.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//spring ko btana padega ki ye file ek config file hai, for that
@Configuration
//since we dont need default spring configuration,
// we want to implement it here for that
@EnableWebSecurity
public class securityConfig {

//    ab since yaha apan ne kuch filter specify nai kiya hai hence run karne par ab login nai maangega

//    we return bean for security filter chain,
//    this bean will be injected when we run program
    @Bean
    public SecurityFilterChain secFilterChain(HttpSecurity http){
//        to disable CSRF protection we do
        http.csrf(customizer-> customizer.disable());
//        usually done to simplify development, nai toh baar baar token bhejna padega update ke liye
//        baad me vapas laga dete

//        we want ki authorized bande hi jaaye, login form aana chahiye
        http.authorizeHttpRequests(request-> request.anyRequest().authenticated());
//        means koi bhi type ka request ho hamesha authenticate karke hi jayega


//        ab authenticate krne ke liye form login chahiye, for that
        http.formLogin(Customizer.withDefaults());
//        ab form dega login karke chala do
//        lekin postman me bhi form hi dega

//        to enable it working with postman,
        http.httpBasic(Customizer.withDefaults());
//        for rest API access


//        stateless banane ke liye we do
        http.sessionManagement(sesson-> sesson.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


//        ye pura upar ka 5 kaam ab normal samajhte

//        same thing to disable csrf, we need object, bana do
//        since cutomizer is functional interface, can use lambda funcn also
//        Customizer<CsrfConfigurer<HttpSecurity>> customizr=new Customizer<CsrfConfigurer<HttpSecurity>>() {
//            @Override
//            public void customize(CsrfConfigurer<HttpSecurity> cust) {
////                yaha ye customizer se bolenge ki disable kardo
//                cust.disable();
//            }
//        };
//        ab http se bolo ye object dede to csrf()
//        iss object ke andar jo bhi hoga vo apply ho jayega csrf par
//        http.csrf(customizr);



        return http.build();
//        build() returns object of security filter chain
    }
}
