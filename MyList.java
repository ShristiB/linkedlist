package com.practice.datastruct.linkedlist;
import com.practice.datastruct.linkedlist.LinkedList.Node;

public class MyList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

//        ll.addNodeAtEnd(new Node(2));
//        ll.addNodeAtEnd(new Node(3));
//        ll.addNodeAtEnd(new Node(4));
//        ll.addNodeAtBeginning(new Node(4));
//        ll.addNodeAtBeginning(new Node(4));
//        ll.addNodeAtEnd(new Node(5));
//        ll.traverse();
//        ll.deleteHeadNode();
//        ll.deleteHeadNode();
//        ll.traverse();
        ll.addNodeInSortedList(new Node(4));
        ll.addNodeInSortedList(new Node(2));
        ll.addNodeInSortedList(new Node(8));
        ll.addNodeInSortedList(new Node(7));
        ll.addNodeInSortedList(new Node(6));
        ll.addNodeInSortedList(new Node(3));
        ll.addNodeInSortedList(new Node(5));
        ll.addNodeInSortedList(new Node(1));
//        ll.addNodeInSortedList(new Node(2));
        ll.traverse();

    }

}

class LinkedList{
    Node head;

    static class Node{

        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    public void addNodeAtBeginning(Node node) {
        if(head==null)
            head = node;
        else{
            Node tmpNode = head;
            head = node;
            node.next = tmpNode;
        }
    }

    public void addNodeAtEnd(Node node) {
        if(head == null){
            head = node;
        }
        else{
            Node currNode = head;
            while (currNode.next!=null){
                currNode = currNode.next;
            }
            currNode.next = node;
            node.next = null;
        }
    }

    public void deleteHeadNode() {
        if(head == null)
            return;
        else{
            System.out.println("\ndeleting head :"+ head.data);
            if(head.next!=null){
                Node currNode = head.next;
                head = currNode;
            }else{
                head = null;
            }
        }
    }

    public void addNodeInSortedList(Node node) {
        if(head == null)
            head = node;
        else if(node.data<head.data)
            addNodeAtBeginning(node);
        else{
            Node currNode = head;
            while(currNode.next!=null){
                if(node.data < currNode.next.data){
                    Node tmp = currNode.next;
                    currNode.next = node;
                    node.next = tmp;
                    break;
                }
                currNode = currNode.next;
            }
            currNode.next = node;
        }
    }

    public void traverse(){
        if(head == null)
            return;
        if(head.next == null)
            System.out.print(head.data);
        else if(head!=null){
            Node currNode = head;
            while(currNode != null){
                System.out.print(currNode.data + " ");
                currNode = currNode.next;
            }
        }
        System.out.print("\n");
    }

}