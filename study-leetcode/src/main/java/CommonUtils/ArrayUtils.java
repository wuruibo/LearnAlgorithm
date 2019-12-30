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
}
