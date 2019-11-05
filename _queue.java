//Queue Practice


public class _queue {

    int[] arr = null;
    int MaxSize;
    int front;
    int rear;
    int size;

    public _queue(int data){
        MaxSize = data;
        arr = new int[MaxSize];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enQueue(int num){
        if(!isFull()){
        arr[rear] = num;
        rear++;
        size++;
         }else{
             System.out.println("Queue Is Full");
         }

        }

    public int deQueue(){
        if(!isEmpty()){
            int temp = arr[front];
            arr[front] = front + 1;
            front = (front + 1) % MaxSize;
            size--;
            return temp;
        }else{
            System.out.println("Queue Is Empty");
            return 0;
        }
    }

    public void showAll(){
        System.out.print("Queue List: ");
        for(int i = 0; i < size; i++){
            System.out.print(arr[(front + i) % MaxSize] + " ");
        }
    }
    
    
    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == MaxSize;
    }
}