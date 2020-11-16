package BackTracking.P842;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<Integer> result= new ArrayList<>();
    public List<Integer> splitIntoFibonacci(String S) {
        dfs(new ArrayList<>(),0,S);
        return result;
    }
    private void dfs(List<Integer> temp,int start,String s){
        //收集回溯结果集
        if (temp.size()>=3 && start==s.length()) {
            result=new ArrayList<>(temp);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            //如果当前开始的首字母是0 那就只能拆0 并且后面的都不用再拆了
            //当前层截取的字符串
            String next=s.substring(start,i+1);

            //当前加入的必须满足规则方可进入下一阶段
            if (next(temp,next)) {
                //继续往下截取
                Integer current=Integer.parseInt(next);
                temp.add(current);
                dfs(temp,i+1,s);
                temp.remove(temp.size()-1);
            }
        }
    }
    private boolean next(List<Integer> array,String next){
        if (next.startsWith("0") && next.length()>1) {
            return false;
        }
        if (next.length()>10) {
            return false;
        }
        Long current=Long.parseLong(next);
        if (Long.parseLong(next)>Integer.MAX_VALUE) {
            return false;
        }
        int size=array.size();
        if (size<2) {
            return true;
        }
        return array.get(size-1)+array.get(size-2)==current?true:false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().splitIntoFibonacci("123456579"));
        System.out.println(new Solution().splitIntoFibonacci("5511816597"));
        System.out.println(new Solution().splitIntoFibonacci("11235813"));
        System.out.println(new Solution().splitIntoFibonacci("112358130"));
        System.out.println(new Solution().splitIntoFibonacci("1101111"));
        System.out.println(new Solution().splitIntoFibonacci("0123"));
    }
}