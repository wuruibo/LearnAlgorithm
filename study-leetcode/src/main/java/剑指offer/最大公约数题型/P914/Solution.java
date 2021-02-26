package 剑指offer.最大公约数题型.P914;

import java.util.Arrays;

/**
 * 统计各个数出现的次数，然后求次数之间是否存在公约数
 */
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        // 计数
        int[] counter = new int[10000];
        for (int num: deck) {
            counter[num]++;
        }
        // 求gcd
        int x=Arrays.stream(counter)
                .filter(integer->integer>0)
                .reduce((a,b)->gcd(a,b))
                .getAsInt();
/*        int x = 0;
        for(int cnt: counter) {
            if (cnt > 0) {
                x = gcd(x, cnt);
                if (x == 1) {
                    return false;
                }
            }
        }*/
        return x >= 2;
    }
    private int gcd(int x,int y){
        return y==0?x:gcd(y,x%y);
    }
}