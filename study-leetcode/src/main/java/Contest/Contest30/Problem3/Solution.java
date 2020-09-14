package Contest.Contest30.Problem3;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目：连接所有点的最小费用
 *
 * 最小生成树 Kruskal(克鲁斯卡尔)算法
 * https://www.bilibili.com/video/BV1Eb41177d1?from=search&seid=2972784950261533820
 *
 * 第一步 算出每个点到其他点的距离放入优先级队列 小顶堆中
 * 第二步 从堆中依次选择最小的边加入 防止出现环（通过并查集判断当前的i，j是否属于同一个祖先）
 */
class Solution {
    int[] parents = null;
    int x=0,y=1;
    public int minCostConnectPoints(int[][] points) {
        int n=points.length,p=n-1,ans=0;
        parents = new int[n];
        for(int i=0;i<n;i++){
            parents[i]=i;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o->o[2]));
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int dis=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                queue.add(new int[]{i,j,dis});
            }
        }
        
        while(p>0){
            int[] poll = queue.poll();
            x=poll[0];y=poll[1];
            if(find(x)!=find(y)){
                ans+=poll[2];
                parents[find(y)]=find(x);
                p--;
            }
            
        }
        return ans;
        
        
    }
    int find(int x){
        if(parents[x]==x){
            return x;
        } else {
            parents[x]=find(parents[x]);
        }
        return parents[x];
    }
    
}