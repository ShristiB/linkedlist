package com.practice.datastruct.linkedlist;

public class RemoveDuplicate {
    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        ListNode node2 = new ListNode(4,node);
        ListNode node3 = new ListNode(2, node2);
        ListNode node4 = new ListNode(2, node3);
        ListNode node5 = new ListNode(1, node4);
        traverse(node5);
        removeduplicate(node5);
        System.out.print("\n");
        traverse(node5);
    }

    private static void removeduplicate(ListNode listNode) {
        if(listNode == null || listNode.next == null)
            return;
        ListNode currNode = listNode;
        ListNode nextNode = listNode.next;
        while(nextNode!=null){
            if(currNode.val == nextNode.val){
                currNode.next = nextNode.next;
                nextNode = nextNode.next;
            }else{
                currNode = currNode.next;
                nextNode = nextNode.next;
            }

        }


    }

    private static void traverse(ListNode listNode) {
        while(listNode!=null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
