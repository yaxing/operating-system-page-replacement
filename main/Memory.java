package main;

/**
 * Singleton memory
 * @author Yaxing Chen(N16929796)
 *
 */
public class Memory {
	private static int[] memory;
	
	/**
	 * pointer to the first free address in memory
	 * if(free Index == -1) ==> memory is full
	 */
	private static int freeIndex = 0;
	
	public static void initMem(int size) {
		memory = new int[size];
		for(int i = 0; i < size; i ++) {
			memory[i] = -1;
		}
	}
	
	public static int[] getMem() {
		return memory;
	}
	
	public static void printMemory() {
		StringBuilder buffer = new StringBuilder();
		for(int i = 0; i < memory.length; i ++) {
			if(memory[i] < 0) {
				break;
			}
			//System.out.print(memory[i] + " ");
			buffer.append(memory[i] + " ");
		}
		String tmp = buffer.toString();
		System.out.println(tmp);
		Output.writeBuffer(tmp);
	}
	
	/**
	 * replace page in addr as pageNo
	 * @param addr memory offset
	 * @param pageNo page #
	 */
	public static void replacePage(int oldPage, int pageNo) {
		int addr = -1;
		if((addr = checkPage(oldPage)) >= 0) {
			memory[addr] = pageNo;
		}
		return;
	}
	
	
	/**
	 * put page into memory
	 * @param pageN
	 */
	public static boolean putPage(int pageN) {
		if(freeIndex == -1) {
			return false;
		}
		memory[freeIndex] = pageN;
		if(++ freeIndex >= memory.length) {
			freeIndex = -1;
		}
		return true;
	}
	
	/**
	 * check whether a page exist in memory
	 * @return int page index or -1 
	 */
	public static int checkPage(int pageN) {
		for(int i = 0; i < memory.length; i ++) {
			if(memory[i] == pageN) {
				return i;
			}
		}
		return -1;
	}
	
	
}
