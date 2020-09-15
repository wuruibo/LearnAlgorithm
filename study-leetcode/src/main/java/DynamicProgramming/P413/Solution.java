package DynamicProgramming.P413;

/**
 * A = [1, 2, 3, 4]
 *
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 *
 * 分析过程
 *
 * 如果A的长度<3 返回0
 * 如果A的长度不小于3 迭代开始的条件是A.length=3
 * 此时temp[2]=前三个元素中以第三个元素为结尾的符合条件的队分割数量 result[2]=result[1]+temp[2] result[3]=result[2]+temp[3] temp[3]=temp[2]+1;
 *
 * 得出状态转移方程
 *
 * A.length>3时  result[i]=result[i-1]+temp[i] temp[i]=temp[i-1]+1; 当新增加的元素和末尾元素满足条件时
 *
 * A.length=3时  result[2]=result[1]+temp[2] result[1]=0;temp[2]=temp[1]+1;temp[1]=0;
 *
 */
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        //step1 初始化
        int size=A.length;
        if (size<3){
            return 0;
        }
        int[] result=new int[A.length];
        int[] temp=new int[A.length];

        for (int i = 0; i < 3; i++) {
            if (i<2){
                result[i]=0;
                temp[i]=0;
            }else {
                temp[i]=(A[i]-A[i-1])==(A[i-1]-A[i-2])?1:0;
                result[i]=temp[i]+result[i-1];
            }
        }
        //step2 运用状态转移方程进行迭代
        for (int i = 3; i < A.length; i++) {
            if ((A[i]-A[i-1])==(A[i-1]-A[i-2])) {
                temp[i]=temp[i-1]+1;
            }else {
                temp[i]=0;
            }
            result[i]=temp[i]+result[i-1];
        }

        //step3 返回结果
        return result[size-1];
    }

    public int numberOfArithmeticSlicesMoreClear(int[] A) {
        int result=0;
        //dp[i]代表以i结尾的符合要求的等差数列有多少个
        int[] dp=new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i<2){
                dp[i]=0;
            }else if (A[i]-A[i-1]==A[i-1]-A[i-2]) {
                dp[i]=dp[i-1]+1;
            }
            result+=dp[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A={1, 3, 5, 7, 9};
        int[] A1={7, 7, 7, 7};
        int[] A2={3, -1, -5, -9};
        int[] A3={1, 1, 2, 3, 7,7,7,8,9,-1,-11};
        System.out.println(new Solution().numberOfArithmeticSlices(A));
        System.out.println(new Solution().numberOfArithmeticSlices(A1));
        System.out.println(new Solution().numberOfArithmeticSlices(A2));
        System.out.println(new Solution().numberOfArithmeticSlices(A3));

        System.out.println(new Solution().numberOfArithmeticSlicesMoreClear(A));
        System.out.println(new Solution().numberOfArithmeticSlicesMoreClear(A1));
        System.out.println(new Solution().numberOfArithmeticSlicesMoreClear(A2));
        System.out.println(new Solution().numberOfArithmeticSlicesMoreClear(A3));
    }
}