/*
 *  SortedList is restricted to PlanarShapes, un-restrict by changing "extends PlanarShape" to "extends Comparable<T>".
 */

public class SortedList<T extends PlanarShape> extends LinkedList<T> implements Iterable<T>
{
    /** Class constructor. */
    public SortedList()
    {
        //Calls base class constructor.
        super();
    }

    /** Inserts the passed object into the list via insertion sort with respect to area. */
    public void insertInOrder(T element)
    {
        //List is empty.
        if (size == 0)
        {
            prepend(element);
        }

        else
        {
            //Current pointer for iteration.
            Node<T> current = sentinel.getNext();

            //Loop across all nodes until an insertion point is found.
            while (true)
            {
                //Check if passed object comes before current.
                if (element.compareTo(current.getData()) <= 0)
                {
                    //Add the object before current and break out of loop.
                    current.getPrev().setNext(new Node<T>(element, current.getPrev(), current));
                    current.setPrev(current.getPrev().getNext());
                    break;
                }

                else
                {
                    //Check if current is the last object in the list.
                    if (current == sentinel.getPrev())
                    {
                        //Add the object to the end of the list and break out of loop.
                        append(element);
                        break;
                    }

                    else
                    {
                        //Move current forward.
                        current = current.getNext();
                    }
                }
            }
        }

        //Increment size.
        size++;

        //Increment mod count.
        modCount++;
    }
}
