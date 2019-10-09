package P155;

import java.util.ArrayList;
import java.util.List;

/**
 * 改善第一种方式
 * 最小值的数组不需要存全部的结果结
 * @autor yeqiaozhu.
 * @date 2019-10-09
 */
public class MInStackUsingTwoArrayBetter {
    //通过数组实现栈
    private List<Integer> stackArray;
    //记录最小值，在push和pop的过程中都要更新下当前的最小值
    private List<Integer> minArray;

    /** initialize your data structure here. */
    public MInStackUsingTwoArrayBetter() {
        stackArray=new ArrayList<>();
        minArray=new ArrayList<>();
    }

    public void push(int x){
        stackArray.add(x);
        int topIndex=minArray.size()-1;
        //最小栈无元素 直接插入
        if(minArray.size()==0){
            minArray.add(x);
        }
        //最小栈有元素但是栈顶元素比插入元素大 插入插入元素
        else if(x<=minArray.get(topIndex)){
            minArray.add(x);
        }
    }

    public void pop() throws Exception {
        if(stackArray.size()==0) {
            throw new Exception("元素为空");
        }
        int value=stackArray.remove(stackArray.size() - 1);
        if(value==minArray.get(minArray.size()-1)) {
            minArray.remove(minArray.size() - 1);
        }
    }

    public int top() throws Exception {
        if(stackArray.size()==0) {
            throw new Exception("元素为空");
        }
        return stackArray.get(stackArray.size() - 1);
    }

    public int getMin() throws Exception {
        if(minArray.size()==0) {
            throw new Exception("元素为空");
        }
        return minArray.get(minArray.size()-1);
    }

    public static void main(String[] args) throws Exception {
        MInStackUsingTwoArrayBetter minStack = new MInStackUsingTwoArrayBetter();
        minStack.push(2);
        minStack.push(3);
        minStack.push(0);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
