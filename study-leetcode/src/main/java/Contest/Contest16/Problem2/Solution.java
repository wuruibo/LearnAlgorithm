package Contest.Contest16.Problem2;

import java.util.Arrays;

/**
 * P950
 */
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        if (deck.length<=2) {
            return deck;
        }
        Arrays.sort(deck);
        int[] result=new int[deck.length];
        for (int i = deck.length-1; i >= 0; i--) {
            if (i>deck.length-3) {
                result[i]=deck[i];
            }else {
                int param = result[result.length-1];
                //step1 复制前面的元素到后面
                for (int j = result.length-2; j > i; j--) {
                    result[j + 1] = result[j];
                }
                //step2 将最后一个值复制到最前面
                result[i+1] = param;
                //step3 将当前元素放到当前位置
                result[i] = deck[i];
            }
        }
        return result;
    }
}