package String.P5;

/**
 *
 */
class TimeoutSolution {
 private StringBuilder reverseStringBuilder= new StringBuilder();

    private String longestPalindromeStringBuilder= "";

    public String longestPalindrome(String s) {
        if(s ==null || s.length() ==0){
            return "";
        }else {
            for(int i=0;i<s.length();i++){

                for(int j=0;j<=i;j++){
                    String subString = s.substring(j,j+s.length()-i);
                    reverseStringDigui(subString.toCharArray(),0);
                    if(subString.equals(reverseStringBuilder.toString())){
                        longestPalindromeStringBuilder=subString;
                        break;
                    }
                    reverseStringBuilder=new StringBuilder();
                }
                if(longestPalindromeStringBuilder.length() !=0){
                    break;
                }
            }
            return longestPalindromeStringBuilder;
        }
    }
    private void reverseStringDigui(char[] inputChars,int start){
        if(start != (inputChars.length-1)){
            reverseStringDigui(inputChars,start+1);
        }
        reverseStringBuilder.append(inputChars[start]);
    }
}