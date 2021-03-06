package com.liugd;

/**
 * TODO
 *
 * @author <a href="mailto:liugd2020@gmail.com">liuguodong</a>
 * @since 1.0
 */
public class Leetcode02AddTwoNumbers {
    /**
     *
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * 示例 2：
     *
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     * 示例 3：
     *
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     *  
     *
     * 提示：
     *
     * 每个链表中的节点数在范围 [1, 100] 内
     * 0 <= Node.val <= 9
     * 题目数据保证列表表示的数字不含前导零
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;

        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(6);
        ListNode listNode5 = new ListNode(4);
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode addTwoNumbers = addTwoNumbers1(listNode, listNode3);
        while (addTwoNumbers.next != null){
            System.out.print(addTwoNumbers.val);
            addTwoNumbers = addTwoNumbers.next;
        }

    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        int num = sum / 10;
        ListNode res = new ListNode(sum % 10);
        loopListNode(res, num, l1.next, l2.next);
        return res;
    }

    public static void loopListNode(ListNode res, int num, ListNode l1, ListNode l2){

        if (l1 != null || l2 != null || num != 0){
            int l1Var = l1 == null ? 0 : l1.val;
            int l2Var = l2 == null ? 0 : l2.val;
            int sum = l1Var + l2Var + num;
            int childNum = sum / 10;
            ListNode chidList= new ListNode(sum % 10);
            res.next = chidList;
            loopListNode(chidList, childNum, l1 == null ? null : l1.next, l2 == null ? null : l2.next);
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result;

        int sum = l1.val + l2.val;

        int num = sum / 10;
        int surplus =  sum % 10;
        result = new ListNode(surplus);

        loopListNode(result, l1.next, l2.next, num);

        return result;

    }
    static void loopListNode(ListNode returnListNode, ListNode l1, ListNode l2, int num){
        if(l1 != null || l2 != null || num != 0){
            int childL1 = l1 == null ? 0 : l1.val;
            int childL2 = l2 == null ? 0 : l2.val;

            int sum = childL1 + childL2 + num;
            int childNum = sum / 10;
            ListNode childNode = new ListNode(sum % 10);
            returnListNode.next = childNode;
            loopListNode(childNode, l1 == null ? null : l1.next, l2 == null ? null : l2.next, childNum);
        }
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
