import java.util.Scanner;

public class LinkListDeleteNode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkList ls = new LinkList();
        int n = scanner.nextInt();
        for(int i = 0;i<n;i++){
            ls.add(scanner.nextInt());
        }
        ls.head = ls.delete(ls.head,scanner.nextInt());
        ls.print(ls.head);
        scanner.close();
    }

    static class Node {
        int data;
        Node next,previous;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(Node node) {
            data = node.data;
            next = node.next;
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
                tem.previous = this.tail;
            }
            this.tail = tem;
        }

        public void print(Node head) {
            for (Node i = head; i != null; i = i.next)
                System.out.print(i.data + " ");
        }

        public void printReverse(Node tail) {
            for (Node i = tail; i != null; i = i.previous)
                System.out.print(i.data + " ");
        }

        public void addHead(int data) {
            Node tem = new Node(data);
            if (this.tail == null) {
                this.tail = tem;
            } else {
                tem.next = head;
                this.head.previous = tem;
            }
            this.head = tem;
        }

        public void add(Node head, int data, int position) {
            Node t = head;
            for (int i = 0; i < position; i++) {
                t = head.next;
            }
            Node tg = new Node(data);
            tg.next = t.next;
            t.next = tg;
            tg.next.previous = tg;
            tg.previous = t;
        }

        public Node delete(Node head, int position) {

            if(position == 0){
               head.next.previous = null;
               return head.next;
            }else{
                Node i = head;
                for (int t = 1; t < position; t++) {
                    i = i.next;
                }
                Node tg = i.next.next;
                i.next = tg;
                tg.previous = i;
            }
            return head;
        }

        public LinkList reverse(Node head) {
            LinkList linkList = new LinkList();
            for (Node i = tail; i != null; i = i.previous) {
                linkList.add(i.data);
            }
            return linkList;
        }

    }
}
