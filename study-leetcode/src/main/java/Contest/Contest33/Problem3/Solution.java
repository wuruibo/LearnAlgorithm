package Contest.Contest33.Problem3;

import java.util.HashSet;
import java.util.Set;

class Solution {

    private String ret;

    private Set<String> visited;

    // 5544. 执行操作后字典序最小的字符串
    public String findLexSmallestString(String s, int a, int b) {
        visited = new HashSet<>();
        dfs(s, a, b);
        return ret;
    }

    private void dfs(String s, int a, int b) {
        if (visited.contains(s)) {
            return;
        }
        visited.add(s);
        if (null == ret || s.compareTo(ret) < 0) {
            ret = s;
        }
        int n = s.length();
        char[] chars = s.toCharArray();

        // 累加
        for (int i = 1; i < n; i += 2) {
            add(chars, i, a);
        }
        dfs(String.valueOf(chars), a, b);

        // 轮转
        dfs(s.substring(n - b) + s.substring(0, n - b), a, b);
    }

    private void add(char[] chars, int i, int a) {
        int num = chars[i] - '0';
        chars[i] = (char) ('0' + ((num + a) % 10));
    }
}