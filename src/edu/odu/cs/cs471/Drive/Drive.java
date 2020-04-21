package edu.odu.cs.cs471.Drive;

import java.util.ArrayList;
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
	private List<Directory> DirectoryList;
	/**
	 * Default Constructor
	 */
	public Drive() {
		setDriveName("");
		DirectoryList = new ArrayList<Directory>();
	}
	
	/**
	 * Constructor
	 * @param name
	 */
	public Drive(String name) {
		setDriveName(name);
		DirectoryList = new ArrayList<Directory>();
		DirectoryList.add(new Directory("root"));
	}

//======================================================================
	public String getDriveName() {
		return driveName;
	}

	public void setDriveName(String driveName) {
		this.driveName = driveName;
	}

	public List<Directory>  getDirList(){
		return DirectoryList;
	}
	
	public void addDirectory(Directory toAdd) {
		DirectoryList.add(toAdd);
	}
	
	public List<File> findDirecFileList (String DirecName) {
		for(Directory ptr : DirectoryList) {
			if (ptr.getDirName() ==  DirecName) {
				return ptr.getFiles();
			}
		}
		return null;
	}
	
	
}
