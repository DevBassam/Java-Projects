package Queue.LinkedList;

public class TestQueue {
    public static void main(String[] args){
        LinkQueue q = new LinkQueue();
        q.display();
        q.insert(15);
        q.insert(13);
        q.insert(20);
        q.insert(74);

        q.display();

        q.insert(168);
        q.insert(92);

        q.display();

        q.remove();
        q.remove();
        q.remove();

        q.display();
    }
}
