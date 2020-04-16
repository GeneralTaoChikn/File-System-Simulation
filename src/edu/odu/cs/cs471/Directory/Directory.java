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
	private int depth;
	private Directory Previous;
	private Directory Link;
	
	/**
	 * Default Constructor
	 */
	public Directory() {
		setPrevious(null);
		setDirName("root");
		setFiles(null);
		depth = 0;
		
		setLink(new Directory(""));
	}
	
	/**
	 * Constructor
	 * @param name
	 * @param parent
	 */
	public Directory(String name) {
		setPrevious(null);
		setPrevious(this);
		setDirName(name);
		setFiles(new ArrayList<File> ());
		depth = this.depth + 1;
		
		//Restrict depth to 4
		if (this.depth > 5)
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

	public Directory getPrevious() {
		return Previous;
	}

	public void setPrevious(Directory previous) {
		Previous = previous;
	}
	
	/**
	 * Add file to Directory
	 * @param file
	 */
	public void addFile(File file) {
		this.files.add(file);
	}
	
}
