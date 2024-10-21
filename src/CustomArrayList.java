public interface CustomArrayList<E> {
    boolean add(E e);
    boolean addTo(int index, E e);
    E get(int index);
    void delete(int index);
    void clear();
    void sort();

}
