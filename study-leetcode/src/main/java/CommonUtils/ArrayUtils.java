package CommonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @autor yeqiaozhu.
 * @date 2019-10-29
 */
public class ArrayUtils<T> {
    private static ArrayUtils arrayUtils=new ArrayUtils();

    private ArrayUtils() {
    }
    public static ArrayUtils getInstance(){
        return arrayUtils;
    }

    public void printObjectArray(T[] array){
        Arrays.stream(array).forEach(T-> System.out.println(T));
    }

    public void printIntArray(int[] array){
        Arrays.stream(array).forEach(interger-> System.out.println(interger));
    }

    public List<List<T>> getListFromArray(T[][] arrays){
        List<List<T>> triangle= new ArrayList<>();

        for (int i = 0; i < arrays.length; i++) {
            List<T> temp=new ArrayList<>();
            for (int j = 0; j < arrays[i].length; j++) {
                temp.add(arrays[i][j]);
            }
            triangle.add(temp);
        }
        return triangle;
    }
    public static int binaryFind(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target >= nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
    public String printListArrayString(List<List<T>> list){
        StringBuilder result=new StringBuilder("[");
        String text=recursive(list,0,list.size()-1);

        return result.append(text).append("]").toString();
    }
    private String recursive(List<List<T>> list,int start,int end){
        if (start==end) {
            return "["+list.get(start).get(0)+","+list.get(start).get(1)+"]";
        }
        int mid=start+(end-start)/2;
        String left=recursive(list,start,mid);
        String right=recursive(list,mid+1,end);

        return left+","+right;

    }
    public static void swap(int[] t,int left,int right){
        int temp=t[left];
        t[left]=t[right];
        t[right]=temp;
    }
}
