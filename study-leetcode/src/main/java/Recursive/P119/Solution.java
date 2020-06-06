package Recursive.P119;

import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<Integer> temp;
    public List<Integer> getRow(int rowIndex) {
        temp=new LinkedList<>();
        if (rowIndex==0) {
            temp.add(1);
            return temp;
        }
        recursive(rowIndex);
        return temp;
    }
    public void recursive(int rowIndex){
        if (rowIndex==1) {
            temp.add(1);
            temp.add(1);
            return;
        }
        recursive(rowIndex-1);
        //根据子结构构建
        int subSize=temp.size();
        //中间加入
        for (int i = 0,ins=0; i < temp.size()-1; i+=2,ins++) {
            temp.add(ins+1,temp.get(i)+temp.get(i+1));
        }
        //多余的remove掉吧
        int curSize=temp.size();
        for (int i = curSize - 2; i > curSize-subSize; i--) {
            //直接remove掉对应位置
            temp.remove(i);
        }
    }

    public static void main(String[] args) {
        new Solution().getRow(2);
        new Solution().getRow(3);
        new Solution().getRow(5);
        new Solution().getRow(8);
    }
}