package TM.CoordinationOffice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
public class PagedList<T> implements Iterable {

    private long NumberOfItems;
    private int PageSize;
    private int CurrentPage;
    private int NumberOfPage;
    private List<T> Items;

    public PagedList() {
        NumberOfItems = 0;
        PageSize = 0;
        CurrentPage = 0;
        NumberOfPage = 0;
        Items = new ArrayList<T>();
    }

    @Override
    public Iterator iterator() {
        return new MyIterator<T>(this);
    }
}
