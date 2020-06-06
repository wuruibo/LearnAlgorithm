package BackTracking.P77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<List<Integer>> result= new ArrayList<>();
    private List<Integer> prepeared= new LinkedList<>();
    private int targetSize;
    public List<List<Integer>> combine(int n, int k) {
        if (n<0 || k<0) {
            return result;
        }
        for (int i = 0; i < n; i++) {
            prepeared.add(i+1);
        }
        if (k>n) {
            targetSize=n;
        }else {
            targetSize=k;
        }
        backTracking(new ArrayList<>(), 0,n);

        return result;
    }
    public void backTracking(List<Integer> temp,int start,int end){
        if (temp.size()==targetSize) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (temp.size()+end-start<targetSize) {
            return;
        }
        for (int i = start; i < end; i++) {
            Integer current=prepeared.get(i);
            temp.add(current);
            backTracking(temp,i+1,end);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        new Solution().combine(4,2);
        new Solution().combine(4,4);
        new Solution().combine(4,5);
    }
}