package BrickWorker;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor yeqiaozhu.
 * @date 2019-12-20
 */
public class BrickWorkerEat {
    private int[] data;
    //用于存储每次吃完毒药老鼠是否死掉
    List<Integer> result=new ArrayList<>();
    /**
     * 输入酒桶列表
     * -1表示为毒酒
     * 0表示非毒酒
     * @param data
     * @return
     */
    public int getLaoheiDeDuLaoShu(int[] data){
        this.data=data;
        int start=0,end=data.length-1,index=0;/*
        //现在已经拿到结果集了 十天潜伏期到了老鼠该死死 如何优雅的拿到正确的结果集
        laoShuSiLeMe();*/
        //根据测试的结果 二分推出那桶就有毒
        while (start<end){
            int mid=(start+end)/2;

            if (result.get(index)==1) {
                start=mid+1;
            }else {
                end=mid;
            }
        }
        return start;
    }

    /**
     * 吃法非常重要
     * 每次二分之后都要跳着吃
     * 每次只吃第一个子集
     * @return
     */
    private List<Boolean> laoShuSiLeMe(){
        //每次需要吃的酒桶数量
        List<Boolean> result= new ArrayList<>();
        int step=data.length/2,index=0;
        //这个外部循环为log2n次表示只需log2n只老鼠
        while (step<data.length){
            index=0;
            while (index<data.length) {
                if (data[index += step] == -1) {
                    result.add(true);
                    break;
                }
            }
            result.add(false);
            step*=2;
        }
        return result;
    }

    /**
     * step为每次二分左子集end-start
     * @param start
     * @param end
     * @param step
     */
    private void recursive(int start,int end,int step){
        if (end-start==step) {
            //遍历一下是否有毒
            for (int i = start; i <= end; i++) {
                if (data[i]==-1) {
                    result.add(data.length-(end-start),1);
                    return;
                }
            }
        }
        int mid=(start+end)/2;
        recursive(start,mid,step);
        recursive(mid+1,end,step);
    }

}
