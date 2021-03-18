package String.P395;

/**
 * 滑动窗口
 * @author yeqiaozhu.
 * @date 3/11/21
 */
public class SlideWindow {
    private final Integer size=26;
    public int longestSubstring(String s, int k) {
        //1.当前窗口内拥有的有效的字符种类 当前窗口内拥有的所有的字符种类
        int max=0;
        for (int i = 1; i <= size; i++) {
            int[] hash=new int[size];
            int curKind=0,sumKind=0;
            for (int r = 0,l=0; r < s.length(); r++) {
                //2.当前窗口的字符种类大于限定的字符种类 移动左指针
                while (sumKind>i){
                    int leftCount=hash[s.charAt(l++)-'a']--;
                    if (leftCount==1) {
                        sumKind--;
                    }
                    if (leftCount==k){
                        curKind--;
                    }
                }
                //3.满足条件的情况下继续往右移动右指针
                int rightCount=++hash[s.charAt(r)-'a'];
                if (rightCount==1) {
                    sumKind++;
                }
                if (rightCount==k){
                    curKind++;
                }
                //4.当前窗口的有效字符数量满足目标 更新最大值
                if (curKind==sumKind){
                    max=Math.max(max,r-l+1);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new SlideWindow().longestSubstring("aaabb", 3));
        System.out.println(new SlideWindow().longestSubstring("aaabbbb", 1));
        System.out.println(new SlideWindow().longestSubstring("ababbc", 2));
    }
}
