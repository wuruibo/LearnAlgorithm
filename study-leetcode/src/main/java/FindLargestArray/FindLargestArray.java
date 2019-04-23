package FindLargestArray;

/**
 * Dynamic Programming
 * 动态规划
 * 动态规划第一个数组 tempArray[i]表示从0开始到第i个元素的以i结尾的最大子串
 * 动态规划第二个数组 maxArray[i]表示从0开始到第i个元素的最大子串
 */
public class FindLargestArray {
    //定义一个数组保存子数组的最大和,tempMaxArray[i]表示前i个元素的数组的最大和
    private  int[] maxArray;
    //定义一个数组保存当前
    private int[] tempArray;

    public int findLargestArray(int[] array){
        maxArray = new int[array.length];
        tempArray = new int[array.length];
        maxArray[0] = array[0];
        tempArray[0] = array[0];
        for(int i=1;i<array.length;i++){
            tempArray[i] =array[i]>(array[i]+tempArray[i-1])?array[i]:(array[i]+tempArray[i-1]);
            maxArray[i] = tempArray[i]>maxArray[i-1]?tempArray[i]:maxArray[i-1];

        }
        return maxArray[array.length-1];
    }

    public static void main(String[] args) {
        int[] testArray={1,-2,3,4,-6};
        System.out.println(new FindLargestArray().findLargestArray(testArray));;
    }
}
