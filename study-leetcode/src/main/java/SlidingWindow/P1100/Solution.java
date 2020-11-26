package SlidingWindow.P1100;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入：S = "havefunonleetcode", K = 5
 * 输出：6
 * 解释：
 * 这里有 6 个满足题意的子串，分别是：'havef','avefu','vefun','efuno','etcod','tcode'。
 *
 * 输入：S = "home", K = 5
 * 输出：0
 * 解释：
 * 注意：K 可能会大于 S 的长度。在这种情况下，就无法找到任何长度为 K 的子串。
 */
class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        Map<Character,Integer> hash= new HashMap<>(16);
        int result=0,k=K;
        for (int r = 0,l=0; r < S.length(); r++) {
            Character cur=S.charAt(r);
            hash.put(cur,hash.getOrDefault(cur,0)+1);
            if (hash.get(cur)==1) {
                k--;
            }
            while (k == 0) {
                if (r-l+1==K) {
                    result++;
                }
                Character pre=S.charAt(l);
                hash.put(pre,hash.getOrDefault(pre,0)-1);
                if (hash.get(pre)==0) {
                    k++;
                }
                l++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numKLenSubstrNoRepeats("havefunonleetcode", 5));
        System.out.println(new Solution().numKLenSubstrNoRepeats("home", 5));
    }
}