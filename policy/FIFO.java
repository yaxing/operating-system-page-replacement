package policy;

import java.util.*;

import main.Memory;

/**
 * FIFO
 * @author Yaxing Chen
 *
 */
public class FIFO extends Policy{
	
	private ArrayList<Integer> queue;
	
	public FIFO() {
		super();
		this.queue = new ArrayList<Integer>();
		return;
	}
	
	@Override
	public void accessPage(int pageN) {
		if(queue.contains(pageN)) {
			return;
		}
		queue.add(pageN);
		return;
	}
	
	@Override
	public void replacePage(int pageN) {
		if(queue.size() == 0) {
			return;
		}
		Memory.replacePage(queue.get(0), pageN);
		queue.remove(0);
		queue.add(pageN);
		return;
	}
}
