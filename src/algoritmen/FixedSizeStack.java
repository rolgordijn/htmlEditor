/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmen;

/**
 * This stack only keeps track of the last n items pushed onto it. When the
 * stack is full, the oldest element in it will be replaced when a new element
 * is pushed onto it
 *
 * @author Rian De Rous
 */
public class FixedSizeStack implements Stack {

    private Object[] list;
    private int writeIndex;
    private final int size;

    public FixedSizeStack(int size) {
        list = new Object[size];
        this.size = size;
        writeIndex = 0;
    }

    @Override
    public void push(Object element) {
        list[writeIndex % size] = element;
        writeIndex++;
        System.out.println("------------------- \r\npush \r\n" + element + "at" + (writeIndex % size));
    }

    @Override
    public Object top() {
        if (size == 0) {
            throw new StackEmptyException();
        }
        System.out.println("------------------- \r\ntop" + (String) list[writeIndex % size] + "\n\r at index" + writeIndex % size + "------------------- \r\n");
        if ((writeIndex - 1) % size > 0) {
            return list[(writeIndex - 1) % size];
        }else{
            writeIndex=50;
            return list[(writeIndex - 1) % size];
        }
    }

    public Object pop() {
        if (isEmpty()) {
            throw new StackEmptyException();
        }
        Object O = list[(writeIndex - 1) % size];
        list[writeIndex % size] = null;
        if (writeIndex == 0) {
            writeIndex = size - 1;
        } else {
            writeIndex--;
        }
        System.out.println("pop" + (String) O);
        return O;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;

    }

    @Override
    public int size() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (list[i] != null) {
                count++;
            }
        }
        return count;
    }

}
