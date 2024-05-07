package com.bcruz.mongodbspringboot.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcruz.mongodbspringboot.domain.Post;
import com.bcruz.mongodbspringboot.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostResource {
	@Autowired
	private PostService service;

	
	@GetMapping(value="/{id}")
	public ResponseEntity <Post> findById(@PathVariable String id){
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
