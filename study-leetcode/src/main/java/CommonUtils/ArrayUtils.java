package CommonUtils;

import java.util.Arrays;

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
}
