package edu.odu.cs.cs471.Directory;

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
	private int depth;
	private Directory Link;
	
	/**
	 * Default Constructor
	 */
	public Directory() {
		setDirName("root");
		setFiles(null);
		depth = 0;
		
		setLink(new Directory("", this));
	}
	
	/**
	 * Constructor
	 * @param name
	 * @param parent
	 */
	public Directory(String name, Directory parent) {
		setDirName(name);
		setFiles(null);
		depth = parent.depth + 1;
		
		//Restrict depth to 4
		if (parent.depth > 5)
			setLink(new Directory());
		else
			setLink(null);
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

	public Directory getLink() {
		return Link;
	}

	public void setLink(Directory link) {
		Link = link;
	}
	
}
