public interface AbstractQueue <E> extends Iterable<E>{
    void offer(E element);
    E poll();
    int size();
    E peek();
    boolean isEmpty();
}
