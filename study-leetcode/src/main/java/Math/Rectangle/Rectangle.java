package Math.Rectangle;

import java.util.Arrays;

/**
 * @autor yeqiaozhu.
 * @date 2019-05-04
 */
public class Rectangle {

    public int[] constructRectangle(int area) {
        int chushu = area;
        int distance = area - 1;
        for(int i =1;i<=area;i++){
            int yushu=area%i;
            chushu = area/i;
            if(yushu ==0 && i >= chushu && i-chushu <= distance){
                return new int[]{i,chushu};
            }
        }
        if(area == 1){ return  new int[]{1,1};}
        return new int[]{};
    }

    public static void main(String[] args) {

        Arrays.stream(new Rectangle().constructRectangle(16)).forEach(intValue ->System.out.println(intValue));
    }
}
