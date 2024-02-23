package Basics;

public class Sum {
    private int start;
    private int end;
    private long sum = 0;
    public Sum(int start, int end) {
        this.start = start;
        this.end = end;
    }
    public void add(){
        for (int i = start; i < end; i++) {
            sum += i;
        }
    }
    public long getSum(){
        return this.sum;
    }
}
