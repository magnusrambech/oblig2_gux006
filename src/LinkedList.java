import sun.awt.image.ImageWatched;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class LinkedList<E> implements IList<E>{
        Node head;
        int size;




        public LinkedList(){
            this.size = 0;
            this.head = null;
        }
        public LinkedList(E elem){
            Node newNode = new Node(elem);
            head = newNode;
            size++;
        }

    /**
     * Legger alle elementene fra en liste inn i en linked list.
     * @param elem
     * @param list
     */
    public LinkedList(E elem, List list) {
            if (list != null) {
                Iterator listIterator = list.iterator();
                while(listIterator.hasNext()){
                    Node newNode = new Node((E)listIterator.next());
                    if(head==null){
                       this.head = newNode;
                    }
                    else{
                        newNode.next = head;
                        this.head = newNode;
                    }

                }
            }
            this.put(elem);
        }

        public int getSize(){
        return size;
        }
    /**
     * ,* Gir det første elementet i listen.
     * ,*
     * ,* @return Det første elementet i listen.
     * ,* @throws NoSuchElementException Hvis listen er tom.
     * ,
     */
    @Override
    public E first() throws NoSuchElementException {
        return head.getData();
    }

    /**
     * ,* Returnerer alle elementene i listen bortsett fra det
     * ,* første.
     * ,*
     * ,* @return Resten av listen.
     * ,
     */
    @Override
    public IList<E> rest() {
        IList<E> returnList = new LinkedList<E>();
        if(size<2){
            System.out.println("Skal funke..");
            returnList= null;
        }
        else {

            Node curr = head.getNext();
            while(curr.getData()!=null){
                returnList.add(curr.getData());
                if(curr.hasNext()){
                    curr = curr.getNext();
                }
                else {
                    break;
                }
            }
        }
        return returnList;



    }

    /**
     * ,* Legger til et element på slutten av listen.
     * ,
     *
     * @param elem
     */
    @Override
    public boolean add(E elem) {
        Node current = head;
        Node newNode = new Node(elem);

        if (isEmpty()) {
            head = newNode;
            size++;
            return true;
        } else {
            while (current.getNext() != null) {
                current = current.getNext();
            }
        }
        current.setNext(newNode);
        size++;
        return true;

    }

    /**
     * ,* Legger til et element på begynnelsen av listen.
     * ,
     *
     * @param elem
     */
    @Override
    public boolean put(E elem) {
        Node newNode = new Node(elem);
        if(isEmpty()){
            this.head = newNode;
        }
        else{
            newNode.next = this.head;
            this.head = newNode;
        }
        size++;
        return true;
    }

    /**
     * ,* Fjerner det første elementet i listen.
     * ,*
     * ,* @return Det første elementet i listen.
     * ,* @throws NoSuchElementException Hvis listen er tom.
     * ,
     */
    @Override
    public E remove() throws NoSuchElementException {
        if(head.hasNext()){
            Node nodeToRemove = head;
            head = head.getNext();
            size--;
            return nodeToRemove.getData();
        }
        else if(isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            Node nodeToRemove = head;
            head = null;
            size--;
            return  nodeToRemove.getData();
        }
    }

    /**
     * ,* Fjerner det angitte objektet fra listen.
     * ,*
     * ,* @param o Objektet som skal fjernes.
     * ,* @return true hvis et element ble fjernet, false
     * ,* ellers.
     * ,
     *
     * @param o
     */
    @Override
    public boolean remove(Object o) {
        if(this.contains(o)){
            if(head.getData() == o){
                this.head = this.head.getNext();
                size--;
                return true;
            }
            else{
                Node current = this.head;
                Node prev = null;
                while(current!= null){
                    if(current.getData()==o){
                        if(current.hasNext()){
                            prev.setNext(current.getNext());
                        }
                        else{
                            prev.setNext(null);
                        }
                        current=null;
                        size--;
                        return true;
                    }
                    else{
                        prev = current;
                        current = current.getNext();
                    }
                }
            }
        }
        return false;

    }

    /**
     * ,* Sjekker om et element er i listen.
     * ,*
     * ,* @param o objektet vi sjekker om er i listen.
     * ,* @return true hvis objektet er i listen, false ellers.
     * ,
     *
     * @param o
     */
    @Override
    public boolean contains(Object o) {
        if(isEmpty()){
            return false;
        }
        else {
            Node curr = head;
            while(curr!=null){
                if(curr.getData() == o){
                    return true;
                }
                else{
                    if(curr.hasNext()){
                        curr = curr.getNext();
                    }
                    else{
                        curr = null;
                    }
                }

            }
        return false;
        }
    }

    /**
     * ,* Sjekker om listen er tom.
     * ,*
     * ,* @return true hvis listen er tom, false ellers.
     * ,
     */
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * ,* Legger til alle elementene i den angitte listen på
     * ,* slutten av listen.
     * ,*
     * ,* @param listen som blir lagt til.
     * ,
     *
     * @param list
     */
    @Override
    public void append(IList<? extends E> list) {
        for (int i = 0; i < list.size(); i++) {
            this.add((E)list.remove());
        }
    }

    /**
     * ,* Legger til alle elementene i den angitte listen på
     * ,* begynnelsen av listen.
     * ,*
     * ,* @param list listen som blir lagt til
     * ,
     *
     * @param list
     */
    @Override
    public void prepend(IList<? extends E> list) {
        for (int i = 0; i <= list.size(); i++) {
            this.put((E) list.remove());
        }
    }

    /**
     * ,* Slår sammen flere lister
     * ,*
     * ,* @param lists listene som skal slås sammen
     * ,* @return Ny liste med alle elementene fra listene som
     * ,* skal slås sammen.
     * ,
     *
     * @param lists
     */
    @Override
    public IList<E> concat(IList<? extends E>... lists) {
        IList<E> mergedList = new LinkedList<E>();
       for(IList<? extends E> list : lists){
           while(!list.isEmpty()){
               mergedList.add(list.remove());
           }
       }
       return mergedList;
    }

    /**
     * ,* Sorterer listen ved hjelp av en
     * ,* sammenligningsfunksjon
     * ,* @param c sammenligningsfunksjon som angir rekkefølgen
     * ,* til elementene i listen
     * ,
     *
     * @param c
     */
    @Override
    public void sort(Comparator<? super E> c) {

        c.compare(head.getData(),head.getNext().getData());
    }

    /**
     * ,* Fjerner elementer fra listen som svarer til et
     * ,* predikat.
     * ,* @param filter predikat som beskriver hvilken
     * ,* elementer som skal fjernes.
     * ,
     *
     * @param filter
     */
    @Override
    public void filter(Predicate<? super E> filter) {
        Node node = head;
        while (node != null){
            if (filter.test(node.getData())){
                Object data = node.getData();
                System.out.println(data);
                this.remove(data);
            }
            node = node.getNext();
        }

    }

    /**
     * ,* Kjører en funksjon over hvert element i listen
     * ,*
     * ,* @param f en funksjon fra typen til elementene i
     * ,* listen til en annen type
     * ,* @return En liste over elementene som funksjonen
     * ,* returnerer
     * ,
     *
     * @param f
     */
    @Override
    public <U> IList<U> map(Function<? super E, ? extends U> f) {
        return null;
    }

    /**
     * ,* Slår sammen alle elementene i listen ved hjelp av en
     * ,* kombinasjonsfunksjon.
     * ,*
     * ,* @param t Det første elementet i sammenslåingen
     * ,* @param accum Funksjonen som holder styr på de
     * ,* sammenslåtte elementene
     * ,* @param combiner funksjonen som slår sammen to
     * ,* elementer
     * ,* @return Den akkumulerte verdien av sammenslåingene
     * ,
     *
     * @param t
     * @param f
     */
    @Override
    public <T> T reduce(T t, BiFunction<T, ? super E, T> f) {
        return null;
    }

    /**
     * ,* Gir størrelsen på listen
     * ,*
     * ,* @return Størrelsen på listen
     * ,
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * ,* Fjerner alle eslementene i listen.
     * ,
     */
    @Override
    public void clear() {

    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        Iterator it = new ListIterator();
        return it;
    }

    /**
     * Printer ut alle elemente i listen
     */
    public void printList(){
        Iterator it = this.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    public class Node {


        private Node next;
        private E data;

        public Node(E data){
            this.data = data;
        }
        public E getData(){
            return  data;
        }
        public Node getNext() {
            return next;
        }
        public boolean hasNext(){
            return next!=null;
        }
        public void setNext(Node e){
            this.next = e;
        }

    }

    public class ListIterator implements Iterator<E>{

        Node current = head;



        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            else{
                E item = current.getData();
                current = current.getNext();
                return item;
            }

        }
    }

}

