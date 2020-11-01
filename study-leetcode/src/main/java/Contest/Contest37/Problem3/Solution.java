package Contest.Contest37.Problem3;

/**
 * 贪心 先用砖块 砖块过不去再用梯子
 */
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int i = 1;
        while (i < heights.length) {
            int height=heights[i]-heights[i-1];
            if (height<=0) {
                i++;
                continue;
            }else if (bricks>=height) {
                bricks-=height;
                i++;
            }else if (ladders>0){
                ladders--;
                i++;
            }else {
                break;
            }
        }
        return i-1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1));
        System.out.println(new Solution().furthestBuilding(new int[]{4}, 5, 1));
        System.out.println(new Solution().furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19}, 10, 2));
        System.out.println(new Solution().furthestBuilding(new int[]{14,3,19,3}, 17, 0));
    }
}