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
import javax.swing.tree.DefaultTreeModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.JTextField;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	private JTextField EnterFileName;

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
		String [] fileExtensions = { ".exe" ,".txt" , ".docx", ".jar"};
		PopulateVFS Tree = new PopulateVFS ();
		DefaultTreeModel t;
		Tree.updateTree(System);
		t = Tree.getTree();
		
		
//		JTree tree = new JTree(PopulateVFS.PopTree(System));
		JTree tree = new JTree(t);
		tree.addTreeExpansionListener(new TreeExpansionListener() {
			public void treeCollapsed(TreeExpansionEvent arg0) {
				files.clear();
			}
			public void treeExpanded(TreeExpansionEvent arg0) {
				files.clear();
				//get directory name
				String DirList = arg0.getPath().getLastPathComponent().toString();
				//return drive
				String n = (arg0.getPath().getParentPath().getLastPathComponent().toString());
				List<File> toCopy = System.get(n).getFileList(DirList);
				for (File file: toCopy) {
					files.addElement(file);
				}
			}
		});
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				files.clear();
				EnterFileName.setText("");
//				e.getPath().getLastPathComponent().toString();
				
				//Set Working Directory--Stores Directory name
				System.setWorkingDirectory(e.getPath().getLastPathComponent().toString());
				//Set Working Drive--Stores Drive aName
				System.setWorkingDrive(e.getPath().getParentPath().getLastPathComponent().toString());

				
			}
		});
		tree.setBounds(12, 13, 251, 419);
		frame.getContentPane().add(tree);
		
		JList <File> FileListViewer = new JList <File>(files);
		FileListViewer.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
			}
		});
		FileListViewer.setBounds(291, 13, 306, 419);
		frame.getContentPane().add(FileListViewer);
		
		EnterFileName = new JTextField();
		EnterFileName.setBounds(692, 331, 116, 22);
		frame.getContentPane().add(EnterFileName);
		EnterFileName.setColumns(10);
		
		JComboBox fileExtension = new JComboBox(fileExtensions);
		fileExtension.setBounds(857, 331, 94, 22);
		frame.getContentPane().add(fileExtension);
		
		JTextPane FileContents = new JTextPane();
		FileContents.setBounds(651, 13, 300, 271);
		frame.getContentPane().add(FileContents);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File (System.get(System.getWorkingDrive()).getdir(System.getWorkingDirectory()).getDepth(),
						EnterFileName.getText(), (String)fileExtension.getSelectedItem(), FileContents.getText());
				
				EnterFileName.setText("");
				FileContents.setText("");
				
				System.get(System.getWorkingDrive()).getFileList(System.getWorkingDirectory()).add(file);
				
				Tree.updateTree(System);
				
			}
		});
		btnSave.setBounds(854, 379, 97, 25);
		frame.getContentPane().add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnDelete.setBounds(500, 457, 97, 25);
		frame.getContentPane().add(btnDelete);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnPrint.setBounds(301, 457, 97, 25);
		frame.getContentPane().add(btnPrint);
		
		JButton btnRefreshTree = new JButton("Refresh Tree");
		btnRefreshTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Tree.updateTree(System);
				t = Tree.getTree();
				
			}
		});
		btnRefreshTree.setBounds(132, 457, 131, 25);
		frame.getContentPane().add(btnRefreshTree);
				
	}
}
