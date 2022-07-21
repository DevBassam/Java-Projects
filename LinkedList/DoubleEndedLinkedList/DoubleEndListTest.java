package LinkedList.DoubleEndList;

public class DoubleEndListTest {
    public static void main(String[] args){
        List theList = new List();

        theList.deleteFirst();

        theList.insertFirst(45);
        theList.insertFirst(13);
        theList.insertFirst(37);
        theList.insertFirst(29);

        theList.displayList();

        theList.insertLast(63);
        theList.insertLast(74);
        theList.insertLast(98);

        theList.displayList();

        theList.deleteFirst();
        theList.deleteFirst();
        theList.deleteFirst();

        theList.displayList();
    }
}
