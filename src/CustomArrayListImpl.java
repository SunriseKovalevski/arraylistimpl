import java.util.Iterator;
public class CustomArrayListImpl<E> implements CustomArrayList<E>{
    
    private E[] values;

    public static void main(String[] args) {
        CustomArrayList<String> strings = new CustomArrayListImpl<>();
        strings.add("House");
        strings.add("Car");
        strings.add("Garage");
        System.out.println(strings.get(1));
        strings.delete(1);
        System.out.println(strings.get(1));
    }

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
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, index - 1);
            values[index] = e;
            System.arraycopy(temp, index + 1, values, index + 1, temp.length + 1 - index);
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public E get(int index) {
       return values[index];
    }

    @Override
    public void delete(int index) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            int amount = temp.length - index - 1;
            System.arraycopy(temp, index + 1, values, index, amount);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
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
