package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PatternUtils<E> {
	private int[] indexes;
	private List<E> original;
	private List<List<E>> pattern;
	
	public PatternUtils(List<E> l) {
		this.original = l;
		this.indexes = new int[original.size()];
		for (int i = 0; i < original.size(); ++i) indexes[i] = i;
	}
	
	void search(int[] perm, Stack<E> stack, int rem) {
		if (rem == 0 || perm.length == 0) {
			pattern.add(new ArrayList<>(stack));
		} else {
			int[] nperm = Arrays.copyOfRange(perm, 1, perm.length);
			for (int i = 0; i < perm.length; ++i) {
				stack.push(original.get(perm[i]));
				search(nperm, stack, rem - 1);
				if (i < nperm.length) nperm[i] = perm[i];
				stack.pop();
			}
		}
	}
	
	List<List<E>> permutation(int n) {
		pattern = new ArrayList<>();
		
		search(indexes, new Stack<>(), n);
		
		return pattern;
	}
	
	void csearch(int[] perm, Stack<E> stack, int rem, int prevIdx) {
		if (rem == 0 || perm.length == 0) {
			pattern.add(new ArrayList<>(stack));
		} else {
			int[] nperm = Arrays.copyOfRange(perm, 1, perm.length);
			for (int i = 0; i < perm.length; ++i) {
				stack.push(original.get(perm[i]));
				if (perm[i] > prevIdx) 
					csearch(nperm, stack, rem - 1, perm[i]);
				if (i < nperm.length) nperm[i] = perm[i];
				stack.pop();
			}
		}
	}
	
	List<List<E>> combination(int n) {
		pattern = new ArrayList<>();
		
		csearch(indexes, new Stack<>(), n, -1);
		
		return pattern;
	}
}