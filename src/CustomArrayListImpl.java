import java.util.Iterator;
public class CustomArrayListImpl<E> implements CustomArrayList<E>{

    public static void main(String[] args) {
        CustomArrayList<String> strings = new CustomArrayListImpl<>();
        strings.add("House");
        strings.add("Car");
        strings.add("Garage");
        System.out.println(strings.get(1));
    }
    
    private E[] values;

    public CustomArrayListImpl() {
        values = (E[]) new Object[0];
    }
    
    @Override
    public boolean add(E e){
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
        
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public boolean addTo(int index, E e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTo'");
    }

    @Override
    public E get(int index) {
       return values[index];
    }

    @Override
    public void delete(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public void sort() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sort'");
    }

}
