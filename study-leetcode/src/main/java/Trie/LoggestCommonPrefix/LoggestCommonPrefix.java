package Trie.LoggestCommonPrefix;

/**
 * @autor yeqiaozhu.
 * @date 2019-06-03
 */
public class LoggestCommonPrefix {

    /**
     * 数组长度为m，最小字符串长度为n
     * 时间复杂度O(n*m)
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        String string=strs[0];
        String finalResult="";
        for(int i=0;i<string.length();i++){
            for(int j=1;j< strs.length;j++){
                //匹配到字符串的结尾或者匹配不相等break
                if(i>strs[j].length()-1 || string.charAt(i) !=strs[j].charAt(i)){
                    return finalResult;
                }

            }
            finalResult=string.substring(0,i+1);
        }
        return finalResult;
    }

    public static void main(String[] args) {
        String[] strings={"flow","floww","fll"};
        System.out.println(new LoggestCommonPrefix().longestCommonPrefix(strings));
    }

}
