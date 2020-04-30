public class _stack{

    int MaxSize = 0; //Maximum Size Of Array
    int length = 0; //Length Of Array
    int arr[]; //Initialize Array


    public int size(){
        return MaxSize; //Returns Size Of The Array
    }

    public boolean isEmpty(){
        return size() == 0; //If Size Is 0 Then Stack Is Empty
    }

    //Expand The Array To Enter More Data
    public void expand(){
        int arrlength = size();
        int[] newArray = new int[arrlength + 1]; //Initiliaze A New Array

        for(int i = 0; i < arrlength; i++){
            newArray[i] = arr[i];       //Iterate Through Array Amd Copy Over Data
        }

        arr = newArray; //Assign Array To New Array
    }


    //Shrink Array To Decrease Size
    public void shrink(){
        int arrlength = size();
        int[] newArray = new int[arrlength - 1]; //Initiliaze A New Array

        for(int i = 0; i < arrlength -1; i++){
            newArray[i] = arr[i];              //Iterate Through Array Amd Copy Over Data
        }
        arr = newArray;  //Assign Array To New Array
    }

    //Push Data Into Array
    public void push(int data){
        length++; //Adds One To Length For ArrayLength
        if(MaxSize == 0){
            arr = new int[MaxSize + 1];   //If 0 The Creates An Array And Adds Data
            arr[MaxSize] = data;
            MaxSize ++;
        }else{
        arr[length - 1] = data;  //If Not 0 Then Simply Adds Data To Existing Array
        MaxSize++;
        }

        expand(); //Then Expands The Array To Allow More Data
    }

    public int pop(){
        int removed = 0;
        if(isEmpty()){
            System.out.println("Stack Is Empty"); //If Stack Is Empty Then Print This
        }else{
            removed = arr[length - 1];      
            arr[length - 1] = 0;        //Turns That Index To Zero
            shrink();                   //Shrinks The Array
            length--;                   
            MaxSize--;
        }
        return removed;             //Return Removed Number
    }

    public void peek(){
        if(isEmpty()){
            System.out.println("Stack Is Empty");
        }else{
            int show = arr[length - 1];
            System.out.println(show);           //Show Most Recent Data Added To Stack
        }
    }

    public void showAll(){
        if(isEmpty()){
            System.out.println("Stack Is Empty");
        }else{
            System.out.print("Elements: ");
            for(int i = length-1; i >= 0; i--){
                System.out.print(arr[i] + " ");     //Print All Items In Stack
            }
        }
    }



}