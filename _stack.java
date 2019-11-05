public class _stack{

    int arr[];
    int first;
    int size;
    int MaxSize;

    public _stack(int data){
       MaxSize = data;
        arr = new int[MaxSize];
        first = 0;
        size = 0;
    }

    public void push(int num){
        if(!isFull()){
        arr[first] = num;
        first++;
        size++;
        }else{
            System.out.println("Stack Is Full");
        }
    }

    public int pop(){
        if(!isEmpty()){
            int t = arr[first];
            first--;
            size--;
            return t;
        }else{
            System.out.println("Stack Is Empty");
            return 0;
        }
    }

    public void peek(){
        if(!isEmpty()){
            System.out.println(arr[first - 1]);
        }else{
            System.out.println("Stack Is Empty");
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
       return size == MaxSize;
    }

}