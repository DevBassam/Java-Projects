package Queue.LinkedList;

public class LinkQueue {
    private List theList;

    LinkQueue(){
        theList = new List();
    }
    public void  insert(int value){
        theList.insertLast(value);
    }
    public int remove(){
        return theList.deleteFirst();
    }
    public boolean isEmpty(){
        return theList.isEmpty();
    }
    public void display(){
        theList.displayList();
    }
}
