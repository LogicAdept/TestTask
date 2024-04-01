import java.util.ArrayDeque;
import java.util.Deque;

class Consumer {
    private final Deque<long[]> queue = new ArrayDeque<>();
    private long sum = 0;

    /**
     * Called periodically to consume an integer.
     */
    public void accept(int number) {
        long currentTime = System.currentTimeMillis();
        queue.add(new long[]{number, currentTime});
        sum += number;
    }

    /**
     * Returns the mean (aka average) of numbers consumed in the
     * last 5 minutes period.
     */
    public double mean() {
        long currentTime = System.currentTimeMillis();
        while (!queue.isEmpty() && currentTime - queue.peek()[1] > 300000) {
            sum -= queue.poll()[0];
        }
        return queue.isEmpty() ? 0 : (double) sum / queue.size();
    }
}