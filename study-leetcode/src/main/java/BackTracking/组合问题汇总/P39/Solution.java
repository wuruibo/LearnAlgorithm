
package BackTracking.组合问题汇总.P39;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private int[] candidates;
    private int target;
    private List<List<Integer>> result= new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates=candidates;
        this.target=target;
        backTracking(new ArrayList<>(),0,0);

        return result;
    }
    public void backTracking(List<Integer> temp,int tempSum,int start){
        if (tempSum>target) {
            return;
        }
        if (tempSum==target) {
            /*for (int i = 0; i < result.size(); i++) {
                result.get(i).sort(Integer::compareTo);
                List<Integer> copyTemp=new ArrayList<>(temp);
                copyTemp.sort(Integer::compareTo);
                if (result.get(i).equals(copyTemp)) {
                    return;
                }
            }*/
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            tempSum+=candidates[i];
            backTracking(temp,tempSum,i);
            temp.remove(temp.size()-1);
            tempSum=tempSum-candidates[i];
        }
    }

    public static void main(String[] args) {
        int[] ints={2,3,5};
        int target=8;
        new Solution().combinationSum(ints,target);

        List<List<Integer>> test=new ArrayList<>();

        List<Integer> sub=new ArrayList<>();
        Arrays.stream(ints).forEach(param->sub.add(param));
        test.add(sub);

        List<Integer> subCopy=new ArrayList<>(sub);
        //test.get(0).add(8);
        test.get(0).equals(subCopy);
    }
}