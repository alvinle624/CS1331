/**
 * @author Alivn Le
 * @version 1.0
 * @param <E> type of elements the node is
 */
public class Node<E> {
    private E data;
    private Node<E> next;
    /**
     * @param data generic type E
     * sets data;
     */
    public void setData(E data) {
        this.data = data;
    }
    /**
     * @param next Node object of type E
     * sets next;
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }
    /**
     * @return generic type E
     */
    public E getData() {
        return this.data;
    }
    /**
     * @return Node object of type E
     */
    public Node<E> getNext() {
        return this.next;
    }
}
