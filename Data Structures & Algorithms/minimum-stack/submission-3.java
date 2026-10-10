class MinStack {
    List<Integer> list;
    Queue<Integer> queue;
    public MinStack() {
        list = new ArrayList<>();
        queue = new PriorityQueue<>();
    }
    
    public void push(int val) {
        list.add(val);
        queue.add(val);
    }
    
    public void pop() {
        int removedValue = list.remove(list.size()-1);
        queue.remove(removedValue);
    }
    
    public int top() {
        return list.get(list.size()-1);
    }
    
    public int getMin() {
        System.out.println(queue);
        return queue.peek();
    }
}
