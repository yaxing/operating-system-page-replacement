package policy;

import java.util.*;

import main.Memory;


/**
 * Second chance policy
 * @author Yaxing Chen(N16929794)
 *
 */
public class SecChance  extends Policy{
	
	private ArrayList<SecChancePageEnty> queue;
	
	public SecChance() {
		super();
		this.queue = new ArrayList<SecChancePageEnty>();
	}
	
	@Override
	public void accessPage(int pageN) {
		for(SecChancePageEnty entity : queue) {
			if(entity.pageN == pageN) {
				entity.r = true;
				return;
			}
		}
		queue.add(new SecChancePageEnty(pageN, false));
		return;
	}
	
	@Override
	public void replacePage(int pageN) {
		int counter = queue.size();
		while(counter >= 0) {
			SecChancePageEnty oldest = queue.get(0);
			if(!oldest.r) {
				Memory.replacePage(oldest.pageN, pageN);
				queue.remove(0);
				break;
			}
			else {
				oldest.r = false;
				queue.remove(0);
				queue.add(oldest);
			}
		}
	}
}
