package com.fif.services.impl;

import com.fif.entity.UserLogin;
import com.fif.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zkoss.zul.South;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserLoginServiceImpl implements UserDetailsService {

    @Autowired
    UserLoginRepository userLoginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            System.out.println("=== USERNAME ===");
            System.out.println(username);
            UserLogin userLogin = userLoginRepository.get(username);
            System.out.println("==================");
            System.out.println(userLogin.getUsername());
            Set<GrantedAuthority> authorities = userLogin.getRoles()
                    .stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
            return new org.springframework.security.core.userdetails.User(userLogin.getUsername(), userLogin.getPassword(), authorities);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException("Invalid Login");
        }
    }
}
