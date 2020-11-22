public class MyCircularDeque {

    private int capacity;
    private int count;
    private DoublelyListNode front;
    private DoublelyListNode rear;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        capacity = k;
        count = 0;
        front = new DoublelyListNode(0);
        rear = new DoublelyListNode(0);
        front.next = rear;
        rear.prev = front;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if( capacity == count){
            return false;
        }

        DoublelyListNode newNode = new DoublelyListNode(value);
        newNode.next = front.next;
        newNode.prev = front;
        front.next.prev = newNode;
        front.next = newNode;

        count ++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if( capacity == count){
            return false;
        }

        DoublelyListNode newNode = new DoublelyListNode(value);
        newNode.next = rear;
        newNode.prev = rear.prev;
        rear.prev.next = newNode;
        rear.prev = newNode;

        count ++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(front.next != rear){
            DoublelyListNode origin = front.next;

            origin.next.prev = front;
            front.next = origin.next;

            //let gc clean origin
            origin.prev = null;
            origin.next = null;

            count--;
            return true;
        }

        return false;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(rear.prev != front){
            DoublelyListNode origin = rear.prev;

            origin.prev.next = rear;
            rear.prev = origin.prev;

            //let gc clean origin
            origin.prev = null;
            origin.next = null;

            count--;
            return true;
        }

        return false;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(front.next != rear) {
            return front.next.value;
        }
        return -1;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(rear.prev != front) {
            return rear.prev.value;
        }

        return -1;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return count == capacity;
    }

    public class DoublelyListNode{
        private DoublelyListNode prev;
        private DoublelyListNode next;
        private int value;

        public DoublelyListNode (int value){
            this.value =  value;
            prev = null;
            next = null;
        }
    }
}
