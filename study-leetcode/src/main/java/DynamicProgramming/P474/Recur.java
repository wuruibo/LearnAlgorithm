package DynamicProgramming.P474;

import java.util.HashMap;
import java.util.Map;

public class Recur {
    private Map<String,int[]> hash= new HashMap<>();
    private Map<String,Integer> dpMap=new HashMap<>();
    public int findMaxForm(String[] strs, int m, int n) {
        for (String str : strs) {
            int[] temp=new int[2];
            for (char c : str.toCharArray()) {
                temp[c-'0']++;
            }
            hash.put(str,temp);
        }
        return dfs(strs,0,m,n);
    }
    private int dfs(String[] str,int i,int m,int n){
        String key=i+"-"+m+"-"+n;
        if (m<0 || n<0 || i>str.length-1) {
            dpMap.put(key,0);
            return 0;
        }
        if (dpMap.containsKey(key)) {
            return dpMap.get(key);
        }
        //可选可不选 先判断i能不能选
        int max;
        int[] temp=hash.get(str[i]);
        if (temp[0]<=m && temp[1]<=n) {
            max=Math.max(dfs(str,i+1,m-temp[0],n-temp[1])+1,dfs(str,i+1,m,n));
        }else {
            max=dfs(str,i+1,m,n);
        }
        dpMap.put(key,max);
        return max;
    }

    public static void main(String[] args) {
        /*System.out.println(new Recur().findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
        System.out.println(new Recur().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));*/
        System.out.println(new Recur().findMaxForm(new String[]{"1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0"}
        ,30 ,30));
    }
}
