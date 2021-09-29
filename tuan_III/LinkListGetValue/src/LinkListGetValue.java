import java.util.List;
import java.util.Scanner;

public class LinkListGetValue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for(int m = 0;m<k;m++) {
            LinkList ls = new LinkList();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                ls.add(sc.nextInt());
            }
            System.out.println(ls.getValueFT(ls.tail, sc.nextInt()));
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

        public int compare(LinkList ano) {
            int res = 0;
            if (this.size == ano.size) {
                for (Node t1 = this.head, t2 = ano.head; t1 != null; t1 = t1.next, t2 = t2.next) {
                    if (t1.data != t2.data) {
                        res = -1;
                        break;
                    }
                }
                res = res == -1 ? 0 : 1;
            }
            return res;
        }

        public LinkList merge(LinkList ano) {
            LinkList res = new LinkList();
            Node i1 = this.head;
            Node i2 = ano.head;
            boolean run = true;
            while (run) {
                if (i1 == null && i2 == null) run = false;
                else {
                    if (i1 == null) {
                        res.add(i2.data);
                        i2 = i2.next;
                    } else if (i2 == null) {
                        res.add(i1.data);
                        i1 = i1.next;
                    } else {
                        if (i1.data <= i2.data) {
                            res.add(i1.data);
                            i1 = i1.next;
                        } else {
                            res.add(i2.data);
                            i2 = i2.next;
                        }
                    }
                }
            }
            return res;
        }
        public int getValueFT(Node tail,int positionFromTail){
            if(positionFromTail == 0) return tail.data;
            else {
                Node t = tail;
                for (int i = 0;i<positionFromTail;i++){
                    t = t.previous;
                }
                return t.data;
            }
        }
    }
}
