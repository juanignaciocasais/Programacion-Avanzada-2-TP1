package com.example.TP1_AMQP;

import static org.junit.jupiter.api.Assertions.*;

import Broker.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class NodeTest {

    private Node node;

    @BeforeEach
    public void setUp() {
        node = new Node(
                "1",
                "json",
                "Message Queue",
                "mp",
                null,
                "25",
                "new",
                1
        );
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("1", node.getUserId());
        assertEquals("json", node.getContentType());
        assertEquals("Message Queue", node.getMessage());
        assertEquals("mp", node.getTo());
        assertNull(node.getReplyTo());
        assertEquals("25", node.getExpiryTime());
        assertEquals("new", node.getState());
        assertEquals(1, node.getPriority());
        assertNotNull(node.getCreationTime()); // creation time should be set to now
    }

    @Test
    public void testSetMessageId() {
        node.setMessageId(123);
        assertEquals(123, node.getMessageId());
    }

    @Test
    public void testSetUserId() {
        node.setUserId("user2");
        assertEquals("user2", node.getUserId());
    }

    @Test
    public void testSetContentType() {
        node.setContentType("image");
        assertEquals("image", node.getContentType());
    }

    @Test
    public void testSetMessage() {
        node.setMessage("New Message");
        assertEquals("New Message", node.getMessage());
    }

    @Test
    public void testSetTo() {
        node.setTo("user3");
        assertEquals("user3", node.getTo());
    }

    @Test
    public void testSetReplyTo() {
        node.setReplyTo("reply1");
        assertEquals("reply1", node.getReplyTo());
    }

    @Test
    public void testSetExpiryTime() {
        node.setExpiryTime("22");
        assertEquals("22", node.getExpiryTime());
    }

    @Test
    public void testSetCreationTime() {
        LocalDateTime newTime = LocalDateTime.of(2024, 1, 1, 0, 0);
        node.setCreationTime(newTime);
        assertEquals(newTime, node.getCreationTime());
    }

    @Test
    public void testSetState() {
        node.setState("processed");
        assertEquals("processed", node.getState());
    }

    @Test
    public void testSetPriority() {
        node.setPriority(5);
        assertEquals(5, node.getPriority());
    }
}
