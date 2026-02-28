package umg.edu.gt.data_structure.queue.manual;


public class Node<T>  {
    T value;
    Node<T> next;

    Node(T value) {
        this.value = value;
    }
}