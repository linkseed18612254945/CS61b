package project.project1b;

public interface Deque<Item>
{
	void addFirst(Item n);
	void addLast(Item n);
	boolean isEmpty();
	int size();
	void printDeque();
	Item removeFirst();
	Item removeLast();
	Item get(int index);
}