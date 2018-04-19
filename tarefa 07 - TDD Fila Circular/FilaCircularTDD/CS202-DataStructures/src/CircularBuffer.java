public class CircularBuffer {
	private int front; //front postion of Circular queue (element will be dequeued from front)
	private int rear; //rear position of Circular queue (new element enqueued from front)
	private int currentSize; //current circular queue size
	private int capacity; //circular queue maximum size
	final int MAXSIZE = 5;
	
	private int[] circularQueue;

	
	public CircularBuffer(int capacity) {
		
		this.front = this.rear = -1;
		this.currentSize = 0;
		this.capacity = capacity;
		this.circularQueue = new int[this.capacity];
		
	}

	public boolean isEmpty() {
		return this.currentSize == 0;
	}

	public boolean isFull() {
		return this.currentSize == this.capacity;
	}

	public void put(int item) {
		
		if(this.isFull()) { 
			throw new CircularBufferException("Put to full circular buffer");
		}else{//if queue is not full
			rear = (rear+1) % circularQueue.length;
			circularQueue[rear] = item;
			currentSize++;
			if(front == -1) {
				front = rear;
			}
		}

	}

	public int get() {
		int removido;
		if (this.isEmpty()) { 
			throw new CircularBufferException("Get from empty circular buffer");
		}else {	//if queue is not empty
			removido = circularQueue[front];
			circularQueue[front] = -1;
			front = (front+1) % circularQueue.length;
			currentSize--;
			return removido;
		}

		
	}

	public int capacity() {
		return this.capacity;
	}

}
