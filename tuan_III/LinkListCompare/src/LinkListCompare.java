import java.util.Scanner;

public class LinkListCompare {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int t = 0;t<n;t++){
            LinkList ls1 = new LinkList();
            LinkList ls2 = new LinkList();
            for(int i = sc.nextInt();i!=0;i--) ls1.add(sc.nextInt());
            for(int i = sc.nextInt();i!=0;i--) ls2.add(sc.nextInt());
            System.out.println(ls1.compare(ls2));
        }
        sc.close();
    }

    static class Node {
        int data;
        Node next;
        Node previous;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }

        Node(Node node) {
            this.data = node == null ? 0 : node.data;
            this.next = node == null ? null : node.next;
            this.previous = node == null ? null : node.previous;
        }

    }

    static class LinkList {
        Node head;
        Node tail;
        int size;

        LinkList() {
            head = null;
            tail = null;
            size = 0;
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
            this.size++;
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
            this.size++;
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
            this.size++;
        }

        public void delete(Node head, int position) {
            Node i = head;
            for (int t = 1; t < position; t++) {
                i = i.next;
            }
            Node tg = i.next.next;
            i.next = tg;
            tg.previous = i;
            this.size--;
        }

        public LinkList reverse(Node head) {
            LinkList linkList = new LinkList();
            for (Node i = tail; i != null; i = i.previous) {
                linkList.add(i.data);
            }
            return linkList;
        }
        public int compare(LinkList ano){
            int res = 0;
            if(this.size == ano.size){
                for (Node t1 = this.head,t2 = ano.head;t1 != null;t1 = t1.next,t2 = t2.next){
                    if(t1.data != t2.data){
                        res = -1;
                        break;
                    }
                }
                res = res == -1 ? 0:1;
            }
            return res;
        }
    }
}
