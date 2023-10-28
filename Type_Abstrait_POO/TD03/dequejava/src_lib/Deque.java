package TD03.dequejava.src_lib;

public class Deque<T> {
    private Long size;
    private Node<T> head;
    private Node<T> queue;

    public Deque(){
        size = 0l;
        head = null;
        queue = null;
    }

    public Long getSize(){
        return size;
    }

    public  Boolean isEmpty(){
        return size == 0;
    }

    public T first() throws Exception{
        if (head == null){
            throw new Exception("Deque vide");
        }
        return head.getData();
    }

    public T last() throws Exception{
        if (queue == null){
            throw new Exception("Deque vide");
        }
        return queue.getData();
    }

    public void inserthead(final T elem) {
        Node<T> newNode = new Node<T>(elem);
        if (isEmpty()){
            head = newNode;
            queue = newNode;
        } else{
            newNode.setPrev(head);
            newNode.getPrev().setNext(newNode);
            head = newNode;
        }
        size++;
    }

    @Override
    public String toString(){
        StringBuilder sbld = new StringBuilder();
        sbld.append("Deque [" + size + "]H->");
        Node<T> ite = head;
        while (ite != null) {
            sbld.append(ite.getData());
            ite = ite.getNext();
            if (ite != null) {
                sbld.append(" -");
            }

            sbld.append("<-0");

        }
        return sbld.toString();
    }
}

