package com.feng.algorithm.question1;

import org.apache.logging.log4j.util.Strings;

import java.util.List;

/**
 * @author zhangfeng
 * @date 2020/5/28 11:47 上午
 * 2 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question2 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);


        Question2 question2 = new Question2();
        ListNode listNode  = question2.addTwoNumbers(listNode1, listNode2);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int result1 = getNumb(l1,0,0);
        int result2 = getNumb(l2,0,0);
        int result = result1 +result2;
        System.out.println("结果："+result);
        String rec = new StringBuffer(result+"").reverse().toString();
        System.out.println("反转后的结果："+rec);
        String[] arrStr = rec.split("");
        ListNode listNode = null;
        for (int i=0; i<arrStr.length; i++) {
            System.out.println(arrStr[i]);
            if (i == 0 ) {
                listNode = new ListNode(Integer.parseInt(arrStr[i]));
                continue;
            }
            insertTail(new ListNode(Integer.parseInt(arrStr[i])), listNode);
        }
        return listNode;
    }

    public void insertTail (ListNode addNode, ListNode listNode) {
        ListNode temp = listNode;
        while (true) {
            if (listNode.next == null) {
                // 将新增的数据添加到尾节点
                listNode.next = addNode;
                break;
            }
            if (temp != null) {
                temp = temp.next;
            }
        }
    }

    public int getNumb (ListNode l1, int time, int lastVal) {
        int val = (int)(lastVal + l1.val * Math.pow(10,time));
        if (l1.next != null) {
            return getNumb(l1.next, time+1, val);
        }
        return val;
    }

}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
