package edu.odu.cs.cs471;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JTree;

import edu.odu.cs.cs471.Directory.Directory;
import edu.odu.cs.cs471.Files.File;
import edu.odu.cs.cs471.VirtualFileSystem.PopulateVFS;
import edu.odu.cs.cs471.VirtualFileSystem.VirtualSystem;

import javax.swing.JTextPane;
import javax.swing.JList;
import java.util.List;

import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.JTextField;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.SystemColor;

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
		
		JTextPane FileContents = new JTextPane();
		FileContents.setBounds(639, 41, 300, 304);
		frame.getContentPane().add(FileContents);
		
		JTree tree = new JTree(PopulateVFS.PopTree(System));
		tree.addTreeExpansionListener(new TreeExpansionListener() {
			public void treeCollapsed(TreeExpansionEvent e) {
				files.clear();
			}
			public void treeExpanded(TreeExpansionEvent e) {
				files.clear();
				EnterFileName.setText("");
//				e.getPath().getLastPathComponent().toString();
				
				//Set Working Directory--Stores Directory name
				System.setWorkingDirectory(e.getPath().getLastPathComponent().toString());
				//Set Working Drive--Stores Drive aName
				System.setWorkingDrive(e.getPath().getParentPath().getLastPathComponent().toString());
				
				
				//Show List
				files.clear();
				//get directory name
				String DirList = e.getPath().getLastPathComponent().toString();
				//return drive
				String n = (e.getPath().getParentPath().getLastPathComponent().toString());
				
				List<File> toCopy = System.get(n).findDirecFileList(DirList);
				for (File file: toCopy) {
					files.addElement(file);
				}//end File
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
				
				
				//Show List
				files.clear();
				//get directory name
				String DirList = e.getPath().getParentPath().getLastPathComponent().toString();
				//return drive
				String n = (e.getPath().getParentPath().getParentPath().getLastPathComponent().toString());
				
				String fileName = e.getPath().getLastPathComponent().toString();
				
				List<File> toCopy = System.get(n).findDirecFileList(DirList);
				for (File file: toCopy) {
					String nme = file.getFileName() + file.getFileExtension();
//					EnterFileName.setText(nme);
					if (nme.contentEquals(fileName)) {
						EnterFileName.setText(file.toString());
						FileContents.setText(file.toString());
					}
				}//end File

				
			}
		});
		tree.setBounds(12, 40, 278, 560);
		frame.getContentPane().add(tree);
		
		JList <File> FileListViewer = new JList <File>(files);
		FileListViewer.setBounds(325, 40, 271, 560);
		frame.getContentPane().add(FileListViewer);
		
		EnterFileName = new JTextField();
		EnterFileName.setBounds(639, 395, 116, 22);
		frame.getContentPane().add(EnterFileName);
		EnterFileName.setColumns(10);
		
//		JComboBox <String>fileExtension = new JComboBox<String>(fileExtensions);
		JComboBox fileExtension = new JComboBox(fileExtensions);
		fileExtension.setBounds(772, 395, 57, 22);
		frame.getContentPane().add(fileExtension);
		
		
		/**
		 * SAVE
		 */
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File (EnterFileName.getText(), 
						(String)fileExtension.getSelectedItem(), FileContents.getText());
				
				EnterFileName.setText("");
				FileContents.setText("");
				
				System.get(System.getWorkingDrive()).findDirecFileList(System.getWorkingDirectory()).add(file);
				
				// Add Node
				DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
				DefaultMutableTreeNode selectedNode;	
				selectedNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
				
				if (selectedNode != null) {
					selectedNode.insert(new DefaultMutableTreeNode(file.getFileName()+file.getFileExtension()), selectedNode.getIndex(selectedNode.getLastChild()));
				}
				model.reload(selectedNode);
								
			}
		});
		btnSave.setBounds(841, 394, 97, 25);
		frame.getContentPane().add(btnSave);
		
		/**
		 * DELETE
		 */
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//Delete Selected Node or File
				DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
				DefaultMutableTreeNode selectedNode;	
				selectedNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
				
				if (selectedNode !=null) {
					DefaultMutableTreeNode parent = (DefaultMutableTreeNode)selectedNode.getParent();
					parent.remove(selectedNode);;
					model.reload(parent);
				}
				
				
				String FileToDelete = selectedNode.toString();
				FileContents.setText(selectedNode.toString());
				
//				System.get(System.getWorkingDrive()).findDirecFileList(System.getWorkingDirectory())
				
				((Directory) System.get(selectedNode.getParent().getParent().toString())
					.findDirecFileList(selectedNode.getParent().toString()))
					.deleteFile(FileToDelete);
				
			}
		});
		btnDelete.setBounds(193, 9, 97, 25);
		frame.getContentPane().add(btnDelete);
		
		JLabel lblFileSystem = new JLabel("FILE SYSTEM");
		lblFileSystem.setBounds(12, 13, 97, 16);
		frame.getContentPane().add(lblFileSystem);
		
		JLabel lblListPreview = new JLabel("List Preview");
		lblListPreview.setBounds(325, 13, 105, 16);
		frame.getContentPane().add(lblListPreview);
		
		JLabel lblFileContents = new JLabel("File Contents");
		lblFileContents.setBounds(654, 13, 101, 16);
		frame.getContentPane().add(lblFileContents);
		
		JLabel lblFileName = new JLabel("File Name");
		lblFileName.setBounds(639, 373, 86, 16);
		frame.getContentPane().add(lblFileName);
		
		JTextPane Directions = new JTextPane();
		Directions.setEditable(false);
		Directions.setText("Directions: \nFileContents pane is used to save a file."
				+ "\nTo Save: Expand the directory you "
				+ "wish to save. \nTo Delete: select the file from Directory"
				+ " and hit delete. \nTo PrintFile: Simply click the file you "
				+ "wish to preview. \n \nNote: the middle pane is used for prev"
				+ "iewing files and shows when expanding/collapsing directories");
		Directions.setBackground(SystemColor.menu);
		Directions.setBounds(625, 448, 345, 148);
		frame.getContentPane().add(Directions);
		
			
	}
}
