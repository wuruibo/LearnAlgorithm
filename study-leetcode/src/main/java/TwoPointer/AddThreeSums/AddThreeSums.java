package TwoPointer.AddThreeSums;

import java.util.*;

/**
 * 找出一个数组中和为零的三个数
 *
 * 类似找出一个数组中和为固定值的问题，但是不同的是数组中的元素可能是重复的
 *
 * 排序算法需要nlogn的时间复杂度 两个数的和可以通过hash减少到n
 *
 * 三数和在有重复的情况下无法用hash算法，通过排序nlogn+n可以实现
 *
 * @autor yeqiaozhu.
 * @date 2019-04-30
 */
public class AddThreeSums {
    /**
     * 方法二
     * 时间复杂度n2
     * 空间复杂度n
     * 使用了map去重复，增加了部分空间和时间复杂度，但是和方法1一个数量级
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumUsingMap(int[] nums) {
        //插入排序，进行排序
        /*LinkedList linkedList = getLinkedSortedList(nums);*/
        Arrays.sort(nums);

        List<List<Integer>> resultList=new ArrayList();
        //结果集列表集每个集合的中间元素push到set中，用于去重
        Map<Integer,Set<Integer>> midValueResultSetMap=new HashMap<>();
        //一次循环，每次抽出一个元素，其他元素都是有序的，然后前后指针分别进行遍历
        for(int i=0;i<nums.length-2;i++){
            //开始元素跟前一个元素相同，放弃
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int deleteValue = nums[i];

                int targetValue = 0 - deleteValue;

                int start = i + 1;
                int end = nums.length - 1;

                while (start != end) {
                    int endValue = nums[end];
                    int startValue = nums[start];
                    if (startValue + endValue < targetValue) {
                        start++;
                    } else if (startValue + endValue > targetValue) {
                        end--;
                    } else {
                        //这里我用了map和set的结构去去重 这样浪费了一定的时间和空间
                        if(midValueResultSetMap.containsKey(startValue) && midValueResultSetMap.get(startValue).contains(endValue)){
                            start++;
                        }else {
                            resultList.add(Arrays.asList(new Integer[]{deleteValue,startValue,endValue}));
                            if(midValueResultSetMap.get(startValue) == null){
                                Set<Integer> set=new HashSet<>();
                                set.add(endValue);
                                midValueResultSetMap.put(startValue,set);
                            }else {
                                midValueResultSetMap.get(startValue).add(endValue);
                            }
                            start++;
                        }

                    }
                }
            }
        }
        return resultList;
    }

    /**
     * 插入排序算法自实现
     * 递归，递归的pop条件是长度为2
     * end-start == 1 三种条件pop
     * @param nums
     * @return
     */
    private LinkedList getLinkedSortedList(int[] nums){
        //链表实现插入排序，增删容易
        LinkedList list= new LinkedList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(list.size() == 0){
                list.push(nums[i]);
            }else if(list.size() ==1){
                if (nums[i] > (Integer) list.getFirst()) {
                    list.add(1, nums[i]);
                } else {
                    list.add(0, nums[i]);
                }
            } else{
                //二分，当end 和start 的间距为1时，pop
                partHalf(list,0,list.size()-1,nums[i]);
            }
        }
        return list;
    }

    /**
     * 方法一
     * 时间复杂度n2
     * 空间复杂度n
     * 自循环去重复
     * @param num
     * @return
     */
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
    private void partHalf(LinkedList linkedList,int start,int end,int insertValue){
        if(end -start ==1){
            //比较之后直接pop return
            Integer startValue=(Integer) linkedList.get(start);
            Integer endValue=(Integer) linkedList.get(end);

            if(insertValue < startValue){
                linkedList.add(start,insertValue);
            }else if(insertValue > endValue){
                linkedList.add(end+1,insertValue);
            }else {
                linkedList.add(end,insertValue);
            }
            return;
        }
        int mid=(start + end)/2;
        Integer midValue=(Integer) linkedList.get(mid);
        if(insertValue < midValue){
            partHalf(linkedList,start,mid,insertValue);
        }else {
            partHalf(linkedList,mid,end,insertValue);
        }
    }

    public static void main(String[] args) {
        //起一个单元测试用例
        int[] nums={3,0,-2,-1,1,2};
        List<List<Integer>> resultList = new  AddThreeSums().threeSum(nums);

        for (int i=0;i<resultList.size();i++){
            List<Integer> tempList=resultList.get(i);
            for (int j =0;j<tempList.size();j++){
                System.out.print(resultList.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
