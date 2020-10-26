package Contest.Contest36.Problem1;

class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] result=new int[]{releaseTimes[0],keysPressed.charAt(0)-'a'};
        for (int i = 1; i < keysPressed.length(); i++) {
            int time=releaseTimes[i]-releaseTimes[i-1];
            if (time>result[0]) {
                result=new int[]{time,keysPressed.charAt(i)-'a'};
            }else if(time==result[0] && keysPressed.charAt(i)>result[1]){
                result=new int[]{time,keysPressed.charAt(i)-'a'};
            }
        }
        return (char) (result[1]+'a');
    }

    public static void main(String[] args) {
        System.out.println(new Solution().slowestKey(new int[]{9, 29, 49, 50}, "cbcd"));
        System.out.println(new Solution().slowestKey(new int[]{12,23,36,46,62}, "spuda"));
    }
}