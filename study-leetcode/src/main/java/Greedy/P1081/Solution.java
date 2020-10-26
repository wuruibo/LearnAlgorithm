package Greedy.P1081;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters/solution/tan-xin-suan-fa-zhan-wei-yan-ma-python-dai-ma-java/
 *
 * 下面以cdadabcc讲解一下算法的具体执行流程：
 *
 * 在第 1 步和第 2 步的时候，即在遍历索引为 0 和索引为 1 的字符的时候，字典序 c < d 成立，故 cd 是目前为止得到的字典序最靠前的子序列，这是显然的。
 * 关键是 当 a 来了之后，此时 a 前面的 d 是字典序靠后的字符，此时想到有没有可能后面还有 d，看了一眼，果然有 d ，那就把前面的 d 放弃。
 * 用同样的方式考察 c，发现后面 c 还有可能出现，因此 c 也被放弃了，此时我们就让字典序最靠前的 a 在最终得到的子序列的最前面（局部最优体现在这里）。
 *
 * 到了第 5 步的时候，虽然 b 的字典序比它前面的 d 要靠前，但此时 d 不会再出现，因此 d 就不能离开当前子序列。
 * 第 7 步，c 在之前的子序列中已经出现过了，就不再考虑。
 *
 * @author yqz
 */
public class Solution {
    public String smallestSubsequence(String text) {
        int len = text.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            Character c = text.charAt(i);
            if (stack.contains(c)) {
                continue;
            }
            while (!stack.empty() && c < stack.peek() && text.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
