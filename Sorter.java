// interfaz con Comparable<T>
public interface Sorter {
    <T extends Comparable<T>> void sort(T[] array);
}
