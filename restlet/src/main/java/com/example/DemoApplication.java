package com.example;

import com.example.webapi.resource.UserResource;
import com.example.webapi.resource.server.Mail;
import org.restlet.data.MediaType;
import org.restlet.data.Parameter;
import org.restlet.ext.spring.SpringComponent;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	SpringComponent restlet;

	public static void main(String[] args) {

		SpringApplicationBuilder builder = new SpringApplicationBuilder();
		RestletStart restletStart = new RestletStart(DemoApplication.class);
		restletStart.setWebEnvironment(false);
		restletStart.run(args).addApplicationListener(restletStart);
//		SpringApplication.run(RestletStart.class, args);
		//	builder.contextClass(SpringContext.class).build().run();
//		SpringApplication.run()
	}

	@Bean
	public CommandLineRunner start(){
		return (args)-> {
			restlet.start();
			ClientResource mailClient = new ClientResource(
					"http://localhost:9003/v1/user");
			mailClient.addQueryParameter(new Parameter("haha", "ok"));
			mailClient.addQueryParameter(new Parameter("hahaaa", "ok"));
			Representation mailRepresentation = mailClient
					.get(MediaType.APPLICATION_XML);
			System.out.println(mailRepresentation.getText());

			UserResource clientResource = ClientResource.create(
					"http://localhost:9003/v1/user",
					UserResource.class);
			Mail represent = clientResource.represent();
			System.out.println(represent.getAccountRef());

			ClientResource client = clientResource.getClientResource();
			Representation representation = client.get(MediaType.APPLICATION_JSON);
			System.out.println(representation.getText());
//			mailClient.put(mailRepresentation);
//			mailRepresentation = mailClient.get(MediaType.APPLICATION_JSON);
//			mailClient.put(mailRepresentation);
		};
	}
}
