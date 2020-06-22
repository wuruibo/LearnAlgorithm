package Sort.P1356;

import java.util.HashMap;
import java.util.Map;

/**
 * 1356. 根据数字二进制下 1 的数目排序
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 *
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 *
 * 请你返回排序后的数组。
 */
class Solution {
    public int[] sortByBits(int[] arr) {
        //用set存一下吧 每次都算
        Map<Integer,Integer> map= new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],countBit(arr[i]));
        }
        quickSort(arr,0,arr.length-1,map);
        return arr;
    }
    private void quickSort(int[] arr,int start,int end,Map<Integer,Integer> map){
        if (start>=end) {
            return;
        }
        int privot=map.get(arr[start]),mark=start,pointer=start;
        while (pointer<=end){
            if (map.get(arr[pointer])<privot) {
                mark++;
                swap(arr,mark,pointer);
            }else if (map.get(arr[pointer])==privot && arr[pointer]<arr[start]){
                mark++;
                swap(arr,mark,pointer);
            }
            pointer++;
        }
        swap(arr,mark,start);

        quickSort(arr,start,mark,map);
        quickSort(arr,mark+1,end,map);
    }
    private void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    private int countBit(int param){
        int sum=0;
        while (param!=0){
            sum+=(param&1);
            param>>=1;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] test={0,1,2,3,4,5,6,7,8};
        System.out.println(new Solution().sortByBits(test));
    }
}