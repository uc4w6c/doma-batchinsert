package com.example.domabatchinsert;

import com.example.domabatchinsert.orverride.CustomQueryImplementors;
import org.seasar.doma.jdbc.ConfigSupport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DomaBatchinsertApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomaBatchinsertApplication.class, args);
	}

}
