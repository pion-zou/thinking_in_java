package collection;


import java.util.*;

public class StackCollision {
    public static void main(String[] args) {
        util.Stack<String> stack = new util.Stack<String>();
        String dog = "My dog has fleas";
        for (String s : dog.split(" ")) {
            stack.push(s);
        }
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

        java.util.Stack<String> stack2 = new Stack<>();

        for(String s : "My dog has fleas".split(" ")){
            stack2.push(s);

        }

        while (!stack2.empty()){
            System.out.print(stack2.pop() + " ");
        }

    }

}
