package Math.P415;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 */
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0){
            int x = i < 0 ? 0 : num1.charAt(i--) - '0';
            int y = j < 0 ? 0 : num2.charAt(j--) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        if (carry!=0) {sb.append(carry);}
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("123","456"));
        System.out.println(new Solution().addStrings("544","456"));
    }
}