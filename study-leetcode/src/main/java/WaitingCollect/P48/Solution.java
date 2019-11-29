package WaitingCollect.P48;

class Solution {
    private int[][] matrix;
    public void rotate(int[][] matrix) {
        this.matrix=matrix;
        revese();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix.length; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
    public void revese(){
        for (int i = 0; i < matrix.length / 2; i++) {
            int[] temp=matrix[i];
            matrix[i]=matrix[matrix.length-1-i];
            matrix[matrix.length-i-1]=temp;
        }
    }
/*    public void swap(Object start,Object to){
        Object temp=to;
        to=start;
        start=temp;
    }*/

    /*public void buildDoubleList(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            List<Integer> temp=new ArrayList<>();
            for (int j = 0; j < matrix.length; j++) {
                temp.add(matrix[i][j]);
            }
            list.add(temp);
        }
    }*/

    public static void main(String[] args) {
        int[][] ints={{1,2,3},{4,5,6},{7,8,9}};
        new Solution().rotate(ints);
    }
}