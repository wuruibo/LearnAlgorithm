package Contest.Contest41.Problem1;

class Solution {
    public String interpret(String command) {
        StringBuilder result=new StringBuilder();
        int i=0;
        while (i < command.length()) {
            if (command.charAt(i)=='G') {
                result.append('G');
                i++;
            }else if(command.charAt(i)=='(' && command.charAt(i+1)==')'){
                result.append('o');
                i+=2;
            }else if (command.charAt(i)=='(' && command.charAt(i+1)=='a'){
                result.append("al");
                i+=4;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().interpret("G()(al)"));
        System.out.println(new Solution().interpret("G()()()()(al)"));
        System.out.println(new Solution().interpret("(al)G(al)()()G"));
    }
}