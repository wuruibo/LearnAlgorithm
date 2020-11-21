package String.P151;

class Solution {
    private final Character blank=' ';
    public String reverseWords(String s) {
        int length=0;
        int i=s.length()-1;
        StringBuilder result=new StringBuilder();
        while (i >= 0) {
            while (!blank.equals(s.charAt(i))) {
                length++;
                i--;
                if (i<0 || blank.equals(s.charAt(i))) {
                    break;
                }
            }
            //length 往后加
            for (int j = i+1; j <= length+i; j++) {
                result.append(s.charAt(j));
            }
            if (length!=0) {
                result.append(" ");
                length=0;
            }else {
                i--;
            }
        }
        if (result.length()!=0) {
            result.deleteCharAt(result.length()-1);
        }
        return result.toString();
    }

    public String reverseWordsV1(String s) {
        String[] strs = s.trim().split(" "); // 删除首尾空格，分割字符串
        StringBuilder res = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            if(strs[i].equals("")) continue; // 遇到空单词则跳过
            res.append(strs[i] + " "); // 将单词拼接至 StringBuilder
        }
        return res.toString().trim(); // 转化为字符串，删除尾部空格，并返回
    }

    public String reverseWordsV2(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while(i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }

    public static void main(String[] args) {
        String s="    1  1   ";
        String a="aaabbaa";
        String[] strings=s.split(" ");
        String[] data=a.split("a");
        System.out.println(new Solution().reverseWords("the sky is blue"));
        System.out.println(new Solution().reverseWords(" "));
        System.out.println(new Solution().reverseWords("a a "));
        System.out.println(new Solution().reverseWords("  hello world!  "));
        System.out.println(new Solution().reverseWords("a good   example"));
        System.out.println(new Solution().reverseWords("  Bob    Loves  Alice   "));
        System.out.println(new Solution().reverseWords("Alice does not even like bob"));
    }
}