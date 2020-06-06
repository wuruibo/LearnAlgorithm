package Recursive.P118;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {
        recursive(numRows);

        return result;
    }
    public List<Integer> recursive(int size){
        List<Integer> temp= new ArrayList<>(size);
        if (size==0) {
            return temp;
        }
        if (size==1) {
            temp.add(1);
            result.add(temp);
            return temp;
        }
        List<Integer> subList=recursive(size-1);
        temp.add(1);
        for (int i = 0; i < subList.size()-1; i++) {
            temp.add(subList.get(i)+subList.get(i+1));
        }
        temp.add(1);
        result.add(temp);
        return temp;
    }

    public static void main(String[] args) {
        new Solution().generate(5);
    }
}