package Sort.P1122;

/**
 * 使用counting sort的版本
 *
 * 1.Because 0 <= arr1[i], arr2[i] <= 1000, we use an array to count every element.
 * 2.Go through every element in the second array, and update values of the first array based on the order in the second array.
 *
 *
 * @autor yeqiaozhu.
 * @date 2020-01-19
 */
public class UsingSort {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for(int n : arr1) cnt[n]++;
        int i = 0;
        for(int n : arr2) {
            while(cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        for(int n = 0; n < cnt.length; n++) {
            while(cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }
}
