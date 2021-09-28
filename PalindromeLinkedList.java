package com.practice.datastruct.linkedlist;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(5, node);
        ListNode node3 = new ListNode(2, node2);
        ListNode node4 = new ListNode(5, node3);
        ListNode node5 = new ListNode(2, node4);
        ListNode node6 = new ListNode(5, node5);
        ListNode node7 = new ListNode(1, node6);

        System.out.println(checkPalindrome(node7));

    }

    private static boolean checkPalindrome(ListNode listNode) {
        ListNode head = listNode;
        int sizeOfList = traverse(listNode);
        System.out.println("\n"+sizeOfList);
        Stack stack = new Stack(sizeOfList);
        while(listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (head!=null){
            if(head.val != stack.pop()){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    private static int traverse(ListNode node2) {
        int count = 0;
        while(node2!=null){
            count++;
            System.out.print(node2.val + " ");
            node2 = node2.next;
        }
        return count;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Stack{
    int[] arr;
    int top = -1;
    Stack(int size){
        arr = new int[size];
    }
    public void push(int value){
        if(top > arr.length){
            System.out.println("Stack overflow");
            return;
        }
        arr[++top] = value;
    }
    public int pop(){
        if(top == -1){
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }
    public int peek(){
        if(top == -1){
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }

}