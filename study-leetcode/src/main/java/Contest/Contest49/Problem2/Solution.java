package Contest.Contest49.Problem2;

/**
 * 001011
 */
class Solution {
    public int[] minOperations(String boxes) {
        int[] result=new int[boxes.length()];
        for (int i = 0; i < result.length; i++) {
            int l=i,r=i,temp=0;
            while (l>=0 || r<boxes.length()){
                if(l>=0 && boxes.charAt(l)=='1'){
                    temp+=i-l;
                }
                l--;
                if (boxes.length()>r && boxes.charAt(r)=='1') {
                    temp+=r-i;
                }
                r++;
            }
            result[i]=temp;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations("001011"));
    }
}