package Contest.Contest37.Problem1;

/**
 * 问题转换为arr由pieces组成
 */
class Solution {
    private int[][] pieces;
    public boolean canFormArray(int[] arr, int[][] pieces) {
        this.pieces=pieces;
        return dfs(arr,new int[arr.length],0);
    }
    private boolean dfs(int[] arr,int[] visited,int i){
        if (i>=arr.length-1) {
            return true;
        }
        for (int j = i; j < arr.length; j++) {
            if (containsPieces(arr,i,j,pieces) && dfs(arr,visited,j+1)) {
                return true;
            }
        }
        return false;
    }
    private boolean containsPieces(int[] arr,int i,int j,int[][] pieces){
        for (int k = 0; k < pieces.length; k++) {
            int[] array =pieces[k];
            if (array.length==j-i+1) {
                int temp=0;
                while (temp<array.length && array[temp]==arr[i]){
                    temp++;
                    i++;
                }
                if (temp==array.length) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canFormArray(new int[]{91, 4, 64, 78}, new int[][]{{78}, {4, 64}, {91}}));
        System.out.println(new Solution().canFormArray(new int[]{37,69,3,74,46},new int[][]{{37,69,3,74,46}}));
        System.out.println(new Solution().canFormArray(new int[]{85}, new int[][]{{85}}));
        System.out.println(new Solution().canFormArray(new int[]{15,18}, new int[][]{{18},{15}}));
        System.out.println(new Solution().canFormArray(new int[]{49,18,16}, new int[][]{{16,18,49}}));
        System.out.println(new Solution().canFormArray(new int[]{1,3,5,7}, new int[][]{{2,4,6,8}}));
    }
}