import java.util.Scanner;

public class LinkListPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkList ls = new LinkList();
        for(int n = sc.nextInt();n!=0;n--){
            ls.add(sc.nextInt());
        }
        ls.print();
        sc.close();
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkList {
        Node head;
        Node tail;

        LinkList() {
            head = null;
            tail = null;
        }

        public void add(int data) {
            Node tem = new Node(data);
            if (this.head == null) {
                this.head = tem;
            } else {
                this.tail.next = tem;
            }
            this.tail = tem;
        }

        public void print() {
            for (Node i = head; i != null; i = i.next)
                System.out.println(i.data);
        }
    }

}
