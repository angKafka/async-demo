import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class EvenOddByThread {
    private static Object object =new Object();
    private static IntPredicate evenPredicate = e -> e % 2 == 0;
    private static IntPredicate oddPredicate = e -> e % 2 != 0;

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(()->EvenOddByThread.printEvenOddByThread(oddPredicate));
        CompletableFuture.runAsync(()->EvenOddByThread.printEvenOddByThread(evenPredicate));
        Thread.sleep(1000);
    }

    public static void printEvenOddByThread(IntPredicate predicate) {
        IntStream.rangeClosed(1, 10).filter(predicate).forEach(EvenOddByThread::execute);
    }


    public static void execute(int num){
        synchronized (object) {
          try {
              System.out.println(Thread.currentThread().getName()+" : "+num);
              object.notify();
              object.wait();
          }catch (InterruptedException e){
              e.printStackTrace();
          }
        }
    }
}
