package main;

import java.util.*;
import java.io.*;
import policy.*;
import java.text.DecimalFormat;;

/**
 * 
 * memory management simulator
 * 
 * @author Yaxing Chen(N16929794)
 *
 */


public class Mmu {
	
	/**
	 * read file get page accesses
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> input(String file) {
		ArrayList<Integer> access = new ArrayList<Integer>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String buffer = "";
			while((buffer = in.readLine()) != null) {
				access.add(Integer.parseInt(buffer));
			}
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return access;
	}
	
	public void output(double rate) {
		DecimalFormat format = new DecimalFormat("#0.00");
		String info = "\nPrecentage of page faults: " + format.format(rate);
		System.out.println(info);
		Output.writeBuffer(info);
	}
	
	
	/**
	 * start paging
	 * @param ArrayList<Integer> access
	 * @return double page fault percentage
	 */
	protected double paging(ArrayList<Integer> access, Policy policy) {
		double accessN = 0;
		double pageFN = 0;
		for(Integer pageN : access) {
			accessN += 1.0;
			if(Memory.checkPage(pageN) >= 0) {
				policy.accessPage(pageN);
			}
			else if(Memory.putPage(pageN)) {
				policy.accessPage(pageN);
				pageFN += 1.0;
			}
			else {
				policy.replacePage(pageN);
				policy.accessPage(pageN);
				pageFN += 1.0;
			}
			Memory.printMemory();
		}
		return pageFN / accessN;
	}
	
	public static void main(String[] args) {
		Mmu ctrl = new Mmu();
		ArrayList<Integer> access = null;
		int policyN = Integer.parseInt(args[0]);
		int memSize = Integer.parseInt(args[1]);
		Memory.initMem(memSize);
		access = ctrl.input(args[2]);
		double rate = ctrl.paging(access, PolicyFactory.genPolicy(policyN));
		ctrl.output(rate);
		Output.flushBuffer("output");
	}
}
