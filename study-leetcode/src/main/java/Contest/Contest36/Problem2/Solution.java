package Contest.Contest36.Problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result= new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            result.add(check(nums,l[i],r[i]));
        }
        return result;
    }
    private Boolean check(int[] array,int l,int r){
        int[] temp= Arrays.copyOfRange(array,l,r+1);
        Arrays.sort(temp);
        int len=temp[1]-temp[0];
        for (int i = 2; i < temp.length; i++) {
            if (temp[i]-temp[i-1]!=len) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2,3,5}));
        System.out.println(new Solution().checkArithmeticSubarrays(new int[]{-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10}, new int[]{0,1,6,4,8,7}, new int[]{4,4,9,7,9,10}));
    }
}