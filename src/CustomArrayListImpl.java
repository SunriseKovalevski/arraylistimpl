import java.util.Arrays;
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
        strings.addTo(1, "Car");
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
            System.arraycopy(temp, 0, values, 0, index);
            values[index] = e;
            System.arraycopy(temp, index + 1, values, index, temp.length - index - 1);
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
        Arrays.fill(values, null);
    }

    public void quickSort(E[] sortArr, int low, int high){
        if (sortArr.length == 0 || low >= high) return;
        int middle = low + (high - low) / 2;
        E border = sortArr[middle];
        int i = low;
        int j = high;
        while (i <= j) {
            while (sortArr[i] < border) i++;
            while (sortArr[j] > border) j--;
            if (i <= j) {
                int swap = sortArr[i];
                sortArr[i] = sortArr[j];
                sortArr[j] = swap;
                i++;
                j--;
            }
        }

        if (low < j) quickSort(sortArr, low, j);
        if (high > i) quickSort(sortArr, i, high);
    }

    @Override
    public void sort() {
        
    }

}
