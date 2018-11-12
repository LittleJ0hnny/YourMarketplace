package com.littlejohnny.auth.domain.service.impl;

import com.littlejohnny.auth.domain.model.entity.User;
import com.littlejohnny.auth.domain.repository.UserRepository;
import com.littlejohnny.auth.domain.service.AbstractService;
import com.littlejohnny.auth.domain.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractService<User, Long, UserRepository> implements UserService, UserDetailsService {

    protected UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findUserByUsername(username);
    }
}
