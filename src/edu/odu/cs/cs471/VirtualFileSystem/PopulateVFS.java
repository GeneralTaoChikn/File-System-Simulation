package edu.odu.cs.cs471.VirtualFileSystem;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import edu.odu.cs.cs471.Directory.Directory;
import edu.odu.cs.cs471.Files.File;
import javafx.util.Pair;
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
		
		for (int i = 1; i < 5; i++) {
			System.A.getDirectory(i).setLink(new Directory("A" + (i+1)));
			System.B.getDirectory(i).setLink(new Directory("B" + (i+1)));
			System.C.getDirectory(i).setLink(new Directory("C" + (i+1)));
		}
		
		System.A.getDirectory(2).addFile(new File(2, "ebay", ".txt", 
				"Steps to becoming a small-scale e-commerce manager"));
		
		return System;
	}
	
	
	
	//TODO Find way to use a tree TOO.
//	public static JTree PopTree(VirtualSystem Sys) {
	public static DefaultTreeModel PopTree(VirtualSystem Sys) {

		DefaultTreeModel tree;
		DefaultMutableTreeNode root = new DefaultMutableTreeNode (Sys.System);
		DefaultMutableTreeNode DriveA = new DefaultMutableTreeNode(Sys.A.getDriveName());
		DefaultMutableTreeNode DriveB = new DefaultMutableTreeNode(Sys.B.getDriveName());
		DefaultMutableTreeNode DriveC = new DefaultMutableTreeNode(Sys.C.getDriveName());


		int i = 1;
		do {
			
			Pair <String,Directory> Apair = new Pair <String, Directory> (Sys.A.getDirectory(i).getDirName(), Sys.A.getDirectory(i));
			List<File> FilePointer = null;
			
			//Build Branch A
//			if (!Sys.A.getDirectory(i).getDirName().equals("")) {
			DefaultMutableTreeNode A = new DefaultMutableTreeNode(Apair);
//			DefaultMutableTreeNode A = new DefaultMutableTreeNode(Sys.A.getDirectory(i).getDirName());
//			DefaultMutableTreeNode A = new DefaultMutableTreeNode(Sys.A.getDirectory(i).getDirName());
//			if ((!(Sys.A.getDirectory(i).getFiles()).equals(null)))
				for (File toAdd : Sys.A.getDirectory(i).getFiles()) {
					A.add(new DefaultMutableTreeNode(toAdd));
					A.add(new DefaultMutableTreeNode(toAdd.toString()));		
				}
//			}
			
			//Build Branch B
//			if (!Sys.B.getDirectory(i).getDirName().equals("")) {
			DefaultMutableTreeNode B = new DefaultMutableTreeNode(Sys.B.getDirectory(i).getDirName());
			
//			if (!Sys.B.getDirectory(i).getFiles().equals(null))
				for (File toAdd : Sys.B.getDirectory(i).getFiles()) {
					B.add(new DefaultMutableTreeNode(toAdd.toString()));
//					B.add(new DefaultMutableTreeNode(toAdd));
				
				}
//			}
			
			//Build Branch C
//			if (!Sys.C.getDirectory(i).getDirName().equals("")) {
			DefaultMutableTreeNode C = new DefaultMutableTreeNode(Sys.C.getDirectory(i).getDirName());
			
//			if (!Sys.C.getDirectory(i).getFiles().equals(null))
				for (File toAdd : Sys.C.getDirectory(i).getFiles()) {
					C.add(new DefaultMutableTreeNode(toAdd));
				
				}
//			}

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
