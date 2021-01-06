package lesson3;

public class Lesson3 {
    public static void main(String[] args) {
    }

    private static void testDeque1() {
        Deque<Integer> deque = new Deque<>(10);

        deque.pushFrontValue(861);
        deque.pushFrontValue(-819);
        System.out.println(deque.popBack());
        System.out.println(deque.popBack());
    }

    private static void testDeque2() {
        Deque<Integer> deque = new Deque<>(10);

        deque.pushFrontValue(-201);
        deque.pushBackValue(959);
        deque.pushBackValue(102);
        deque.pushFrontValue(20);
        System.out.println(deque.popFront());
        System.out.println(deque.popBack());
    }

    private static void testStack() {
        Stack<Integer> stack = new Stack<>();

        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
    }

    private static void testQueue() {
        Queue<Integer> queue = new Queue<>();

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);

        System.out.println(String.format("Размер очереди: %d", queue.size()));
        System.out.println(queue.poll());
        System.out.println(String.format("Размер очереди: %d", queue.size()));
        System.out.println(queue.poll());
        System.out.println(String.format("Размер очереди: %d", queue.size()));
        System.out.println(queue.poll());
        System.out.println(String.format("Размер очереди: %d", queue.size()));
        System.out.println(queue.poll());
        System.out.println(String.format("Размер очереди: %d", queue.size()));


        queue.insert(5);
        queue.insert(6);

        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(String.format("Размер очереди: %d", queue.size()));
    }
}
