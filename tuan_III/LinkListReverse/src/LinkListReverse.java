public class LinkListReverse {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        LinkList ls = new LinkList();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);
        System.out.println("truoc khi doi");
        ls.print();
        System.out.println("\nSau khi doi");
        ls = ls.reverse();
        ls.print();
        System.out.println();
        ls.printReverse();
        System.out.println();
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

        public void print() {
            for (Node i = head; i != null; i = i.next)
                System.out.print(i.data + " ");
        }

        public void printReverse() {
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

        public void delete( int position) {
            Node i = head;
            for (int t = 1; t < position; t++) {
                i = i.next;
            }
            Node tg = i.next.next;
            i.next = tg;
            tg.previous = i;
        }

        public LinkList reverse() {
            LinkList linkList = new LinkList();
            for (Node i = tail; i != null; i = i.previous) {
                linkList.add(i.data);
            }
            return linkList;
        }

    }
}
