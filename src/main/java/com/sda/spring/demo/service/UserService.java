package com.sda.spring.demo.service;

import com.sda.spring.demo.dto.UserDTO;
import com.sda.spring.demo.dto.UserPropDTO;
import com.sda.spring.demo.model.User;
import com.sda.spring.demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getUser(){
        return userRepository.findAll();
    }

    public List<UserPropDTO> getUsers(){

        List<User> users = userRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();

        Type listType = new TypeToken<List<UserPropDTO>>(){}.getType();

        List<UserPropDTO> userPropDTOS = modelMapper.map(users, listType);

        return userPropDTOS;
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public UserDTO getUserById(Long id){

        Optional<User> user = userRepository.findById(id);
        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(user.get(), UserDTO.class);

        return userDTO;
    }

    public User save(User user) {
        return userRepository.save(user);
    }
    public void userSave(User user){
        user.setPassword(
                bCryptPasswordEncoder.encode(user.getPassword()));



    }
}

