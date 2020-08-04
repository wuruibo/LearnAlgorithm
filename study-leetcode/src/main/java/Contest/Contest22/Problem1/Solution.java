package Contest.Contest22.Problem1;

class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    int left=Math.abs(arr[i]-arr[j]);
                    int right=Math.abs(arr[j]-arr[k]);
                    int mid=Math.abs(arr[i]-arr[k]);
                    if (left<=a && right<=b && mid<=c) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countGoodTriplets(new int[]{3, 0, 1, 1, 9, 7}, 7, 2, 3));
        System.out.println(new Solution().countGoodTriplets(new int[]{1,1,2,2,3}, 0, 0, 1));
    }
}