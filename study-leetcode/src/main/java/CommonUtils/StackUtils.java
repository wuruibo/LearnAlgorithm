package CommonUtils;

import java.util.Deque;
import java.util.Map;

public class StackUtils {

    public static void cutStack(Integer param,Map<Integer,Integer> hashIndex, Deque<Integer> deque){
        while (!deque.isEmpty() && deque.peekLast()<param){
            Integer last=deque.pollLast();
            hashIndex.put(last,param);
        }
        deque.addLast(param);
    }
}
