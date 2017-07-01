import java.util.Arrays;

public class Stack {

    private String[] stackArray;

    private int stackSize;

    private int topOfStack = 0;

    Stack (int size){

        stackSize = size;
        stackArray = new String [stackSize];
        Arrays.fill(stackArray, null);
    }

    public void displayStack(){
        System.out.println(" ");
        for (int i = stackArray.length-1; i >=0; i--){

            System.out.println(stackArray[i]);
        }
        System.out.println(" ");
    }

    public void puch(String input){
        if (topOfStack < stackSize){

            //System.out.println(topOfStack);

            stackArray[topOfStack] = input;

            topOfStack++ ;

            //System.out.println("| PUSH ! | " + input + " was added");
        }
        else{
            System.out.println("\n| Stack overflow ! |");
        }

    }

    public void puchMany(String multipleValue){

        String []tempString  = multipleValue.split(" ");
        for (int i = 0 ; i< tempString.length;i++){

            puch(tempString[i]);

        }


    }

    public void pop(){
        if (topOfStack > 0){

            topOfStack --;
            //System.out.println("| POP ! | " + stackArray[topOfStack] + " removed");
            stackArray[topOfStack] = null;

        }
        else {
            System.out.println("\n| Stack empty ! |");

        }

    }

    public String peek(){
        //renvoie la valeur en haut de la pile
        if (topOfStack>0){
            return stackArray[topOfStack-1];
        }
        else{
            return null;
        }

    }

    public boolean contains(String value){

        Stack temp = new Stack(stackSize);
        boolean statement = false;

        //on dépile on regarde

        while (this.peek() != null){

            if (this.peek().equals(value)){
                statement = true;
            }

            temp.puch(this.peek());
            this.pop();
        }

        //on rempile
        while (temp.peek() != null){
            this.puch(temp.peek());
            temp.pop();

        }

        return statement;
    }

    public void delete(String value){

        //check si la valeur à supprimée est présente dans la pile

        if(this.contains(value)){

            Stack temp = new Stack(stackSize);
            while (this.peek() != null){

                if(this.peek().equals(value)) {
                    this.pop();
                }
                else {
                    temp.puch(this.peek());
                    this.pop();
                }
            }

            while(temp.peek()!=null){
                this.puch(temp.peek());
                temp.pop();

            }
            System.out.println(value + " successfully removed");
        }
        else{
            System.out.println("there is no \""+value+"\" in the stack");
        }

    }

}
