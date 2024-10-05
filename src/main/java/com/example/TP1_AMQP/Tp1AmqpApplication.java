package com.example.TP1_AMQP;

import Broker.Node;
import Broker.BrokerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;


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
	public Node add(@RequestBody Node params) {
		Node nodo1 = new Node(
				params.getUserId(),
				params.getContentType(),
				params.getMessage(),
				params.getTo(),
				params.getReplyTo(),
				params.getExpiryTime(),
				params.getState(),
				params.getPriority());
		return this.brokerService.addNode(nodo1);
	}

	@DeleteMapping("/pop")
	public Node pop() {
		return this.brokerService.removeNode();
	}

	@GetMapping
	public List<Node> getQueue() {
		return this.brokerService.getQueue();
	}
}

