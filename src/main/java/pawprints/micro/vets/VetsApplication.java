package pawprints.micro.vets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pawprints.micro.vets.Firebaseinitiaization.Firebaseinitialization;

@SpringBootApplication
public class VetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(VetsApplication.class, args);
	}

}
