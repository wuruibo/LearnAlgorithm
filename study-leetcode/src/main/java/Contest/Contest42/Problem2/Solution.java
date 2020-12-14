package Contest.Contest42.Problem2;

class Solution {
    public int minPartitions(String n) {
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < n.length(); i++) {
            int target=n.charAt(i)-'0';
            max=Math.max(target,max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minPartitions("32"));
        System.out.println(new Solution().minPartitions("82734"));
        System.out.println(new Solution().minPartitions("27346209830709182346"));
    }
}