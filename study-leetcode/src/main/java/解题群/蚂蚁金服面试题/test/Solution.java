package 解题群.蚂蚁金服面试题.test;

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        boolean first=equalsMat(mat,target);
        rolate(mat);
        boolean second=equalsMat(mat,target);
        rolate(mat);
        boolean third=equalsMat(mat,target);
        rolate(mat);
        boolean fourth=equalsMat(mat,target);
        return first || second || third || fourth;
    }
    private void rolate(int[][] mat){
        //先按照横线对换一次
        for(int j=0;j<mat[0].length;j++){
            for(int i=0;i<mat.length/2;i++){
                swap(mat,i,j,mat.length-i-1,j);
            }
        }
        //斜线变换一次
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<=i;j++){
                swap(mat,i,j,j,i);
            }
        }
    }
    private boolean equalsMat(int[][] mat,int[][] target){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]!=target[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    private void swap(int[][] mat,int x,int y,int nx,int ny){
        int temp=mat[x][y];
        mat[x][y]=mat[nx][ny];
        mat[nx][ny]=temp;
    }
    private static void get() throws Exception {

        try {
            int a=1+1;
            throw new Exception("1");
        } catch (Exception e) {
            throw new Exception("11");
        } finally {
            System.out.println(111);
        }
    }


    public static void main(String[] args) throws Exception {
        Solution.get();
        System.out.println(new Solution().findRotation(new int[][]{{0, 1}, {1, 0}}, new int[][]{{1, 0}, {0, 1}}));
        //1 1   1 1
        //0 1   1 0
        System.out.println(new Solution().findRotation(new int[][]{{1,1},{0,1}}, new int[][]{{1,1},{1,0}}));
        //0 0   0 0
        //0 1   1 0
        System.out.println(new Solution().findRotation(new int[][]{{0,0},{0,1}}, new int[][]{{0,0},{1,0}}));
    }
}
