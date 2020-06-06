package HashTable.P1160;

/**
 * Example 1:
 *
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation:
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 * Example 2:
 *
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation:
 * The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 */
class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] hashArray=new int[26];
        for (int i = 0; i < chars.length(); i++) {
            int index=chars.charAt(i)-'a';
            hashArray[index]++;
        }

        //循环
        int sum=0;
        for (int i = 0; i < words.length; i++) {
            int recover=words[i].length();
            for (int j = 0; j < words[i].length(); j++) {
                char temp=words[i].charAt(j);
                if (hashArray[temp-'a']==0) {
                    recover=j;
                    break;
                }else {
                    hashArray[temp-'a']--;
                }
            }
            sum+=recover==words[i].length()?recover:0;
            //重置回去
            for (int k = 0; k < recover; k++) {
                hashArray[words[i].charAt(k)-'a']++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] strings={"cat","bt","hat","tree"};
        System.out.println(new Solution().countCharacters(strings,"atach"));

        String[] string1={"hello","world","leetcode"};
        System.out.println(new Solution().countCharacters(string1,"welldonehoneyr"));
    }
}