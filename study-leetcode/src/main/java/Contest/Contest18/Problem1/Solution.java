package Contest.Contest18.Problem1;

class Solution {
    public String restoreString(String s, int[] indices) {
        char[] hash=new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            hash[indices[i]]=s.charAt(i);
        }
        StringBuilder result=new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            result.append(hash[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3}));
        System.out.println(new Solution().restoreString("abc", new int[]{0,1,2}));
        System.out.println(new Solution().restoreString("aiohn", new int[]{3,1,4,2,0}));
        System.out.println(new Solution().restoreString("aaiougrt", new int[]{4,0,2,6,7,3,1,5}));
        System.out.println(new Solution().restoreString("art", new int[]{1,0,2}));
    }
}