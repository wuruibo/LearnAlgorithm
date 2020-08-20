package Contest.Contest25.Problem2;

import java.util.HashMap;

/**
 * 贪心+记忆化递归
 *
 * 有了橘子个数之后，我们有三种选择，
 * 最差的是吃一个
 * 可以给2整除可以吃一半
 * 可以给3整除吃2/3
 * 我们想要的是尽量吃的多，那么只有在2和3不成立的时候 才选择吃一个
 * 如果剩下的个数不能给3整除，但是可以给2整除的情况下，不一定吃一半就是最优解，比如10个橘子的时候，先花一天吃一个，然后第二天再吃2/3 这样更快一点
 * 所以我们的到一个n，2和3不成立的情况下，就一天吃一个，吃到2和3成立为止，然后比较哪个花的天数比较少
 * 我们可以得到 minDays(n / 2) + (n % 2) n%2 代表吃到能给2整除的天数，minDays(n / 2)就是剩下的橘子需要的天数，加起来就是吃到2成立的所需天数，minDays(n / 3) + (n % 3)也是如此
 * 因为递归的过程中 可能会有已经算过的最佳天数，所以打算用个map保存起来，key是橘子个数，value是天数
 *
 * @author yqz
 */
public class UsingRecursive {
    private static HashMap<Integer, Integer> map = new HashMap<>();

    public int minDays(int n) {
        return helper(n);
    }

    private int helper(int n) {
        if (n == 1) {
            return 1;
        } else if (n <= 3) {
            return 2;
        } else if (!map.containsKey(n)) {
            int res = Integer.MAX_VALUE;
            res = Math.min(res, helper((n - n % 2) / 2) + 1 + n % 2);
            res = Math.min(res, helper((n - n % 3) / 3) + 1 + n % 3);
            map.put(n, res);
        }
        return map.get(n);
    }

    public static void main(String[] args) {
        System.out.println(new UsingRecursive().minDays(9209408));
        System.out.println(new UsingRecursive().minDays(6));
        System.out.println(new UsingRecursive().minDays(1));
        System.out.println(new UsingRecursive().minDays(56));
    }
}
