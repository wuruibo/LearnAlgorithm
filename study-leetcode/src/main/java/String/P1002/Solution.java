package String.P1002;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] A) {
        //构建hash数组
        int[][] hash=new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            int[] temp=new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                temp[A[i].charAt(j)-'a']++;
            }
            hash[i]=temp;
        }
        List<String> result= new ArrayList<>();
        //遍历hash数组
        int[] start=hash[0];
        for (int i = 0; i < start.length; i++) {
            while (start[i]>0) {
                Boolean flag=Boolean.TRUE;
                for (int j = 1; j < hash.length; j++) {
                    if (hash[j][i]==0) {
                        flag=Boolean.FALSE;
                        continue;
                    }
                    hash[j][i]--;
                }
                if (flag) {
                    char zero = (char) (i + 'a');
                    Character character=Character.valueOf(zero);
                    result.add(character.toString());
                }
                start[i]--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().commonChars(new String[]{"bella","label","roller"}));
        System.out.println(new Solution().commonChars(new String[]{"cool","lock","cook"}));
    }
}