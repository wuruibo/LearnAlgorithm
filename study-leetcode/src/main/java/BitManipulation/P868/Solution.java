package BitManipulation.P868;

/**
 *
 */
class Solution {
    public int binaryGap(int N) {
        //这里count初始化为0，解决了只含一个1或不含1的情况
        int count = 0, max = 0;
        while(N != 0){
            //判断最后一位是否为1 可以用N&1进行操作
            if((N & 1) == 1){
                max = Math.max(count,max);
                count = 1;
            }else{
                if(count > 0) {
                    //在遇到一个1之后的0才开始计数
                    count++;
                }
            }
            N = N >> 1;
        }
        return max;
    }
}