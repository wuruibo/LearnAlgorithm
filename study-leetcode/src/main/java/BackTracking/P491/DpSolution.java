package BackTracking.P491;

import java.util.*;
import java.util.stream.Collectors;

public class DpSolution {
    private Map<Integer,List<List<Integer>>> dpMap= new HashMap<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result=dfs(nums,0);
        return result.stream().filter(list -> list.size()>1).collect(Collectors.toList());
    }
    private List<List<Integer>> dfs(int[] nums,int start){
        List<List<Integer>> result=new ArrayList<>();
        if (start==nums.length-1) {
            List<Integer> temp=new ArrayList<>();
            temp.add(nums[start]);
            result.add(temp);
            return result;
        }
        if (dpMap.containsKey(start)) {
            return dpMap.get(start);
        }
        Set<Integer> set= new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            int current=nums[i];
            if (set.add(current)) {
                List<List<Integer>> subResult=dfs(nums,i+1);
                List<List<Integer>> tempResult=subResult.stream()
                        .filter(list -> current<=list.get(0))
                        .map(list -> {
                            List<Integer> temp=new ArrayList<>();
                            temp.add(current);
                            temp.addAll(list);
                            return temp;
                        }).collect(Collectors.toList());
                //将当前节点也加入进去
                List<Integer> currentList=new ArrayList<>();
                currentList.add(current);
                tempResult.add(currentList);
                result.addAll(tempResult);
            }
        }
        dpMap.put(start,result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new DpSolution().findSubsequences(new int[]{4,3,2,1}));
        System.out.println(new DpSolution().findSubsequences(new int[]{4, 6, 7, 7}));
        System.out.println(new DpSolution().findSubsequences(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}));
    }
}
