package Design.P295;

import java.util.LinkedList;
import java.util.List;

/**
 * == 插入排序实现方式 关键是找到插入的位置
 *
 *
 * @autor yeqiaozhu.
 * @date 2019-12-25
 */
public class UsingSort {
    List<Integer> queue= new LinkedList<>();
    /** initialize your data structure here. */
    public UsingSort() {

    }

    public void addNum(int num) {
        int start=0,end=queue.size()-1;

        while (start<=end){
            int mid=(start+end)/2;

            if (queue.get(mid)>num) {
                end=mid-1;
            }else {
                start=mid+1;
            }
        }
        int index=start>end?start:end;
        queue.add(index,num);
    }

    public double findMedian() {
        if (queue.size()==0) {
            return 0;
        }
        int mid=queue.size()/2;
        if ((queue.size()&1)==0) {
            return (queue.get(mid)+queue.get(mid-1))/2.0;
        }else {
            return queue.get(mid);
        }
    }

    public static void main(String[] args) {
        UsingSort usingSort=new UsingSort();
        System.out.println(usingSort.findMedian());
        usingSort.addNum(1);
        System.out.println(usingSort.findMedian());
        usingSort.addNum(2);
        System.out.println(usingSort.findMedian()); //-> 1.5
        usingSort.addNum(3);
        System.out.println(usingSort.findMedian()); //-> 2
        usingSort.addNum(8);
        System.out.println(usingSort.findMedian());
        usingSort.addNum(6);
        System.out.println(usingSort.findMedian());
    }
}
