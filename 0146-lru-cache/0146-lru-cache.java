class Node {
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        head = new Node(0, 0); // dummy head
        tail = new Node(0, 0); // dummy tail
        head.next = tail;
        tail.prev = head;
    }

    // Add to front
    public void addFirst(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    // Remove a node
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Remove last
    public Node removeLast() {
        if (tail.prev == head) return null;
        Node lru = tail.prev;
        remove(lru);
        return lru;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    DoublyLinkedList dll;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dll = new DoublyLinkedList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        dll.remove(node);
        dll.addFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            dll.remove(node);
            dll.addFirst(node);
        } else {
            if (map.size() == capacity) {
                Node lru = dll.removeLast();
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            dll.addFirst(newNode);
            map.put(key, newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */