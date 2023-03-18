package com.iscae._election_etudient;

import com.iscae._election_etudient.services.EmailSenderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Application {
@Autowired
private EmailSenderServices senderServices;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public  void  send(){
		//senderServices.sendEmail("ip19293.etu@iscae.mr","code vote "," this is a code");
	}

}
