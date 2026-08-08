package com.example.springsec01.model;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserPrincipal implements UserDetails {

//    user input lelo, ye alag se bana rhe
    private Users user;

    public UserPrincipal(Users user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

//        yaha roles dene hai,GrantedAuthority is interface, iska ek implemented class use kardlo

        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public @Nullable String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
//        nahi h bhi explired acct
//        return UserDetails.super.isAccountNonExpired();
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
//        return UserDetails.super.isAccountNonLocked();
//        yes acct not lockec
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
//        yaha bhi maan rhe credentials not expired
//        return UserDetails.super.isCredentialsNonExpired();
        return true;
    }

    @Override
    public boolean isEnabled() {
//        abhi maan rahe user is enabled toh true bhej rhe
//        return UserDetails.super.isEnabled();
        return true;
    }
//    implement the methods

}
