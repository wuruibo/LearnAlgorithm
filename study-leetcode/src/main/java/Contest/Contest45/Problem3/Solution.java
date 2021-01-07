package Contest.Contest45.Problem3;

/**
 * 输入：binary = "000110"
 * 输出："111011"
 * 解释：一个可行的转换为：
 * "000110" -> "000101"
 * "000101" -> "100101"
 * "100101" -> "110101"
 * "110101" -> "110011"
 * "110011" -> "111011"
 */
class Solution {
    public String maximumBinaryString(String binary) {
        char[] chars = binary.toCharArray();
        int length = chars.length;
        int[] z = new int[length];
        int j = 0;
        //记录0的位置
        for (int i = 0; i < length; i++) {
            if (chars[i] == '0') {
                z[j++] = i;
            }
        }

        for (int i = 0; i < j - 1; i++) {
            //00->10
            if (z[i] + 1 == z[i + 1]) {
                chars[z[i]] = '1';
            } else {
                // 0111……10可以直接变1011……11
                chars[z[i]] = '1';
                chars[z[i + 1]] = '1';
                z[i + 1] = z[i] + 1;
                chars[z[i + 1]] = '0';// 0记录变更
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumBinaryString("000110"));
        System.out.println(new Solution().maximumBinaryString("01"));
        System.out.println(new Solution().maximumBinaryString("11"));
        System.out.println(new Solution().maximumBinaryString("000110"));
        System.out.println(new Solution().maximumBinaryString("101010111011001101000110010001100001111"));
        System.out.println(new Solution().maximumBinaryString("111111111111111111011111111111111111111"));
        System.out.println(new Solution().maximumBinaryString("111111111111111111101111111111111111111"));
    }
}