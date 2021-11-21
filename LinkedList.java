package prj5;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Joshua Murphy (Jmmurphy), Connor Pepin (connorpepin), Kebron Zike
// (kebronZike)

// -------------------------------------------------------------------------
/**
 * Stores the data for the project
 * 
 * @author Joshua Murphy (jmmurphy)
 * @author Connor Pepin (connorpepin)
 * @author Kebron Zike (kebronZike)
 * @version 2021.11.15
 * 
 */
public class LinkedList<E> {

    private Node<E> head;
    private int size;

    /**
     * Constructor for the LinkedList Class
     */
    public LinkedList() {
        head = null;
        size = 0;

    }


    /**
     * Gets the size
     * 
     * @return
     *         the size of the LinkedList
     */
    public int size() {
        return size;
    }


    /**
     * Adds an element to the LinkedList
     * 
     * @param index
     *            the index where it is being added
     * @param obj
     *            the object being
     * @thows IndexOutOfBoundsException
     *        if the index is not in the Linked list
     * @thows IllegalArgumentException
     *        if the object is null
     */
    public void add(int index, E obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }
        if ((index < 0) || (index > size())) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Node<E> current = head;
        if (isEmpty()) {
            head = new Node<E>(obj);
        }
        else {
            if (index == 0) {
                Node<E> newNode = new Node<E>(obj);
                newNode.setNext(head);
                head = newNode;
            }
            else {
                int currentIndex = 0;
                while (current != null) {
                    if ((currentIndex + 1) == index) {
                        Node<E> nextNext = current.next;
                        Node<E> newNode = new Node<E>(obj);
                        current.setNext(newNode);
                        newNode.setNext(nextNext);
                    }
                    current = current.getNext();
                    currentIndex++;
                }
            }
        }
        size++;
    }


    /**
     * Adds object to the end of the list
     * 
     * @param obj
     *            the object being added
     * @thows IllegalArgumentException
     *        when the object is null
     */
    public void add(E obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }
        Node<E> current = head;
        if (isEmpty()) {
            head = new Node<E>(obj);
        }
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.setNext(new Node<E>(obj));
        }
        size++;
    }


    /**
     * Sees if the LinkedList is empty
     * 
     * @return
     *         if the LinkedList is empty
     */
    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * Removes the object from the front of the list
     * 
     * @param obj
     *            the object being removed
     * @return
     *         if the object is removed
     */
    public boolean remove(E obj) {
        Node<E> current = head;

        if ((null != head) && (obj.equals(current.data))) {
            head = head.next;
            size--;
            return true;
        }
        while (size() >= 2 && (current.next != null)) {
            if ((obj.equals(current.next.data))) {
                if (current.next.next != null) {
                    current.setNext(current.next.next);
                }
                else {
                    current.setNext(null);
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }


    /**
     * removes the object at a particular index
     * 
     * @param index
     *            where the object is being removed
     * @return
     *         if the object was removed
     * @thows IndexOutOfBoundsException
     *        if the index is not in the array
     */
    public boolean remove(int index) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        if (index == 0) {
            head = head.next;
            size--;
            return true;
        }
        else {
            Node<E> current = head;
            int currentIndex = 0;
            while (current.next != null) {
                if ((currentIndex + 1) == index) {
                    Node<E> newNext = current.next.next;
                    current.setNext(newNext);
                    size--;
                    return true;
                }
                current = current.next;
                currentIndex++;
            }
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }


    /**
     * gets the data of the node at a particular index
     * 
     * @param index
     *            the index where the data is located
     * @return
     *         the data of the node
     * @throws IndexOutOfBoundsException
     *             if the index exceeds the size
     * 
     */
    public E get(int index) {
        Node<E> current = head;
        int currentIndex = 0;
        E data = null;
        while (current != null) {
            if (currentIndex == index) {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }
        if (data == null) {
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
    }


    /**
     * Gets the node at a certain index
     * 
     * @param index
     *            the index where the node is
     * @return
     *         the node at a given index
     */
    public Node<E> getNode(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }


    /**
     * Sees if the linked list contains a certain node
     * 
     * @param obj
     *            the object being searched for
     * @return
     *         if the object was found
     */
    public boolean contains(E obj) {
        Node<E> current = head;
        while (current != null) {
            if (obj.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    /**
     * Clears the LinkedList
     */
    public void clear() {
        if (head != null) {
            head.setNext(null);
            head = null;
        }
        size = 0;
    }


    /**
     * Gets the lastIndex of a certain object in the the LinkedList
     * 
     * @param obj
     *            the object being looked for
     * @return
     *         the index of the object
     */
    public int lastIndexOf(E obj) {
        int lastIndex = -1;
        Node<E> current = head;
        int currentIndex = 0;
        while (current != null) {
            if (obj.equals(current.data)) {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;
        }
        return lastIndex;
    }


    /**
     * @param typeOfComparator
     *            the type of comparator used for the sorting
     */
    public void sortList(Comparator<E> typeOfComparator) {
        for (int i = 0; i < this.size() - 1; i++) {
            int tempDex = i;
            for (int j = i+1; j < this.size(); j++) {
                if (typeOfComparator.compare(get(tempDex), get(j)) > 0) {
                    tempDex = j;
                }
            }
            switchNode(i, tempDex);
        }
        
    }


    /**
     * A helper method that switch nodes in the linked list
     * 
     * @param firstIndex
     *            the first index of the node
     * @param nextIndex
     *            the index of the node being compared
     */
    private void switchNode(int firstIndex, int nextIndex) {
        Node<E> node1 = this.getNode(firstIndex);
        Node<E> node2 = this.getNode(nextIndex);

        E temp = node2.getData();
        node2.setData(node1.getData());
        node1.setData(temp);
    }


    /**
     * Turns the LinkedList into a string
     * 
     * @return
     *         a string representaion of the LinkedList
     */
    @Override
    public String toString() {
        String result = "{";

        Node<E> current = head;
        while (current != null) {
            result += "" + current.data;
            current = current.next;
            if (current != null) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }


    /**
     * Turns the LinkedList into an array
     * 
     * @return
     *         an array of the objects found in the linked list
     */
    public Object[] toArray() {
        Object[] array = new Object[this.size()];
        Node<E> current = head;
        int count = 0;
        while (current != null) {
            array[count] = current.getData();
            current = current.next;
            count++;
        }
        return array;
    }


    /**
     * Checks to see if the linked lists are equal
     * 
     * @return
     *         if the objects are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            LinkedList<E> other = ((LinkedList<E>)obj);
            if (other.size() == this.size()) {
                Node<E> current = head;
                Node<E> otherCurrent = other.head;
                while (current != null) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.getNext();
                    otherCurrent = otherCurrent.getNext();
                }
                return true;
            }
        }
        return false;
    }

    // ----------PRIVATE NODE CLASS------------------

    /**
     * Private node class for the linked list
     *
     * @param <E>
     */
    @SuppressWarnings("hiding")
    class Node<E> {
        private E data;
        private Node<E> next;

        /**
         * Constructor for the node class
         * 
         * @param d
         *            the data of the node
         */
        public Node(E d) {
            data = d;
        }


        /**
         * Sets up the next node
         * 
         * @param n
         *            the node being set
         */
        public void setNext(Node<E> n) {
            next = n;
        }


        /**
         * Gets the next node
         * 
         * @return
         *         the next node
         */
        public Node<E> getNext() {
            return next;
        }


        /**
         * Gets the data of the node
         * 
         * @return
         *         the data of the node
         */
        public E getData() {
            return data;
        }


        /**
         * Sets the data to a nod
         * 
         * @param d
         *            the data being set
         */
        public void setData(E d) {
            data = d;
        }

    }

    /**
     * Iterator method creates Iterator object
     *
     * @return new Iterator object
     */
    public Iterator<E> iterator() {
        return new LinkedListIterator<E>();
    }

    // -------PRIVATE ITERATOR CLASS-----------------

    /**
     * Iterator for the linked list
     * 
     * 
     * @author connorpepin
     *
     * @param <A>
     */
    private class LinkedListIterator<A> implements Iterator<E> {

        private Node<E> prev;
        private Node<E> curr;
        private Node<E> next;

        private boolean calledNext;

        /**
         * Constructor for a new LinkedListIterator
         */
        public LinkedListIterator() {

            prev = null;
            curr = null;
            next = head;
            calledNext = false;

        }


        /**
         * Checks if there are any more
         * elements in the list
         * 
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {

            return (next != null);

        }


        /**
         * Gets the next value in the list
         * 
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         * 
         */
        @Override
        public E next() {

            if (!hasNext()) {
                throw new NoSuchElementException("No nodes left in the list.");
            }

            prev = curr;
            curr = next;
            next = next.getNext();
            if (curr == null) {
                throw new NoSuchElementException("No nodes left in the list.");
            }
            calledNext = true;
            return curr.data;
        }


        /**
         * Removes the last object returned with next() from the list
         *
         * @throws IllegalStateException
         *             if next has not been called yet
         *             and if the element has already been removed
         */
        @Override
        public void remove() {

            if (next == head) {
                throw new IllegalStateException(
                    "Next has not been called yet.");
            }
            else if (!calledNext) {
                throw new IllegalStateException(
                    "The Element has already been removed.");
            }
            else if (curr == head) {
                head = next;
                curr = null;
            }
            else {
                prev.setNext(curr.getNext());
                curr = prev;
                // this code that updates prev is not necessary
                // because next() must be called before another remove()
                // and that will update prev, saving this O(n) operation
                // prev = firstNode;
                // while ((prev != null) && (prev.getNext() != curr)){
                // prev = prev.getNext();
                // }
            }
            size--;
            calledNext = false;
        }
    }
}
