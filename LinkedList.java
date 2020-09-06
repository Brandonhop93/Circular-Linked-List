/*
 *  LinkedList is restricted to PlanarShapes, un-restrict by removing "extends PlanarShape".
 */

import java.io.*;
import java.util.*;

public class LinkedList<T extends PlanarShape> implements Iterable<T>
{
    protected Node<T> sentinel;
    protected int size;
    protected int modCount;

    /** Class constructor. */
    public LinkedList()
    {
        //Create a sentinel as a Node with no data.
        sentinel = new Node<T>(null, null, null);

        //Assign previous and next to sentinel.
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);

        //Set default integer values.
        size = modCount = 0;
    }

    /** Adds the passed object to the start of the list. */
    public void prepend(T element)
    {
        //Add an object to the start of the list.
        sentinel.setNext(new Node<T>(element, sentinel, sentinel.getNext()));
        sentinel.getNext().getNext().setPrev(sentinel.getNext());

        //Increment size.
        size++;

        //Increment modCount.
        modCount++;
    }

    /** Adds the passed object to the end of the list. */
    public void append(T element)
    {
        //Add an object to the end of the list.
        sentinel.setPrev(new Node<T>(element, sentinel.getPrev(), sentinel));
        sentinel.getPrev().getPrev().setNext(sentinel.getPrev());

        //Increment size.
        size++;

        //Increment modCount.
        modCount++;
    }

    /** Removes and returns the object at the start of the list. */
    public T removeFromStart()
    {
        if (size != 0)
        {
            //Object to return.
            T element = sentinel.getNext().getData();

            //Remove an object from the start of the list or re-assign sentinel if empty.
            sentinel.getNext().getNext().setPrev(sentinel);
            sentinel.setNext(sentinel.getNext().getNext());

            //Decrement size
            size--;

            //Increment modCount.
            modCount++;

            //Returns node data or null if the list was empty.
            return element;
        }

        else
        {
            //No elements exist, throw exception.
            throw new IndexOutOfBoundsException("Cannot remove from empty list.");
        }
    }

    /** Removes and returns the object at the end of the list. */
    public T removeFromEnd()
    {
        if (size != 0)
        {
            //Object to return.
            T element = sentinel.getPrev().getData();

            //Remove an object from the end of the list.
            sentinel.getPrev().getPrev().setNext(sentinel);
            sentinel.setPrev(sentinel.getPrev().getPrev());

            //Decrement size
            size--;

            //Increment modCount.
            modCount++;

            //Returns node data.
            return element;
        }

        else
        {
            //No elements exist, throw exception.
            throw new IndexOutOfBoundsException("Cannot remove from empty list.");
        }
    }

    /** Returns list size. */
    public int size()
    {
        return size;
    }

    /** Returns if the list is empty. */
    public boolean isEmpty()
    {
        return size == 0;
    }

    public Iterator<T> iterator()
    {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T>
    {
        //Current pointer for iteration.
        private Node<T> current = sentinel;

        //Modcount tracker.
        private int expectedModCount = modCount;

        public boolean hasNext()
        {
            //Check for concurrent modification.
            checkForModification();

            //Check currents next doesn't equal the sentinel.
            return current.getNext() != sentinel;
        }

        public T next()
        {
            if (hasNext())
            {
                //Return current's next.
                current = current.getNext();
                return current.getData();
            }

            else
            {
                //Throw no such element exception.
                throw new NoSuchElementException();
            }
        }

        public void remove()
        {
            //Check for concurrent modification.
            checkForModification();

            if (current == sentinel)
            {
                //Throw no such element exception.
                throw new IllegalStateException("There is no established item to be removed.");
            }

            else
            {
                //Move current to previous.
                current = current.getPrev();

                //Remove current's next.
                current.setNext(current.getNext().getNext());
                current.getNext().setPrev(current);

                //Decrement size
                size--;

                //Increment mod count.
                modCount++;

                //Increment expected mod count.
                expectedModCount++;
            }
        }

        private void checkForModification()
        {
            if (modCount != expectedModCount)
            {
                //Throw concurrent modification exception.
                throw new ConcurrentModificationException();
            }
        }
    }
}
