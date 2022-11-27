package LinkedListChapter;

import java.util.LinkedList;

public class StackAdpaterLinkedList {

    public static class LinkedListSTACK{

        LinkedList<Integer> list;

        public LinkedListSTACK(){
            list = new LinkedList<>();
        }

        int size(){
            return list.size();
        }

        int pop(){
            if(size()==0){
                System.out.println("Stack underflow");
                return -1;
            }else{
                return list.removeFirst();
            }
        }

        void push(int val){
            list.addFirst(val);
        }

        int top(){
            if(size()==0){
                System.out.println("Stack underflow");
                return -1;
            }else{
                return list.getFirst();
            }
        }
        void display(){
            System.out.println(list);
        }


    }
    public static void main(String[] args) {
        LinkedListSTACK stack = new LinkedListSTACK();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        stack.display();
    }
}
