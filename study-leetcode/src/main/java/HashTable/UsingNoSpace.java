package HashTable;

/**
 * The idea is that we need to map a char to another one, for example, "egg" and "add", we need to constract the mapping 'e' -> 'a' and 'g' -> 'd'.
 * Instead of directly mapping 'e' to 'a', another way is to mark them with same value, for example, 'e' -> 1, 'a'-> 1, and 'g' -> 2, 'd' -> 2, this works same.
 *
 * So we use two arrays here m1 and m2, initialized space is 256 (Since the whole ASCII size is 256, 128 also works here).
 * Traverse the character of both s and t on the same position,
 * if their mapping values in m1 and m2 are different, means they are not mapping correctly,
 * returen false; else we construct the mapping, since m1 and m2 are both initialized as 0, we want to use a new value when i == 0, so i + 1 works here.
 * @autor yeqiaozhu.
 * @date 2019-11-30
 */
public class UsingNoSpace {
    private int[] m1=new int[256];
    private int[] m2=new int[256];
    public boolean isIsomorphic(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            char currentS=s.charAt(i);
            char currentT=t.charAt(i);

            if (m1[currentS]!=m2[currentT]) {
                return false;
            }
            m1[currentS]=i+1;
            m2[currentT]=i+1;
        }
        return true;
    }
}