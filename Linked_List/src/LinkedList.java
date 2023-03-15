import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * LinkedList Abstract Data Type.
 * @author Alivn Le
 * @version 1.0
 * @param <E> type of elements the linked list contains
 */
public class LinkedList<E> implements List<E> {
    private int size;
    private Node<E> head;
    /**
     * no args constructor.
     */
    public LinkedList() {
        this.size = 0;
        this.head = null;

        LinkedList<E> list = new LinkedList<>();
    }
    /**
     * @param array Array of generic type E
     */
    public LinkedList(E[] array) {
        this.size = array.length;

        for (int i = 0; i < array.length; i = i + 1) {
            add(array[i]);
        }
    }
    /**
     * Inserts the element at the front of the list.
     * @param element data we are adding to the list
     * @throws IllegalArgumentException if the passed in element is null
     */
    @Override
    public void add(E element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException();
        } else {
            Node<E> firstNode = new Node<>();
            firstNode.setData(element);
            firstNode.setNext(head);
        }
    }
    /**
     * Inserts the element at the specified index.
     * @param index index to add the element
     * @param element data we are adding to the list
     * @throws IllegalArgumentException if the passed in element is null
     * @throws IndexOutOfBoundsException if the passed in index is invalid. index == list.size() is valid
     */
    @Override
    public void add(int index, E element) throws IllegalArgumentException, IndexOutOfBoundsException {
        if (element == null) {
            throw new IllegalArgumentException();
        } else if (index > getSize() || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> addedNode = new Node<>();
            addedNode.setData(element);
            Node<E> temp = getHead();

            if (index == 0) {
                add(element);
            } else {
                for (int i = 0; i < index; i = i + 1) {
                    if (i == index - 1) {
                        addedNode.setNext(temp.getNext());
                        temp.setNext(addedNode);
                    }
                    temp = temp.getNext();
                }
            }
        }
    }
    /**
     * Removes the element at the specified index and returns it.
     * @param index index of element to be removed
     * @return the removed element at the specified index
     * @throws IndexOutOfBoundsException if the passed in index is invalid
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= getSize()) {
            throw  new IndexOutOfBoundsException();
        } else {
            Node<E> temp = getHead();
            Node<E> returnedNode = temp;

            for (int i = 0; i < index; i = i + 1) {
                if (i == index) {
                    temp.setData(temp.getNext().getData());
                    returnedNode.setData(returnedNode.getNext().getData());
                    temp.setNext(temp.getNext().getNext().getNext());
                }
                if (temp.getNext() != null) {
                    temp = temp.getNext();
                }
            }
            return returnedNode.getData();
        }
    }
    /**
     * Removes the specified element from the list and returns it.
     * @param element data to be removed
     * @return the removed element from the list
     * @throws IllegalArgumentException if the passed in element is null
     * @throws NoSuchElementException if the passed in element is not in the list
     */
    @Override
    public E remove(E element) throws IllegalArgumentException, NoSuchElementException {
        if (element == null) {
            throw new IllegalArgumentException();
        } else {
            if (contains(element)) {
                if (this.head.getData().equals(element)) {
                    return remove();
                }
                Node<E> temp = getHead();
                while (!element.equals(temp.getData()) && temp.getNext() != null) {
                    if (element.equals(temp.getNext().getData())) {
                        temp.setNext(temp.getNext().getNext());
                    }
                    temp = temp.getNext();
                }
            } else {
                throw new NoSuchElementException();
            }
        }
        return null;
    }
    /**
     * Removes the head (first element) from the list and returns it.
     * @return the removed element from the head of the list, null if the list is empty
     */
    @Override
    public E remove() {
        if (getHead() == null) {
            return null;
        } else {
            Node<E> temp = getHead();
            getHead().setData(getHead().getNext().getData());
            getHead().setNext(temp.getNext().getNext());
            return temp.getData();
        }
    }

    /**
     * Returns the element at the specified index.
     * @param index index of the element to return
     * @return element at the specified index
     * @throws IndexOutOfBoundsException if the passed in index is invalid
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException();
        } else {
            int i = 0;
            Node<E> temp = getHead();
            while (i != index) {
                temp = temp.getNext();
                i = i + 1;
            }
            return temp.getData();
        }
    }

    /**
     * Checks if a list contains a specific element.
     * @param element data to check for in list
     * @return boolean representing if the list has the element or not
     * @throws IllegalArgumentException if the passed in element is null.
     */
    @Override
    public boolean contains(E element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException();
        } else {
            boolean found = false;
            Node<E> temp = getHead();
            while (!element.equals(temp.getData()) && temp.getNext() != null) {
                if (element.equals(temp.getData())) {
                    found = true;
                }
                temp = temp.getNext();
            }
            return found;
        }
    }
    /**
     * Replaces the element at a specific index with the passed in data.
     * @param index index of the element to replace
     * @param element the element to set
     * @return element that has been replaced
     * @throws IllegalArgumentException if the passed in element is null. Make this check first.
     * @throws IndexOutOfBoundsException if the passed in index is invalid
     */
    @Override
    public E set(int index, E element) throws IllegalArgumentException, IndexOutOfBoundsException {
        if (element == null) {
            throw new IllegalArgumentException();
        } else {
            E removedData = null;
            if (index < 0 || index >= getSize()) {
                throw new IndexOutOfBoundsException();
            } else {
                removedData = remove(index);
                add(index, element);
            }
            return removedData;
        }
    }
    /**
     * Clears the list.
     */
    @Override
    public void clear() {
        this.head = null;
    }

    /**
     * Checks if the list is empty.
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        int booleanSize = getSize();
        return booleanSize == 0;
    }
    /**
     * Returns the number of elements in the list.
     * @return int representing size of list
     */
    @Override
    public int size() {
        return getSize();
    }
    /**
     * @return LinkedListIterator object
     */
    @Override
    public Iterator<E> iterator() {
        LinkedListIterator<E> iteratorUtil = new LinkedListIterator<E>(this.head);
        return iteratorUtil;
    }
    /**
     * removes all the duplicates in linked list.
     */
    public void removeDuplicates() {
        LinkedListIterator<E> iteratorUtil = new LinkedListIterator<>(getHead());
        Node<E> temp = getHead();
        Node<E> temp2 = getHead();
        E data = temp.getData();

        while (iteratorUtil.hasNext()) {
            temp = temp2;
            for (int i = 0; i < getSize(); i = i + 1) {
                if (data.equals(temp.getNext().getData())) {
                    remove(data);
                    temp = temp.getNext();
                } else {
                    temp = temp.getNext();
                }
            }
            temp2 = temp2.getNext();
            data = temp2.getData();
        }
    }
    /**
     * @return Array of generic type E
     */
    public E[] toArray() {
        E[] arr = (E[]) new Object[getSize()];
        LinkedListIterator<E> iteratorUtil = new LinkedListIterator<>(getHead());
        int i = 0;

        while (iteratorUtil.hasNext()) {
            arr[i] = iteratorUtil.next();
            i = i + 1;
        }

        return arr;
    }
    /**
     * @param size int
     * sets size.
     */
    public void setSize(int size) {
        this.size = size;
    }
    /**
     * @param head Node object of generic type E
     * sets head;
     */
    public void setHead(Node<E> head) {
        this.head = head;
    }
    /**
     * @return int
     */
    public int getSize() {
        return this.size;
    }
    /**
     * @return Node object of generic type E
     */
    public Node<E> getHead() {
        return this.head;
    }
}
