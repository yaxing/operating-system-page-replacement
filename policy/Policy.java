package policy;


/**
 * 
 * Policy super class
 * @author Yaxing Chen(N16929794)
 *
 */

public abstract class Policy {
	
	public Policy() {
		
	}
	
	/**
	 * successfully accessed a page
	 * @param pageN
	 */
	public abstract void accessPage(int pageN);
	
	
	/**
	 * page fault handling
	 * @param pageN
	 */
	public abstract void replacePage(int pageN);
	
}
