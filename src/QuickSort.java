
import java.util.Comparator;

public class QuickSort {

    public static <E> void sort(CustomArrayList<E> arrayList, Comparator<E> comparator){

        if(arrayList == null || arrayList.size() == 0){
            return;
        }
        quickSort(arrayList,0,arrayList.size() - 1, comparator);
    }

    private static <E> void quickSort(CustomArrayList<E> arrayList, int low, int high,
                                      Comparator<? super E> comparator){
        if(low < high){
            int pivotIndex = partition(arrayList, low, high, comparator);
            quickSort(arrayList,low,pivotIndex - 1, comparator);
            quickSort(arrayList,pivotIndex + 1, high, comparator);
        }
    }

    private static <E> int partition(CustomArrayList<E> arrayList, int low, int high,
                                     Comparator<? super E> comparator){

        int middle = low + (high - low) / 2;
        E pivot = arrayList.get(middle);

        E temp = arrayList.get(middle);
        arrayList.set(middle,arrayList.get(high));
        arrayList.set(high,temp);

        int i = low - 1;
        for(int j = low; j < high; j++){
            if(comparator.compare(arrayList.get(j), pivot) < 0){
                i++;
                E pi = arrayList.get(i);
                arrayList.set(i,arrayList.get(j));
                arrayList.set(j,pi);
            }
        }
        E tempPivot = arrayList.get(i + 1);
        arrayList.set(i + 1,arrayList.get(high));
        arrayList.set(high,tempPivot);
        return i + 1;
    }

    public static <E extends Comparable<E>> void sort(CustomArrayList<E> arr) {

        if(arr == null || arr.size() == 0){
            return;
        }
        quickSort(arr, 0, arr.size() - 1);
    }

    private static <E extends Comparable<E>> void quickSort(CustomArrayList<E> arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static <E extends Comparable<E>> int partition(CustomArrayList<E> arrayList, int low, int high) {
        int middle = low + (high - low) / 2;
        E pivot = arrayList.get(middle);

        E temp = arrayList.get(middle);
        arrayList.set(middle,arrayList.get(high));
        arrayList.set(high,temp);

        int i = low - 1;
        for(int j = low; j < high; j++){
            if(arrayList.get(j).compareTo(pivot)< 0){

                i++;
                E pi = arrayList.get(i);
                arrayList.set(i,arrayList.get(j));
                arrayList.set(j,pi);
            }
        }
        E tempPivot = arrayList.get(i + 1);
        arrayList.set(i + 1,arrayList.get(high));
        arrayList.set(high,tempPivot);
        return i + 1;
    }

}