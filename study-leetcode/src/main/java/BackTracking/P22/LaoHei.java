package BackTracking.P22;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor yeqiaozhu.
 * @date 2020-04-09
 */
public class LaoHei {
    List<String> r = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        trace("", 0, n);
        return r;
    }
    private void trace(String cur, int valid, int n) {
        // 迭代出口。当长度满足或者括号不再有效时
        if (cur.length() == n * 2) {
            // circle end
            if (valid == 0) {
                r.add(cur);
            }
            System.out.println(cur);
        } else {
            // split with valid
            if (valid == 0) {
                // 复位阶段。表示目前的cur本身是有效括号，包含空串。只能在后面新增左括号
                trace(cur + "(", valid + 1, n);
            } else if (valid == n) {
                // 添加右括号情况。
                trace(cur + ")", valid - 1, n);
            } else {
                // 添加左括号情况。
                trace(cur + "(", valid + 1, n);
                // 添加右括号情况。
                trace(cur + ")", valid - 1, n);
            }
        }
    }
        public static void main(String[] args) {
        new LaoHei().generateParenthesis(3);
    }
}
