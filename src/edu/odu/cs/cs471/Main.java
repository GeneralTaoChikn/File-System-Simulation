package edu.odu.cs.cs471;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JTree;

import edu.odu.cs.cs471.Directory.Directory;
import edu.odu.cs.cs471.Files.File;
import edu.odu.cs.cs471.VirtualFileSystem.PopulateVFS;
import edu.odu.cs.cs471.VirtualFileSystem.VirtualSystem;
import javafx.util.Pair;

import javax.swing.JTextPane;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;


import javax.swing.event.TreeSelectionEvent;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 675);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		VirtualSystem System;
		System = PopulateVFS.populate();
		DefaultListModel <File> files = new DefaultListModel<File> (); 
		
		JTree tree = new JTree(PopulateVFS.PopTree(System));
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				Pair <String, Directory> selected = (Pair <String, Directory>)e.getPath().getLastPathComponent();
				
				files = (DefaultListModel<File>) selected.getValue().getFiles();

			}
		});
		tree.setBounds(12, 13, 251, 419);
		frame.getContentPane().add(tree);
		
		JList FileListViewer = new JList(files);
		FileListViewer.setBounds(291, 32, 306, 400);
		frame.getContentPane().add(FileListViewer);
				
	}
}
