package graph;

class UnionFind {
	private	int[] rank, parent;
	
	public UnionFind(int size) {
		this.rank = new int[size];
		this.parent = new int[size];
		for (int i = 0; i < size; ++i) {
			parent[i] = i;
			rank[i] = 0;
		}
	}
	
	public boolean same(int x, int y) {
		return root(x) == root(y);
	}
	
	public void unite(int x, int y) {
		int a = root(x);
		int b = root(y);
		
		if (rank[a] < rank[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		parent[b] = a;
		if (rank[a] == rank[b]) rank[a]++;
	}
	
	public int root (int x) {
		if (parent[x] != x) {
			parent[x] = root(parent[x]);
		}
		return parent[x];
	}
}