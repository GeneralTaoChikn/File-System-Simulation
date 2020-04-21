package edu.odu.cs.cs471.Files;

/**
 * File class object file
 * @author Christopher Diasanta
 *
 */
public class File {
	
//	private int i_node;
	private String fileName;
	private String fileExtension;
	private String Uniqlo;
	
	/**
	 * Default Constructor
	 */
	public File() {
//		i_node = -1;
		fileName = "";
		fileExtension = "";
		Uniqlo = "";
	}
	
//	public File (int node, String name, String extension, String content) {
	public File (String name, String extension, String content) {
//		i_node = node;
		fileName = name;
		fileExtension = extension;
		Uniqlo = "-- " + content;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public String getFileExtension() {
		return fileExtension;
	}
	
	/**
	 * override
	 */
	public String toString() {
		return fileName + fileExtension +
				'\n' + Uniqlo;
		
	}
}
