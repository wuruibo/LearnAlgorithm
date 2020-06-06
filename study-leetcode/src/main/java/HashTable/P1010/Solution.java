package HashTable.P1010;

/**
 * Example 1:
 *
 * Input: [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 * Example 2:
 *
 * Input: [60,60,60]
 * Output: 3
 * Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 *
 *
 * 先对所有的数组取余 然后放入hashtable中 类似two sum
 */
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        //创建hashtable
        int[] hashtable=new int[60];
        //先取余数
        for (int i = 0; i < time.length; i++) {
            time[i]%=60;
            hashtable[time[i]]++;
        }
        //遍历过去 统计count符合条件的pairs
        int count=0;
        for (int j = 0; j < time.length; j++) {
            hashtable[time[j]]--;
            if (hashtable[(Math.abs(60-time[j]))%60]>0) {
                count+=hashtable[(60-time[j])%60];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] ints={30,20,150,100,40};
        System.out.println(new Solution().numPairsDivisibleBy60(ints));


        int[] ints1={60,60,60};
        System.out.println(new Solution().numPairsDivisibleBy60(ints1));

        int[] ints2={60};
        System.out.println(new Solution().numPairsDivisibleBy60(ints2));
    }
}