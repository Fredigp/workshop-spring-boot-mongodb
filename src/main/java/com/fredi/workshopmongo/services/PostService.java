package com.fredi.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fredi.workshopmongo.domain.Post;
import com.fredi.workshopmongo.repository.PostRepository;
import com.fredi.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findByID(String id) {

		Optional<Post> post = repo.findById(id);

		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}

}
