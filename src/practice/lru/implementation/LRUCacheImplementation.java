package practice.lru.implementation;

import java.util.HashMap;
import java.util.Map;

class Node{
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache{
    private int capacity;
    private int size = 0;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }

        // Connect previous and next of current node so that current can be seperated
        Node node = map.get(key);
        removeNode(node);
        // Attach current to end
        insertNode(node);
        return node.value;
    }

    public void set(int key, int value){
        if (map.containsKey(key)){
            // If already present remove from there and attach at the end

        }else {
            // If not present create new node and attach at tail
            if(size == capacity){
                // Remove first node and create new node at tail
            }

        }
    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertNode(Node node){
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }
}

public class LRUCacheImplementation {
}
