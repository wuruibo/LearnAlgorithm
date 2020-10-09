package TwoPointer.P1089;

/**
 * 双指针
 */
class Solution {
    public void duplicateZeros(int[] arr) {
        int i = 0 , zero = 0 , l = arr.length-1;
        while(i <= l){
            if(arr[i] == 0) {
                zero++;
            }
            if(i + zero >= l) {
                break;
            }
            i++;
        }
        while(i >=0){
            arr[l--] = arr[i];
            //<=用来判断最后一个如果是0是否超出边界
            if(arr[i] == 0 && (i + zero <= arr.length-1) )
            {
                arr[l--] = arr[i];
            }
            i--;
        }
    }
}
