/**
 * Deque.java
 * Nama: Desati Dinda Saraswati
 * NIM: 18223110
 */

/**
 * Kelas Deque merupakan implementasi struktur data double-ended queue
 * menggunakan double linked list.
 * Mendukung operasi penambahan dan penghapusan elemen di kedua ujung.
 */
public class Deque<E> {

    /**
     * Kelas Node merepresentasikan satu elemen dalam Deque.
     * Menyimpan data serta reference ke node berikutnya dan sebelumnya.
     */
    private class Node {
        E data;
        Node next;
        Node prev;

        Node(E data) {
            // Lengkapi konstruktornya
            this.data = data;
        }
    }

    private Node head; // Menunjuk ke elemen pertama
    private Node tail; // Menunjuk ke elemen terakhir
    private int size;  // Menyimpan jumlah elemen dalam deque

    /**
     * Konstruktor untuk menginisialisasi deque kosong.
     */
    public Deque() {
        // Lengkapi konstruktornya
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Mengecek apakah deque kosong.
     * @return true jika kosong, false jika tidak
     */
    public boolean isEmpty() {
        // Silakan tulis kodenya di bawah ini
        return head == null && tail == null && size == 0;
    }

    /**
     * Mengembalikan jumlah elemen dalam deque.
     * @return jumlah elemen
     */
    public int getSize() {
        // Silakan tulis kodenya di bawah ini
        return size;
    }

    /**
     * Menambahkan elemen ke depan deque.
     * @param element elemen yang ingin ditambahkan
     */
    public void addFirst(E element) {
        // Silakan tulis kodenya di bawah ini
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    /**
     * Menambahkan elemen ke belakang deque.
     * @param element elemen yang ingin ditambahkan
     */
    public void addLast(E element) {
        // Silakan tulis kodenya di bawah ini
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * Menghapus dan mengembalikan elemen dari depan deque.
     * Jika deque kosong, print "Deque kosong. Tidak bisa menghapus elemen".
     * @return elemen yang dihapus, atau null jika kosong
     */
    public E removeFirst() {
        // Silakan tulis kodenya di bawah ini
        if (isEmpty()) {
            System.out.println("Deque kosong. Tidak bisa menghapus elemen.");
            return null;
        }

        E removedElmt = head.data;
        if (head == tail) {
            head = tail = null;
        }
        else {
            head = head.next;
            head.prev = null;
        }
        size--;

        return removedElmt;
    }

    /**
     * Menghapus dan mengembalikan elemen dari belakang deque.
     * Jika deque kosong, print "Deque kosong. Tidak bisa menghapus elemen".
     * @return elemen yang dihapus, atau null jika kosong
     */
    public E removeLast() {
        // Silakan tulis kodenya di bawah ini
        if (isEmpty()) {
            System.out.println("Deque kosong. Tidak bisa menghapus elemen.");
            return null;
        }

        E removedElmt = tail.data;
        if (head == tail) { 
            head = tail = null;
        } 
        else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;

        return removedElmt;
    }

    /**
     * Mengambil elemen pertama tanpa menghapusnya.
     * @return elemen pertama, atau null jika kosong
     */
    public E getHead() {
        // Silakan tulis kodenya di bawah ini
        if (isEmpty()) {
            return null;
        }
        else {
            return head.data;
        }
    }

    /**
     * Mengambil elemen terakhir tanpa menghapusnya.
     * @return elemen terakhir, atau null jika kosong
     */
    public E getTail() {
        // Silakan tulis kodenya di bawah ini
        if (isEmpty()) {
            return null;
        }
        else {
            return tail.data;
        }
    }

    /**
     * Menampilkan isi deque dalam format [elemen1, elemen2, ...]
     */
    public void display() {
        // Silakan tulis kodenya di bawah ini
        Node p = head;
        System.out.print("[");
        while (p != null) {
            System.out.print(p.data);
            if (p.next != null) {
                System.out.print(", ");
            }
            p = p.next;
        }
        System.out.println("]");
    }
}