package com.abc.service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.abc.model.Book;
import com.abc.model.User;
import com.abc.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),grantedAuthorities);
	}
	
	public User save(User user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setName(user.getName());
		newUser.setAddress(user.getAddress());
		newUser.setEmail(user.getEmail());
		newUser.setRole(user.getRole());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setFeatured(true);
		return userRepository.save(newUser);
	}
	
	public List<User> getList(){
		List<User> listUsers = new ArrayList<User>();
		userRepository.findAll().forEach(listUsers::add);
		return listUsers;	
	}
	
	public User findByUser(String username) {
		return userRepository.findByUsername(username);
	}
	
	public void deleteById(long id) {
		userRepository.deleteById(id);
	}
	
	public List<User> searchName(String name){
		return userRepository.findByNameContaining(name);
	}
	
	public long countFeatured(Boolean featured) {
		return userRepository.countByFeatured(featured);
	}
	
}
