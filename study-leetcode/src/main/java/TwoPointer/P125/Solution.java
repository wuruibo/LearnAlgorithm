package TwoPointer.P125;

/**
 * 双指针
 */
class Solution {
    public boolean isPalindrome(String s) {
        int start=0,end=s.length()-1;

        while (start<=end){
            if(!Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }else if(!Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }else {
                if (Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
                start++;
                end--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new Solution().isPalindrome("race a car"));
    }
}