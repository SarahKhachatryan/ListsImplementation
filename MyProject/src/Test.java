public class Test {
    public static void main(String[] args) {

       MyStack<Integer> sss = new MyStack<>();
       sss.push(123);
       sss.push(345);
       sss.push(256);
       sss.print();
        System.out.println(sss.peek());
        sss.print();
        System.out.println(sss.isEmpty());
    }
}
