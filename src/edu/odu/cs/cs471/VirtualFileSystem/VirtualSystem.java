package edu.odu.cs.cs471.VirtualFileSystem;

import edu.odu.cs.cs471.Drive.*;

public class VirtualSystem {
	
	protected String System;
	protected Drive A;
	protected Drive B;
	protected Drive C;
	protected String WorkingDirectory;
	protected String WorkingDrive;
	
	/**
	 * Default Constructor
	 */
	public VirtualSystem() {
		System = "CHRIS-desktop";
		setA(new Drive("A"));
		setB(new Drive("B"));
		setC(new Drive("C"));
		setWorkingDirectory("C");
		setWorkingDrive("A1");
		
	}

//======================================================================
	public Drive getA() {
		return A;
	}

	public void setA(Drive a) {
		A = a;
	}
	
	public Drive getB() {
		return B;
	}

	public void setB(Drive b) {
		B = b;
	}

	public Drive getC() {
		return C;
	}

	public void setC(Drive c) {
		C = c;
	}
	
	public String getSystem() {
		return this.System;
	}
	
	public void setWorkingDirectory(String work) {
		WorkingDirectory = work;
	}
	
	public void setWorkingDrive(String drive) {
		WorkingDrive = drive;
	}
	
	public String getWorkingDirectory () {
		return WorkingDirectory;
	}
	
	public String getWorkingDrive () {
		return WorkingDrive;
	}
	public Drive get(String N) {
		switch(N) {
		case "A":
			return getA();
		case "B":
			return getB();
		case "C":
			return getC();
		default:
			return null;
			
		}
	}

}
