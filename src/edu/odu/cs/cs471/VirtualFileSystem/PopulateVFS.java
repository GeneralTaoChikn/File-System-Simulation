package edu.odu.cs.cs471.VirtualFileSystem;

import javax.swing.JTree;

import edu.odu.cs.cs471.Directory.Directory;
/**
 * Child class of Virtual System
 * populate File System
 * @author Chris
 *
 */
public class PopulateVFS extends VirtualSystem {
	
	public static VirtualSystem populate() {
		VirtualSystem System = new VirtualSystem();
		
		//TODO Prepopulate a Virtual System
		System.A.getRoot().setLink(new Directory("A1"));
		System.A.getDirectory(1).setLink(new Directory("A2"));
		System.A.getDirectory(2).setLink(new Directory("A3"));
		System.A.getDirectory(3).setLink(new Directory("A4"));
		System.A.getDirectory(4).setLink(new Directory("A5"));
		
		System.B.getRoot().setLink(new Directory("B1"));
		System.B.getDirectory(1).setLink(new Directory("B2"));
		System.B.getDirectory(2).setLink(new Directory("B3"));
		System.B.getDirectory(3).setLink(new Directory("B4"));
		System.B.getDirectory(4).setLink(new Directory("B5"));
		
		System.C.getRoot().setLink(new Directory("C1"));
		System.C.getDirectory(1).setLink(new Directory("C2"));
		System.C.getDirectory(2).setLink(new Directory("C3"));
		System.C.getDirectory(3).setLink(new Directory("C4"));
		System.C.getDirectory(4).setLink(new Directory("C5"));

		return System;
	}
	
	
	
	//TODO Find way to use a tree TOO.
	public static JTree PrePopTree() {
		JTree tree = new JTree();
		
		
		
		
		
		return tree;
	}

}
