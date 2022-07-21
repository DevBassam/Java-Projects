package LinkedList.DoubleEndList;

public class List {
    private Link first;
    private Link last;

    private boolean isEmpty(){
        return first == null;
    }
    public void insertFirst(int value){
        Link newNode = new Link(value);
        if (isEmpty())
            last = newNode;
        newNode.next = first;
        first = newNode;
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
            System.out.println("Empty List");
            return -1;
        }
    }
    public void displayList(){
        Link current = first;
        System.out.print("List items: ");
        while (current != null){
            System.out.print(current.value+" ");
            current = current.next;
        }
        System.out.println("");
    }
}
