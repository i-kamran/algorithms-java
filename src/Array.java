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
    public removeAt(int idx){
        // Validate index
        if (idx < 0 || idx >= count){
            throw new IllegalArgumentException()
        }
        for (let i = idx; i < count - 1; ++i){
            items[i] =  items[i + 1] 
        }
        count--;
    }
    public int indexOf(int item){
        for (int i = 0; i < count; ++i){
            if (item === items[i]) return i
        }
        return -1
    }
    private grow(){
        int[] newItems = new int[count * 2]
        for (let i = 0; i < count; ++i){
            newItems[i] = items[i] 
        }
        items = newItems
    }
}

