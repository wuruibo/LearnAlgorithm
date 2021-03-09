package Contest.Contest51.Problem1;

class Solution {
    public boolean checkOnesSegment(String s) {
        String[] strings=s.split("0");
        int count=strings.length;
        for (String string : strings) {
            if (string.length()==1 && string.charAt(0)=='0') {
                count--;
            }
        }
        return count==1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkOnesSegment("110"));
        System.out.println(new Solution().checkOnesSegment("1"));
        System.out.println(new Solution().checkOnesSegment("1001"));
    }
}