public class Array {
    private int[] items;
    public int count;
    public Array(int length){
        items = new int[length]
    }
    public void print(){
        for (int i = 0 ; i < count; i++){
            System.out.println(items[i])
        }
    }
    public insert(int item){
        if (count === items.length) grow()
        items[count++] = item
    }
    private grow(){
        int[] newItems = new int[count * 2]
        for (let i = 0; i < count; ++i){
            newItems[i] = items[i] 
        }
        items = newItems
    }
}

