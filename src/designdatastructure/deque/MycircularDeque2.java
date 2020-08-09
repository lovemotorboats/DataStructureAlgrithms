package designdatastructure.deque;

//设计双端循环队列方式一：利用数组结构
public class MycircularDeque2 {
    public int[] queue;  //队列数组
    public int front;  //队头索引
    public int rear;  //队尾索引
    public int capacity;  //队列容量

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MycircularDeque2(int k) {
        queue = new int[k + 1];  //需消耗一个位置
        front = 0;
        rear = 0;
        capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        //从头部插入时队满条件(front - 1 + k + 1) % (k + 1) == r
        if ((front + capacity) % (capacity + 1) == rear) {
            return false;
        }
        front = (front + capacity) % (capacity + 1);
        queue[front] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        //从尾部插入时队满条件(rear + 1) % (k + 1) == front
        if ((rear + 1) % (capacity + 1) == front) {
            return false;
        }
        queue[rear] = value;
        rear = (rear + 1) % (capacity + 1);
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        //队列为空的条件：rear == front
        if (front == rear) {
            return false;
        }
        front = (front + 1) % (capacity + 1);
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (front == rear) {
            return false;
        }
        rear = (rear + capacity) % (capacity + 1);
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (rear == front) {
            return -1;
        }
        return queue[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (rear == front) {
            return -1;
        }
        return queue[(rear + capacity) % (capacity + 1)];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return rear == front;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (front + capacity) % (capacity + 1) == rear || (rear + 1) % (capacity + 1) == front;
    }
}
