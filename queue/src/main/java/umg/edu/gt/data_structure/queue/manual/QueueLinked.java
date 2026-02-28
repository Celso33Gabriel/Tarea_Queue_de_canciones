package umg.edu.gt.data_structure.queue.manual;
/**
 * Implementación de una cola (FIFO) basada en nodos enlazados.
 * @param <T> El tipo de elementos que la cola almacenará.
 */
 
public class QueueLinked<T> {
	private static class Node<T> {
        private T value;    // Atributo privado
        private Node<T> next; // Atributo privado

        private Node(T value) {
            this.value = value;
        }
	}

    private Node<T> head; // primero en salir
    private Node<T> tail; // ultimo en entrar
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // add
    public void enqueue(T value) {
        Node<T> newnode = new Node<>(value);
        if (isEmpty()) {
            head = tail = newnode;
        } else {
            tail.next = newnode;
            tail = newnode;
        }
        size++;
    }

    // delete
    public T dequeue() {
        if (isEmpty()) 
            throw new IllegalStateException("Queue underflow");
        
        T value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflow");
        }
        return head.value;
    }

}

