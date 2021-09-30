package com.practice.datastruct.linkedlist;

public class RotateLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        ListNode node2 = new ListNode(4,node);
        ListNode node3 = new ListNode(2, node2);
        ListNode node4 = new ListNode(2, node3);
        ListNode node5 = new ListNode(1, node4);
        int k = 4;
        traverse(node5);
        ListNode newList = rotateList(node5, k);
        System.out.print("\n");
        traverse(newList);
    }

    private static ListNode rotateList(ListNode listNode, int k) {
        if(k<=0 || listNode==null || listNode.next == null)
            return listNode;
        int count = 0;
        ListNode head = listNode;
        ListNode nextNode = new ListNode();
        ListNode headNode = listNode;
        while(listNode.next!=null){
            count++;
            if(count == k){
                nextNode = listNode.next;
                headNode = nextNode;
                listNode.next = null;
                break;
            }
            listNode = listNode.next;
        }
        if(k>count)
            return head;
        if(nextNode != null) {
            while (nextNode.next != null) {
                nextNode = nextNode.next;
            }
            nextNode.next = head;
        }
        return headNode;
    }

    private static void traverse(ListNode listNode) {
        while(listNode!=null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

}
