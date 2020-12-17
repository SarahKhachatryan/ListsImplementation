public class MyStack<T> {
    private MyArrayList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    public void push(T obj) {
        list.add(obj);
    }
    public T peek(){
        if(isEmpty())
            throw new RuntimeException("Stack is empty");
       T t = list.get(list.size()-1);
       list.remove(size()-1);
       return t;
    }
 public boolean isEmpty()
 {
     return list.size()==0;
 }

 public int size()
 {
     return list.size();
 }

    @Override
    public String toString() {
        return list.toString();
    }
    public void print()
    {
        System.out.println("------");
        for(int i=list.size()-1;i>=0;i--)
        {
            System.out.println("|"+ list.get(i)+ "|");
            System.out.println();
        }
        System.out.println("------");

    }

}
