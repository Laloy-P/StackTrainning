
public class Main {

    public static void main(String[] args) {

    Stack s1 = new Stack(5);

    s1.puchMany("lapin blanc retard");
    s1.displayStack();
    s1.puch("Alice");
    s1.displayStack();
    s1.pop();
    s1.displayStack();
    System.out.println("top of stack is : "+s1.peek());

    if (s1.contains("retard")){
        System.out.println("true");
    }
    else {
        System.out.println("false");
    }

    s1.delete("lapin");
    s1.displayStack();


    }

}
