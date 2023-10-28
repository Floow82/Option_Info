package TD03.dequejava.src_lib;

class Node<T> {
    private T val;
    private Node<T> next;
    private Node<T> prev;

    public Node(final T v){
        val = v;
        next = null;
        prev = null;
    }
    public Node<T> getNext(){
        return next;
    }

    public Node<T> getPrev(){
        return prev;
    }

    public void setNext(final Node<T> nde){
        next = nde;
    }

    public void setPrev(final Node<T> nde){
        prev = nde;
    }

    public T getData(){
        return val;

    }
    public String toString() {
        return val.toString();
    }
}
