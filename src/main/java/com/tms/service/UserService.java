package com.tms.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tms.models.User;
import com.tms.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository repository;
	private BCryptPasswordEncoder encoder;
	
	public UserService(UserRepository repository,BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
		this.repository = repository;
	}
	public User getUser(Long id) {
		return repository.findById(id)
				.map(user -> {
					user.setPassword("");
					return user;
				})
				.orElseThrow(() -> new EntityNotFoundException("User not found."));
	}
	
	public List<User> getAllUsers(){
		return repository.findAll();
	}
	
	public User registerUser(User newUser ) {
		if(repository.findByUsername(newUser.getUsername()) != null) {
			throw new EntityNotFoundException("Email already used.");
		}
		newUser.setPassword(encoder.encode(newUser.getPassword()));
		
		return repository.save(newUser);
	}
	public ResponseEntity<Object> deleteUser(Long id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			throw new EntityNotFoundException("User not found.");
		}

		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
