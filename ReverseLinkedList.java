package com.practice.datastruct.linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4,node1);
        ListNode node3 = new ListNode(4,node2);
        ListNode node4 = new ListNode(7,node3);
        ListNode node5 = new ListNode(1,node4);
//        traverse(node5);
        ListNode reversed = reverseList(node5);
        traverse(reversed);
    }

    private static ListNode reverseList(ListNode listNode) {
        int size = traverse(listNode);
        Stack stack = new Stack(size);
        stack.push(listNode);
        while(listNode.next!= null){
            stack.push(listNode.next);
            listNode = listNode.next;
        }
        ListNode newNode = listNode;
        stack.pop(new ListNode());
        while(true){
            newNode.next = stack.pop(new ListNode());
            if(newNode.next == null)
                break;
            newNode = newNode.next;
        }
        newNode.next = null;

        return listNode;
    }

    private static int traverse(ListNode node) {
        int count = 0;
        while(node!=null){
            count++;
            System.out.print(node.val + " " );
            node = node.next;
        }
        return count;
    }
}
