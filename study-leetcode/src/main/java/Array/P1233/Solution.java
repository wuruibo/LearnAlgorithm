package Array.P1233;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Example 1:
 *
 * Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
 * Output: ["/a","/c/d","/c/f"]
 * Explanation: Folders "/a/b/" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.
 * Example 2:
 *
 * Input: folder = ["/a","/a/b/c","/a/b/d"]
 * Output: ["/a"]
 * Explanation: Folders "/a/b/c" and "/a/b/d/" will be removed because they are subfolders of "/a".
 * Example 3:
 *
 * Input: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
 * Output: ["/a/b/c","/a/b/ca","/a/b/d"]
 */
class Solution {
    public List<String> removeSubfolders(String[] folder)
    {
        //Sort the list 第一步排序 字符串比较
        Arrays.sort(folder);
        //第一个字符串长度最小 && 字符最小
        String temp = folder[0];
        List<String> res = new ArrayList<>();
        //插入最小的值
        res.add(temp);
        for(int i = 1; i < folder.length; i++)
        {
            // Check if the string StartsWith or not. If not, add to the result list
            if(!(folder[i]).startsWith(temp + "/"))
            {
                res.add(folder[i]);
                temp = folder[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] test={"/a","/a/b","/c/d","/c/d/e","/c/f"};
        new Solution().removeSubfolders(test);
    }
}