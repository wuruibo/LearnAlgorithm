package Recursive.P56;

import java.util.Arrays;

/**
 * [[1,9],[2,5],[19,20],[10,11],[12,20],[0,3],[0,1],[0,2]]
 *
 * [[0,1],[0,2],[0,3],[1,9],[2,5],[10,11],[12,20],[19,20]]
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals==null || intervals.length==0) {
            return new int[0][0];
        }
        //intervals
        int[][] result=mergeSort(intervals,0,intervals.length-1);
        int[][] temp=new int[intervals.length][2];
        //index位置为0
        int index=0;
        int[] tempInts=result[0];
        for (int i = 1; i < result.length; i++) {
            //第一种情况 当前元素起始位置大于比较起始位置
            if (result[i][0]<=tempInts[1]) {
                tempInts[1]=Math.max(result[i][1],tempInts[1]);
            }else{//第二种情况 如果当前位置元素包含了temp元素 更新temp的start 和temp的end位置
                temp[index++]=tempInts;
                tempInts=result[i];
            }
        }
        temp[index]=tempInts;

        //开始输出结果
        return Arrays.copyOf(temp,index+1);

    }
    private int[][] mergeSort(int[][] intervals,int start,int end){
        if (start==end) {
            return Arrays.copyOfRange(intervals,start,end+1);
        }
        int mid=(start+end)/2;
        int[][] left=mergeSort(intervals,start,mid);
        int[][] right=mergeSort(intervals,mid+1,end);

        return merge(left,right);

    }
    private int[][] merge(int[][] left,int[][] right){
        //merge two sort
        int newLength=left.length+right.length;
        int[][] newArray=new int[newLength][2];

        //定义双指针
        int first=0,second=0,index=0;
        while (first<left.length || second<right.length){
            if (second==right.length) {
                newArray[index]=left[first];
                first++;
            }else if(first==left.length){
                newArray[index]=right[second];
                second++;
            }else if (left[first][0]<right[second][0]) {
                newArray[index]=left[first];
                first++;
            }else {
                newArray[index]=right[second];
                second++;
            }
            index++;
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[][] ints= {{1,3},{2,6},{8,10},{15,18}};
        int[][] ints1= {{1,4},{2,3}};

        int[][] result=new Solution().merge(ints);
        StringBuilder string=new StringBuilder("[");
        for (int i = 0; i < result.length; i++) {
            int[] temp=result[i];
            StringBuilder sb=new StringBuilder("[");
            for (int j : temp) {
                sb.append(j+",");
            }
            sb.replace(sb.length()-1,sb.length(),"],");

            string.append(sb.toString());
        }
        string.replace(string.length()-1,string.length(),"]");
        System.out.println(string);
    }
}