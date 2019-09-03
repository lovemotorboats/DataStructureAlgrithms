package stackandqueue.twostacksqueue;

import java.util.Stack;

//用两个栈构造一个队列，实现队列的add、poll、peek功能
//1、stackPush倒数据时必须一次性倒完
//2、stackPop必须为空的时候才允许倒数据
public class Solution {
    private Stack<Integer> stackPush;  //倒入栈
    private Stack<Integer> stackPop;  //倒出栈

    public Solution(){
        stackPop = new Stack<Integer>();
        stackPush = new Stack<Integer>();
    }

    public void add(int pushInt){
        stackPush.push(pushInt);
        pushToPop();
    }

    public int poll(){
        if (stackPush.isEmpty() && stackPop.isEmpty())
            throw new RuntimeException("queue is empty.");
        pushToPop();
        return stackPop.pop();
    }

    public int peek(){
        if (stackPush.isEmpty() && stackPop.isEmpty())
            throw new RuntimeException("queue is empty.");
        pushToPop();
        return stackPop.peek();
    }

    public void pushToPop(){
        if (stackPop.isEmpty()){
            while (!stackPush.isEmpty())
                stackPop.push(stackPush.pop());
        }
    }
}
