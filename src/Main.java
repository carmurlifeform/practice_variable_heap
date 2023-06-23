// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        ModifiedHeap heap = new ModifiedHeap(1);
        heap.insert(new intItem(-10));
        System.out.println(heap);
        heap.insert(new intItem(-15));
        System.out.println(heap);
        heap.insert(new intItem(-20));
        System.out.println(heap);
        heap.insert(new intItem(-17));
        System.out.println(heap);
        heap.insert(new intItem(-25));
        System.out.println(heap);
        System.out.println("popped heap of "+heap.popMax().order());
        System.out.println(heap);

    }

    private static class intItem implements OrderedItem{

        public int value;

        public intItem(int value){
            this.value=value;
        }

        @Override
        public int order() {
            return value;
        }
    }
}