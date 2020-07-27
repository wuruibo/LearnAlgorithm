package Contest.Contest16.Problem2;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * P950
 *
 * 思路：此题，乍一眼看上去，一点规律没有，甚至示例看起来都觉得莫名其妙，相信很多人看了这道题都会像我这么觉得，所以此题归属于明显的阅读理解加脑筋急转弯题型。
 *
 * 但是，如果我们从另一个角度去看此题，就会发现此题的意思所在了。于是我们尝试着倒着看示例，我们有一个数组，数组中元素不重复，且按照降序排列，我们称之为卡牌，初始值为[17,13,11,7,5,3,2]，我们有另一个队列，初始为空，我们每次将数组中未放入队列中的最大的数插入到队列中，然后我们把队首元素移到队尾，重复这个过程，直到数组中所有元素都被放入队列中为止。
 *
 * 第一次，我们选17，[17]->[17]
 *
 * 第二次，我们选13，[17, 13]->[13, 17]
 *
 * 第三次，我们选11，[13, 17, 11]->[17, 11, 13]
 *
 * 第四次，我们选 7，[17, 11, 13, 7]->[11, 13, 7, 17]
 *
 * 第五次，我们选 5，[11, 13, 7, 17, 5]->[13, 7, 17, 5, 11]
 *
 * 第六次，我们选 3，[13, 7, 17, 5, 11, 3]->[7, 17, 5, 11, 3, 13]
 *
 * 第七次，我们选 2，[7, 17, 5, 11, 3, 13, 2]，此时，数组中所有元素都在队列中，过程结束。我们需要将这个队列倒过来，于是我们便称这样的队列，是按递增顺序显示卡牌。
 *
 */
public class UsingDeque {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> deque= new LinkedList<>();
        for (int i = deck.length-1; i >=0 ; i--) {
            if (deque.isEmpty()) {
                deque.offerLast(deck[i]);
            }else {
                Integer last=deque.pollLast();
                deque.offerFirst(last);
                deque.offerFirst(deck[i]);
            }
        }
        int[] result=new int[deck.length];
        for (int i = 0; i < result.length; i++) {
            result[i]=deque.pollFirst();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new UsingDeque().deckRevealedIncreasing(new int[]{7, 17, 5, 11, 3, 13, 2}));
    }
}
