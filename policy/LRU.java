package policy;

import java.util.*;

import main.Memory;

/**
 * LRU policy
 * @author Yaxing Chen(N16929794)
 *
 */
public class LRU  extends Policy{
	// stack: 0 is stack top. 
	private ArrayList<Integer> stack;
	
	public LRU() {
		super();
		this.stack = new ArrayList<Integer>();
	}
	
	@Override
	public void accessPage(int pageN) {
		int addr = stack.indexOf(pageN); 
		if(addr >= 0) {
			stack.remove(addr);
		}
		stack.add(0, pageN);
	}
	
	@Override
	public void replacePage(int pageN) {
		if(stack.isEmpty()) {
			return;
		}
		stack.add(0, pageN);
		int tmp = stack.size() - 1;
		Memory.replacePage(stack.get(tmp), pageN);
		stack.remove(tmp);
	}
}
