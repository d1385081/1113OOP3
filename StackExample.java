class MyStack<T> {

    private Object[] stack;  // 不改變變數名稱
    private int top;         // 指向下一個可放元素的位置

    public MyStack() {
        stack = new Object[10]; // 初始容量
        top = 0;
    }

    public void push(T item) {
        if (top == stack.length) {
            expandCapacity();
        }
        stack[top++] = item;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        T item = (T) stack[--top];
        stack[top] = null; // 避免記憶體洩漏
        return item;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int size() {
        return top;
    }

    private void expandCapacity() {
        Object[] newStack = new Object[stack.length * 2];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }
}


public class StackExample {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        // 可自行測試
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Pop: " + stack.pop()); // 30
        System.out.println("Pop: " + stack.pop()); // 20
        System.out.println("Size: " + stack.size()); // 1
    }
}



//我的Junit測試會測這個Object，這邊以下請不要修改
//---------------------------------------------------------------------------------
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
//---------------------------------------------------------------------------------