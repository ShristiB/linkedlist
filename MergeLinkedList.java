package com.practice.datastruct.linkedlist;
import static com.practice.datastruct.linkedlist.LinkedList.Node;

public class MergeLinkedList {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.head = new Node(4);
        l1.addNodeInSortedList(new Node(6));
        l1.addNodeInSortedList(new Node(3));
        l1.addNodeInSortedList(new Node(5));
        l1.addNodeInSortedList(new Node(4));
        l1.traverse();
        LinkedList l2 = new LinkedList();
        l2.head = new Node(4);
        l2.addNodeInSortedList(new Node(1));
        l2.addNodeInSortedList(new Node(8));
        l2.addNodeInSortedList(new Node(6));
        l2.addNodeInSortedList(new Node(4));
        l2.traverse();
        LinkedList newList = new LinkedList();
        newList.head = mergeLists(l1,l2);
        newList.traverse();
//        LinkedList newList2 = new LinkedList();
//        newList2.head = mergeRecursively(l1.head, l2.head);
//        newList2.traverse();
    }

    private static Node mergeRecursively(Node head1, Node head2) {
        if(head1 == null) {
            return head2;
        }
        if(head2 == null) {
            return head1;
        }
        Node result;
        if(head1.data < head2.data){
            result = head1;
            result.next = mergeRecursively(head1.next,head2);
        }else{
            result = head2;
            result.next = mergeRecursively(head1,head2.next);
        }
        return result;
    }

    private static Node mergeLists(LinkedList l1, LinkedList l2) {
        Node currNode1 = l1.head;
        Node currNode2 = l2.head;
        Node dummyNode = new Node(-1);
        Node currDummy = dummyNode;

        while (currNode1 != null && currNode2 != null) {
            if (currNode1.data <= currNode2.data) {
                currDummy.next = currNode1;
                currNode1 = currNode1.next;
            } else {
                currDummy.next = currNode2;
                currNode2 = currNode2.next;
            }
            currDummy = currDummy.next;
        }
        while (currNode1 != null) {
            currDummy.next = currNode1;
            currNode1 = currNode1.next;
        }
        while(currNode2 != null){
            currDummy.next = currNode2;
            currNode2 = currNode2.next;
        }
        return dummyNode.next;
    }
}
