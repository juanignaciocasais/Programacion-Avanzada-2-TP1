package com.example.TP1_AMQP;

import Broker.BrokerService;
import Broker.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BrokerServiceTest {

	private BrokerService brokerService;
	private Node node;

	@BeforeEach
	public void setUp() {
		brokerService = new BrokerService();
		node = new Node(
				"1",
                "json",
				"Message Queue",
				"mp",
				"ecommerce",
				"25",
				"new",
				1
		);
	}

	@Test
	public void testAddNode() {
		Node result = brokerService.addNode(node);

		assertEquals(1, result.getMessageId());
	}

	@Test
	public void testAddMultipleNodes() {
		
		brokerService.addNode(node);
		brokerService.addNode(node);

		assertEquals(2, brokerService.getQueue().size());
	}

	@Test
	public void testRemoveNode() {
		brokerService.addNode(node);

		Node removedNode = brokerService.removeNode();

		assertEquals(node, removedNode);
		assertTrue(brokerService.getQueue().isEmpty());
	}

	@Test
	public void testGetNextMessageId() {
		brokerService.addNode(node);
		brokerService.addNode(node);

		int nextMessageId = brokerService.getNextMessageId();

		assertEquals(3, nextMessageId);
	}

	@Test
	public void testGetNextMessageIdWhenQueueIsEmpty() {
		int nextMessageId = brokerService.getNextMessageId();

		assertEquals(1, nextMessageId);
	}
}
