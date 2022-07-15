class MyCircularQueue {
    private int[] queue;
    private int headIndex;
    private int count;
    private int capacity;
    private ReentrantLock queueLock = new ReentrantLock();
    
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
        this.headIndex = 0;
        this.count = 0;
    }
    
    public boolean enQueue(int value) {
        if(this.count == this.capacity)
            return false;
        queueLock.lock();
        try{
            this.queue[(this.headIndex+this.count)%this.capacity] = value;
            this.count++;
        }finally {
            queueLock.unlock();
        }
        
        return true;
        
    }
    
    public boolean deQueue() {
        if(this.count == 0)
            return false;
        queueLock.lock();
        try{
            this.headIndex = (this.headIndex+1) % this.capacity;
            this.count--;
        }finally{
            queueLock.unlock();
        }
        return true;
    }
    
    public int Front() {
        if(this.count == 0)
            return -1;
        return this.queue[(this.headIndex)];
    }
    
    public int Rear() {
        if(this.count == 0)
            return -1;
        int tailIndex = (this.headIndex+this.count-1)%this.capacity;
        return this.queue[tailIndex];
    }
    
    public boolean isEmpty() {
        if(this.count == 0)
            return true;
        else
            return false;
    }
    
    public boolean isFull() {
        if(this.count == this.capacity)
            return true;
        else
            return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */