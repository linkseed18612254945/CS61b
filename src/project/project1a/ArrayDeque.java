package project.project1a;

public class ArrayDeque<obj>
{	
	private obj[] items;
	private int size;
	private int front, rear;
	private int REFACTOR = 2;
	private int capacity = 8;

	public ArrayDeque()
	{
		size = 0;
		items = (obj[]) new Object[capacity];
		front = 0;
		rear = 0;
	}

	public boolean isEmpty()
	{
		return size == 0;
	}

	/* Check if the deque is full */
	private boolean isFull()
	{
		return size == capacity;
	}

	/* Resize the array deque */
	private void resize(int newCapacity)
	{
		obj[] tempArray = (obj[]) new Object[newCapacity];
		int newFront = front + newCapacity / REFACTOR;
		System.arraycopy(items, front, tempArray, newFront, capacity - front);
		System.arraycopy(items, 0, tempArray, 0, front);
		front = newFront;
		items = tempArray;
	}


	public void addLast(obj x)
	{
		if (isFull())
		{
			resize(capacity * REFACTOR);
			capacity *= REFACTOR;
		}
		items[rear] = x;
		rear = (rear + 1) % capacity;
		size += 1;
	}

	public obj removeFirst()
	{
		obj removeItem = items[front];
		front = (front + 1) % capacity;
		size -= 1;
		return removeItem;
	}

	public int size()
	{
		return size;
	}


	public String toString()
	{
		int i = front;
		String returnString = "";
		int num = size;
		while (num > 0)
		{
			if (returnString.equals(""))
			{
				returnString = "" + items[i];
			}
			else
			{
				returnString = returnString + " " + items[i];					
			}
			i = (i + 1) % capacity;
			num -= 1;
		}
		return returnString;
	}
}