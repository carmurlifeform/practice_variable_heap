import java.util.Arrays;

public class ModifiedHeap {
    //array list of the contents of the heap
    OrderedItem[] heapContent;
    public int count;
    private int capacity;
    protected final int maxChildren;

    public ModifiedHeap(int x){
        capacity = 10;
        heapContent = new OrderedItem[capacity];
        count = 0;
        this.maxChildren=1<<x; //  1<<x == 2 to the power of x
        System.out.println("created heap with max children "+maxChildren);
    }

    private void ensureCapacity(){
        if(count>=capacity){
            capacity*=2;
            heapContent = Arrays.copyOf(heapContent,capacity);
        }
    }

    protected boolean swap(int index1, int index2){
        OrderedItem swap = heapContent[index1];
        heapContent[index1] = heapContent[index2];
        heapContent[index2] = swap;
        return true;
    }

    public OrderedItem peek(){
        if(count<=0) throw new IllegalStateException();
        return heapContent[0];
    }

    public OrderedItem popMax(){
        if(count<=0) throw new IllegalStateException();
        OrderedItem swap = heapContent[0];
        heapContent[0] = heapContent[count-1];
        count--;
        heapifyDown();
        return swap;
    }

    public boolean insert(OrderedItem item){
        ensureCapacity();
        heapContent[count] = item;
        count++;
        heapifyUp();
        return true;
    }

    public void heapifyDown(){
        int index = 0;
        while(firstChild(index)<count){
            int largestChild = firstChild(index);
            for(int i=firstChild(index)+1;i<firstChild(index)+maxChildren&&i<count;i++){
                if(heapContent[i].order()>heapContent[largestChild].order()){
                    largestChild = i;
                }
            }
            if(heapContent[index].order()>heapContent[largestChild].order()){
                return;
            }
            swap(index,largestChild);
            index = largestChild;

        }
    }

    public void heapifyUp(){
        int index = count-1;
        while(index>0 && heapContent[parent(index)].order()<heapContent[index].order()){
            swap(parent(index),index);
            index = parent(index);
        }
    }


    private int parent(int child){
        return (child-1)/maxChildren;
    }

    private int firstChild(int parent){
        return maxChildren*parent+1;
    }

    public String toString(){
        if(count<=0) return "[]";
        StringBuilder ret = new StringBuilder("[");
        ret.append(heapContent[0].order());
        for(int i=1;i<count;i++){
            ret.append(",");
            ret.append(heapContent[i].order());
        }
        ret.append("]");
        return ret.toString();
    }

}
