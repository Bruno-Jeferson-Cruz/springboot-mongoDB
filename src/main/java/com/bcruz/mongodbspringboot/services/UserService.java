package com.bcruz.mongodbspringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcruz.mongodbspringboot.domain.User;
import com.bcruz.mongodbspringboot.dto.UserDTO;
import com.bcruz.mongodbspringboot.repository.UserRepository;
import com.bcruz.mongodbspringboot.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj=findById(obj.getId());
		updateData(newObj,obj);
		return repository.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		
	}

	public User fromDto(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getNome(),objDto.getEmail());
	}
	
}
