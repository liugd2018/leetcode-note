package com.liugd;

import java.util.Objects;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * @author <a href="mailto:liugd2020@gmail.com">liuguodong</a>
 * @since 1.0
 */
public class Leetcode206ReverseList {
    public static void main(String[] args) {

        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

//        ListNode listNode = reverseList(listNode1);
        ListNode listNode = reverseSimple(listNode1);
//        ListNode listNode = reverseList1(listNode1);

        System.out.println(listNode);


    }

    public static ListNode reverseSimple(ListNode head){

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode reverseList(ListNode head) {
        // 最后节点数据
        ListNode postListNode = new ListNode();
        return recursion(head, postListNode);
    }

    private static ListNode recursion(ListNode pre, ListNode post){

        if (Objects.isNull(pre)) return null;
        
        ListNode next = pre.next;
        // next节点是空说明是最后节点
        if (Objects.isNull(next)){
            post.val = pre.val;
        } else {
            // 创建新一个节点,需要把不是最后节点赋值给next,然后把next节点在赋值给最终节点
            ListNode cur = new ListNode();
            cur.next = post.next;
            cur.val = pre.val;
            post.next = cur;
            recursion(next, post);
        }
        return post;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
