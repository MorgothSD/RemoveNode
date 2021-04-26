
public class Main {

    public static void main(String[] args) {
        Node head = new Node(2, null);
        Node second = new Node(4, null);
        head.setNext(second);
        Node third = new Node(6, null);
        second.setNext(third);
        Node forth = new Node(8, null);
        third.setNext(forth);
        Node fifth = new Node(10, null);
        forth.setNext(fifth);
        //System.out.println("kek");

        head = remNode(head, 3);
        print(head);

    }

    public static void print(Node head) {
        Node current = head;
        if (current == null) {
            System.out.println("Empty");
        }
        else {
            Node next = current.getNext();
            while (true) {
                System.out.println(current.getValue());
                if (current.getNext() == null) break;
                current = next;
                next = current.getNext();
            }
        }
    }

    public static Node remNode(Node node, int n) {

        int counter = 0;
        Node current = node;
        Node next = current.getNext();
        //System.out.println("kek");
        while (true) {
            //System.out.println("lol");
            if (current.getNext() == null) break;
            current = next;
            next = current.getNext();
            counter++;
        }

        //System.out.println("kek");
        Node reserv = node;
        current = node;
        Node previous = null;
        next = null;
        int i = 0;
        if (current.getNext() == null) {
            reserv = null;
            return reserv;
        }
        while (i < counter+1) {
            if (i == counter+1 - n) {
                if (previous == null) {
                    reserv = current.getNext();
                    current.setNext(null);
                    break;
                }
                if (current.getNext() == null) {
                    previous.setNext(null);
                }
                else {
                    current.setNext(null);
                    previous.setNext(next);
                }
                break;
            }

            previous = current;
            current = current.getNext();
            next = current.getNext();

            i++;
        }

        return reserv;
    }
}

class Node {
    private int value = 0;
    Node next = null;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
