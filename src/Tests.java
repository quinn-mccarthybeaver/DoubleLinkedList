public class Tests {
    public static void main(String[] args) {
        DoublyLinkedList d = new DoublyLinkedList();
        d.add(1);
        d.add(2);
        d.add(3);
        d.add(4);
        d.addAlternative(10);
        System.out.println(d);
    }
}
