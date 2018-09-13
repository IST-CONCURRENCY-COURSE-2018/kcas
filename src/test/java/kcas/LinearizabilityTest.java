package kcas;


import com.devexperts.dxlab.lincheck.LinChecker;
import com.devexperts.dxlab.lincheck.annotations.Operation;
import com.devexperts.dxlab.lincheck.annotations.Param;
import com.devexperts.dxlab.lincheck.paramgen.IntGen;
import com.devexperts.dxlab.lincheck.strategy.stress.StressCTest;
import org.junit.Test;


@StressCTest
@Param(name = "index", gen = IntGen.class, conf = "0:3")
@Param(name = "value", gen = IntGen.class, conf = "0:1")
public class LinearizabilityTest {
    private AtomicArray<Integer> a = new AtomicArray<>(10);

    @Operation
    public void set(@Param(name = "index") int i, @Param(name = "value") Integer x) {
        a.set(i, x);
    }

    @Operation
    public Integer get(@Param(name = "index") int i) {
        return a.get(i);
    }

    @Operation
    public boolean cas(@Param(name = "index") int i,
                       @Param(name = "value") int exp, @Param(name = "value") int upd) {
        return a.cas(i, exp, upd);
    }

    @Operation
    public boolean cas2(@Param(name = "index") int i1,
                        @Param(name = "value") int exp1, @Param(name = "value") int upd1,
                        @Param(name = "index") int i2,
                        @Param(name = "value") int exp2, @Param(name = "value") int upd2) {
        return a.cas2(i1, exp1, upd1, i2, exp2, upd2);
    }

    @Operation
    public boolean cas2_2(@Param(name = "index") int i1,
                        @Param(name = "value") int exp1, @Param(name = "value") int upd1,
                        @Param(name = "index") int i2,
                        @Param(name = "value") int exp2, @Param(name = "value") int upd2) {
        return a.cas2(i1, exp1, upd1, i2, exp2, upd2);
    }

    @Operation
    public boolean cas2_3(@Param(name = "index") int i1,
                        @Param(name = "value") int exp1, @Param(name = "value") int upd1,
                        @Param(name = "index") int i2,
                        @Param(name = "value") int exp2, @Param(name = "value") int upd2) {
        return a.cas2(i1, exp1, upd1, i2, exp2, upd2);
    }

    @Operation
    public boolean cas2_4(@Param(name = "index") int i1,
                        @Param(name = "value") int exp1, @Param(name = "value") int upd1,
                        @Param(name = "index") int i2,
                        @Param(name = "value") int exp2, @Param(name = "value") int upd2) {
        return a.cas2(i1, exp1, upd1, i2, exp2, upd2);
    }

    @Test
    public void test() {
        LinChecker.check(LinearizabilityTest.class);
    }
}