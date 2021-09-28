public class LinkListPrintReverse {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        LinkList ls = new LinkList();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);
        ls.addHead(30);
        ls.add(ls.head, 40, 2);
//        ls.delete(ls.head, 2);
        ls.print(ls.head);
        System.out.println();
        ls.printReverse(ls.tail);
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

        public void printReverse(Node tail){
            for(Node i = tail;i!=null;i = i.previous)
                System.out.print(i.data+" ");
        }

        public void addHead(int data) {
            Node tem = new Node(data);
            if (this.head == null) {
                this.head = tem;
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

        public void delete(Node head, int position) {
            Node i = head;
            for (int t = 1; t < position; t++) {
                i = i.next;
            }
            Node tg = i.next.next;
            i.next = tg;
            tg.previous = i;
        }
    }

}
