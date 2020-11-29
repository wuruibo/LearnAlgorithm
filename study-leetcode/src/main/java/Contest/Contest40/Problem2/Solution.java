package Contest.Contest40.Problem2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    private int[] result;
    public int[] mostCompetitive(int[] nums, int k) {
        dfs(nums,new int[k],k,0);
        return result;
    }
    private void dfs(int[] nums,int[] temp,int k,int start){
        if (result!=null || nums.length-start<k) {
            return;
        }
        if (k==0) {
            result= Arrays.stream(temp).toArray();
            return;
        }
        //将当前元素加入队列中
        Queue<int[]> queue= new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = start; i < nums.length; i++) {
            queue.offer(new int[]{nums[i],i});
        }
        for (int i = start,n=temp.length;i < nums.length; i++) {
            int[] cur = queue.poll();
            temp[n - k] = cur[0];
            dfs(nums, temp, k - 1, cur[1] + 1);
            temp[n - k] = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mostCompetitive(new int[]{3, 5, 2, 6}, 2));
        System.out.println(new Solution().mostCompetitive(new int[]{2,4,3,3,5,4,9,6}, 4));
        System.out.println(new Solution().mostCompetitive(new int[]{71,18,52,29,55,73,24,42,66,8,80,2}, 3));
        System.out.println(new Solution().mostCompetitive(new int[]{3,5,2,6}, 2));
    }
}