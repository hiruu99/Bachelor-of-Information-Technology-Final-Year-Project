package lk.samagispice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
// If RestController is not installed, any mapping can not be proceeded
public class BitprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitprojectApplication.class, args);

		getName();
	}

	public static void getName(){
		System.out.println("Hiruni");
	}

	@RequestMapping(value = "/")
	public String index(){
		// return "Hello World";
		return "<h1> Hello World </h1>";
	}

	
	

}
