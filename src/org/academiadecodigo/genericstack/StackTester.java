package org.academiadecodigo.genericstack;

/**
 * Created by codecadet on 20/10/16.
 */
public class StackTester {

    public static void main(String[] args) {

        StackTester test = new StackTester();

        test.assertCondition("Add data to the stack", test.testAdd());
        test.assertCondition("Pop from the stack", test.testPop());
        test.assertCondition("Check the peek and the empty stack", test.testEmpty());


        /*BetterStack<Integer> stack = new BetterStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);


        //stack.printStack();

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.isEmpty());

        System.out.println(stack.peek());

        stack.clear();

        System.out.println(stack.isEmpty());

        System.out.println(stack.peek());

        */

    }

    public boolean testAdd(){

        // Preparation
        BetterStack<Integer> stack = new BetterStack();

        // Empty stack should contain zero elements
        if (stack.size() != 0) {
            return false;
        }

        // Stack with one element should have size of one
        stack.push(new Integer(1));
        if (stack.size() != 1) {
            return false;
        }

        // Stack with two elements should have size of two
        stack.push(new Integer(2));
        if (stack.size() != 2) {
            return false;
        }

        // stack with three elements should have size of three
        stack.push(new Integer(3));
        if (stack.size() != 3) {
            return false;
        }

        return true;
    }

    public boolean testPop() {

        // Preparation
        BetterStack stack = new BetterStack();
        Object data1 = new Integer(1);
        Object data2 = new Integer(2);
        Object data3 = new Integer(3);

        // Tests with empty list
        if (stack.pop() != null) {
            return false;
        }

        // Tests with one element
        stack.push(data1);
        if (!data1.equals(stack.pop())) {
            return false;
        }

        // Tests with two elements
        stack.push(data1);
        stack.push(data2);
        if (!data2.equals(stack.pop())) {
            return false;
        }

        if (!data1.equals(stack.pop())) {
            return false;
        }

        // Tests with three elements
        stack.push(data1);
        stack.push(data2);
        stack.push(data3);

        if(!data3.equals(stack.pop()))
            return false;

        if (!data2.equals(stack.pop())) {
            return false;
        }

        if (!data1.equals(stack.pop())) {
            return false;
        }

        return true;

    }

    public boolean testEmpty() {

        // Preparation
        BetterStack stack = new BetterStack();
        Object data1 = new Integer(1);
        Object data2 = new Integer(2);
        Object data3 = new Integer(3);
        Object data4 = new Integer(4);

        //Check for empty stack
        if(!stack.isEmpty())
            return false;

        //Test pop with empty stack
        if(stack.pop() != null)
            return false;

        stack.push(data1);
        stack.push(data2);
        stack.push(data3);
        stack.push(data4);

        if(!data4.equals(stack.pop()))
            return false;

        if(!data3.equals(stack.pop()))
            return false;

        //test the peek
        if(!data2.equals(stack.peek()))
            return false;

        if(stack.isEmpty())
            return false;

        stack.clear();

        if(!stack.isEmpty())
            return false;

        return true;
    }

    private void assertCondition(String test, boolean result) {

        System.out.println(test + ": " + (result ? "OK" : "FAIL"));

    }
}
