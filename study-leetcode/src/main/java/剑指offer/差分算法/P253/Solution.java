package 剑指offer.差分算法.P253;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length==0) {
            return 0;
        }
        //1.找出最大最小值
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            max=Math.max(intervals[i][1],max);
            min=Math.min(intervals[i][0],min);
        }
        int[] diff=new int[max+2];
        for (int[] interval : intervals) {
            int l=interval[0],r=interval[1];
            diff[l]+=1;diff[r]-=1;
        }
        int temp=0,result=0;
        for (int i : diff) {
            temp+=i;
            result=Math.max(result,temp);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println(new Solution().minMeetingRooms(new int[][]{{7,10},{2,4}}));
        System.out.println(new Solution().minMeetingRooms(new int[][]{{13,15},{1,13}}));
    }
}