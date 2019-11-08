/*
Author: Mohammed Bekhouche
Date: 11/7/2019

Discription: the program presents an implementation of a generic stack that 
uses a linkedList.The program allow us to access entries on a first-in, 
last-out basis.
 */
package genericstackapp;

import java.util.*;

class GenericStack<T> {

    private LinkedList<T> list = new LinkedList<>();

    public int getSize() {
        return list.size();
    }

    public T pop() {
        T object = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return object;
    }

    public T peek() {
        return list.get(getSize() - 1);
    }

    public void push(T x) {
        list.add(x);
    }

}

public class GenericStackApp {

    public static void main(String[] args) {
        GenericStack<String> shapes = new GenericStack<>();
        shapes.push("circle");
        System.out.println("push:circle");

        shapes.push("square");
        System.out.println("push:square");

        shapes.push("triangle");
        System.out.println("push:triangle");

        System.out.println("the stack contains: " + shapes.getSize() + " items \n");
        System.out.println(shapes.peek());
        System.out.println("the stack contains: " + shapes.getSize() + " items \n");
        int stackSize = shapes.getSize();

        for (int i = 0; i < stackSize; i++) {
            System.out.println("pop: " + shapes.pop());
        }

        System.out.println("the stack contains: " + shapes.getSize() + " items ");
    }
}
