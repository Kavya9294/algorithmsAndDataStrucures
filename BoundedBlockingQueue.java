class BoundedBlockingQueue {
    //Final for arrays means only the array is final
    //not the elements
    // because array elements are references, theses refs
    // are constant, but values vary
    private final int[] queue;
    //Volatile suggests don't store in cache
    //It will be used by multiple threads
    private volatile int size = 0;
    private int wp = 0, rp = 0;
    Semaphore enqSem, deqSem, lockSem;
    
    public BoundedBlockingQueue(int capacity) {
        this.queue = new int[capacity];
        enqSem = new Semaphore(capacity);
        deqSem = new Semaphore(0);
        lockSem = new Semaphore(1);
    }
    
    public void enqueue(int element) throws InterruptedException {
        enqSem.acquire();
        lockSem.acquire();
        this.queue[wp++] = element;
        size++;
        wp %= queue.length;
        lockSem.release();
        deqSem.release();
    }
    
    public int dequeue() throws InterruptedException {
        deqSem.acquire();
        lockSem.acquire();
        int res = this.queue[rp++];
        size--;
        rp %= this.queue.length;
        lockSem.release();
        enqSem.release();
        return res;
    }
    
    public int size() {
        return size;
    }
}