package csit254proglabch04bstringlinkedbags21;

/**
 *
 * @author Tyler Elvis
 */
public class StringLinkedBag 
{

    private StringNode head;
    private StringNode tail;
    private int numElements;

    /**
     * The StringLinkedBag() constructor gets the inputs and sets them to the
     * private attributes
     */
    public StringLinkedBag() 
    {
        head = null;
        tail = null;
        numElements = 0;
    }

    /**
     * The getSize() method gets the size of the list
     *
     * @return numElements the size of the list
     */
    public int getSize() 
    {
        return numElements;
    }

    /**
     * the Add() method adds a new element to the linked List
     *
     * @param element the element that is going in
     */
    public void add(String element) 
    {
        if (tail == null) 
        {
            head = new StringNode(element, null);
            tail = head;
        } 
        else 
        {
            tail.setLink(new StringNode(element, null));
            tail = tail.getLink();
        }
        numElements++;
    }

    /**
     * the exists() method marches down the list to see if the targe String
     * exists
     *
     * @param target the string that is being looked for
     * @return found true or false if the target exists in the list
     */
    public boolean exists(String target) 
    {
        boolean found = false;
        StringNode cursor = head;

        while (cursor != null && !found) 
        {
            if (cursor.getData().equalsIgnoreCase(target)) 
            {
                found = true;
            } 
            else 
            {
                cursor = cursor.getLink();
            }

        }
        return found;
    }

    /**
     * The countOccurrences() method counts the amount of occurrences
     *
     * @param target String the is being looked for
     * @return numOccur, number of occurrences
     */
    public int countOccurrences(String target) 
    {
        int numOccur = 0;
        StringNode cursor = head;

        while (cursor != null)
        {

            if (cursor.getData().equalsIgnoreCase(target)) 
            {
                numOccur++;
            }
            cursor = cursor.getLink();
        }

        return numOccur;
    }

    /**
     * The remove() method removed an element from the linked List
     *
     * @param target, string that is being looked for
     * @return if the element is found to be removed
     */
    public boolean remove(String target) 
    {
        StringNode cursor = head, previous = null;
        boolean found = false;

        while (cursor != null && !found) 
        {
            if (cursor.getData().equalsIgnoreCase(target)) 
            {
                found = true;
            } 
            else 
            {
                previous = cursor;
                cursor = cursor.getLink();
            }
            if (found && cursor != null) 
            {
                if (previous == null) 
                {
                    head = head.getLink();
                } 
                else 
                {
                    previous.setLink(cursor.getLink());
                }
                if (tail == cursor) 
                {
                    tail = previous;
                }
                numElements--;
            }
        }

        return found;
    }

    /**
     * the iteratorPrototype method "copies" the linked list and passes the
     * copied linked list to a new ListerPrototype2
     *
     * @return a ListerPrototype2 using a copy of the linked list
     */
    public ListerPrototype2 iteratorPrototype() 
    {
        // declare variables
        StringNode headOfListToReturn; // beginning of new "copied" list
        StringNode cursorOfListToCopy; // active node of list to copy
        StringNode lastNodeOfListToReturn; // end of new "copied" list

        // establish the copied list
        headOfListToReturn = null;

        if (head != null) 
        {
            // create the head of the new list
            headOfListToReturn = new StringNode(head.getData(), null);
            // use lastNodeOfListToReturn as a pointer to the last node in the copied list
            lastNodeOfListToReturn = headOfListToReturn;
            // use currentCursor as the pointer to the existing list
            cursorOfListToCopy = head.getLink();
            // if we have a node...
            while (cursorOfListToCopy != null) 
            {
                // create a new node from the end of the new list
                lastNodeOfListToReturn.setLink(new StringNode(cursorOfListToCopy.getData(), null));
                // move lastNodeOfListToReturn to the new last node
                lastNodeOfListToReturn = lastNodeOfListToReturn.getLink();
                // move the cursorOfListToCopy to the next node
                cursorOfListToCopy = cursorOfListToCopy.getLink();
            }
        }

        return new ListerPrototype2(headOfListToReturn);
    }

}
