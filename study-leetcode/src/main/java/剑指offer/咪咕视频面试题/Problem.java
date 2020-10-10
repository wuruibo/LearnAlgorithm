package 剑指offer.咪咕视频面试题;

/**
 * 打印输出
 */
public class Problem {

    public void print(int n){
        int start=1;
        for (int i = 0; i < n; i++) {
            if ((i&1)==0) {
                printString(start,start+i,true);
            }else {
                printString(start,start+i,false);
            }
            System.out.println();
            start+=(i+1);
        }
    }
    private void printString(int start,int end,boolean order){
        if (start==end) {
            System.out.print(start);
            return;
        }
        int mid=start+((end-start)>>1);
        if (order) printString(start,mid,order);
        else printString(mid+1,end,order);
        System.out.print("*");
        if (order) printString(mid+1,end,order);
        else printString(start,mid,order);
    }

    public static void main(String[] args) {
        new Problem().print(1);
    }
}
