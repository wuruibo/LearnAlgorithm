package Greedy.P781;

import java.util.Arrays;

class Solution {
    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int sum=0,i=0;
        while (i < answers.length){
            sum+=answers[i]+1;
            int count=answers[i];
            while (i+1<answers.length && answers[i+1]==answers[i] && count>0) {
                count--;
                i++;
            }
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numRabbits(new int[]{1,0,1,0,0}));
        System.out.println(new Solution().numRabbits(new int[]{2,0,0,9,5,6,5,4,5,4}));
        System.out.println(new Solution().numRabbits(new int[]{1, 1, 2}));
        System.out.println(new Solution().numRabbits(new int[]{10, 10, 10}));
    }
}