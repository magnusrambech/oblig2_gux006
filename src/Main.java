public class Main {
    public static void main(String[] args) {
        IList<Integer> myList = new LinkedList<Integer>(0);
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);

        System.out.println("______________Printer listen__________________");
        myList.printList();

        myList.remove();
        System.out.println("______________Fjerner første element__________________");
        myList.printList();
        myList.put(1995);
        System.out.println("______________Putter inn '1995' fremst i listen__________________");
        myList.printList();

    }
}
