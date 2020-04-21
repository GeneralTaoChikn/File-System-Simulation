package edu.odu.cs.cs471.VirtualFileSystem;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import edu.odu.cs.cs471.Directory.Directory;
import edu.odu.cs.cs471.Files.File;

/**
 * Child class of Virtual System
 * populate File System
 * @author Chris
 *
 */
public class PopulateVFS extends VirtualSystem {
	
	public static VirtualSystem populate() {
		VirtualSystem System = new VirtualSystem();
		
		File filler = new File("ebay", ".txt", 
					"Steps to becoming a small-scale e-commerce manager");	
		//TODO Prepopulate a Virtual System

		System.A.getDirList().get(0).getFiles().add(new File("Crap", ".exe", "Absolute Garbage"));
		System.B.getDirList().get(0).getFiles().add(new File("Bullocks", ".jar", "Absolute Garbage"));
		System.C.getDirList().get(0).getFiles().add(new File("[Object]", "object", "Error"));
				
		for (int i = 0; i < 6; i++) {
			
			Directory Ai = new Directory("A"+(i+1));
			Ai.addFile(filler);
			System.A.addDirectory(Ai);
			
			Directory Bi = new Directory("B"+(i+1));
			Bi.addFile(filler);
			System.B.addDirectory(Bi);
			
			Directory Ci = new Directory("C"+(i+1));
			Ci.addFile(filler);
			System.C.addDirectory(Ci);
			
		}	
		return System;
	}
	
	
	
	//TODO Find way to use a tree TOO.
//	public static JTree PopTree(VirtualSystem Sys) {
	public static DefaultTreeModel PopTree(VirtualSystem Sys) {

		DefaultTreeModel tree;
		
		//Set virtual file system as root
		DefaultMutableTreeNode root = new DefaultMutableTreeNode (Sys.System);
		
		//Set Main branches of Tree as Drives
		DefaultMutableTreeNode DriveA = new DefaultMutableTreeNode(Sys.A.getDriveName());
		DefaultMutableTreeNode DriveB = new DefaultMutableTreeNode(Sys.B.getDriveName());
		DefaultMutableTreeNode DriveC = new DefaultMutableTreeNode(Sys.C.getDriveName());
		
		for(Directory d : Sys.A.getDirList()) {
			DefaultMutableTreeNode A = new DefaultMutableTreeNode(d.getDirName());
			for (File toAdd : d.getFiles()) {
				A.add(new DefaultMutableTreeNode(toAdd.getFileName()+toAdd.getFileExtension()));
			}
			DriveA.add(A);
		}
		
		for(Directory d : Sys.B.getDirList()) {
			DefaultMutableTreeNode B = new DefaultMutableTreeNode(d.getDirName());
			for (File toAdd : d.getFiles()) {
				B.add(new DefaultMutableTreeNode(toAdd.getFileName()+toAdd.getFileExtension()));
			}
			DriveB.add(B);
		}

		for(Directory d : Sys.C.getDirList()) {
			DefaultMutableTreeNode C = new DefaultMutableTreeNode(d.getDirName());
			for (File toAdd : d.getFiles()) {
				C.add(new DefaultMutableTreeNode(toAdd.getFileName()+toAdd.getFileExtension()));
			}
			DriveC.add(C);
		}

		root.add(DriveA);
		root.add(DriveB);
		root.add(DriveC);
		tree = new DefaultTreeModel(root);
		return tree;
	}

}
