package DynamicProgramming.P907;

/**
 * 直接中心扩展 找到以当前值为最小值的往左往右的最大边界
 */
public class MidSolution {
    public int sumSubarrayMins(int[] A) {
        int ans=0;
        int mod=1000000007;
        for(int i=0;i<A.length;i++){
            long sum=0;
            int a=A[i];
            int j=i-1;
            int k=i+1;
            for(;j>=0;j--){
                if(A[j]<a){break;}
            }
            for(;k<A.length;k++){
                if(A[k]<=a){break;}
            }
            sum=a*(i-j)*(k-i)%mod;
            ans=(ans+(int)sum)%mod;
        }
        return ans;
    }
}
