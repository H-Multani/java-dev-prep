package com.example.springsec01.config;


import org.springframework.beans.factory.BeanRegistrarDslMarker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password4j.BcryptPassword4jPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//spring ko btana padega ki ye file ek config file hai, for that
@Configuration
//since we dont need default spring configuration,
// we want to implement it here for that
@EnableWebSecurity
public class securityConfig {

//    user detail service ka obejct bana do, since we want object to be managed by spring hence autowire
//    yaha custom service use karenge toh uska name hai myUserDetailService,
//    jo class hogi and iss interface ko implement karegi
    @Autowired
    private UserDetailsService userDetailService;


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



//    suppose we want to create custom user details checking service
//    for that we create bean of userDetailService, since this is interface toh iska ek implemented class ka object chalega
//    @Bean
//    public UserDetailsService userDetailsService(){
//
////        this InMemoryUserDetailsManager(), takes UserDetails() ke objects
////        but UserDetails() is interface , object kaise?
////        interface ka implemented classs is User(), use karlo
//        UserDetails user1= User
////        user ka password me default encoding daalna before sending to DBMS
//                .withDefaultPasswordEncoder()
////                username is
//                .username("hars")
////                password is
//                .password("hars@123")
////                role is
//                .roles("USER")
////                kaam batane ke baad bana do user build kardlo
//                .build();
//
//
//        UserDetails user2= User
//                .withDefaultPasswordEncoder()
//                .username("hars1")
//                .password("hars@1234")
//                .roles("ADMIN")
//                .build();
//
////        can make multiple users here
//
//
////        jitne users dene hai dedo comma daal kar
//        return new InMemoryUserDetailsManager(user1,user2);
//    }


//    for custom authentication provider we make another bean
//again this is an interface toh implemented class ka object banana padega
    @Bean
    public AuthenticationProvider authenticationProvider(){
//        one of implemented classes is DAO Authentication provider(among others)
//        implements indirectly AuthenticationProvider, ghus kar dekh sakte andar class ke
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider(userDetailService);

//        for now i dont want password encoder, for that i do
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

//        ab apan ne password save karte time encoding ki hai using bcrypt, toh yaha ab decode karna padega, check karne ke time
//        yaha bhi same encoder laga denga,
//        then if password is correct, then DB wala passwd will be same as this entered wala password since same passwd will have same encoding
//        here since apan ne 12 strength ka encoder use kiya hai toh object bhej denge bas bcrpt wale encoder ka with strength
//        ezpz
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));

//        apan apna custom userDetailServide use karenge
//        this func has been depricated hence nai chalega,
//        toh ye kaam object ke constructor ne hi kar liya kayega
//        provider.setUserDetailsService(userDetailService);

//        we need to connect this to DB (postgres),
        return provider;

    }
}
