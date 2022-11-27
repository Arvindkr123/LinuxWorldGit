package LinkedListChapter;

import java.util.concurrent.locks.ReadWriteLock;

public class SL{
    Node head;
    Node tail;
    int size;

    SL(){

    }
    // get something work here
    int getFirst(){
        if(size==0){
            System.out.println("Linked list is Empty");
            return -1;
        }else{
            return head.data;
        }
    }

    int getLast(){
        if(size==0){
            System.out.println("Linked list is Empty");
            return -1;
        }else{
            return tail.data;
        }
    }
    
    int getAt(int idx){
        if(size==0){
            System.out.println("Linked list is Empty");
            return -1;
        }else if(idx<0 || idx>=size){
            System.out.println("Invalid argument");
            return -1;
        }else{
            Node temp = head;
            for (int i = 0; i <idx; i++) {
                temp = temp.next;
            }
            return temp.data;
        }
    }
    
    // Delete something work here
    int RemoveAt(int index){
        if(index<0 || index>=size-1){
            System.out.println("Invalid argument");
            return -1;
        }else if(index==0){
            return ReomveFirst();
        }else if(index==size-1){
            return ReomveLast();
        }else{
            Node temp = head;
            for (int i = 0; i < index-1; i++) {
                temp = temp.next;
            }
            int val = temp.next.data;
            temp.next = temp.next.next;
            size--;
            return val;
        }
    }
    int  ReomveFirst(){
        if(size==0){
            System.out.println("Linked lis is Empty");
            return -1;
        }

        if(size==1){
            int val = head.data;
            head = tail = null;
            size=0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

   
    int ReomveLast(){
        if(size==0){
            System.out.println("Linked lis is Empty");
            return -1;
        }else if(size==1){
            int val = head.data;
            head = tail = null;
            size=0;
            return val;
        }else{
            Node temp = head;
            for (int i = 0; i <size-2; i++) {
                temp = temp.next;
            }
            int data  = tail.data;
            tail = temp;
            temp.next= null;
            size--;
            return data;
        }
        

    }
    // Reverse the linked list
    private Node getANodeAt(int index){
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void reverseLinkedList(){
        int li=0;
        int ri =size-1;

        while(li<ri){
            Node left = getANodeAt(li);
            Node right = getANodeAt(ri);
            int temp = left.data;
            left.data = right.data;
            right.data = temp;

            li++;
            ri--;
        }
    }

    // Add Something work here
    void addAt(int val, int idx){
        if(idx<0 || idx>=size){
            System.out.println("Invalid argument");
        }else if(idx==0){
            addFirst(val);
            return;
        }else if(idx==size){
            addLast(val);
            return;
        }else{
            Node temp = head;
            for (int i = 0; i <idx-1; i++) {
                temp = temp.next;
            }
            Node new_node = new Node(val);
            new_node.next = temp.next;
            temp.next = new_node;
            size++;
        }
    }
    void addFirst(int val){
        if(size==0){
            Node temp = new Node();
            temp.data = val;
            temp.next = null;
            head = tail = temp;
            size++;
        }

        Node temp = new Node();
        temp.data = val;
        temp.next = head;
        head = temp;
        size++;
    }

    void addLast(int val){
        Node temp = new Node();
        temp.data = val;
        temp.next = null;
        if(size==0){
            head=tail=temp;
        }else{
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    void display(){
        Node temp = head;
        System.out.print("HEAD -> ");
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static class Node{
        int data;
        Node next;

        Node(){

        }
        Node(int data){
            this.data = data;
        }
        Node(int data, Node next){
            this.data = data;
            this.next= next;
        }

    }
    public static void main(String[] args) {
        SL list = new SL();
        list.display();
        for (int i = 0; i < 7; i++) {
            list.addLast(i);
        }
        list.display();
        list.addFirst(7);
        list.display();
        // list.addAt(8, 2);
        // list.display();
        list.ReomveFirst();
        list.display();
        list.ReomveFirst();
        list.display();
        list.ReomveFirst();
        list.display();
        System.out.println("This is the Linked list get first element "+list.getFirst());
        System.out.println("This is the Linked list get last element "+list.getLast());
        System.out.println("This is the Linked list get idx element "+list.getAt(3));
        list.display();
        list.addAt(100, 2);
        list.display();
        System.out.println(list.ReomveLast());
        list.display();
        list.RemoveAt(2);
        list.display();
        list.reverseLinkedList();
        list.display();

    }
}