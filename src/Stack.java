

import java.util.Iterator;
import java.util.NoSuchElementException;
public class Stack <E> implements AbstractStack<E> {
    class Node<E>{
        private E element;
        private Node<E> next;
        public Node(E element){
            this.element = element;
            this.next = null;
        }

    }
    private Node<E> top;
    private int size;
    public Stack(){
        top = null;
        size = 0;
    }
    @Override
    public void push(E element) {
        Node<E>newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    @Override
    public E pop() {
        Node<E> current = top;
        top = top.next;
        current.next = null;
        size--;
        return current.element;
    }

    @Override
    public E peek() {
        if (isEmpty())throw new  NoSuchElementException();

        return top.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size==0)return true;
        return false;
    }
    @Override
    public Iterator<E> iterator() {
        return null;
    }
    public void displayAllNodeRecursive(Node<E> current ){
        if (current==null)return;
        if (isEmpty())throw new NoSuchElementException();
        System.out.println(current.element);
        displayAllNodeRecursive(current.next);
    }
    public void displayAllNode(){
        displayAllNodeRecursive(top);
    }




}
