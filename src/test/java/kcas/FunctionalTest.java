package kcas;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReferenceArray;

import static org.junit.Assert.assertEquals;

public class FunctionalTest {
    private static Random R = new Random(0);

    @Test
    public void test() {
        int N = 100;
        AtomicReferenceArray<Integer> expected = new AtomicReferenceArray<>(N);
        AtomicArray<Integer> cur = new AtomicArray<>(N);
        for (int t = 0; t < 1_000_000; t++) {
            int op = R.nextInt(4);
            switch (op) {
            case 0:
                // set
                int i = R.nextInt(N);
                int x = R.nextInt(10);
                expected.set(i, x);
                cur.set(i, x);
                break;
            case 1:
                // get
                i = R.nextInt(N);
                assertEquals(expected.get(i), cur.get(i));
                break;
            case 2:
                // cas
                i = R.nextInt(N);
                int exp = R.nextInt(10);
                int upd = R.nextInt(10);
                assertEquals(expected.compareAndSet(i, exp, upd), cur.cas(i, exp, upd));
                break;
            case 3:
                // cas2
                int i1 = R.nextInt(N);
                int exp1 = R.nextInt(10);
                int upd1 = R.nextInt(10);
                int i2 = R.nextInt(N);
                int exp2 = R.nextInt(10);
                int upd2 = R.nextInt(10);
                boolean curRes = cur.cas2(i1, exp1, upd1, i2, exp2, upd2);
                if (Objects.equals(expected.get(i1), exp1) && Objects.equals(expected.get(i2), exp2)) {
                    expected.set(i1, upd1);
                    expected.set(i2, upd2);
                    assertEquals(true, curRes);
                } else {
                    assertEquals(false, curRes);
                }
            }
        }
    }
}