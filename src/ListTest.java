
import com.sun.xml.internal.ws.developer.UsesJAXBContext;
import org.junit.jupiter.api.Test;
import sun.awt.image.ImageWatched;
import java.time.Duration;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {



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
        IList test = list.rest();
        assertNull(test);
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
        assertEquals(list.size(),0);
        list.add(10);
        assertEquals(1, list.size());
        assertEquals(10,(int)list.first());
    }

    /**
     * Test av remove på tom liste.
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
        int j = 20;
        list.add(i);
        list.add(j);
        assertEquals(10,(int)list.first());
        assertEquals(2,list.size());

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
        assertEquals(null, restList);
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
        assertEquals(1,list.size());
        list.add(y);
        assertEquals(2,list.size());
        assertEquals(i,(int)list.first());

    }

    /**
     * Test av put() på liste med 1 objekt
     */
    @Test
    void oppg1_singleEntryPut(){
        IList<Integer> list = new LinkedList<Integer>();
        int i = 10;
        int y = 20;
        list.put(i);
        assertEquals(1,list.size());
        list.put(y);
        assertEquals(2, list.size());
        assertEquals(y, (int)list.first());
    }

    /**
     * Test av remove() på liste med 1 objekt
     */
    @Test
    void oppg1_singleEntryRemove(){
        IList<Integer> list = new LinkedList<Integer>();
        int i = 10;
        list.add(i);
        assertEquals(i, (int)list.remove());

    }

    /**
     * Test av first når listen inneholder flere enn 1 element
     */
    @Test
    void oppg1_multipleEntries_first(){
        IList<String> list = new LinkedList<String>();
        String a = "En";
        String b = "To";
        String c = "Tre";
        list.add(a);
        list.add(b);
        list.add(c);
        assertEquals(a, list.first());

    }
    /**
     * Test av rest på liste med flere objekt
     */
    @Test
    void oppg1_multipleEntriesRest(){
        IList<Integer> list = new LinkedList<Integer>();
        int i = 10;
        int j = 20;
        int k = 30;
        list.add(i);
        list.add(j);
        list.add(k);
        int x = list.first();

        IList<Integer> restList = list.rest();
        assertTrue(restList.contains(j));
        assertTrue(restList.contains(k));
        assertFalse(restList.contains(x));
    }

    /**
     * Test av add med flere elementer i listen.
     */
    @Test
    void oppg1_multipleEntries_add(){
        IList<String> list = new LinkedList<String>();
        assertEquals(0,list.size());
        String a = "En";
        String b = "To";
        String c = "Tre";
        list.add(a);
        list.put(b);
        list.add(c);
        assertEquals(list.first(),b);
        assertEquals(3,list.size());
    }

    /**
     * Test av put med flere elementer i listen
     */
    @Test
    void oppg1_multipleEntries_put(){
        IList<String> list = new LinkedList<String>();
        assertEquals(0,list.size());
        String a = "En";
        String b = "To";
        String c = "Tre";
        list.put(a);
        list.add(c);
        list.put(b);
        assertEquals(3,list.size());
        assertEquals(b, list.first());

    }

    /**
     * Test av remove med flere elementer i listen.
     */
    @Test
    void oppg1_multipleEntries_remove(){
        IList<String> list = new LinkedList<String>();
        String a = "En";
        String b = "To";
        String c = "Tre";
        list.add(a);
        list.add(b);
        list.add(c);
        assertEquals(3, list.size());
        list.remove();
        assertEquals(2, list.size());
        assertEquals(b, list.first());
    }


    /**
     * Tester remove(object) når objektet finnes i listen
     */
    @Test
    void oppg2_removeObject_exists(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        int i = 10;
        list.add(i);
        assertTrue(list.remove(i));
    }
    /**
     * Tester remove(object) når listen er tom.
     */
    @Test
    void oppg2_removeObject_empty(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        int i = 10;
        assertFalse(list.remove(i));
    }
    /**
     * Tester remove(object) når objektet ikke finnes.
     */
    @Test
    void oppg2_removeObject_notExists(){
        LinkedList<String> list = new LinkedList<String>();
        String x = "finnes";
        String y = "finnnes ikke";
        list.add(x);
        assertFalse(list.remove(y));
    }

    /**
     * Tester contains når listen er tom.
     */
    @Test
    void oppg3_containsTest_empty(){
        IList<String> list = new LinkedList<String>();
        assertFalse(list.contains("hei"));
    }

    /**
     * Tester contains når listen ikke inneholder elementet og listen ikker er tom.
     */
    @Test
    void oppg3_containsTest_notEmpty_notContains(){
        IList<String> list = new LinkedList<String>();
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");
        assertFalse(list.contains("Test4"));
    }

    /**
     * Tester contains når elementet finnes i listen.
     */
    @Test
    void oppg3_containsTest_notEmpty_contains(){
        IList<String> list = new LinkedList<String>();
        String x = "finnes";
        String y = "finnnes også!";
        String z = "finnes ikke..";
        list.add(y);
        list.add(x);
        assertTrue(list.contains(x));
        assertTrue(list.contains(y));

    }

    /**
     * Tester isEmpty når listen er tom.
     */
    @Test
    void oppg3_isEmpty_empty(){
        LinkedList<String> list = new LinkedList<String>();
        assertTrue(list.isEmpty());
    }

    /**
     * Tester isEmpty når listen ikke er tom.
     */
    @Test
    void oppg3_isEmpty_notEmpty(){
        LinkedList<String> list = new LinkedList<String>();
        assertTrue(list.isEmpty());
        list.add("test");
        assertFalse(list.isEmpty());
    }

    /**
     * Tester prepend når listene er tommme. Forveneter exceprion.
     */
    @Test
    void oppg4_prepend_empty(){
        IList<Integer> list = new LinkedList<Integer>();
        IList<Integer> prepList = new LinkedList<Integer>();

        list.prepend(prepList);
        assertThrows(NoSuchElementException.class, list::first);
    }

    /**
     * Tester prepend når listene ikke er tomme.
     */
    @Test
    void oppg4_prepend_notEmpty(){
        IList<Integer> list = new LinkedList<Integer>();
        IList<Integer> prepList = new LinkedList<Integer>();

        list.add(1);

        prepList.add(2);
        prepList.add(3);
        list.prepend(prepList);

        assertEquals(3, list.size());
        assertEquals(3, (int)list.first());

    }

    /**
     * Tester append når begge listene er tomme. Forventer exception i first().
     */
    @Test
    void oppg4_append_empty(){
        IList<Integer> list = new LinkedList<Integer>();
        IList<Integer> prepList = new LinkedList<Integer>();

        list.append(prepList);
        assertThrows(NoSuchElementException.class, list::first);
    }

    /**
     * Tester append når listen(e) ikke er tomme. list inneholder "0" fra konstruktøren, og preplist inneholder "6" og "7".
     */
    @Test
    void oppg4_append_notEmpty(){
        IList<Integer> list = new LinkedList<Integer>(5);
        IList<Integer> prepList = new LinkedList<Integer>();

        prepList.add(6);
        prepList.add(7);
        list.append(prepList);

        assertEquals(3, list.size());
        assertEquals(5, (int)list.first());
    }

    /**
     * Test av concat med 3 lister som alle har elementer i seg.
     */
    @Test
    void oppg5_concat_withEntriesInAll(){
        IList<String> conc1 = new LinkedList<String>();
        IList<String> conc2 = new LinkedList<String>();
        IList<String> conc3 = new LinkedList<String>();

        conc1.add("1");
        conc1.add("2");

        conc2.add("3");
        conc2.add("4");

        conc3.add("5");
        conc3.add("6");

        IList<String> conc4 = new LinkedList<String>();
        conc4 = conc4.concat(conc1,conc2,conc3);

        assertEquals(6, conc4.size());
        assertEquals("1",conc4.first());
    }

    /**
     * Test av concat når èn av listene er tomme
     */
    @Test
    void oppg5_concat_withEntriesInSome(){
        IList<String> conc1 = new LinkedList<String>();
        IList<String> conc2 = new LinkedList<String>();
        IList<String> conc3 = new LinkedList<String>();

        conc1.add("1");
        conc1.add("2");

        conc3.add("5");
        conc3.add("6");

        IList<String> conc4 = new LinkedList<String>();
        conc4 = conc4.concat(conc1,conc2,conc3);

        assertEquals(4, conc4.size());
        assertEquals("1",conc4.first());

    }

    /**
     * Test av concat når alle listene er tomme
     */
    @Test
    void oppg5_concat_withNoEntires(){
        IList<String> conc1 = new LinkedList<String>();
        IList<String> conc2 = new LinkedList<String>();
        IList<String> conc3 = new LinkedList<String>();
        IList<String> conc4 = new LinkedList<String>();
        conc4 = conc4.concat(conc1,conc2,conc3);

        assertEquals(0, conc4.size());
        assertThrows(NoSuchElementException.class, conc4::first);

    }

    /**
     * Test av iterator når listen er tom
     */
    @Test
    void oppg7_iterator_empty(){
        IList<String> myList = new LinkedList<String>();
        Iterator it = myList.iterator();

        assertFalse(it.hasNext());
    }

    /**
     * Test av iterator når listen ikke er tom
     */
    @Test
    void oppg7_iterator_notEmpty(){
        IList<String> myList = new LinkedList<String>();
        myList.add("1");
        myList.add("2");
        myList.add("3");

        Iterator it = myList.iterator();

        while(it.hasNext()){
            assertNotNull(it.next());
        }
    }


    /**
     * Sorterer boksatavene i listen til å være i alfabetisk rekkefølge.
     */
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
    /**
     * Tester sortering av integers i stigende rekkefølge.
     */
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
     * Filtrerer ut alle navn på 3 bokstaver
     */
    @Test
    void oppg9_filter_names() {
        // Se oppgave 9
        List<String> values = Arrays.asList("Thomas","Magnus","Ina","Kari","Ola","test3","Per");

        IList<String> list = new LinkedList<>();
        for (String value : values) {
            list.add(value);
        }

        list.filter(n -> n.length()==3);
        String n = list.remove();
        while(list.size() > 0) {
            if (n.length()==3) {
                fail("List contains filtered out elements.");
            }
            n = list.remove();

        }

    }
    /**
     * Filtrerer ut alle forekomster av "ugress" fra listen, også når "ugress" forekommer som en del av en streng.
     */
    @Test
    void oppg9_filter_Strings() {
        // Se oppgave 9
        List<String> values = Arrays.asList("test","ugress","test2","filter","ugress","test3","testugresstest");

        IList<String> list = new LinkedList<>();
        for (String value : values) {
            list.add(value);
        }

        list.filter(n -> n.contains("ugress"));

        String n = list.remove();
        while(list.size() > 0) {
            if (n.equals("ugress")) {
                fail("List contains filtered out elements.");
            }
            n = list.remove();

        }

    }

    /**
     * Filtrerer ut alle oddetall fra listen.
     */
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

    /**
     * Gjør om strengene i listen til tall
     */
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

    /**
     * Endrer alle strengene til upper case
     */
    @Test
    void oppg10_map_toUppercase() {
        List<String> values = Arrays.asList("magnus rambech", "thomas rognes", "tord kvifte", "kent hansen", "ola normann");

        IList<String> list = new LinkedList<>();
        for (String value : values) {
            list.add(value);
        }

        IList<String> result = list.map(String::toUpperCase);

        List<String> target = Arrays.asList("MAGNUS RAMBECH", "THOMAS ROGNES", "TORD KVIFTE", "KENT HANSEN", "OLA NORMANN");

        for (String t : target) {
            if (!result.remove().equals(t)) {
                fail("Result of map gives the wrong value.");
            }
        }
    }



    /**
     * Legger sammen alle tallene i listen.
     */
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

    /**
     * Slår sammen alle strengene og setter inn "t".
     */
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

    /**
     * Slår sammen alle strengene og setter inn "t", og sjekker at den gamle listen fortsatt har alle elementene etter reduce (sjekker feil bruk av remove).
     */
    @Test
    void oppg11_reduceStrings_andCheckSize() {
        List<String> values = Arrays.asList("e", "s", "t");
        IList<String> list = new LinkedList<>();
        for (String s : values) {
            list.add(s);
        }
        assertEquals(3, list.size());

        String result = list.reduce("t", (acc, s) -> acc + s);

        assertEquals(result, "test");
        assertEquals(3, list.size());
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
