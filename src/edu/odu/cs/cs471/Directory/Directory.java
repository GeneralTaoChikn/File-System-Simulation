package edu.odu.cs.cs471.Directory;

import java.util.ArrayList;
import java.util.List;

import edu.odu.cs.cs471.Files.*;

/**
 * Directory class object file
 * @author Christopher Diasanta
 *
 */
public class Directory {
	
	private String dirName;
	private List<File> files;

	
	/**
	 * Default Constructor
	 */
	public Directory() {
		setDirName("root");
		setFiles(new ArrayList<File> ());
	}
	
	/**
	 * Constructor
	 * @param name
	 * @param parent
	 */
	public Directory(String name) {
		setDirName(name);
		setFiles(new ArrayList<File> ());

	}

//======================================================================
	public void setName(String name) {
		this.setDirName(name);
	}

	public String getDirName() {
		return dirName;
	}

	public void setDirName(String dirName) {
		this.dirName = dirName;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	/**
	 * Add file to Directory
	 * @param file
	 */
	public void addFile(File file) {
		files.add(file);
	}
	
	public void deleteFile(String toDelete) {
		File ptr = null;
		for (File file: files) {
			if ((file.getFileName()+file.getFileExtension()) == toDelete) {
					ptr = file;
			}		
		}
		files.remove(ptr);
	}
	
	public String print(String toPrint) {
		File ptr = null;
		for (File file: files) {
			if ((file.getFileName()+file.getFileExtension()) == toPrint) {
				ptr = file;
				return ptr.toString();
			}
		}
		return null;
		
	}
	
}
