package edu.odu.cs.cs471.VirtualFileSystem;
import edu.odu.cs.cs471.Drive.*;

public class VirtualSystem {
	
	protected Drive A;
	protected Drive B;
	protected Drive C;
	
	/**
	 * Default Constructor
	 */
	public VirtualSystem() {
		setA(new Drive("A"));
		setB(new Drive("B"));
		setC(new Drive("C"));
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
	

}
