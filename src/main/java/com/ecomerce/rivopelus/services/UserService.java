package com.ecomerce.rivopelus.services;

import com.ecomerce.rivopelus.entities.User;
import com.ecomerce.rivopelus.exception.BadRequestException;
import com.ecomerce.rivopelus.exception.ResourceNotFoundException;
import com.ecomerce.rivopelus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pengguna Id  : " + id + "Tidak di temukan"));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User create(User user){

        if (!StringUtils.hasText(user.getEmail())){
            throw  new BadRequestException("Email harus di isi");
        }
        if(userRepository.existsByEmail(user.getEmail())){
            throw  new BadRequestException("Email " + user.getId() + "Sudah Terdaftar");
        }

        user.setIs_active(true);
        return userRepository.save(user);
    }

    public User edit (String id, User user){
        if (!StringUtils.hasText(user.getEmail())){
            throw  new BadRequestException("Email harus di isi");
        }

        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteById(String id){
        userRepository.deleteById(id);
    }
}
