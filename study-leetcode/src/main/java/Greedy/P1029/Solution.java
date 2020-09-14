package Greedy.P1029;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 假定2N人都去B市，则费用为
 *
 * for(int i=0; i<n; ++i)
 *      sum+=price_B;
 * 现在我们让其中的N个人不去B市，而是直接去A市。那这个费用就变成
 *
 * sum = sum + price_A - price_B; //对于N个人的其中一个来说
 * 所有的price_B累加是固定值，要让sum最小，我们只要按(price_A - price_B)排序，
 *
 * 这个值小的前N个人去A市，那sum就最小
 */
class Solution {
    public int twoCitySchedCost(int[][] costs) {
      // Sort by a gain which company has 
      // by sending a person to city A and not to city B
      Arrays.sort(costs, new Comparator<int[]>() {
          @Override
          public int compare(int[] o1, int[] o2) {
              return o1[0] - o1[1] - (o2[0] - o2[1]);
          }
      });

      int total = 0;
      int n = costs.length / 2;
      // To optimize the company expenses,
      // send the first n persons to the city A
      // and the others to the city B
      for (int i = 0; i < n; ++i) {
          total += costs[i][0] + costs[i + n][1];
      }
      return total;
    }
}
