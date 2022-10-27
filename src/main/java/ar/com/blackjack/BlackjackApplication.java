package ar.com.blackjack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class BlackjackApplication {

	public static void main(String[] args) {

		SpringApplication.run(BlackjackApplication.class, args);

		int numero = new Random().nextInt(52);
		System.out.println(numero);


	}

}
