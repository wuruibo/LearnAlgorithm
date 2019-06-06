package FindAllNumbersDisappeared;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor yeqiaozhu.
 * @date 2019-06-05
 *
 * 448. Find All Numbers Disappeared in an Array
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 */
public class FindAllNumbersDisappeared {

    public List<Integer> findDisappearedNumbersSecond(int[] nums) {
        ArrayList<Integer> arrayList=new ArrayList();
        //数组index对应的数值为value，将index=value的位置标记为-value，表示出现过，并且value取正可以持续标记
        for(int i=0;i<nums.length;i++){
            int value=Math.abs(nums[i])-1;
            if(nums[value] >0){
                nums[value]=-nums[value];
            }
        }
        //遍历出未被标记的index，index+1即为未出现过的数值
        for (int i=0;i<nums.length;i++){
            if(nums[i]>0){
                arrayList.add(i+1);
            }
        }

        return arrayList;
    }
    public static void main(String[] args) {
        int[] ints={4,3,2,7,8,2,3,1};
        System.out.println(new FindAllNumbersDisappeared().findDisappearedNumbersSecond(ints));
    }
}
