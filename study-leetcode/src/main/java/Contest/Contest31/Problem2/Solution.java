package Contest.Contest31.Problem2;

class Solution {
    public String reorderSpaces(String text) {
        int breaks=0,count=text.length();char current=' ';
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i)==' ') {
                continue;
            }
            while (i<text.length() && text.charAt(i)!=current) {
                count--;
                i++;
            }
            breaks++;
        }
        //计算
        int left=breaks==1?count:count%(breaks-1),distance=breaks==1?0:(count-left)/(breaks-1);
        StringBuilder result= new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i)==' ') {
                continue;
            }
            while (i<text.length() && text.charAt(i)!=current) {
                result.append(text.charAt(i++));
            }
            if (breaks==1) {
                for (int j = 0; j < left; j++) {
                    result.append(" ");
                }
            }else {
                for (int j = 0; j < distance; j++) {
                    result.append(" ");
                }
                breaks--;
            }

        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reorderSpaces("  this   is  a sentence "));
        System.out.println(new Solution().reorderSpaces(" practice   makes   perfect"));
        System.out.println(new Solution().reorderSpaces("hello   world"));
        System.out.println(new Solution().reorderSpaces("  walks  udp package   into  bar a"));
        System.out.println(new Solution().reorderSpaces("a"));
    }
}