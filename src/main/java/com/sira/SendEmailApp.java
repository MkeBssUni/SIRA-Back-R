package com.sira;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sira.dto.MailRequest;
import com.sira.dto.MailResponse;
import com.sira.service.EmailService;

@SpringBootApplication
@RestController
public class SendEmailApp {

	@Autowired
	private EmailService service;

	@PostMapping("/sendEmail")
	public MailResponse sendEmail(@RequestBody MailRequest request) {
		Map<String, Object> model = new HashMap<>();
		model.put("Name", request.getName());
		model.put("location", "Cuernavaca, Morelos, Mexico");
		return service.sendEmail(request, model);

	}

	public static void main(String[] args) {
		SpringApplication.run(SendEmailApp.class, args);
	}
}
