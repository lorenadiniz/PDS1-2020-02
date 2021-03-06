package com.iftm.PDS1.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.iftm.PDS1.dto.UserDTO;
import com.iftm.PDS1.dto.UserInsertDTO;
import com.iftm.PDS1.entities.User;
import com.iftm.PDS1.repositories.UserRepository;
import com.iftm.PDS1.resources.exceptions.DatabaseException;
import com.iftm.PDS1.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<UserDTO> findAll() {
		List<User> list = repository.findAll();

		return list.stream().map(e -> new UserDTO(e)).collect(Collectors.toList());
	}

	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);

		User entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new UserDTO(entity);
	}

	public UserDTO insert(UserInsertDTO dto) {
		
		User entity = dto.toEntity();
		entity = repository.save(entity);
		return new UserDTO(entity);
	}

	public void delete(Long id) {

		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}

	}

	private void updateData(User entity, UserDTO dto) {

		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());

	}

	public UserDTO update(Long id, UserDTO dto) {

		try {
			User entity = repository.getOne(id);
			updateData(entity, dto);
			entity = repository.save(entity);
			return new UserDTO(entity);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}

	}

}
