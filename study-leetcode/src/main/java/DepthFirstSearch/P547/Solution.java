package DepthFirstSearch.P547;

/**
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
 *
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.
 *
 * Example 1:
 * Input:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 * Example 2:
 * Input:
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 * so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 * Note:
 * N is in range [1,200].
 * M[i][i] = 1 for all students.
 * If M[i][j] = 1, then M[j][i] = 1.
 */
class Solution {
    public int findCircleNum(int[][] M) {
        int result=0;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j]==1) {
                    dfs(M,i,j);
                    result++;
                }
            }
        }
        return result;
    }
    public void dfs(int[][] M,int i,int j){
        if (i<0 || j<0 || i>=M[0].length || j>=M.length || M[i][j]!=1) return;
        M[i][j]=0;
        //横向扩展
        for (int k = 0; k < M[0].length; k++) {
            if (M[i][k]==1) {
                dfs(M,i,k);
            }
        }
        //纵向扩展
        for (int m = 0; m < M.length; m++) {
            if (M[m][j]==1) {
                dfs(M,m,j);
            }
        }
    }

    public static void main(String[] args) {
        int[][] M={{1,1,0},
                   {1,1,0},
                   {0,0,1}};
        System.out.println(new Solution().findCircleNum(M));

        int[][] M1={{1,0,0,1},
                    {0,1,1,0},
                    {0,1,1,1},
                    {1,0,1,1}};
        System.out.println(new Solution().findCircleNum(M1));

        int[][] M2={{1,1,0},
                {1,1,1},
                {0,1,1}};
        System.out.println(new Solution().findCircleNum(M2));

    }
}