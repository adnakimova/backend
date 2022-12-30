package com.jap.initial.springjwt;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.jap.initial.springjwt.model.Roles;
import com.jap.initial.springjwt.repositories.RolesRepository;


@SpringBootApplication
@EnableJpaAuditing
public class SpringJwtApplication implements CommandLineRunner{

	@Autowired
	RolesRepository rolesRepository;
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() { return new BCryptPasswordEncoder(); }

    public static void main(String[] args) {
        SpringApplication.run(SpringJwtApplication.class, args);
    }
    @Override
	public void run(String... args) throws Exception {
    	
		System.out.println("Starting code");	
    }

	
}
