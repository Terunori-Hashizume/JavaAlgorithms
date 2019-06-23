package number;

import java.util.HashMap;
import java.util.Map;

public class Prime {
    static Map<Integer, Integer> primeDivision(int n) {
        Map<Integer, Integer> factors = new HashMap<>();

        for (int base = 2; base * base <= n; ++base) {
            int exp = 0;
            while (n % base == 0) {
                n /= base;
                exp++;
            }
            factors.put(base, exp);
        }
        if (n > 1)
            factors.put(n, 1);

        return factors;
    }

    static boolean isPrime(int n) {
        for (int i = 2; i * i < n; ++i) {
            if (n % i == 0)
                return false;
        }
        return n > 1;
    }
}
