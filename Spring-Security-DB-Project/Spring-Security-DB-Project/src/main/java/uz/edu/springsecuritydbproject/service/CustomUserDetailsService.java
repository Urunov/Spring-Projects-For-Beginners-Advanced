package uz.edu.springsecuritydbproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.edu.springsecuritydbproject.aggregate.model.User;
import uz.edu.springsecuritydbproject.repo.UserRepository;
import uz.edu.springsecuritydbproject.security.CustomUserDetails;

/**
 * @project: Spring-Security-DB-Project
 * @Date: 12.11.2022
 * @author: H_Urunov
 **/
@Service
public class CustomUserDetailsService implements UserDetailsService {
    //
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user =userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User not found.");
        }
        return new CustomUserDetails(user);
    }
}
