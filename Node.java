/*
 *  Brandon Hopkins - C3290146
 *  Software Engineering - SENG2200
 *  Assignment 2
 */

public class Node<T>
{
    private T data;
    private Node<T> next;
    private Node<T> prev;

    /** Class constructor. */
    public Node(T data, Node<T> prev, Node<T> next)
    {
        //Initialise variables.
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    /** Returns node data reference. */
    public T getData()
    {
        return data;
    }

    /** Sets next to passed node. */
    public void setNext(Node<T> next)
    {
        this.next = next;
    }

    /** Returns next node. */
    public Node<T> getNext()
    {
        return next;
    }

    /** Sets previous to passed node. */
    public void setPrev(Node<T> prev)
    {
        this.prev = prev;
    }

    /** Returns previous node. */
    public Node<T> getPrev()
    {
        return prev;
    }
}
