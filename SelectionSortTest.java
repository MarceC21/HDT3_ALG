import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {
    
    //Un array normal de enteros 
    @Test
    void testSortIntegers() {
        SelectionSort sorter = new SelectionSort();
        Integer[] array = {5, 2, 9, 1, 5, 6};
        Integer[] expected = {1, 2, 5, 5, 6, 9};
        
        sorter.sort(array);
        
        assertArrayEquals(expected, array);
    }
    
    //Un test para un array ordenado
    @Test
    void testSortAlreadySorted() {
        SelectionSort sorter = new SelectionSort();
        Integer[] array = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};
        
        sorter.sort(array);
        
        assertArrayEquals(expected, array);
    }
    
    //Un test para un array con duplicados
    @Test
    void testSortAllDuplicates() {
        SelectionSort sorter = new SelectionSort();
        Integer[] array = {3, 3, 3, 3, 3};
        Integer[] expected = {3, 3, 3, 3, 3};
        
        sorter.sort(array);
        
        assertArrayEquals(expected, array);
    }
}