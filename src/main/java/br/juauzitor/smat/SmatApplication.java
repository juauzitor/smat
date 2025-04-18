package br.juauzitor.smat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("br.juauzitor.smat.infrastructure.persistence.entities")
public class SmatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmatApplication.class, args);
	}

}
