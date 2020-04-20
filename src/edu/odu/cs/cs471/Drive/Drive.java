package edu.odu.cs.cs471.Drive;

import java.util.List;

import edu.odu.cs.cs471.Directory.*;
import edu.odu.cs.cs471.Files.*;

/**
 * Drive object class file
 * @author Christopher Diasanta
 *
 */
public class Drive {
	
	private String driveName;
	private Directory root;
	
	/**
	 * Default Constructor
	 */
	public Drive() {
		setDriveName("");
		setRoot(new Directory());
	}
	
	/**
	 * Constructor
	 * @param name
	 */
	public Drive(String name) {
		setDriveName(name);
		setRoot(new Directory());
	}

//======================================================================
	public String getDriveName() {
		return driveName;
	}

	public void setDriveName(String driveName) {
		this.driveName = driveName;
	}

	public Directory getRoot() {
		return root;
	}

	public void setRoot(Directory root) {
		this.root = root;
	}
	
	/**
	 * Retrieve Nested Directory
	 * @param i
	 * @return nested directory
	 */
	public Directory getDirectory(int i) {
		
		switch(i) {
		case 0:
			return this.root;
		case 1:
			return this.root.getLink();
		case 2:
			return this.root.getLink().getLink();
		case 3:
			return this.root.getLink().getLink().getLink();
		case 4:
			return this.root.getLink().getLink().getLink().getLink();
		case 5:
			return this.root.getLink().getLink().getLink().getLink().getLink();
		default:
			return null;
		}
	}
	
	public List<File> getFileList(String Name) {
		Directory pointer = null;
		pointer = this.root;
		do {
			if (pointer.getDirName() == Name) {
				return pointer.getFiles();
			}
			pointer = pointer.getLink();
			
		}while(pointer != null);
		
		return null;
		
//		for(File file: this.root.getFiles()) {
//			
//		}
//		
//		return pointer.getFiles();
	}
	
	public Directory getdir(String Name) {
		Directory pointer = null;
		pointer = this.root;
		do {
			if (pointer.getDirName() == Name) {
				return pointer;
			}
			pointer = pointer.getLink();
			
		}while(pointer != null);
		
		return null;
		
//		for(File file: this.root.getFiles()) {
//			
//		}
//		
//		return pointer.getFiles();
	}
	
}
