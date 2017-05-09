package ListStack;

import java.util.EmptyStackException;

public interface Stack<E>
{
	public void push(E x);
	public E pop() throws EmptyStackException;
	public E peek() throws EmptyStackException;
	public boolean empty();
	public int size();
}
