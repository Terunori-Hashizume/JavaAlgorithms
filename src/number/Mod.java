package number;

public class Mod {
	private int mod;
	
	Mod(int mod) {
		this.mod = mod;
	}
	
	public long add(long a, long b) {
		return (a + b) % mod;
	}
	
	public long mul(long a, long b) {
		return a * b % mod;
	}
	
	public long pow(long a, long n) {
		if (n == 0) return 1;
		else if (n == 1) return a;
		else {
			long sq = pow(a, n/2);
			long ret = mul(sq, sq);
			if (n % 2 != 0) ret = mul(ret, a);
			return ret;
		}
	}
	
	public long div(long a, long b) {
		return mul(a, pow(b, mod - 2));
	}
}
