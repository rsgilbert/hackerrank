package hackerrank.learning;

import org.junit.Test;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

import static junit.framework.TestCase.assertEquals;

public class ArrayDifferenceTest {
    public static <T> List<T> difStream(T[] input, BiFunction<T,T,T> operation) {
        List<T> output = new ArrayList<>();

        for (int i=0; i < input.length-1; i++) {
            output.add(operation.apply(input[i], input[i+1]));
        }

        return output;
    }

    public static void main(String[] args) {
        long[] array = new long[] { 1, 4, 6, 7};
    }

    @Test
    public void test_integer() {
        List<Integer> result = difStream(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)},
                Math::subtractExact);

        assertEquals(Arrays.asList(-1,-1), result);
    }

    @Test
    public void test_long() {
        List<Long> result = difStream(new Long[]{Long.valueOf(1), Long.valueOf(2), Long.valueOf(3)},
                Math::subtractExact);

        assertEquals(Arrays.asList(-1L,-1L), result);
    }

    @Test
    public void test_double() {
        List<Double> result = difStream(new Double[]{Double.valueOf(1), Double.valueOf(2), Double.valueOf(3)},
                ArrayDifferenceTest::substract);

        assertEquals(Arrays.asList(-1D,-1D), result);
    }

    static double substract(double d1, double d2) {
        return d1-d2;
    }

    @Test
    public void test_float() {
        List<Float> result = difStream(new Float[]{Float.valueOf(1F), Float.valueOf(2F), Float.valueOf(3F)},
                ArrayDifferenceTest::substract);

        assertEquals(Arrays.asList(-1F,-1F), result);
    }

    static float substract(float f1, float f2) {
        return f1-f2;
    }
}