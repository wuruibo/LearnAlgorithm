package BackTracking.P526;

class Solution {
    private boolean[] used;
    public int countArrangement(int N) {
        used=new boolean[N];
        return dfs(N,1);
    }
    private int dfs(int N, int position){
        if (position==N+1) {
            return 1;
        }
        int result=0;
        for (int i = 0; i < N; i++) {
            if (!used[i] && fit(position,i+1)) {
                used[i]=true;
                result+=dfs(N,position+1);
                used[i]=false;
            }
        }
        return result;
    }

    /**
     * 判断当前选取的值是否满足条件
     * 1.第 i 位的数字能被 i 整除
     * 2.i 能被第 i 位上的数字整除
     * @param position
     * @param value
     * @return
     */
    private boolean fit(int position,int value){
        return value%position==0 || position%value==0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countArrangement(3));
        System.out.println(new Solution().countArrangement(5));
    }
}