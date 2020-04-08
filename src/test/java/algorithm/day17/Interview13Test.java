package algorithm.day17;

import org.junit.Test;

public class Interview13Test {

    @Test
    public void movingCount() {
        Interview13 test = new Interview13();
        int count = test.movingCount(16, 8, 4);
        System.out.println(count);
    }
}
