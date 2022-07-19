public class TestStackX {
    public static void main(String []args){

        int[] numbers = {1,2,3,4,5,6};
        StackX s = new StackX(5);

        for (int i = 0 ; i < numbers.length;i++){
            s.push(numbers[i]);
        }

        s.peek();

        for (int i = 0 ; i < numbers.length;i++){
            s.pop();
        }

        s.push(10);
        s.peek();
        s.pop();
    }
}
