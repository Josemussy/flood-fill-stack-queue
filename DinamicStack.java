public class DinamicStack <T> {
    private static class Node<T>{
        public Node previous;
        public T data;
    }

    private Node<T> top = null;

    public boolean isEmpty(){
        return top == null;
    }

    public void push (T value){
        var node      = new Node<T>();
        node.data     = value;
        node.previous = top;
        top           = node;
    }

    public T pop(){
        if (isEmpty()){
            throw new IllegalStateException("A pilha está vazia");
        }
        T data = top.data;
        top = top.previous;
        return data;
    }

    public void clear (){
        top = null;
    }
}
