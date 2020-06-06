package LinkedList.P1290;

import CommonUtils.ListNodeUtils;
import LinkedList.AddTwoNumbers.ListNode;

/**
 *
 * Example 1:
 *
 *
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 * Example 2:
 *
 * Input: head = [0]
 * Output: 0
 * Example 3:
 *
 * Input: head = [1]
 * Output: 1
 * Example 4:
 *
 * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * Output: 18880
 * Example 5:
 *
 * Input: head = [0,0]
 * Output: 0
 *
 *
 * Constraints:
 *
 * The Linked List is not empty.
 * Number of nodes will not exceed 30.
 * Each node's value is either 0 or 1.
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private int result=0;
    public int getDecimalValue(ListNode head) {
        recursive(head);
        return result;
    }

    private int recursive(ListNode head){
        if (head==null) {
            return -1;
        }
        int depth=recursive(head.next)+1;
        int temp=1;
        for (int i = 0; i < depth; i++) {
            temp*=2;
        }
        result+=(temp*head.val);
        return depth;
    }

    public static void main(String[] args) {
        int[] ints={1,0,0,1,0,0,1,1,1,0,0,0,0,0,0};
        ListNode listNode= ListNodeUtils.buildWithArray(ints);
        System.out.println(new Solution().getDecimalValue(listNode));


        int[] ints1={1};
        ListNode listNode1= ListNodeUtils.buildWithArray(ints1);
        System.out.println(new Solution().getDecimalValue(listNode1));

        int[] ints2={0};
        ListNode listNode2= ListNodeUtils.buildWithArray(ints2);
        System.out.println(new Solution().getDecimalValue(listNode2));
    }
}