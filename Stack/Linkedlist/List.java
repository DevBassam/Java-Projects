package Linkedlist;

public class List {
    private Node first;

    List(){
        first = null;
    }

    private boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(int input){
        Node newNode = new Node(input);
        newNode.next = first;
        first = newNode;
        System.out.println(input+" is Saved Successfully");
    }

    public int deleteFirst(){
        if (!isEmpty()){
            Node temp = first;
            first = first.next;
            System.out.println(temp.value+" is returned and deleted Successfully");
            return temp.value;
        }else {
            System.out.println("Stack is Empty,Your return value will be -1");
            return -1;
        }
    }
    public void displayList(){
        Node current = first;
        while(current != null){
            System.out.print(current.value+" ");
            current = current.next;
        }
        System.out.println("");
    }
}
