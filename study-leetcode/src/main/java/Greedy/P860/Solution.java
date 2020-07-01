package Greedy.P860;

import java.util.List;

/**
 * 860. Lemonade Change
 * Easy
 *
 * 492
 *
 * 73
 *
 * Add to List
 *
 * Share
 * At a lemonade stand, each lemonade costs $5.
 *
 * Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).
 *
 * Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.  You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.
 *
 * Note that you don't have any change in hand at first.
 *
 * Return true if and only if you can provide every customer with correct change.
 *
 *
 *
 * Example 1:
 *
 * Input: [5,5,5,10,20]
 * Output: true
 * Explanation:
 * From the first 3 customers, we collect three $5 bills in order.
 * From the fourth customer, we collect a $10 bill and give back a $5.
 * From the fifth customer, we give a $10 bill and a $5 bill.
 * Since all customers got correct change, we output true.
 * Example 2:
 *
 * Input: [5,5,10]
 * Output: true
 * Example 3:
 *
 * Input: [10,10]
 * Output: false
 * Example 4:
 *
 * Input: [5,5,10,10,20]
 * Output: false
 * Explanation:
 * From the first two customers in order, we collect two $5 bills.
 * For the next two customers in order, we collect a $10 bill and give back a $5 bill.
 * For the last customer, we can't give change of $15 back because we only have two $10 bills.
 * Since not every customer received correct change, the answer is false.
 *
 *
 * Note:
 *
 * 0 <= bills.length <= 10000
 * bills[i] will be either 5, 10, or 20.
 */
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) {five--; ten++;}
            else if (ten > 0) {ten--; five--;}
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }
    public boolean lemonadeChangeClear(int[] bills) {
        // greedy, pay change as large as possible
        int[] changes = new int[2]; // changes[0] - $5, changes[1] - $10, $20 cannot be change so ignore it
        for (int bill : bills) {
            if (bill == 5) changes[0]++;
            else {
                if (bill == 10) changes[1]++;
                int change = bill-5;
                while (changes[1] > 0 && change >= 10) {
                    change -= 10;
                    changes[1]--;
                }
                while (changes[0] > 0 && change >= 5) {
                    change -= 5;
                    changes[0]--;
                }
                if (change != 0) return false;
            }
        }

        return true;
    }
    private boolean greedy(int[] bills, int end, List<Integer> coins){
        if (end<0) return true;

        boolean sub=greedy(bills,end-1,coins);
        int left=bills[end]-5,change=0;
        //开始从有序列表里面以贪心的方式拿coin
        if (sub && left==0) {
            insert(coins,bills[end]);
            return true;
        }else {
            for (int i = coins.size() - 1; sub && i >= 0; i--) {
                if (coins.get(i) <= left) {
                    change += coins.get(i);
                    coins.remove(i);
                    if (change == left) {
                        insert(coins, bills[end]);
                        return true;
                    }
                }
            }
            return false;
        }
    }
    private void insert(List<Integer> coins,int target){
        int begin=0,end=coins.size()-1;
        while (begin<=end){
            int mid=begin+((end-begin)>>1);
            if (target>=coins.get(mid)) {
                begin=mid+1;
            }else {
                end=mid-1;
            }
        }
        coins.add(begin,target);
    }

    public static void main(String[] args) {

/*        Stack<Integer> stack=new Stack<>();
        Integer count=stack.pop();
        System.out.println(count);*/
        int[] test = {5,5,5,5,10,5,10,10,10,20};
        System.out.println(new Solution().lemonadeChange(test));

        int[] test1 = {};
        System.out.println(new Solution().lemonadeChange(test1));

        int[] test2={10,10};
        System.out.println(new Solution().lemonadeChange(test2));

        int[] test3={5,5,10,10,20};
        System.out.println(new Solution().lemonadeChange(test3));
    }
}