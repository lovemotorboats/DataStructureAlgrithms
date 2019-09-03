package stackandqueue.getmin;

import java.util.Stack;

//实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
//方案2：压栈时若新压入的元素小于等于当前的min时则压入到stackMin，否则压入之前的peek元素到stackMin
//弹出时每次将stackData和stackMin的栈顶元素都弹出
public class MyStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack2(){
        stackData = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public void push(int newNum){
        if (stackMin.isEmpty())
            stackMin.push(newNum);
        else if (this.getMin() > newNum)
            stackMin.push(newNum);
        else stackMin.push(this.getMin());
        stackData.push(newNum);
    }

    public int pop(){
        if (stackData.isEmpty())
            throw new RuntimeException("stack is empty.");
        stackMin.pop();
        return stackData.pop();
    }

    public int getMin(){
        if (stackMin.isEmpty())
            throw new RuntimeException("stack is empty.");
        return stackMin.peek();
    }
}
