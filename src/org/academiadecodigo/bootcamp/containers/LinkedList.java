package org.academiadecodigo.bootcamp.containers;

public class LinkedList  {

    private Node head;


    //leith was here
    private int length = 0;

    public LinkedList() {

        this.head = new Node(null);
    }

    public int size() {

        return length;
    }

    /**
     * Adds an element to the end of the list
     *
     * @param data the element to add
     */
    public void add(Object data) {

        Node node = new Node(data);
        Node iterator = head;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     *
     * @param index the index of the element
     * @return the element
     */
    public Object get(int index) {
        if (index >= length) {
            return null;
        }
            Node iterator = head.getNext();
            for (int i = 0; i < index; i++) {
                iterator = iterator.getNext();
            }
            return iterator.getData();
            //throw new UnsupportedOperationException();
        }





    /**
     * Returns the index of the element in the list
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(Object data) {
        int index = 0;
        Node iterator = head;
        while (iterator.getNext() != null) {
            if (data.equals(iterator.getNext().getData())) {
                return index;
            }
            iterator = iterator.getNext();
            index++;
        }

        return -1;
    }

    /**
     * Removes an element from the list
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(Object data) {
        Node iterator = head;
        while(iterator.getNext() != null){
            if(data.equals(iterator.getNext().getData())){
                iterator.setNext(iterator.getNext().getNext());
                length--;
                return true;
            }
            iterator = iterator.getNext();
        }
        return false;

     //   throw new UnsupportedOperationException();
    }

    private class Node <T> {

        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public T getData() {

            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {

            return next;
        }

        public void setNext(Node next) {

            this.next = next;
        }
    }

}
