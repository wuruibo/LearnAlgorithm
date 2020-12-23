package 剑指offer.P89;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yeqiaozhu.
 * @date 12/22/20
 */
public class Recur {
    public List<Integer> grayCode(int n) {
        if (n==1) {
            return Arrays.stream(new int[]{0, 1}).boxed().collect(Collectors.toList());
        }
        List<Integer> subs=grayCode(n-1);
        for (int i = subs.size() - 1; i >= 0; i--) {
            subs.add(subs.get(i)^(1<<n-1));
        }
        return subs;
    }

    public static void main(String[] args) {
        System.out.println(new Recur().grayCode(1));
        System.out.println(new Recur().grayCode(2));
        System.out.println(new Recur().grayCode(3));
    }
}
