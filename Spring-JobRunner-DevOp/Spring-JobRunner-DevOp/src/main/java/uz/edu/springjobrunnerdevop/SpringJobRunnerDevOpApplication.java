package uz.edu.springjobrunnerdevop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import uz.edu.springjobrunnerdevop.model.MainConfiguration;

@SpringBootApplication
@Import(MainConfiguration.class)
public class SpringJobRunnerDevOpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJobRunnerDevOpApplication.class, args);
	}

}
