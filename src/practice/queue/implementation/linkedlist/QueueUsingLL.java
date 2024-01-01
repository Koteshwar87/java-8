package practice.queue.implementation.linkedlist;

import java.util.LinkedList;
import java.util.Queue;

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class LinkedListQueue{
    private ListNode head;
    private ListNode tail;

    public LinkedListQueue(){
        this.head = null;
        this.tail = null;
    }

    public void add(int val){
        ListNode node = new ListNode(val);
        if(head == null){
            head = node;
            tail = node;
        }else {
            tail.next = node;
            tail = node;
        }
    }

    public boolean isEmpty(){
        if(head == null){
            return true;
        }
        return false;
    }

    public int remove(){
        if(head == null){
            throw new IllegalStateException("Queue is empty");
        }
        int val = head.val;
        head = head.next;
        return val;
    }

    public int peek(){
        if(head == null){
            throw new IllegalStateException("Queue is empty");
        }
        return head.val;
    }
}

public class QueueUsingLL {
    public static void main(String[] args) {
//        Queue queue = new LinkedList();
        LinkedListQueue queue = new LinkedListQueue();
//        queue.peek();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println("Front of the queue: " + queue.peek());

        System.out.println("Dequeued element: " + queue.remove());
        System.out.println("Dequeued element: " + queue.remove());

        System.out.println("Is queue empty? " + queue.isEmpty());

        System.out.println("Front of the queue: " + queue.peek());
        System.out.println("Dequeued element: " + queue.remove());

        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}
