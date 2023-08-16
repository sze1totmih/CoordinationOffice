package TM.CoordinationOffice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Node<T> {
    private T data;
    private Node<T> next;

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }
}
