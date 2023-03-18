package com.jap.initial.springjwt;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;





@SpringBootApplication
@EnableJpaAuditing
public class SpringJwtApplication implements CommandLineRunner{
	
	  public static void main(String[] args) {
		  
		  SpringApplication.run(SpringJwtApplication.class, args);
	  
	  
	  }
	  
	  @Override 
	  public void run(String... args) throws Exception {
	  
	  System.out.println("Starting code");
	  
	  }
	 

	
}
