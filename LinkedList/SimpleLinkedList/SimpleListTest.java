package LinkedList.SimpleList;

public class SimpleListTest {
    public static void main(String[] args){
        List theList = new List();

        theList.insertFirst(14);
        theList.insertFirst(6);
        theList.insertFirst(108);
        theList.insertFirst(278);
        theList.insertFirst(9);
        theList.insertFirst(35);

        theList.displayList();

        Link get = theList.find(108);
        if (get != null) System.out.println("Link with key: "+get.value+" is Founded");
        else System.out.println("No Link with that key");

        get = theList.delete(110);
        if (get != null) System.out.println("Link with key: "+get.value+" is deleted");
        else System.out.println("No Link with that key");

        theList.displayList();

        get = theList.delete(9);
        if (get != null) System.out.println("Link with key: "+get.value+" is deleted");
        else System.out.println("No Link with that key");

        theList.displayList();

        theList.deleteFirst();
        theList.displayList();
    }
}
