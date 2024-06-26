package com.bcruz.mongodbspringboot.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcruz.mongodbspringboot.domain.Post;
import com.bcruz.mongodbspringboot.repository.PostRepository;
import com.bcruz.mongodbspringboot.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	
	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}
	public List<Post> findByTitle(String text){
		return repository.findByTitle(text);
	}
	public List<Post> fullSearch(String text,Date minDate,Date maxDate){
		maxDate=new Date(maxDate.getTime()+24*60*60*1000);
		return repository.fullSearch(text,minDate,maxDate);
	}
}
