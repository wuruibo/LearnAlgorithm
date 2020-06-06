package BinarySearch.P744;

/**
 * Examples:
 * Input:
 * letters = ["c", "f", "j"]
 * target = "a"
 * Output: "c"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "c"
 * Output: "f"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "g"
 * Output: "j"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "j"
 * Output: "c"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 */
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start=0,end=letters.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if (target<letters[mid]) {
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return start==letters.length?letters[0]:letters[start];
    }

    public static void main(String[] args) {
        char[] chars={'c', 'f', 'j'};
        char target='a';
        System.out.println(new Solution().nextGreatestLetter(chars,target));

        char target2='c';
        System.out.println(new Solution().nextGreatestLetter(chars,target2));

        char target1='d';
        System.out.println(new Solution().nextGreatestLetter(chars,target1));

        char target3='g';
        System.out.println(new Solution().nextGreatestLetter(chars,target3));

        char target4='j';
        System.out.println(new Solution().nextGreatestLetter(chars,target4));

        char target5='k';
        System.out.println(new Solution().nextGreatestLetter(chars,target5));
    }
}