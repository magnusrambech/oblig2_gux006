public class Main {
    public static void main(String[] args) {

        // Lager ny liste med et element "0".
        IList<Integer> myList = new LinkedList<Integer>(0);
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);

        System.out.println("______________Printer listen__________________");
        myList.printList();

        System.out.println("______________Test av prepend__________________");
        IList<Integer> prepList = new LinkedList<Integer>();
        prepList.add(7);
        prepList.add(8);
        prepList.add(9);
        prepList.add(10);


        myList.prepend(prepList);
        myList.printList();

        System.out.println("______________Test av append__________________");
        IList<Integer> appList = new LinkedList<Integer>();
        appList.add(7);
        appList.add(8);
        appList.add(9);
        appList.add(10);


        myList.append(appList);
        myList.printList();


        System.out.println("______________Test av concat__________________");
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
        conc4 = conc4.concat(conc1, conc2, conc3);

        conc4.printList();


        System.out.println("______________________SORTERING________________________________");

        IList<Integer> conc5 = new LinkedList<Integer>();
        conc5.add(2);
        conc5.add(3);
        conc5.add(1);
        conc5.add(5);
        conc5.add(4);
        conc5.add(8);
        conc5.add(10);
        conc5.add(7);
        conc5.add(6);
        conc5.add(9);
        System.out.println("___________FØR SORTERING_________");
        conc5.printList();
        System.out.println("___________ETTER SORTERING_________");
        conc5.sort(Integer::compare);
        conc5.printList();


    }
}
