public class LinkListAddHead {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        LinkList ls = new LinkList();
        ls.add(10);
        ls.add(100);
        ls.addHead(30);
        ls.print();
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
                System.out.print(i.data + " ");
        }

        public void addHead(int data) {
            Node tem = new Node(data);
            if (this.head == null) {
                this.head = tem;
            } else {
                tem.next = head;
            }
            this.head = tem;
        }
    }

}
