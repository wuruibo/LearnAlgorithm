package Sort.QuickSort;

/**
 *
 * 写一个快排吧
 *
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */
class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums,0,nums.length-1);
    }
    private void quickSort(int[] nums,int start,int end){
        if (start>end)return;
        int index=getPriotIndex(nums,start,end);
        quickSort(nums,start,index-1);
        quickSort(nums,index+1,end);
    }
    private int getPriotIndex(int[] nums,int start,int end){
        //step1 找到一个基准元素 第一个元素让出第一个元素的坑位
        int priot=nums[start];
        while (start<end){
            //step2  找到右边第一个小于基准元素的元素
            while (start<end && nums[end]>=priot){
                end--;
            }
            //step3 找到这个位置之后 直接把坑给占了
            if (start<end){
                swap(nums,start,end);
                start++;
            }
            //step4 找到左边第一个大于基准元素的元素
            while (start<end && nums[start]<=priot){
                start++;
            }
            //step5 找到这个位置之后把前面替换的坑给填了
            if (start<end){
                swap(nums,start,end);
                end--;
            }
        }
        //nums[start]=priot;
        return start;
    }
    private void swap(int[] nums,int from,int to){
        int temp=nums[from];
        nums[from]=nums[to];
        nums[to]=temp;
    }

    public static void main(String[] args) {
        int[] ints={-1,2,3,6,5,4,0,11,7};
        new Solution().sortColors(ints);
    }
}