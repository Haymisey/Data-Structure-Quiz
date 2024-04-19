import java.util.Stack;
public class Main{

    public static class QueueUsingStacks {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public QueueUsingStacks() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void enqueue(int x) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

            stack1.push(x);

            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        public int dequeue() {
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int x = stack1.peek();
            stack1.pop();
            return x;
        }
    }

    public static class LinearQueue {
        private int front, rear;
        private int size;
        private int[] queue;
        private Stack sc;

        public LinearQueue(int size) {
            front = -1;
            rear = -1;
            this.size = size;
            queue = new int[size];
        }

        public void enqueue(int item) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
            } else {
                if (front == -1)
                    front = 0;
                queue[++rear] = item;
            }
        }

        public int dequeue() {
            if (front == -1 || front > rear) {
                System.out.println("Queue is empty");
                return -1;
            } else {
                int item = queue[front++];
                if (front > rear) {
                    front = -1;
                    rear = -1;
                }
                return item;
            }
        }
    }

    public static class CircularQueue {
        private int front, rear;
        private int size;
        private int[] queue;

        public CircularQueue(int size) {
            front = -1;
            rear = -1;
            this.size = size;
            queue = new int[size];
        }

        public void enqueue(int item) {
            if ((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1))) {
                System.out.println("Queue is full");
            } else {
                if (front == -1) front = 0;
                rear = (rear + 1) % size;
                queue[rear] = item;
            }
        }

        public int dequeue() {
            if (front == -1) {
                System.out.println("Queue is empty");
                return -1;
            } else {
                int item = queue[front];
                if (front == rear) {
                    front = -1;
                    rear = -1;
                } else {
                    front = (front + 1) % size;
                }
                return item;
            }
        }
    }


    public static void main(String[] args) {
                LinearQueue lq = new LinearQueue(5);
                lq.enqueue(9);
                lq.enqueue(2);
                lq.enqueue(3);
        System.out.println(lq.dequeue());
        System.out.println();
                CircularQueue cq = new CircularQueue(5);
                cq.enqueue(10);
                cq.enqueue(2);
                cq.enqueue(3);
        System.out.println(cq.dequeue());
        System.out.println();
                QueueUsingStacks qs= new QueueUsingStacks();
                qs.enqueue(14);
                qs.enqueue(3);
                qs.enqueue(7);
        System.out.println(qs.dequeue());
        System.out.println(qs.dequeue());




    }
}