package String.RegularExpressionMatching;

import java.util.LinkedList;

/**
 *
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 *
 * Test Case:
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 *
 * @autor yeqiaozhu.
 * @date 2019-04-25
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if(s.length() ==0 && p.length()==0) {
            return true;
        }else  if(s.length()==0 || p.length() ==0){
            return false;
        }else {
            LinkedList sLinkedList=getLinkedList(s);
            LinkedList pLinkedList=getLinkedList(p);
            for(int i=0,j=0;i<s.length();){
                if(sLinkedList.get(i) != pLinkedList.get(j)){
                    //比较不相等，分为几种情况，1.单纯字符不相等,只能判断后缀是否为* 2.字符和*不相等，只能从前缀字符中拷贝一个 3.字符和.不相等，将.转换掉
                    if(pLinkedList.get(j).equals('*')){
                        if(j>0 && pLinkedList.get(j-1).equals(sLinkedList.get(i))){
                            pLinkedList.add(j,sLinkedList.get(i));
                            i++;j++;
                        }else if(j ==0){
                            pLinkedList.removeFirst();
                        }else {
                            pLinkedList.remove(j);
                            pLinkedList.remove(--j);
                        }
                    }else if(pLinkedList.get(j).equals('.')){
                        pLinkedList.add(j,sLinkedList.get(i));
                        j++;i++;
                    }else {
                        if(j+1 < s.length() && (pLinkedList.get(j+1).equals('*') || pLinkedList.get(j+1).equals('.'))){
                            pLinkedList.remove(j);
                            pLinkedList.remove(j+1);
                        }else {
                            return false;
                        }
                        //如果就是字符不相等，需要判断后面有咩有*或者.   可以将中间的所有的都remove掉
                        return false;
                    }
                }else {
                    i++;j++;
                }

            }
        }
        return true;
    }

    private LinkedList<Character> getLinkedList(String s){
        LinkedList<Character> linkedList=new LinkedList();

        for(int i=0;i<s.length();i++){
            linkedList.add(new Character(s.charAt(i)));
        }
        return linkedList;
    }

    public static void main(String[] args) {
        System.out.println("".equals(" "));
    }

}
