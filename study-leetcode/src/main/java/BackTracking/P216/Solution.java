package BackTracking.P216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * using extra space
 */
class Solution {
    private List<List<Integer>> result= new ArrayList<>();
    private List<Integer> prepeared= new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n<k){
            return result;
        }
        //初始化数据
        for (int i = 0; i < 9; i++) {
            prepeared.add(i+1);
        }
        backTracking(new ArrayList<>(),0,0,n,k);
        return result;
    }
    public void backTracking(List<Integer> temp,int tempSum,int start,int n,int k){
        if (temp.size()==k) {
            if (tempSum==n) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = start; i < 9; i++) {
            Integer current=prepeared.get(i);
            temp.add(current);
            tempSum+=current;
            backTracking(temp,tempSum,i+1,n,k);
            temp.remove(temp.size()-1);
            tempSum-=current;
        }
    }

    public static void main(String[] args) {
        new Solution().combinationSum3(3,7);
        new Solution().combinationSum3(3,9);
        new Solution().combinationSum3(2,18);
    }
}