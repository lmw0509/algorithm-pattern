package linked_list;

/**
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 */
public class SinglyLinkedList {

    private Node head = null;

    public Node findByValue(final int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }

        return p;
    }

    public Node findByIndex(final int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }

        return p;
    }

    //无头结点
    //表头部插入
    //这种操作将于输入的顺序相反，逆序
    public void insertToHead(final int value) {
        final Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    public void insertToHead(final Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    //顺序插入
    //链表尾部插入
    public void insertTail(final int value) {

        final Node newNode = new Node(value, null);
        //空链表，可以插入新节点作为head，也可以不操作
        if (head == null) {
            head = newNode;

        } else {
            Node q = head;
            while (q.next != null) {
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    public void insertAfter(final Node p, final int value) {
        final Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    public void insertAfter(final Node p, final Node newNode) {
        if (p == null) return;

        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(final Node p, final int value) {
        final Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    public void insertBefore(final Node p, final Node newNode) {
        if (p == null) return;
        if (head == p) {
            insertToHead(newNode);
            return;
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        newNode.next = p;
        q.next = newNode;

    }

    public void deleteByNode(final Node p) {
        if (p == null || head == null) return;

        if (p == head) {
            head = head.next;
            return;
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        q.next = q.next.next;
    }

    public void deleteByValue(final int value) {
        if (head == null) return;

        Node p = head;
        Node q = null;
        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }

        if (p == null) return;

        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }

        // 可重复删除指定value的代码
        /*
           if (head != null && head.data == value) {
           head = head.next;
           }

           Node pNode = head;
           while (pNode != null) {
           if (pNode.next.data == data) {
           pNode.next = pNode.next.next;
           continue;
           }
           pNode = pNode.next;
           }
         */
    }

    public static class Node {
        private final int data;
        private Node next;

        public Node(final int data, final Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
