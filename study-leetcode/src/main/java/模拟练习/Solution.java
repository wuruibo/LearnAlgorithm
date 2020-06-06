package 模拟练习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入：s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
 * 输出：[true,false,false,true,true]
 * 解释：
 * queries[0] : 子串 = "d"，回文。
 * queries[1] : 子串 = "bc"，不是回文。
 * queries[2] : 子串 = "abcd"，只替换 1 个字符是变不成回文串的。
 * queries[3] : 子串 = "abcd"，可以变成回文的 "abba"。 也可以变成 "baab"，先重新排序变成 "bacd"，然后把 "cd" 替换为 "ab"。
 * queries[4] : 子串 = "abcda"，可以变成回文的 "abcba"。
 */
class Solution {
    /*public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[][] temp=new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length()-i; j++) {
                if (i>=1) {
                    int count=s.charAt(j) != s.charAt(j+i)?1:0;
                    temp[i][j]+=count;
                    if (i>=2) temp[i][j]+=temp[i-2][j];
                }
            }
        }

        List<Boolean> result= new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int length=queries[i][1]-queries[i][0];
            int start=queries[i][0];
            if (temp[length][start]>queries[i][2]) {
                result.add(false);
            }else {
                result.add(true);
            }
        }
        return result;
    }*/
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        //step1统计前缀的对应的hash数组
        int[][] cached=new int[s.length()+1][26];
        int[] temp=new int[26];
        for (int i = 1; i <= s.length(); i++) {
            temp[s.charAt(i-1)-'a']++;
            cached[i]= Arrays.copyOf(temp,temp.length);
        }
        List<Boolean> result=new ArrayList<>();
        //step2 统计完前缀和开始循环queries
        for (int[] query : queries) {
            int left=query[0];
            int right=query[1];
            int k=query[2];

            int[] leftHash=cached[left];
            int[] rightHash=cached[right+1];
            //step3 统计奇数出现的个数
            int count=0;
            for (int i = 0; i < 26; i++) {
                if (((rightHash[i]-leftHash[i]) & 1)==1) {
                    count++;
                }
            }

            if (count/2 > k) {
                result.add(Boolean.FALSE);
            }else {
                result.add(Boolean.TRUE);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] querys={{6,6,0},{1,1,1},{2,5,4},{1,3,1},{5,6,1}};
        System.out.println(new Solution().canMakePaliQueries("ninmjmj", querys).toString());
    }
}