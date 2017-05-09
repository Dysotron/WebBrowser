package ListStack;

class ListNode<E>
{
	E element;
	ListNode<E> next;
	
	ListNode(E theElement, ListNode<E> n)
	{
		element = theElement;
		next = n;
	}
}
