package P647;

/**
 * 中心扩展法
 * @autor yeqiaozhu.
 * @date 2019-10-28
 */
public class UsingCircle {
    private String string;
    private int count;
    public int countSubstrings(String s) {
        string=s;
        for (int i = 0; i < s.length(); i++) {
            //两个元素为中心
            checkParamlings(i,i+1);
            //单个元素为中心
            checkParamlings(i,i);
        }
        return count;
    }

    public void checkParamlings(int i,int j){
        while (i>=0 && j<string.length() && string.charAt(i) == string.charAt(j)){
            count++;
            i--;
            j++;
        }
    }

    public static void main(String[] args) {
        String s="aaa";
        System.out.println(new UsingCircle().countSubstrings(s));

        String s1="abc";
        System.out.println(new UsingCircle().countSubstrings(s1));
    }
}