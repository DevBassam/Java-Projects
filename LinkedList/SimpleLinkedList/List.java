package LinkedList.SimpleList;

public class List {
    private Link first;

    public boolean isEmpty(){
        return first == null;
    }
    public void insertFirst(int input){
        Link newItem = new Link(input);
        newItem.next = first;
        first = newItem;
    }
    public int deleteFirst(){
        Link temp = first;
        first = first.next;
        return temp.value;
    }
    public void displayList(){
        Link current = first;
        while(current != null){
            System.out.print(current.value+" ");
            current = current.next;
        }
        System.out.println("");
    }
    public Link find(int value){
        Link current = first;
        while(current != null){
            if (current.value == value) return current;
            else current = current.next;
        }
        return null;
    }
    public Link delete(int value){
        Link current = first;
        Link previous = first;
        while(current != null){
            if (current.value == value) break;
            else {
                previous = current;
                current = current.next;
            }
        }
        if (current == first) first = first.next;
        else if(current != null) previous.next = current.next;
        return current;
    }
}
