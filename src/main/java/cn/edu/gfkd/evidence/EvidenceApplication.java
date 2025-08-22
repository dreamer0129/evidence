package cn.edu.gfkd.evidence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("cn.edu.gfkd.evidence.repository")
public class EvidenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvidenceApplication.class, args);
	}

}
