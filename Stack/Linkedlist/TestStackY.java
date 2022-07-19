package Linkedlist;

public class TestStackY {
    public static void main(String[] args){
    StackY s = new StackY();
    s.push(15);
    s.push(37);
    s.push(98);

    s.displayStack();

    s.push(145);
    s.push(16);

    s.displayStack();

    s.pop();
    s.pop();
    s.pop();
    s.pop();
    s.pop();
    s.pop();
    s.displayStack();
    }
}
