package P438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
 * 此题可参考通用算法模板
 * using slide window
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int begin=0;
        int end=0;
        List<Integer> result=new ArrayList<>();
        //构造子串的map
        Map<Character,Integer> pMap=new HashMap<>(128,0.75f);
        for (int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i),pMap.getOrDefault(p.charAt(i),0)+1);
        }
        int count=pMap.size();
        while (end<s.length()){
            Character currentChar=s.charAt(end);
            //如果当前key在pMap中
            if (pMap.containsKey(currentChar)) {
                //pMap值-1
                pMap.put(currentChar,pMap.get(currentChar)-1);
                //当前key全部减完 count更新
                if (pMap.get(currentChar)==0) {
                    count--;
                }
            }
            end++;
            //如果count目标减为0 从begin开始加回去
            while (count==0) {
                Character c=s.charAt(begin);
                if (pMap.containsKey(c)) {
                    pMap.put(c,pMap.get(c)+1);
                    if (pMap.get(c)>0) {
                        count++;
                    }
                }
                //记录当前的begin的位置之后继续遍历
                //这里可以判断下当前是否满足条件
                if ((end-begin)==p.length()) {
                    result.add(begin);
                }
                begin++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().findAnagrams("cbaebabacd","abc");
    }
}