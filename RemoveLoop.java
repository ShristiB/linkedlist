package com.practice.datastruct.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class RemoveLoop {
    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        ListNode node2 = new ListNode(4,node);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(2, node3);
        ListNode node5 = new ListNode(1, node4);
        node.next = node3;
        removeloop(node5);
        traverse(node5);

    }

    private static void removeloop(ListNode listNode) {
        List<ListNode> list = new ArrayList<>();
        if(listNode == null)
            return;
        while(listNode.next!=null){
            if(list.contains(listNode.next))
                break;
            else
                list.add(listNode.next);
            listNode = listNode.next;
        }
        listNode.next = null;
    }

    private static void traverse(ListNode listNode) {
        while(listNode!=null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
