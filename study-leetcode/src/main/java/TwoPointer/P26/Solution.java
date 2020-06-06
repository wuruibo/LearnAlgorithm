package TwoPointer.P26;

/**
 * Using two pointer
 */
class Solution {
    public int[] removeDuplicates(int[] nums) {
        if (nums==null || nums.length==0) {
            return nums;
        }
        int start=0,end=0,resultIndex=1;
        int count=1;
        int[] result=new int[nums.length];
        result[0]=nums[0];
        while (end<nums.length){
            if (nums[start]==nums[end]) {
                end++;
            }else {
                //统计新数组的长度
                count++;
                //如果碰上不同的元素，将起点修改为end-1 继续双指针遍历
                start=end;
                //记录当前不同的end位置到新数组 resultIndex继续往后递增
                result[resultIndex]=nums[end];
                //目标数组index继续往后递增
                resultIndex++;
                //后指针继续移动
                end++;
            }
        }
        int[] resultArray=new int[count];
        for (int i = 0; i < count; i++) {
            resultArray[i]=result[i];
        }
        nums=resultArray;
        return nums;
    }

    public static void main(String[] args) {
        int[] ints={0,0,1,1,1,2,2,3,3,4};
        int[] ints1={1,1,2};
        System.out.println(new Solution().removeDuplicates(ints));
        System.out.println(new Solution().removeDuplicates(ints1));
    }
}