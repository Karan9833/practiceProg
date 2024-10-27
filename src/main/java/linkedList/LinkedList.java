package main.java.linkedList;

public interface LinkedList {

    void append(Node node);
    void addBegin(Node node);
    void deleteNode(int data);
    void display();
    int count();
    boolean detectCycle();
}
