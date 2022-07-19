public class StackX {
    private int[] data;
    private int top;
    private int maxSize;
    public StackX(int maxSize) {
        this.maxSize = maxSize;
        this.data = new int[maxSize];
        this.top = -1;
    }

    private boolean isEmpty(){
        return top == -1;
    }
    private boolean isFull(){
        return top == maxSize-1;
    }
    public void push(int input){
        if(isFull())
            System.out.println("Stack is Full, Can't Save ("+input+") into Stack");
        else{
            data[++top] = input;
            System.out.println("Data ("+input+") Saved into Stack");
        }
    }
    public int pop(){
        if(isEmpty()) {
            System.out.println("Stack is Empty, Your value will be -1");
            return -1;
        }else {
            System.out.println("Value = "+data[top]);
            return data[top--];
        }
    }
    public void peek(){
        if (isEmpty()) System.out.println("Stack is Empty");
        else System.out.println("Top = "+data[top]);
    }
}
