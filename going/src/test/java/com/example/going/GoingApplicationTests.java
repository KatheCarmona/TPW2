package com.example.going;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class GoingApplicationTests {
	
	
	@Test
	void contextLoads() {
		
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		String passEncriptado = "12345678";
		System.out.println("PALABRA: " +passEncriptado +" "+pe.encode(passEncriptado));
	}

}
