package 剑指offer.稀疏数组搜索;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int findString(String[] words, String s) {
        List<Integer> indexes= new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (!"".equals(words[i])) {
                indexes.add(i);
            }
        }
        //二分查找indexes
        int l=0,r=indexes.size()-1;
        while (r >= l) {
            int mid=l+((r-l)>>1);
            int index=indexes.get(mid);
            if (words[index].equals(s)) {
                return index;
            }else if (words[index].compareTo(s)<0){
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findString(new String[]{"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""}, "ta"));
        System.out.println(new Solution().findString(new String[]{"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""}, "ball"));
    }
}