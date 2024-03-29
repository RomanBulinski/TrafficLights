

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class TestMain {

//    private static void doTest(String initial, String[] expected, int n) {
//        String got[] = Main.trafficLights(initial, n);
//        assertEquals("Result array length", expected.length, got.length);
//
//        int errIdx = -1;
//        for (int i = 0; i < got.length; i++) {
//            if (!expected[i].equals(got[i])) { errIdx = i; break; }
//        }
//
//        System.out.println("Expected:");
//        for (int i = 0; i < expected.length; i++) {
//            System.out.println(String.format("%03d %s", i, Common.display(expected[i])));
//        }
//
//        if (errIdx >= 0) {
//            System.out.println("\nYour result:");
//            for (int i = 0; i < got.length; i++) {
//                System.out.println(String.format("%03d %s", i, Common.display(got[i])));
//            }
//            fail(String.format("A difference was detected at index %d", errIdx));
//        }
//    }
//
//    @Test
//    public void example() {
//        int n = 10;
//        String sim[] = {
//                "C...R............G......",  // 0
//                ".C..R............G......",  // 1
//                "..C.R............G......",  // 2
//                "...CR............G......",  // 3
//                "...CR............G......",  // 4
//                "....C............O......",  // 5
//                "....GC...........R......",  // 6
//                "....G.C..........R......",  // 7
//                "....G..C.........R......",  // 8
//                "....G...C........R......",  // 9
//                "....O....C.......R......"   // 10
//        };
//        doTest(sim[0], sim, n);
//    }


    @Test
    public void light(){
        String start = "C..R..G";
        String end = "....O............R";
        assertEquals(end, Main.trafficLights(start,20));
    }

    @Test
    public void light2(){
        String start = "C..R.G...";
        String end = "....O............R";
        assertEquals(end, Main.trafficLights(start,20));
    }

    @Test
    public void light3(){
        String start = "C..";
        String end = "....O............R";
        assertEquals(end, Main.trafficLights(start,20));
    }


}
