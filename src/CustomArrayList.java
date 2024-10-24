public interface CustomArrayList<E> extends Iterable<E> {
    boolean add(E e);
    boolean addTo(int index, E e);
    E get(int index);
    void delete(int index);
    void clear();
    int size();
    E set(int index, E element);
}
