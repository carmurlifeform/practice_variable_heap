import java.util.Arrays;

public class ModifiedHeap {
    //array list of the contents of the heap
    Comparable[] heapContent;
    public int count;
    protected boolean order;
    private int capacity;
    protected final int maxChildren;

    public ModifiedHeap(int childrenPower,boolean highestTowardsRoot){
        capacity = 10;
        heapContent = new Comparable[capacity];
        count = 0;
        order = highestTowardsRoot;
        this.maxChildren=1<<childrenPower; //  1<<x == 2 to the power of x
        System.out.println("created heap with max children "+maxChildren);
    }

    public ModifiedHeap(){
        this(1,true);
    }
    public ModifiedHeap(int childrenPower){
        this(childrenPower,true);
    }
    public ModifiedHeap(boolean highestTowardsRoot){
        this(1,highestTowardsRoot);
    }

    private void ensureCapacity(){
        if(count>=capacity){
            capacity*=2;
            heapContent = Arrays.copyOf(heapContent,capacity);
        }
    }

    protected boolean swap(int index1, int index2){
        Comparable swap = heapContent[index1];
        heapContent[index1] = heapContent[index2];
        heapContent[index2] = swap;
        return true;
    }

    public Comparable peek(){
        if(count<=0) throw new IllegalStateException();
        return heapContent[0];
    }

    public Comparable popMax(){
        if(count<=0) throw new IllegalStateException();
        Comparable swap = heapContent[0];
        heapContent[0] = heapContent[count-1];
        count--;
        heapifyDown();
        return swap;
    }

    public boolean insert(Comparable item){
        ensureCapacity();
        heapContent[count] = item;
        count++;
        heapifyUp();
        return true;
    }

    protected boolean closerToRoot(Comparable compared, Comparable comparedAgainst){
        return order?compared.compareTo(comparedAgainst)>0:compared.compareTo(comparedAgainst)<0;
    }

    public void heapifyDown(){
        int index = 0;
        while(firstChild(index)<count){
            int largestChild = firstChild(index);
            for(int i=firstChild(index)+1;i<firstChild(index)+maxChildren&&i<count;i++){
                if(closerToRoot(heapContent[i],heapContent[largestChild])){
                    largestChild = i;
                }
            }
            if(closerToRoot(heapContent[index],heapContent[largestChild])){
                return;
            }
            swap(index,largestChild);
            index = largestChild;

        }
    }

    public void heapifyUp(){
        int index = count-1;
        while(index>0 && closerToRoot(heapContent[index],heapContent[parent(index)])){
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
        ret.append(heapContent[0].toString());
        for(int i=1;i<count;i++){
            ret.append(",");
            ret.append(heapContent[i].toString());
        }
        ret.append("]");
        return ret.toString();
    }

}
