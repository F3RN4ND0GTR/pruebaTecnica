package es.inditex.pruebatecnica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "es.inditex.pruebatecnica")
@EntityScan("es.inditex.pruebatecnica.adapter.out.persistence")
@EnableJpaRepositories("es.inditex.pruebatecnica.adapter.out.persistence")
public class PruebatecnicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebatecnicaApplication.class, args);
	}

}
