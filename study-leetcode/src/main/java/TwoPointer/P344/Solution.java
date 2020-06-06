package TwoPointer.P344;

/**
 * using two pointer
 */
class Solution {
    public void reverseString(char[] s) {
        int start=0,end=s.length-1;
        char temp;
        while (start<end){
            temp=s[start];
            s[start]=s[end];
            s[end]=temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        char[] s={'h','e','l','l','o'};
        new Solution().reverseString(s);
        System.out.println(s);
    }
}