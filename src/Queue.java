

import java.util.Iterator;
import java.util.NoSuchElementException;
public class Queue<E> implements AbstractQueue<E> {
    class Node<E>{
        private E element;
        private Node<E> next;
        public Node(E element){
            this.element = element;
            next = null;
        }
    }
    private Node<E> head;
    private Node<E> tail;
    private int size;
    public Queue(){
        head = null;
        tail =  null;
        size = 0;
    }
    @Override
    public void offer(E element) {
        Node<E> newNode = new Node<>(element);
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public E poll() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<E>current = head;
        if (size!=1){
            head = head.next;
            current.next = null;
        }
        else {
            head = tail = null;
        }
        size--;
        return current.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E peek() {
        return head.element;
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

    public void enQueue(E element)
    {
        offer(element);
    }
    public E dequeue(){
            E element = poll();
            return element;
       }

    }




