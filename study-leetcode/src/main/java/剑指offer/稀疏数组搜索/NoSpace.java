package 剑指offer.稀疏数组搜索;

/**
 * @author yeqiaozhu
 */
public class NoSpace {
    public int findString(String[] words, String s) {
        //二分查找indexes
        int l=0,r=words.length-1;
        while (r >= l) {
            int mid=l+((r-l)>>1);
            while (mid>l && "".equals(words[mid])) {
                mid--;
            }
            if (words[mid].equals(s)) {
                return mid;
            }else if (words[mid].compareTo(s)<0){
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new NoSpace().findString(new String[]{"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""}, "ta"));
        System.out.println(new NoSpace().findString(new String[]{"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""}, "ball"));
    }
}
