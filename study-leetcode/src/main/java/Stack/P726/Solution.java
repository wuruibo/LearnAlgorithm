package Stack.P726;

import java.util.*;

/**
 * 726. 原子的数量
 * 给定一个化学式formula（作为字符串），返回每种原子的数量。
 *
 * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
 *
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
 *
 * 两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。
 *
 * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
 *
 * 给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
 *
 * 示例 1:
 *
 * 输入:
 * formula = "H2O"
 * 输出: "H2O"
 * 解释:
 * 原子的数量是 {'H': 2, 'O': 1}。
 * 示例 2:
 *
 * 输入:
 * formula = "Mg(OH)2"
 * 输出: "H2MgO2"
 * 解释:
 * 原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
 * 示例 3:
 *
 * 输入:
 * formula = "K4(ON(SO3)2)2"
 * 输出: "K4N2O14S4"
 * 解释:
 * 原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
 * 注意:
 *
 * 所有原子的第一个字母为大写，剩余字母都是小写。
 * formula的长度在[1, 1000]之间。
 * formula只包含字母、数字和圆括号，并且题目中给定的是合法的化学式。
 */
class Solution {
    public String countOfAtoms(String formula) {
        if (formula==null || formula.length()==0) {
            return formula;
        }
        Deque<String> deque= new ArrayDeque<>();

        List<String> params=new ArrayList<>();
        for (int i = 0; i < formula.length(); ) {
            StringBuilder current=new StringBuilder();
            //判断数字元素
            if (boolNumber(formula.charAt(i))) {
                while (i<formula.length() && boolNumber(formula.charAt(i))){
                    current.append(formula.charAt(i++));
                }
            }else if (boolChar(formula.charAt(i),'A') && i+1<formula.length() && boolChar(formula.charAt(i+1),'a')){//处理Mg两个字母的元素
                current.append(formula.charAt(i));
                current.append(formula.charAt(i+1));
                i+=2;
            }else {
                current.append(formula.charAt(i++));
            }
            params.add(current.toString());
        }
        Map<String,Integer> hashArray= new HashMap<>();

        for (int i = 0; i < params.size(); i++) {
            String now=params.get(i);
            if (now.equals("(")){
                deque.offerLast(now);
            }else if (boolChar(now.charAt(0),'A')) {
                deque.offerLast(now);
                hashArray.put(now,hashArray.getOrDefault(now,0)+1);
            }else if (boolNumber((now.charAt(0)))){
                String last=deque.peekLast();
                hashArray.put(last,hashArray.get(last)*Integer.valueOf(now));
            }else if (now.equals(")")){
                String next=params.get(++i);
                Deque<String> temp=new ArrayDeque<>();
                //弹出来进行加倍
                String param;
                while (!(param=deque.pollLast()).equals("(") ) {
                    temp.offerLast(param);
                    Integer time=hashArray.get(param)*(Integer.valueOf(next));
                    hashArray.put(param,time);
                }
                //重新弹回去
                while (!temp.isEmpty()) {
                    deque.offerLast(temp.pollLast());
                }
            }
        }
        StringBuilder result=new StringBuilder();
        Iterator<Map.Entry<String,Integer>> iterator=hashArray.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,Integer> entry=iterator.next();
            String key=entry.getKey();
            String value=entry.getValue()==1?"":entry.getValue().toString();

            result.append(key).append(value);
        }

        return result.toString();
    }
    private boolean boolChar(Character character,Character begin){
        return character-begin>=0 && character-begin<26;
    }
    private boolean boolNumber(Character character){
        return character-'0'>=0 && character-'0'<=9;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().countOfAtoms("H2O"));
        System.out.println(new Solution().countOfAtoms("Mg(OH)2"));
        System.out.println(new Solution().countOfAtoms("K4(ON(SO3)2)2"));
    }
}