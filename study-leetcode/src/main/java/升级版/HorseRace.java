package 升级版;

import java.util.Arrays;

/**
 * 25匹马5个赛道，选出前n名
 *
 * 一次赛跑就是一次排序5log5
 * 抽象成五个有序队列，每个序列头部是跑的最快的马
 *
 * @autor yeqiaozhu.
 * @date 2019-10-25
 */
public class HorseRace {
    public int horseRace(int[][] race,int n){
        //先全部拉出来
        for (int i = 0; i < race.length; i++) {
            Arrays.sort(race[i]);
        }
        return 0;
    }

}
