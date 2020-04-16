package hackerrank.util;

import java.math.BigInteger;

public class Compute {
    public static BigInteger nCr(final int N, final int K) {
        BigInteger ret = BigInteger.ONE;
        for (int k = 0; k < Math.min(N-K, K); k++) {
            ret = ret.multiply(BigInteger.valueOf(N-k))
                    .divide(BigInteger.valueOf(k+1));
        }
        return ret;
    }

}
