package Queue.LinkedList;

public class List {
    private Link first;
    private Link last;

    List(){
        first = null;
        last = null;
    }
    public boolean isEmpty(){
        return first == null;
    }

    public void insertLast(int value){
        Link newNode = new Link(value);
        if (isEmpty())
            first = newNode;
        else
            last.next = newNode;
        last = newNode;
    }
    public int deleteFirst(){
        if (!isEmpty()){
            int temp = first.value;
            if (first.next == null)    //Check if the list has just one element
                last = null;
            first = first.next;
            return temp;
        }
        else{
            System.out.println("Empty Queue");
            return -1;
        }
    }

    public void displayList(){
       Link current = first;
       System.out.print("Queue items: ");
        while (current != null){
            System.out.print(current.value+" ");
            current = current.next;
        }
        System.out.println("");
    }
}
