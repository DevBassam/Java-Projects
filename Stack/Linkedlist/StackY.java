package Linkedlist;

public class StackY {
    private List theList;

    StackY(){
        theList = new List();
    }

    public void push(int input){
        theList.insertFirst(input);
    }
    public int pop(){
        return theList.deleteFirst();
    }
    public void displayStack(){
        System.out.print("Stack Data: ");
        theList.displayList();
    }
}
