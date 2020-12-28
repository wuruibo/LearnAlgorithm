package Stack.P1190;

class Solution {
    public String reverseParentheses(String s) {
        StringBuilder temp=new StringBuilder();
        int i=0,count;
        while (s.length() > i) {
            if (s.charAt(i)=='(') {
                //找到下一个)
                i++;
                int j=i;count=1;
                while (count!=0){
                    if (s.charAt(i)=='(') {
                        count++;
                    }else if (s.charAt(i)==')'){
                        count--;
                    }
                    i++;
                }
                String subString=reverseParentheses(s.substring(j,i-1));
                temp.append(new StringBuilder(subString).reverse());
            }else {
                temp.append(s.charAt(i++));
            }
        }
        return temp.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseParentheses("(abcd)"));
        System.out.println(new Solution().reverseParentheses("()"));
        System.out.println(new Solution().reverseParentheses("(u(love)i)"));
        System.out.println(new Solution().reverseParentheses("(ed(et(oc))el)"));
        System.out.println(new Solution().reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }
}