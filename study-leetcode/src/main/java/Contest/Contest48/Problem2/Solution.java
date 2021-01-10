package Contest.Contest48.Problem2;

import CommonUtils.ListNodeUtils;
import LinkedList.AddTwoNumbers.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[1,4,3,2,5]
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        //计算连表长度
        ListNode current=head;
        int count=0;
        while (current != null) {
            count++;
            current=current.next;
        }
        //找到左边的位置
        int left=1;
        ListNode l=head;
        while (left!=k){
            left++;
            l=l.next;
        }
        //找到右边的位置
        //找到左边的位置
        int right=0;
        ListNode r=head;
        while (right!=count-k){
            right++;
            r=r.next;
        }
        //交换左右两边的元素
        int temp=l.val;
        l.val=r.val;
        r.val=temp;

        return head;
    }

    public static void main(String[] args) {
        ListNode head= ListNodeUtils.buildWithArray(new int[]{1,2,3,4,5});
        System.out.println(new Solution().swapNodes(head, 2));

        ListNode head1= ListNodeUtils.buildWithArray(new int[]{7,9,6,6,7,8,3,0,9,5});
        System.out.println(new Solution().swapNodes(head1, 5));

        ListNode head2= ListNodeUtils.buildWithArray(new int[]{1});
        System.out.println(new Solution().swapNodes(head2, 1));

        ListNode head3= ListNodeUtils.buildWithArray(new int[]{1,2});
        System.out.println(new Solution().swapNodes(head3, 1));

        ListNode head4= ListNodeUtils.buildWithArray(new int[]{1,2,3});
        System.out.println(new Solution().swapNodes(head4, 2));
    }
}