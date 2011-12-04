package main;

import java.io.*;

/**
 * output class
 * @author Yaxing Chen(N16929794)
 *
 */
public class Output {
	private static StringBuilder buffer = new StringBuilder();
	
	public static void writeBuffer(String info) {
		buffer.append(info + "\n");
	}
	
	public static void flushBuffer(String fileName) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			out.write(buffer.toString());
			out.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
