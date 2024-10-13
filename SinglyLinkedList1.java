import java.util.Scanner;

public class SinglyLinkedList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        while (true) {
            System.out.println("Menu: ");
            System.out.println("1. Insert\n2. Deletion\n3. Display\n4. Exit");
            System.out.print("Enter your option: ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.println("1. Insert First\n2. Insert Last\n3. Insert at Position");
                    System.out.print("Enter your choice: ");
                    int choice = input.nextInt();
                    if (choice == 1) {
                        System.out.print("How many Data to add at First: ");
                        int n = input.nextInt();
                        for (int i = 1; i <= n; i++) {
                            System.out.print("Enter your data " + i + ": ");
                            int data = input.nextInt();
                            list.addFirst(data);
                        }
                        System.out.println("Data inserted at First Successfully!");
                    } else if (choice == 2) {
                        System.out.print("How many Data to add at Last: ");
                        int n = input.nextInt();
                        for (int i = 1; i <= n; i++) {
                            System.out.print("Enter your data " + i + ": ");
                            int data = input.nextInt();
                            list.addLast(data);
                        }
                        System.out.println("Data inserted at Last Successfully!");
                    } else {
                        System.out.print("Enter your position: ");
                        int s = input.nextInt();
                        System.out.print("Enter your data: ");
                        int data = input.nextInt();
                        list.addAt(data, s);
                        System.out.println("Data inserted Successfully!");
                    }
                    break;

                case 2:
                    System.out.println("1. Delete First Element\n2. Delete Last Element\n3. Delete at Position");
                    System.out.print("Enter your choice: ");
                    int choices = input.nextInt();
                    if (choices == 1) {
                        list.removeFirst();
                        System.out.println("First Data Deleted Successfully");
                    } else if (choices == 2) {
                        list.removeLast();
                        System.out.println("Last Data Deleted Successfully");
                    } else {
                        System.out.print("Which position you want to delete: ");
                        int s = input.nextInt();
                        list.removeAt(s);
                        System.out.println("Data Deleted Successfully");
                    }
                    break;

                case 3:
                    System.out.println("Display: ");
                    list.display();
                    break;

                case 4:
                    System.out.println("Exited!");
                    System.out.println("Happy Coding!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option, Please enter a valid option");
            }
        }
    }
}

class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    SinglyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public void addFirst(int data) {
        Node n = new Node(data);
        n.next = head;
        head = n;
        if (size == 0) {
            tail = n;
        }
        size++;
    }

    public void addAt(int data, int index) {
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node temp = head;
            for (int jump = 1; jump <= index - 1; jump++) {
                temp = temp.next;
            }
            Node n = new Node(data);
            n.next = temp.next;
            temp.next = n;
            size++;
        }
    }

    public void addLast(int data) {
        Node n = new Node(data);
        if (size == 0) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;
    }

    public int removeFirst() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        int output = head.data;
        head = head.next;
        size--;
        if (size == 0) {
            tail = null;
        }
        return output;
    }

    public int removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            return removeFirst();
        }
        Node temp = head;
        for (int jump = 1; jump < index; jump++) {
            temp = temp.next;
        }
        Node output = temp.next;
        temp.next = output.next;
        size--;
        if (size == 0) {
            tail = null;
        }
        return output.data;
    }

    public int removeLast() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        if (size == 1) {
            return removeFirst();
        }
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        int output = tail.data;
        temp.next = null;
        tail = temp;
        size--;
        return output;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
