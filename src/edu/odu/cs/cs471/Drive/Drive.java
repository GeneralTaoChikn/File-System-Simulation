package edu.odu.cs.cs471.Drive;

import edu.odu.cs.cs471.Directory.*;

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
	
	
}
