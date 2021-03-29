package com.jwt;

import com.jwt.model.User;
import com.jwt.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JwtauthenticationserverApplication implements  CommandLineRunner  {

    @Autowired
    private UserRepository userRepository;
//
//    Random random = new Random();

    public void createUsers() {

        User user = new User();
        Long id = (long) 1;//new Long(random.nextInt(100));
        user.setId(id);
        user.setName("Manish Pandey");
        user.setEmail("smpandey.2008@gmail.com");
        user.setPhone("6375336527");
        user.setUsername("pandey_1");
        user.setPassword("pandey123");
        user.setRole("Admin");
        
        //userRepository.save(user);

       // System.out.println(save);

    }

    public static void main(String[] args) {
        SpringApplication.run(JwtauthenticationserverApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
        createUsers();
    }
}
