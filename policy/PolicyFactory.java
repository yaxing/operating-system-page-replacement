package policy;

public class PolicyFactory {
	
	/**
	 * generate corresponding policy object
	 * @param mode
	 * @return
	 */
	public static Policy genPolicy(int mode) {
		switch(mode) {
		case 0:
			return new FIFO();
		case 1:
			return new SecChance();
		case 2:
			return new LRU();
		default:
			return null;
		}
	}
}
