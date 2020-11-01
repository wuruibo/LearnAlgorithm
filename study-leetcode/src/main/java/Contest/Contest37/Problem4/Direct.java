package Contest.Contest37.Problem4;

/**
 * @author yqz
 */
public class Direct {
    int[][] dp=new int[40][40];
    public String kthSmallestPath(int[] destination, int k) {
        int h=destination[1],v=destination[0];
        StringBuffer sb = new StringBuffer();
        if(k==1) {
            for(int i=0;i<h;i++){
                sb.append('H');
            }
            for(int i=0;i<v;i++){
                sb.append('V');
            }
            return sb.toString();
        }

        if(k<=find(h+v-1,v)) {
            sb.append('H');
            sb.append(kthSmallestPath(new int[]{v,h-1},k));
        }
        else {
            sb.append('V');
            sb.append(kthSmallestPath(new int[]{v-1,h},k-find(h+v-1,v)));
        }
        return sb.toString();
    }

    public int find(int h,int v){
        if(h==v||v==0) {
            return 1;
        }
        if(dp[h][v]==0) {
            dp[h][v] = find(h-1,v)+find(h-1,v-1);
        }
        return dp[h][v];
    }
}
