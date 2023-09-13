public class DinamicStack <T> {
    private static class Node<T>{
        public Node previous;                                         //Referencia no anterior da pilha
        public T data;                                                //Valor armazenado neste no
    }

    private Node<T> top = null;                                       //Referencia topo da pilha

    public boolean isEmpty(){
        return top == null;
    }

    public void push (T value){
        var node      = new Node<T>();                                //Criacao de novo no para armazenar valor
        node.data     = value;                                        //Atribuicao do valor ao no
        node.previous = top;                                          //O no anterior aponta para o antigo topo
        top           = node;                                         //O novo no se torna o topo da pilha
    }

    public T pop(){
        if (isEmpty()){
            throw new IllegalStateException("A pilha está vazia");
        }
        T data = top.data;                                            //Armazena o dado do topo a ser retornado
        top = top.previous;                                           //Atualiza o topo para o no anterior da pilha
        return data;
    }

    public void clear (){
        top = null;
    }                              //Topo nulo retira as referencias dos nos, garbage collector atua
}
