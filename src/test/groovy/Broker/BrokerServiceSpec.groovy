import Broker.BrokerService
import Broker.Node
import spock.lang.*

class BrokerServiceSpec extends Specification {

    BrokerService brokerService
    Node node

    def setup() {
        brokerService = new BrokerService()
        node = new Node(
                "1",
                "json",
                "Message Queue",
                "mp",
                "ecommerce",
                "25",
                "new",
                1
        )
    }

    def "should add a node and assign a message ID"() {
        given: "a new node"
        Node node = node

        when: "the node is added"
        Node addedNode = brokerService.addNode(node)

        then: "the node should have a message ID and be in the queue"
        addedNode.messageId == 1
        brokerService.getQueue().size() == 1
        brokerService.getQueue().get(0) == addedNode
    }

    def "should add multiple nodes"() {
        given: "a new node"
        Node node = node

        when: "two nodes are added"
        Node addedNode = brokerService.addNode(node)

        then: "the queue should have two nodes"
        brokerService.getQueue().size() == 2
    }

    def "should return the next message ID correctly"() {
        given: "two nodes are added"
        brokerService.addNode(node)
        brokerService.addNode(node)

        when: "the next message ID is requested"
        int nextMessageId = brokerService.getNextMessageId()

        then: "the next message ID should be 3"
        nextMessageId == 3
    }

    def "should remove a node from the queue"() {
        given: "two nodes are added"
        brokerService.addNode(node)
        brokerService.addNode(node)

        when: "a node is removed"
        Node removedNode = brokerService.removeNode()

        then: "the removed node should be the first node and the queue size should be 1"
        removedNode.messageId == 1
        brokerService.getQueue().size() == 1
    }

    def "should return null when removing from an empty queue"() {
        when: "a node is removed from an empty queue"
        Node removedNode = brokerService.removeNode()

        then: "the removed node should be null"
        removedNode == null
    }
}
