package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        /* Create the AList for test addLast function */
        AList<Integer> al1 = new AList<Integer>();

        /* Three lists for store the results */
        AList<Integer> Ns = new AList<Integer>();
        AList<Double> times = new AList<Double>();
        AList<Integer> opCounts = new AList<Integer>();

        int stopPoint = 1000;
        double timeSeconds = 0.0;

        Stopwatch sw = new Stopwatch();

        for (int i = 0; i < 128000; i++){
            if (i == stopPoint - 1){
                timeSeconds = sw.elapsedTime();
                Ns.addLast(stopPoint);
                times.addLast(timeSeconds);
                opCounts.addLast(stopPoint);
                stopPoint = stopPoint * 2;
            }
            al1.addLast(i);
        }
        printTimingTable(Ns, times, opCounts);

    }
}
