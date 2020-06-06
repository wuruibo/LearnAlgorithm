package Math.P43;

/**
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 * 大数相乘
 */
class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                //step1 计算当前位置的乘积
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                //找到准备存储 mul的位置
                int p1 = i + j, p2 = i + j + 1;
                //如果当前位置有值 加上这个已有的值
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().multiply("2","3"));
        System.out.println(new Solution().multiply("123","456"));
    }
}