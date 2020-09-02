package Greedy.P984;

class Solution {
    public String strWithout3a3b(int A, int B) {
        if(B==0) {
            return repeatString("a",A);
        }
        if(A==0) {
            return repeatString("b",B);
        }
        if(A==B) {
            return "ab"+strWithout3a3b(A-1,B-1);
        }
        return A>B?"aab"+strWithout3a3b(A-2,B-1):"bba"+strWithout3a3b(A-1,B-2);
 
    }
    private String repeatString(String str,int time){
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < time; i++) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }
}