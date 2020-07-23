package Contest.Contest15.Problem1;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result=new ArrayList<>();
        result.add(1);
        if (rowIndex==0) {
            return result;
        }else if(rowIndex==1){
            result.add(1);
            return result;
        }
        List<Integer> son=getRow(rowIndex-1);
        for (int i = 0; i < son.size()-1; i++) {
            result.add(son.get(i)+son.get(i+1));
        }
        result.add(1);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getRow(1));
        System.out.println(new Solution().getRow(2));
        System.out.println(new Solution().getRow(3));
    }
}