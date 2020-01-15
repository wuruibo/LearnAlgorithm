package TwoPointer.P11;

/**
 * 找出一个数组中可以容纳最多的water
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * 不具备子结构,时间复杂度n2
 * 空间复杂度1
 *
 * @autor yeqiaozhu.
 * @date 2019-04-23
 */
public class ContainerWithMostWater {
    /**
     * 时间复杂度n2
     * 空间复杂度n
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxWater =0;
        //第一层循环数组长度循环，次数为length-1
        for(int i=0;i<height.length-1;i++){
            //第二层循环实际循环
            for(int j=0;j<height.length-i-1;j++){
                int min=height[j] <height[j+i+1]?height[j]:height[j+i+1];
                int tempMaxWater = min * (i+1);
                if(tempMaxWater > maxWater ){
                    maxWater = tempMaxWater;
                }
            }
        }
        return maxWater;
    }

    /**
     * 时间复杂度n
     * 空间复杂度1
     * @param height
     * @return
     */
    public int maxAreaN(int[] height){
        int maxWater=0;
        int left=0;
        int right=height.length-1;
        while (left<right){
            int min=height[left] <height[right]?height[left]:height[right];
            int tempMaxWater = min * (right-left);
            maxWater=tempMaxWater>maxWater?tempMaxWater:maxWater;
            if(height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        int[] array = {1,8,6,2,5,4,8,3,7};
        System.out.println(new ContainerWithMostWater().maxArea(array));
        System.out.println(new ContainerWithMostWater().maxAreaN(array));
    }
}
