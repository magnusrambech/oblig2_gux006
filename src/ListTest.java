
import com.sun.xml.internal.ws.developer.UsesJAXBContext;
import org.junit.jupiter.api.Test;
import sun.awt.image.ImageWatched;

import java.time.Duration;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {
    @Test
    void oppg8_sortIntegers() {
        // Se oppgave 8
        LinkedList<Integer> list = new LinkedList<Integer>();
        List<Integer> values = Arrays.asList(3, 8, 4, 7, 10, 6, 1, 2, 9, 5);

        for (Integer value : values) {
            list.add(value);
        }
        list.sort(Comparator.comparingInt(x -> x));


        int n = list.remove();
        while (list.size() > 0) {
            int m = list.remove();
            if (n > m) {
                fail("Integer liist is not sorted.");
            }
            n = m;
        }

    }

    /**
     * Test av First() på tom liste.
     */
    @Test
    void oppg1_emptyFirst(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        assertThrows(NoSuchElementException.class, list::first);
    }

    /**
     * Test av rest() på tom liste.
     */
    @Test
    void oppg1_emptyRest(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        assertThrows(NoSuchElementException.class, list::rest);
    }

    /**
     * Test av add() på tom liste.
     */
    @Test
    void oppg1_emptyAdd(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        assertEquals(list.size,0);
        list.add(10);
        assertEquals(1, list.size);
    }

    /**
     * Test av put() på tom liste.
     */
    @Test
    void oppg1_emptyPut(){
        IList<Integer> list = new LinkedList<Integer>();
        assertEquals(list.getSize(),0);
        list.add(10);
        assertEquals(1, list.getSize());
    }

    /**
     * Test av remove på tom jsliste.
     */
    @Test
    void oppg1_emptyRemove(){
        IList<Integer> list = new LinkedList<Integer>();
        assertThrows(NoSuchElementException.class, list::remove);
    }

    /**
     * Test av first() på liste med 1 objekt
     */
    @Test
    void oppg1_singleEntryFirst(){
        IList<Integer> list = new LinkedList<Integer>();
        int i = 10;
        list.add(i);
        assertNotNull(list.first());
    }

    /**
     * Test av rest() på liste med 1 objekt
     */
    @Test
    void oppg1_singleEntryRest(){
        IList<Integer> list = new LinkedList<Integer>();
        int i = 10;
        list.add(i);

        IList<Integer> restList = list.rest();
        assertEquals(null, restList.first());
    }

    /**
     * Test av add() på liste med 1 objekt
     */
    @Test
    void oppg1_singleEntryAdd(){
       IList<Integer> list = new LinkedList<Integer>();
        int i = 10;
        int y = 20;
        list.add(i);
        assertEquals(1,list.getSize());
        list.add(y);
        assertEquals(2,list.getSize());

    }

    /**
     * Test av put() på liste med 1 objekt
     */
    @Test
    void oppg1_singleEntryPut(){
        IList<Integer> list = new LinkedList<Integer>();
        int i = 10;
        int y = 20;
        list.add(i);
        assertEquals(list.size(),1);
        list.add(y);
        assertEquals(list.size(), 2);
    }

    /**
     * Test av remove() på liste med 1 objekt
     */
    @Test
    void oppg1_singleEntryRemove(){
        IList<Integer> list = new LinkedList<Integer>();
        int i = 10;
        list.add(i);
        assertNotNull(list.remove());

    }
    @Test
    void oppg1_multipleEntries_first(){
        IList<String> list = new LinkedList<String>();
        String a = "En";
        String b = "To";
        String c = "Tre";
        list.add(a);
        list.add(b);
        list.add(c);
        assertEquals(c, list.first());

    }
    @Test
    void oppg1_multipleEntries_rest(){
        IList<String> list = new LinkedList<String>();
        String a = "En";
        String b = "To";
        String c = "Tre";
        list.add(a);
        list.add(b);
        list.add(c);
        IList<String> restList = list.rest();
        assertTrue(restList.contains(a));
        assertTrue(restList.contains(b));
        assertFalse(restList.contains(c));
    }

    /**
     * Tester add-metoden ved flere gjentagelser.
     */
    @Test
    void oppg1_multipleEntries_add(){
        IList<String> list = new LinkedList<String>();
        assertEquals(0,list.getSize());
        String a = "En";
        String b = "To";
        String c = "Tre";
        list.add(a);
        list.put(b);
        list.add(c);
        assertEquals(list.first(),b);
        assertEquals(3,list.getSize());


    }
    @Test
    void oppg1_multipleEntries_put(){
        IList<String> list = new LinkedList<String>();
        assertEquals(0,list.getSize());
        String a = "En";
        String b = "To";
        String c = "Tre";
        list.put(a);
        list.put(b);
        list.add(c);
        assertEquals(3,list.getSize());
        assertEquals(b, list.first());

    }
    @Test
    void oppg1_multipleEntries_remove(){
        IList<String> list = new LinkedList<String>();
        String a = "En";
        String b = "To";
        String c = "Tre";
        list.add(a);
        list.add(b);
        list.add(c);
        assertEquals(3, list.getSize());
        list.remove();
        assertEquals(2, list.getSize());
    }





    @Test
    void oppg2_removeObject_exists(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        int i = 10;
        list.add(i);
        assertTrue(list.remove(i));
    }
    @Test
    void oppg2_removeObject_empty(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        int i = 10;
        assertFalse(list.remove(i));
    }
    @Test
    void oppg2_removeObject_notExists(){
        LinkedList<String> list = new LinkedList<String>();
        String x = "finnes";
        String y = "finnnes ikke";
        list.add(x);
        assertFalse(list.remove(y));
    }

    @Test
    void oppg3_containsTest(){
        LinkedList<String> list = new LinkedList<String>();
        String x = "finnes";
        String y = "finnnes også!";
        String z = "finnes ikke..";
        list.add(y);
        list.add(y);
        list.add(x);
        System.out.println("Head er: " + list.first());
        assertTrue(list.contains(x));
        assertFalse(list.contains(z));
    }



    @Test
    void oppg8_sortStrings() {
        // Se oppgave 8
        IList<String> list = new LinkedList<>();
        List<String> values = Arrays.asList(
                "g", "f", "a", "c", "b", "d", "e", "i", "j", "h"
        );
        for (String value : values) {
            list.add(value);
        }


        list.sort(Comparator.naturalOrder());

        String n = list.remove();
        while (list.size() > 0) {
            String m = list.remove();
            if (n.compareTo(m) > 0) {
                fail("String list is not sorted.");
            }

        }
    }

    @Test
    void oppg9_filter() {
        // Se oppgave 9
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        IList<Integer> list = new LinkedList<>();
        for (Integer value : values) {
            list.add(value);
        }

        list.filter(n -> n % 2 == 1);

        int n = list.remove();
        while(list.size() > 0) {
            if (n % 2 == 1) {
                fail("List contains filtered out elements.");
            }
            n = list.remove();

        }

    }

    @Test
    void oppg10_map() {
        // Se oppgave 10
        List<String> values = Arrays.asList("1", "2", "3", "4", "5");

        IList<String> list = new LinkedList<>();
        for (String value : values) {
            list.add(value);
        }

        IList<Integer> result = list.map(Integer::parseInt);

        List<Integer> target = Arrays.asList(1, 2, 3, 4, 5);


        for (int t : target) {
            if (result.remove() != t) {
                fail("Result of map gives the wrong value.");
            }
        }
    }

    @Test
    void oppg11_reduceInts() {
        // Se oppgave 11
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);

        IList<Integer> list = new LinkedList<>();
        for (Integer value : values) {
            list.add(value);
        }

        int result = list.reduce(0, Integer::sum);

        assertEquals(result, 5*((1 + 5)/2));
    }

    @Test
    void oppg11_reduceStrings() {
        List<String> values = Arrays.asList("e", "s", "t");
        IList<String> list = new LinkedList<>();
        for (String s : values) {
            list.add(s);
        }

        String result = list.reduce("t", (acc, s) -> acc + s);

        assertEquals(result, "test");
    }

    @Test
    void ex1_FastSort() {
        // Se ekstraoppgave 1
        Random r = new Random();
        IList<Integer> list = new LinkedList<>();
        for (int n = 0; n < 1000000; n++) {
            list.add(r.nextInt());
        }

        assertTimeout(Duration.ofSeconds(2), () -> list.sort(Integer::compare));

        int n = list.remove();
        for(int m = list.remove(); !list.isEmpty(); n = m) {
            if (n > m) {
                fail("List is not sorted");
            }
        }


    }
}
