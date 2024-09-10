package com.practice.stack.implementation.linkedlist;

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class LinkedListStack{
    private ListNode top;

    public LinkedListStack(){
        this.top = null;
    }

    public boolean isEmpty(){
        if(top == null){
            return true;
        }
        return false;
    }

    public void push(int val){
        ListNode node = new ListNode(val);
        node.next = top;
        top = node;
    }

    public int pop(){
        if(top == null){
            throw new IllegalStateException("Stack is empty");
        }
        int val = top.val;
        top = top.next;
        return val;
    }

    public int peek(){
        if(top == null){
            throw new IllegalStateException("Stack is empty");
        }

        return top.val;
    }
}

public class StackUsingLL {
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();

//        stack.pop();
        stack.push(2);
        stack.peek();
        stack.push(4);
        stack.push(5);
        stack.push(7);
        stack.push(9);
        stack.peek();

        System.out.println("Top of the stack: " + stack.peek());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
