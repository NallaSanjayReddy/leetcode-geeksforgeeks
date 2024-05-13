class Node {
    int val;
    Node next;
    Node prev;
    Node(int data){
        val=data;
        next=null;
        prev=null;
    }
}

class MyCircularQueue {
    Node first, rear;
    int length, cur;

    public MyCircularQueue(int k) {
        length = k;
        cur = 0;
        first = new Node(-1); // Dummy node for the front
        rear = new Node(-1); // Dummy node for the rear
        first.next = rear;
        first.prev = rear;
        rear.next = first;
        rear.prev = first;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        Node newNode = new Node(value);
        if (isEmpty()) {
            first.next = newNode;
            rear.prev = newNode;
            newNode.prev = first;
            newNode.next = rear;
        } else {
            newNode.prev = rear.prev;
            rear.prev.next = newNode;
            rear.prev = newNode;
            newNode.next = rear;
        }
        cur++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        first.next = first.next.next;
        first.next.prev = first;
        cur--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : first.next.val;
    }

    public int Rear() {
        return isEmpty() ? -1 : rear.prev.val;
    }

    public boolean isEmpty() {
        return cur == 0;
    }

    public boolean isFull() {
        return cur == length;
    }
}
