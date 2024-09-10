package com.yedam.app.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
@Getter
public class LoginVO implements UserDetails{

    private UserVO userVO;

    public LoginVO(UserVO userVO){
        this.userVO = userVO;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //인터페이스의 최상위
        List <GrantedAuthority> auths = new ArrayList<>();
        auths.add(new SimpleGrantedAuthority(userVO.getRoleName()));
        return auths; 
    }

    @Override
    public String getPassword() {
        return userVO.getPassWord();
    }

    @Override
    public String getUsername() {
        return userVO.getLoginId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}