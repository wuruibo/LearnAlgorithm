package WaitingCollect.P647;

class Solution {
    boolean[][] booleans;
    public int countSubstrings(String s) {
        if (s==null || s.length()==0) {
            return 0;
        }
        booleans=new boolean[s.length()][s.length()];
        int count=0;
        //一层循环定义长度
        for (int i = 1; i <=s.length(); i++) {
            //定义
            for (int j = 0; j+i-1 < s.length(); j++) {
                if (i==1) {
                    booleans[j][j]=true;
                }else if (i==2) {
                    booleans[j][j+1] = s.charAt(j)==s.charAt(j+1);
                }else {
                    booleans[j][j+i-1]=(s.charAt(j)==s.charAt(j+i-1) && booleans[j+1][j+i-2]);
                }
                if (booleans[j][j+i-1]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s="aaa";
        System.out.println(new Solution().countSubstrings(s));

        String s1="abc";
        System.out.println(new Solution().countSubstrings(s1));
    }
}