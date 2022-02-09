package com.ssembara.springnews.presist.services.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.ssembara.springnews.presist.models.Role;
import com.ssembara.springnews.presist.models.User;
import com.ssembara.springnews.presist.repositories.RoleRepository;
import com.ssembara.springnews.presist.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements UserInterface, UserDetailsService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private RoleRepository roleRepo;

    // private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            log.error("user not found in database");
            throw new UsernameNotFoundException("user not found in database");
        } else {
            log.info("user found: {}", username);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                authorities);
    }

    @Override
    public User storeUser(User user) {
        log.info("saving new user :{}", user.getUsername());
        return userRepo.save(user);
    }

    @Override
    public Role storeRole(Role role) {
        log.info("saving new role :{}", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

}
