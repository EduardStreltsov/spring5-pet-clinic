package guru.springframework.sfgpetclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SfgPetClinicApplication {

    public static void main(String[] args) {
	    System.out.println("\033[0;31m" + "something something" + "\033[0m");
        SpringApplication.run(SfgPetClinicApplication.class, args);
    }
}
