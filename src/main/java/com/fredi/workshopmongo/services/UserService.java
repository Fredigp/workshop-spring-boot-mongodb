package com.fredi.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fredi.workshopmongo.domain.User;
import com.fredi.workshopmongo.dto.UserDTO;
import com.fredi.workshopmongo.repository.UserRepository;
import com.fredi.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findByID(String id) {

		Optional<User> user = repo.findById(id);

		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		findByID(id);
		repo.deleteById(id);
	}

	public User update(User obj) {
		User newObj = findByID(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getName());
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}

}
