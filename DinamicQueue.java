public class DinamicQueue <T>{
    private static class Node<T>{
        public DinamicQueue.Node <T> next;   //Referencia para proximo no
        public T data;                       //Valor armazenado neste no
    }

    //Referencia da base e topo da fila
    private DinamicQueue.Node<T> top  = null;
    private DinamicQueue.Node<T> base = null;

    //Verificar se fila esta vazia
    public boolean isEmpty() {return top == null;}


    public void add(T value){
        var node         = new Node<T>();      //Novo no para armazenar o valor
        node.data        = value;              //Atribuicao do valor ao no
        if (isEmpty()) {                       //Se a fila estiver vazia, o novo no sera a base e o topo
            base = node;
            top  = node;
        }else{                                 //Se nao, novo no sera o topo
            top.next  = node;                  //O proximo do no criado aponta para o antigo topo
            top        = node;                //Topo da fila agora é o novo no
        }

    }

    public T remove(){
        if (isEmpty()){
            throw new IllegalStateException("A fila está vazia!!");
        }
        T data = base.data;                    //Armazena dado da base que sera retornado
        base   = base.next;                    //Atualiza a base para o proximo no
        if (base == null){                     //Se a base esta vazia (null) a fila esta vazia, logo topo tambem sera vazio
            top = null;
        }
        return data;
    }
    public void clear(){
        base = null;                           //Para limpar basta retirar as referencias que o garbage collector atua
        top  = null;
    }
}
