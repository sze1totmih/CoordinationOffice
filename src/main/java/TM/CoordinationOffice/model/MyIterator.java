package TM.CoordinationOffice.model;

import java.util.Iterator;

public class MyIterator <T> implements Iterator<T> {

    Node<T> current;

    public MyIterator(PagedList<T> tPagedList){
    }

    @Override
    public boolean hasNext() {
        return current!=null;
    }

    @Override
    public T next() {
        T data = current.getData();
        current = current.getNext();
        return data;
    }
}
