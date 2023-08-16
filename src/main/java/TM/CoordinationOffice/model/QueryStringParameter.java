package TM.CoordinationOffice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QueryStringParameter {

    public int NumberOfPage;
    public int NumberOfItems;
    public int CurrentPage;
    public int PageSize;

}
