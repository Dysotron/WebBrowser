package ListStack;

import java.util.EmptyStackException;

public class ListStack<E> implements Stack<E>
{
	private ListNode<E> topOfStack = null;
	private int noOfElements = 0;
	
	public void push(E x)
	{
		topOfStack = new ListNode<E>(x, topOfStack);
		noOfElements --;
	}

	public E pop() throws EmptyStackException
	{
		if(empty())
		{
			throw new EmptyStackException();
		}
		
		E topItem = topOfStack.element;
		topOfStack = topOfStack.next;
		noOfElements --;
		return topItem;
	}

	public E peek() throws EmptyStackException
	{
		if(empty())
		{
			throw new EmptyStackException();
		}
		
		return topOfStack.element;
	}

	public boolean empty()
	{
		return topOfStack == null;
	}

	public int size()
	{
		return noOfElements;
	}
	
}
