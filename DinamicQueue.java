public class DinamicQueue <T>{
    private static class Node<T>{
        public DinamicQueue.Node <T> next;
        public T data;
    }

    private DinamicQueue.Node<T> top  = null;
    private DinamicQueue.Node<T> base = null;

    public boolean isEmpty() {return top == null;}

    public void add(T value){
        var node         = new Node<T>();
        node.data        = value;
        if (isEmpty()) {
            base = node;
            top  = node;
        }else{
            node.next  = top;
            base        = node;
        }

    }

    public T remove(){
        if (isEmpty()){
            throw new IllegalStateException("A fila está vazia!!");
        }
        T data = base.data;
        base   = base.next;
        if (base == null){
            top = null;
        }
        return data;
    }
    public void clear(){
        base = null;
        top  = null;
    }
}
