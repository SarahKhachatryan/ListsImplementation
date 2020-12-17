public class MyLinkedList <T> implements MyList<T> {
private Node<T> first;
private Node<T> last;
private int size;
    @Override
    public void add(T obj) {
     if(first==null)
     {
         first = new Node<>(obj);
         last= first;
         size++;
         return;
     }
     last.next= new Node<>(obj);
     last= last.next;
     size++;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = first;
        for (int i = 0; i < size - 1; i++) {
            sb.append(current.value).append(", ");
            current= current.next;

        }
        sb.append(current.value).append("]");
        return sb.toString();
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        Node<T> current = first;
        int count=0;
        while(count<index)
        {
            current= current.next;
            count++;
        }
        return current.value;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        if(index == 0)
        {
            first= first.next;
            size--;
            return;
        }
        Node<T> current = first;
        int count=0;
        while(count<index-1)
        {
            current= current.next;
            count++;
        }
     current.next= current.next.next;
        size--;
    }

    @Override
    public boolean remove(T obj) {
        Node<T> current = first;
        //if elemnt is with index 0 it works not properly fix
        while(current.next!=null)
        {
            System.out.println(current.value);
            if(current.next.value.equals(obj))
            {
                System.out.println(current.value);
                current.next= current.next.next;
                size--;
                return true;
            }
            current= current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }
    private void checkIndex(int index) {
        if (index < 0) {
            throw new RuntimeException("Index must be >=0");
        }
        if (index >=size) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }
    }
}
