package number;

public class NumUtils {
    static int gcd(int a, int b) {
        return (a < b) ? gcd(b, a) : (b > 0) ? gcd(b, a % b) : a;
    }

    static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}
