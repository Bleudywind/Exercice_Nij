package com.example.demo;

import com.example.demo.jsonplaceholder.service.UsersServiceRN;
import com.example.demo.jsonplaceholder.service.UsersServiceRT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		UsersServiceRN usersServiceRN = new UsersServiceRN();

		String getAll = usersServiceRN.getAll();


		DisposableServer server =
				HttpServer.create()
						.host("localhost")
						.port(8080)
						.route(routes ->
								routes.get("/users",
												(request, response) -> response.sendString(Mono.just(getAll)))
										)
						.bindNow();

		server.onDispose()
				.block();
	}

}
