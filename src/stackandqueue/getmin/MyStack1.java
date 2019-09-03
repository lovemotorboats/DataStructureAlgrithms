package stackandqueue.getmin;

import java.util.Stack;

//实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
//方案1：压栈时只有新压入的元素小于等于当前的min时才压入到stackMin，
//弹出时只有弹出的元素等于min时才将stackMin中的栈顶元素弹出
public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1(){
        stackData = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public void push(int newNum){
        if (stackData.isEmpty())
            stackMin.push(newNum);
        else if (newNum <= this.getMin())
            stackMin.push(newNum);
        stackData.push(newNum);
    }

    public int pop(){
        if (stackData.isEmpty())
            throw new RuntimeException("stack is empty.");
        int value = stackData.pop();
        if (value == this.getMin())
            stackMin.pop();
        return value;
    }

    public int getMin(){
        if (stackData.isEmpty())
            throw new RuntimeException("stack is empty.");
        return stackMin.peek();
    }
}
