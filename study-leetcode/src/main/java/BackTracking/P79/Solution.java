
package BackTracking.P79;

/**
 * using backtracking
 */
class Solution {
    private char[][] board;
    private String target;
    private char flag='0';
    public boolean exist(char[][] board, String word) {
        this.board=board;
        this.target=word;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backTracking(0,i,j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTracking(int index,int i,int j){
        if (index==target.length()) {
            return true;
        }
        if (i>board.length-1 || i<0 || j>board[0].length-1 || j<0 || board[i][j]==flag || board[i][j]!=target.charAt(index)) {
            return false;
        }
        //标记为不可用
        board[i][j]=flag;
        boolean sub=backTracking(index+1,i+1,j) || backTracking(index+1,i-1,j) || backTracking(index+1,i,j-1) || backTracking(index+1,i,j+1);
        //重新标记为可用
        board[i][j]=target.charAt(index);
        return sub;
    }

    public static void main(String[] args) {
        char[][] chars={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] chars1={{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        System.out.println(new Solution().exist(chars,"ABCCED"));
        System.out.println(new Solution().exist(chars,"SEE"));
        System.out.println(new Solution().exist(chars,"ABCB"));
        System.out.println(new Solution().exist(chars1,"oath"));


    }
}