package com.littlejohnny.auth.domain.service.impl;

import com.littlejohnny.auth.domain.model.entity.User;
import com.littlejohnny.auth.domain.repository.UserRepository;
import com.littlejohnny.auth.domain.service.AbstractService;
import com.littlejohnny.auth.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Primary
@Service
public class UserServiceImpl extends AbstractService<User, Long, UserRepository> implements UserService, UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    protected UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findUserByUsername(username);
    }

    @Override
    public void save(User entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        super.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
