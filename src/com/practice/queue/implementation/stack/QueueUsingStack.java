package com.practice.queue.implementation.stack;

import java.util.Stack;

class StackQueue{
    private Stack<Integer> st1;
    private Stack<Integer> st2;

    public StackQueue(){
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public boolean isEmpty(){
        if(st1.isEmpty() && st2.isEmpty()){
            return true;
        }
        return false;
    }

    public void add(int val){
        st1.push(val);
    }

    public int remove(){
        if(st2.isEmpty()){
            while (!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        if(st2.isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        return st2.pop();
    }

    public int peek(){
        if(st2.isEmpty()){
            while (!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        return st2.peek();
    }
}


public class QueueUsingStack {
    public static void main(String[] args) {
        StackQueue queue = new StackQueue();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println("Front of the queue: " + queue.peek());

        System.out.println("Dequeued element: " + queue.remove());
        System.out.println("Dequeued element: " + queue.remove());

        System.out.println("Is queue empty? " + queue.isEmpty());

        System.out.println("Front of the queue: " + queue.peek());
        queue.add(10);
        System.out.println("Dequeued element: " + queue.remove());
        System.out.println("Is queue empty? " + queue.isEmpty());

        System.out.println("Dequeued element: " + queue.remove());
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}
