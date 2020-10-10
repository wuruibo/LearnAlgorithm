package 剑指offer.咪咕视频面试题;

/**
 * 给定两个正整数数组
 * 输出升序数组
 * @autor yeqiaozhu.
 * @date 2020-04-30
 */
public class Solution {
    public int[] sortMergeArray(int[] arr1,int[] arr2){

        arr1=mergeSort(arr1,0,arr1.length-1);
        arr2=mergeSort(arr2,0,arr2.length-1);

        return mergeArray(arr1,arr2);
    }
    private int[] mergeSort(int[] input,int start,int end){
        if (start>end) return new int[0];//主要是防止输入的数组是{}这种空的情况
        if (start==end) return new int[]{input[start]};
        int mid=start+((end-start)>>1);
        int[] left=mergeSort(input,start,mid);
        int[] right=mergeSort(input,mid+1,end);

        return mergeArray(left,right);
    }
    private int[] mergeArray(int[] arr1,int[] arr2){
       int[] newArray=new int[arr1.length+arr2.length];
       int first=0,second=0,index=0;
       while (first<arr1.length || second<arr2.length){
           if (first==arr1.length) {
               newArray[index++]=arr2[second++];
           }else if(second==arr2.length){
               newArray[index++]=arr1[first++];
           }else {
               if (arr1[first]<=arr2[second]) {
                   newArray[index++]=arr1[first++];
               }else {
                   newArray[index++]=arr2[second++];
               }
           }
       }
       return newArray;
    }

    public static void main(String[] args) {
        int[] test1={};
        int[] test2={2,1,6,8};
        new Solution().sortMergeArray(test1,test2);

    }
}
