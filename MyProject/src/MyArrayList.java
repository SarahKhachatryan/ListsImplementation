public class MyArrayList<T> implements MyList {

    private Object[] data;
    private static final int FACTOR = 5;
    private int capacity;
    private int cursor;

    public MyArrayList() {
     init();
    }
public MyArrayList(T... t)
{
  init();
  for(int i=0;i<t.length;i++)
  {
      add(t[i]);
  }
}
private void init()
{
    capacity = FACTOR;
    data = new Object[capacity];
    cursor=0;
}


    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < cursor - 1; i++) {
            sb.append(data[i]).append(", ");

        }
        sb.append(data[cursor - 1]).append("]");
        return sb.toString();
    }

    @Override
    public void add(Object obj) {
        if (cursor == capacity - 1) {
            growArray();
        }
        data[cursor++]= obj;
    }

    private void growArray() {
        capacity += FACTOR;
        Object[] newArray = new Object[capacity];
        System.arraycopy(data, 0, newArray, 0, cursor);
        data = newArray;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < cursor - 1; i++) {
            data[i] = data[i + 1];
        }
        cursor--;

    }

    @Override
    public boolean remove(Object obj) {
        int i= indexOf((T) obj);
        if(i!=-1)
        {
            remove(i);
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return cursor;
    }

    private void checkIndex(int index) {
        if (index < 0) {
            throw new RuntimeException("Index must be >=0");
        }
        if (index > cursor) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }
    }
    public boolean contains(T obj)
    {
      return indexOf(obj)>=0;
    }

public int indexOf(T obj)
{

    for(int i=0;i<cursor;i++)
    {
        if(data[i]==null){
            if(obj==null)
                return i;
        }
        else {
            if(data[i].equals(obj)){
                return i;
            }
        }
    }
  return -1;
}

}
