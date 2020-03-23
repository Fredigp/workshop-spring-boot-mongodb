package com.fredi.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fredi.workshopmongo.domain.Post;
import com.fredi.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@GetMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Post> findByID(@PathVariable String id){
		Post obj = service.findByID(id);		
		return ResponseEntity.ok().body(obj);		
	}	


}
