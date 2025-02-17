package com.codenation.service;

import com.codenation.dto.UserDTO;
import com.codenation.entity.User;
import com.codenation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User findByEmail(String email){
    return userRepository.findByEmail(email);
  }

  public List<UserDTO> findAll() {
    List<UserDTO> resultSet = new ArrayList<>();
    for(User U: userRepository.findAll()){
      resultSet.add(new UserDTO(U.getId(), U.getName(), U.getEmail(), U.getPassword(), U.getAuthorities()));
    }
    return resultSet;
  }

  public Optional<User> findById (Long id){
    return userRepository.findById(id);
  }

  public void save(User user){
    userRepository.save(user);
  }
}
