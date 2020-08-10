package Contest.Contest23.Problem2;


/**
 * 那就先归并吧
 */
class Solution {
    public String arrangeWords(String text) {
        String[] strings=text.split(" ");
        String[] result=mergeSort(strings,0,strings.length-1);
        StringBuilder stringBuilder=new StringBuilder();

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length(); j++) {
                if (i==0 && j==0) {
                    stringBuilder.append(Character.toUpperCase(result[i].charAt(j)));
                }else if(Character.isUpperCase(result[i].charAt(j))){
                    stringBuilder.append(Character.toLowerCase(result[i].charAt(j)));
                }else {
                    stringBuilder.append(result[i].charAt(j));
                }
            }
            stringBuilder.append(" ");
        }
        return stringBuilder.substring(0,stringBuilder.length()-1);
    }
    private String[] mergeSort(String[] input,int start,int end){
        if (start>end) {
            return new String[]{};
        }
        if (start==end) {
            return new String[]{input[start]};
        }
        int mid=start+((end-start)>>1);
        String[] left=mergeSort(input,start,mid);
        String[] right=mergeSort(input,mid+1,end);

        return merge(left,right);
    }
    private String[] merge(String[] left,String[] right){
        String[] result=new String[left.length+right.length];
        int first=0,second=0;
        while (first<left.length || second<right.length){
            int index=first+second;
            if (first==left.length) {
                result[index]=right[second++];
            }else if(second==right.length){
                result[index]=left[first++];
            }else {
                String leftString=left[first];
                String rightString=right[second];
                if (leftString.length()<=rightString.length()) {
                    result[index]=leftString;
                    first++;
                }else {
                    result[index]=rightString;
                    second++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().arrangeWords("Keep calm and code on"));
        System.out.println(new Solution().arrangeWords("To"));
    }
}