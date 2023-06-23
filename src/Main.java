// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        ModifiedHeap heap = new ModifiedHeap(1,false);
        heap.insert((Integer)10);
        System.out.println(heap);
        heap.insert((Integer)15);
        System.out.println(heap);
        heap.insert((Integer)20);
        System.out.println(heap);
        heap.insert((Integer)17);
        System.out.println(heap);
        heap.insert((Integer)25);
        System.out.println(heap);
        System.out.println("popped heap of "+heap.popMax().toString());
        System.out.println(heap);

    }
}