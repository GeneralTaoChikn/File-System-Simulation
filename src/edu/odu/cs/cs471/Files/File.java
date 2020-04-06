package edu.odu.cs.cs471.Files;

/**
 * File class object file
 * @author Christopher Diasanta
 *
 */
public class File {
	
	private int i_node;
	private String fileName;
	private String fileExtension;
	private String Uniqlo;
	
	/**
	 * Default Constructor
	 */
	public File() {
		i_node = -1;
		fileName = "";
		fileExtension = "";
		Uniqlo = "";
	}
	
	/**
	 * Copy Constructor 
	 * @param copy
	 */
	public File (File copy) {
		this.i_node = copy.i_node;
		this.fileName = copy.fileName;
		this.fileExtension = copy.fileExtension;
		this.Uniqlo = copy.Uniqlo;
	}

}
