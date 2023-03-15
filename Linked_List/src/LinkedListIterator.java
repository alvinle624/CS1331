import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author Alivn Le
 * @version 1.0
 * @param <E> type of elements the linked list iterator contains
 */
public class LinkedListIterator<E> implements Iterator<E> {
    private Node<E> next;
    /**
     * @param head Node object of type E
     */
    public LinkedListIterator(Node<E> head) {
        next = head;
    }
    /**
     * @return boolean
     * checks if linked list has a next element.
     */
    public boolean hasNext() {
        return (getNext() != null);
    }
    /**
     * @return the next element from the linked list
     * @throws NoSuchElementException if the passed in element is not in the list
     */
    public E next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            E data = this.next.getData();
            this.next = this.next.getNext();
            return data;
        }
    }
    /**
     * @param next Node object of type E
     * sets next.
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }
    /**
     * @return Node object of type E
     */
    public Node<E> getNext() {
        return this.next;
    }
}
