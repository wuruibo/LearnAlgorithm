package Math.ReverseInteger;

import java.util.ArrayList;

/**
 * 利用一个
 * 反转int数字
 */
public class ReverseInteger {

    public int reverse(int x) {
        int tempX = x;
        Long result = 0L;
        ArrayList<Integer> integers = new ArrayList<Integer>();
        while (tempX != 0) {
            integers.add(tempX % 10);
            tempX /= 10;
        }
        for (int i = 0; i < integers.size(); i++) {
            int time = integers.size() - i - 1;
            if (time == 0) {
                result += integers.get(i);
            } else {
                Long temp = integers.get(i).longValue();
                while (time != 0) {
                    temp *=10;
                    time --;
                }
                result += temp;
            }
        }
        if(result >Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }
        return result.intValue();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(-2147483648));
    }
}
