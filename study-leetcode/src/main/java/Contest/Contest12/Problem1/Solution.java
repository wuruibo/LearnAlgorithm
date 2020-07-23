package Contest.Contest12.Problem1;

class Solution {
    public String removeDuplicates(String S) {
        StringBuilder result=new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            Character left=S.charAt(i);
            Character right=i==S.length()-1?'A':S.charAt(i+1);
            if (left==right) {
                i++;
            }else {
                result.append(left);
            }
        }
        return S.length()==result.length()?result.toString():removeDuplicates(result.toString());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates("abbaca"));
    }
}