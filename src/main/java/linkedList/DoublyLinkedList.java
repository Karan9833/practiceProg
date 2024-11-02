package main.java.linkedList;


public class DoublyLinkedList implements LinkedList {
    Node head;

    @Override
    public void append(Node node) {
        if (head == null) {
            head = node; // first element to be added
        } else {
            var currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = node;
        }

    }

    @Override
    public void addBegin(Node node) {
        if (head == null) {
            head = node; // first element to be added
        } else {
            node.next = head; // add to the head
            head = node;
        }

    }

    @Override
    public void deleteNode(int data) {
        if (head == null) {
            System.out.println("No data in the linked list");
        }
        if (head.data == data) {
            head = head.next; //head is the node to be deleted
        }

        var currentNode = head;
        Node prevNode;
        while (currentNode.next != null) {
            /*
            Example: 4 is to be deleted in 3->4->5->6
             */
            prevNode = currentNode;
            currentNode = currentNode.next;
            if (currentNode.data == data) {
                prevNode.next = currentNode.next; // 3->5->6 => o/p
            }

        }
    }

    @Override
    public void display() {
        if (head == null) {
            System.out.println("No data in the linked list");
        }
        System.out.println("Total Nodes in the linkedList :" + this.count());
        System.out.println("Nodes in the linkedList");
        var currentNode = head;
        while (currentNode.next != null) {
            System.out.println(+currentNode.data);
            currentNode = currentNode.next;
        }
        System.out.println(+currentNode.data);

    }

    @Override
    public int count() {
        int count = 0;
        if (head == null) {
            System.out.println("No data in the linked list");
            return count;
        }
        var currentNode = head;
        while (currentNode.next != null) {
            ++count;
            currentNode = currentNode.next;
        }
        ++count;
        return count;

    }

    @Override
    public boolean detectCycle() {
        if (head == null || head.next == null) {
            System.out.println("No cycle in the linked list");
            return false;
        }
        Node fast = head;
        Node slow = head.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    @Override
    public void reverse(Node head) {

    }

    public static void main(String args[]) {
        LinkedList list = new DoublyLinkedList();
        list.append(new Node(2));
        list.append(new Node(3));
        list.append(new Node(9));
        list.append(new Node(4));

        list.display();// 2->3->9->4

        list.addBegin(new Node(12)); //12 -> 2->3->9->4
        list.display(); //12 -> 2->3->9->4

        list.deleteNode(3);
        list.display(); //12 -> 2->9->4

        list.deleteNode(12);
        list.display(); // 2->9->4
        System.out.println("Cycle exists in linkedList :" + list.detectCycle());
    }
}
