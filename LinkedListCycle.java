package com.practice.datastruct.linkedlist;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        ListNode node2 = new ListNode(4, node);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(2, node3);
        ListNode node5 = new ListNode(1, node4);
        ListNode node6 = new ListNode(0, node5);
        node.next = node4; // comment this to make it linear linked list
        System.out.println(checkCyclicList(node6));
//        traverse(node6);
    }

    private static boolean checkCyclicList(ListNode listNode) {
        if(listNode!=null && listNode.next!=null){
            ListNode head = listNode;
            ListNode nextNode = head.next;
            while(head!=null && nextNode.next!=null){
                if(head.next == nextNode.next){
                    return true;
                }
                head = head.next;
                nextNode = nextNode.next.next;
            }
        }
        return false;
    }

    private static void traverse(ListNode listNode) {
        while(listNode!=null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

}
