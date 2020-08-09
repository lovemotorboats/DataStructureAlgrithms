package linklist.deque;

class MyCircularDeque {

    public Node front;  //头指针
    public Node rear;  //尾指针
    public int size;  //实际包含的元素个数
    public int capacity;  //队列的容量

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        front = new Node(0);
        rear = new Node(0);
        front.next = rear;
        rear.pre = front;
        size = 0;
        capacity = k;  //初始化容量
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == capacity) {
            //队列已满
            return false;
        }
        Node newNode = new Node(value);
        newNode.next = front.next;
        front.next.pre = newNode;
        newNode.pre = front;
        front.next = newNode;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == capacity) {
            //队列已满
            return false;
        }
        Node newNode = new Node(value);
        newNode.next = rear;
        rear.pre.next = newNode;
        newNode.pre = rear.pre;
        rear.pre = newNode;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        Node temp = front.next;
        front.next = temp.next;
        temp.next.pre = front;
        temp.pre = null;
        temp.next = null;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        Node temp = rear.pre;
        rear.pre = temp.pre;
        temp.pre.next = rear;
        temp.pre = null;
        temp.next = null;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (size == 0) {
            return -1;
        }
        return front.next.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (size == 0) {
            return -1;
        }
        return rear.pre.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}

class Node {
    public int val;
    public Node pre;
    public Node next;

    public Node (int val) {
        this.val = val;
    }
}
