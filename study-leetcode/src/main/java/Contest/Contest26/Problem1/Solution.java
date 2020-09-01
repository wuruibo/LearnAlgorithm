package Contest.Contest26.Problem1;

class Solution {
    public String thousandSeparator(int n) {
        if (n==0) {
            return "0";
        }
        StringBuilder result=new StringBuilder();
        int length=0;
        while (n != 0) {
            result.append(n%10);
            n/=10;
            if (++length%3==0 && n!=0) {
                result.append(".");
            }
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().thousandSeparator(987));
        System.out.println(new Solution().thousandSeparator(1234));
        System.out.println(new Solution().thousandSeparator(123456789));
        System.out.println(new Solution().thousandSeparator(0));
    }
}