package Contest.Contest37.Problem2;

class Solution {
    private Integer number=5;
    public int countVowelStrings(int n) {
        return dfs(0,0,n);
    }
    private int dfs(int length,int i,int n){
        if (length==n) {
            return 1;
        }
        int result=0;
        for (int j = i; j < number; j++) {
            result+=dfs(length+1,j,n);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countVowelStrings(1));
        System.out.println(new Solution().countVowelStrings(2));
        System.out.println(new Solution().countVowelStrings(33));
    }
}