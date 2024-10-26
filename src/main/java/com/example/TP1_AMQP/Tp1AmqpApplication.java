package com.example.TP1_AMQP;

import Broker.Node;
import Broker.BrokerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootApplication(scanBasePackages = {"com.Broker.BrokerService", "Broker"})
@RestController
@RequestMapping("/queue")
public class Tp1AmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tp1AmqpApplication.class, args);
	}

	@Autowired
	private final BrokerService brokerService;

	@Autowired
	public Tp1AmqpApplication(BrokerService brokerService) {
		this.brokerService = brokerService;
	}

	@PostMapping("/push")
	public ResponseEntity<Response> push(@RequestBody Node params) {
		Node nodo1 = new Node(
				params.getUserId(),
				params.getContentType(),
				params.getMessage(),
				params.getTo(),
				params.getReplyTo(),
				params.getExpiryTime(),
				params.getState(),
				params.getPriority());
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new Response("Nuevo mensaje agregado", this.brokerService.addNode(nodo1)));
	}

	@GetMapping("/pop")
	public ResponseEntity<Response> pop() {

		if (this.brokerService.getQueue().isEmpty())
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("Error: Cola vacía", null));
		}

		return ResponseEntity.status(HttpStatus.OK)
				.body(new Response("Mensaje entregado", this.brokerService.removeNode()));
	}

	@GetMapping
	public ResponseEntity<Response> getQueue() {

		if (this.brokerService.getQueue().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response("Error: Cola vacía.", null));
		}

		return ResponseEntity.status(HttpStatus.OK)
				.body(new Response("Mensajes encolados", this.brokerService.getQueue()));
	}
}
