import sort.BaseHelper;
import sort.Helper;
import sort.SortWithHelper;
import sort.simple.InsertionSort;
import util.Benchmark;
import util.Benchmark_Timer;

public class Test {
    public static void main(String[] args) {
        for (int i = 1000; i <= 64000; i = i * 2) {
            Helper<Integer> helper = new BaseHelper<>("InsertionSort", i);
            helper.init(i);
            SortWithHelper<Integer> sorter = new InsertionSort<Integer>(helper);
            int finalI = i;
            Integer[] xs = helper.random(Integer.class, r -> r.nextInt(finalI));
            Benchmark<Boolean> bm = new Benchmark_Timer<>(
                    "InsertionSortBenchmark",null, b -> sorter.sort(xs),null);
            double x = bm.run(true, 10);
            System.out.println("The time cost for sorting " + i + " integers is: " + x);
        }
    }
}
