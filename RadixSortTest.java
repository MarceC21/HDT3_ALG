import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadixSortTest {
    
    //Un array normal de enteros 
    @Test
    void testSortIntegers() {
        RadixSort sorter = new RadixSort();
        Integer[] array = {5, 2, 9, 1, 5, 6};
        Integer[] expected = {1, 2, 5, 5, 6, 9};
        
        sorter.sort(array);
        
        assertArrayEquals(expected, array);
    }
    
    //Un test para un array ordenado
    @Test
    void testSortAlreadySorted() {
        RadixSort sorter = new RadixSort();
        Integer[] array = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};
        
        sorter.sort(array);
        
        assertArrayEquals(expected, array);
    }
    
    //Un test para un array con duplicados
    @Test
    void testSortAllDuplicates() {
        RadixSort sorter = new RadixSort();
        Integer[] array = {3, 3, 3, 3, 3};
        Integer[] expected = {3, 3, 3, 3, 3};
        
        sorter.sort(array);
        
        assertArrayEquals(expected, array);
    }
}