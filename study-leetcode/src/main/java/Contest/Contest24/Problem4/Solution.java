package Contest.Contest24.Problem4;

class Solution {
    public char findKthBit(int n, int k) {
        //定义dp问题 当n=i的时候对应的字符串
        String s="0";
        for (int i = 1; i < n; i++) {
            s=s+"1"+invertAndReverse(s);
        }
        return s.charAt(k-1);
    }
    private String invertAndReverse(String string){
        StringBuilder result=new StringBuilder(string);
        for (int i = 0; i < result.length(); i++) {
            Character character=result.charAt(i)=='0'?'1':'0';
            result.setCharAt(i,character);
        }
        result.reverse();
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findKthBit(3,1));
        System.out.println(new Solution().findKthBit(4,11));
        System.out.println(new Solution().findKthBit(1,1));
        System.out.println(new Solution().findKthBit(2,3));
    }
}