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
//	public static JTree PopTree(VirtualSystem Sys) {
	public static DefaultTreeModel PopTree(VirtualSystem Sys) {
//		JTree tree2Return;
//		tree2Return = new JTree(tree);
		DefaultTreeModel tree;
		DefaultMutableTreeNode root = new DefaultMutableTreeNode (Sys.System);
		DefaultMutableTreeNode DriveA = new DefaultMutableTreeNode(Sys.A.getDriveName());
		DefaultMutableTreeNode DriveB = new DefaultMutableTreeNode(Sys.B.getDriveName());
		DefaultMutableTreeNode DriveC = new DefaultMutableTreeNode(Sys.C.getDriveName());


		int i = 1;
		do {
			
			//Build Branch A
//			if (!Sys.A.getDirectory(i).getDirName().equals("")) {
			DefaultMutableTreeNode A = new DefaultMutableTreeNode(Sys.A.getDirectory(i).getDirName());
			
			if ((!(Sys.A.getDirectory(i).getFiles()).equals(null)))
				for (File toAdd : Sys.A.getDirectory(i).getFiles()) {
					A.add(new DefaultMutableTreeNode(toAdd));
				
				}
//			}
			
			//Build Branch B
//			if (!Sys.B.getDirectory(i).getDirName().equals("")) {
			DefaultMutableTreeNode B = new DefaultMutableTreeNode(Sys.B.getDirectory(i).getDirName());
			
			if (!Sys.B.getDirectory(i).getFiles().equals(null))
				for (File toAdd : Sys.B.getDirectory(i).getFiles()) {
					B.add(new DefaultMutableTreeNode(toAdd));
				
				}
//			}
			
			//Build Branch C
//			if (!Sys.C.getDirectory(i).getDirName().equals("")) {
			DefaultMutableTreeNode C = new DefaultMutableTreeNode(Sys.C.getDirectory(i).getDirName());
			
			if (!Sys.C.getDirectory(i).getFiles().equals(null))
				for (File toAdd : Sys.C.getDirectory(i).getFiles()) {
					C.add(new DefaultMutableTreeNode(toAdd));
				
				}
//			}
			
//			DriveA.getLastLeaf().add(new DefaultMutableTreeNode(Sys.A.getDirectory(i).getDirName()));
//			DriveB.getLastLeaf().add(new DefaultMutableTreeNode(Sys.B.getDirectory(i).getDirName()));
//			DriveC.getLastLeaf().add(new DefaultMutableTreeNode(Sys.C.getDirectory(i).getDirName()));
			
			DriveA.getLastLeaf().add(new DefaultMutableTreeNode(A));
			DriveB.getLastLeaf().add(new DefaultMutableTreeNode(B));
			DriveC.getLastLeaf().add(new DefaultMutableTreeNode(C));
			i++;
		}while( i != 6 );
		
		root.add(DriveA);
		root.add(DriveB);
		root.add(DriveC);
		tree = new DefaultTreeModel(root);
		return tree;
	}

}
