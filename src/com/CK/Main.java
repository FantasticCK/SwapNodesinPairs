package com.CK;

public class Main {

    public static void main(String[] args) {
        ListNode l2 = new ListNode(1);
        ListNode l2_1 = new ListNode(2);
        ListNode l2_2 = new ListNode(3);
        ListNode l2_3 = new ListNode(4);
        ListNode l2_4 = new ListNode(10);
        l2_3.next = l2_4;
        l2_2.next = l2_3;
        l2_1.next = l2_2;
        l2.next = l2_1;

        Solution2 solution = new Solution2();
        ListNode.printListNode(solution.swapPairs(l2));
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode leftNode = head, rightNode = head.next, rightNextNode = head.next.next, prevNode = dummyHead;
        do {
            prevNode.next = rightNode;
            leftNode.next = rightNextNode;
            rightNode.next = leftNode;
            prevNode = leftNode;
            if (prevNode.next == null || prevNode.next.next == null) break;
            leftNode = prevNode.next;
            rightNode = leftNode.next;
            rightNextNode = rightNode.next;
        } while (rightNextNode != null);
        prevNode.next = rightNode;
        leftNode.next = rightNextNode;
        rightNode.next = leftNode;
        return dummyHead.next;
    }
}

class Solution2 {
    public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}