package Broker;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BrokerService {

    private final List<Node> queue = new ArrayList<>();

    public Node addNode(Node node) {
        node.setMessageId(this.getNextMessageId());
        this.queue.add(node);
        return node;
    }

    public List<Node> getQueue() {
        return this.queue;
    }

    public Node removeNode() {
        return this.queue.remove(0);
    }

    public int getNextMessageId() {
        if (this.queue.isEmpty()) {
            return 1;
        }
        Node lastNode = this.queue.get(this.queue.size() - 1);
        return lastNode.getMessageId() + 1;
    }
}
