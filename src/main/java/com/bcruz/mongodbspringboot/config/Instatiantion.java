package com.bcruz.mongodbspringboot.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.bcruz.mongodbspringboot.domain.Post;
import com.bcruz.mongodbspringboot.domain.User;
import com.bcruz.mongodbspringboot.dto.AuthorDTO;
import com.bcruz.mongodbspringboot.repository.PostRepository;
import com.bcruz.mongodbspringboot.repository.UserRepository;

@Configuration
public class Instatiantion implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Paritu viagem", "Vou para SP", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("22/03/2018"), "Bom dia!", "To feliz hoje!", new AuthorDTO(maria));

		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);
	}

}
