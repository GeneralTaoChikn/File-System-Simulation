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
		
		//TODO Prepopulate a Virtual System
		System.A.getRoot().setLink(new Directory("A1"));
		System.B.getRoot().setLink(new Directory("B1"));
		System.C.getRoot().setLink(new Directory("C1"));
		
		System.A.getRoot().addFile(new File("Crap", ".exe", "Absolute Garbage"));
		System.B.getRoot().addFile(new File("Bullocks", ".jar", "Absolute Garbage"));
		System.C.getRoot().addFile(new File("[Object]", "object", "Error"));

		
		for (int i = 1; i < 6; i++) {
			System.A.getDirectory(i).setLink(new Directory("A" + (i+1)));
//			System.A.getDirectory(i).addFile(new File(i, "ebay", ".txt", 
//					"Steps to becoming a small-scale e-commerce manager"));
			System.A.getDirectory(i).addFile(new File( "ebay", ".txt", 
					"Steps to becoming a small-scale e-commerce manager"));
			System.B.getDirectory(i).setLink(new Directory("B" + (i+1)));
			System.B.getDirectory(i).addFile(new File( "ebay", ".txt", 
					"Steps to becoming a small-scale e-commerce manager"));
			System.C.getDirectory(i).setLink(new Directory("C" + (i+1)));
			System.C.getDirectory(i).addFile(new File( "ebay", ".txt", 
					"Steps to becoming a small-scale e-commerce manager"));
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


		int i = 0;
		do {
					
			//Build Branch A
			DefaultMutableTreeNode A = new DefaultMutableTreeNode(Sys.A.getDirectory(i).getDirName());
			for (File toAdd : Sys.A.getDirectory(i).getFiles()) {
				A.add(new DefaultMutableTreeNode(toAdd.getFileName()+toAdd.getFileExtension()));
			}
			
				
			//Build Branch B
			DefaultMutableTreeNode B = new DefaultMutableTreeNode(Sys.B.getDirectory(i).getDirName());
			for (File toAdd : Sys.B.getDirectory(i).getFiles()) {
				B.add(new DefaultMutableTreeNode(toAdd.getFileName()+toAdd.getFileExtension()));				
			}

			
				
			//Build Branch C
			DefaultMutableTreeNode C = new DefaultMutableTreeNode(Sys.C.getDirectory(i).getDirName());
			for (File toAdd : Sys.C.getDirectory(i).getFiles()) {
				C.add(new DefaultMutableTreeNode(toAdd.getFileName()+toAdd.getFileExtension()));
			}

			DriveA.add(A);
			DriveB.add(B);
			DriveC.add(C);
		
			i++;
			
		}while( i != 6 );
		
		root.add(DriveA);
		root.add(DriveB);
		root.add(DriveC);
		tree = new DefaultTreeModel(root);
		return tree;
	}

}
