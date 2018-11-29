public class Tests {
    public static void main(String[] args) {
	DoublyLinkedList a = new DoublyLinkedList();
	a.add(0);
	System.out.println(a.getSize());
	a.addAll(1, 1, 2, 3, 4, 5, 6, 7);
	System.out.println(a);
	System.out.println(a.getSize());
    }
}
