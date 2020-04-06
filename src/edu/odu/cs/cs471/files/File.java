package edu.odu.cs.cs471.files;

/**
 * Object File class
 * @author Chris
 *
 */
public class File {
	
	private int i_node;
	private String fileName;
	private String fileExtension;
	private String Uniqlo;
	
	public File() {
		i_node = -1;
		fileName = "";
		fileExtension = "";
		Uniqlo = "";
	}
	
	public File (File copy) {
		this.i_node = copy.i_node;
		this.fileName = copy.fileName;
		this.fileExtension = copy.fileExtension;
		this.Uniqlo = copy.Uniqlo;
	}

}
