package Contest.Contest39.Problem2;

/**
 * 具有给定数值的最小字符串
 */
class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder result=new StringBuilder();
        while (n>0){
            int left=(n-1)*26;
            int right=n*26;
            if (k > left && k<=right) {
                n--;
                result.append((char) (k-left-1+'a'));
                k=left;
                for (int i = 0; i < n - 1; i++) {
                    result.append("z");
                    k-=26;
                    n--;
                }
            }else {
                result.append("a");
                k--;
                n--;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getSmallestString(3, 27));
        System.out.println(new Solution().getSmallestString(5, 73));
    }
}