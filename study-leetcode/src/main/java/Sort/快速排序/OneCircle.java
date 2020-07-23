package Sort.快速排序;

import java.util.Arrays;

public class OneCircle {
    public void quickSortOneCircle(int[] arr,int start,int end){
        if (start>=end) return;
        int index=oneCirCle(arr,start,end);
        quickSortOneCircle(arr,index+1,end);
        quickSortOneCircle(arr,start,index-1);
    }
    private int oneCirCle(int[] arr,int start,int end){
        int mark=start;
        int pointer=start;
        int privot=arr[start];
        while (pointer<=end){
            if (arr[pointer]<privot) {
                mark++;
                int temp=arr[mark];
                arr[mark]=arr[pointer];
                arr[pointer]=temp;
            }
            pointer++;
        }
        int temp=arr[mark];
        arr[mark]=arr[start];
        arr[start]=temp;

        return mark;
    }

    public static void main(String[] args) {
        int[] ints={-1,2,3,6,5,4,0,11,7};
        new OneCircle().quickSortOneCircle(ints,0,ints.length-1);
        System.out.println(Arrays.toString(ints));
        int[] ints1={2,1};
        new OneCircle().quickSortOneCircle(ints1,0,ints1.length-1);
        System.out.println(Arrays.toString(ints1));
    }
}
