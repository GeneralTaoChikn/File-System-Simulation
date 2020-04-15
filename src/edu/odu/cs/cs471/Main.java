package edu.odu.cs.cs471;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTree;

import edu.odu.cs.cs471.VirtualFileSystem.PopulateVFS;
import edu.odu.cs.cs471.VirtualFileSystem.VirtualSystem;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//import edu.odu.cs.cs471.VirtualFileSystem.*;	

public class Main {

	private JFrame frame;
	//VirtualSystem system = new VirtualSystem();

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
		
		JTree tree = new JTree(PopulateVFS.PopTree(System));
		tree.setBounds(12, 13, 410, 419);
		frame.getContentPane().add(tree);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(516, 24, 351, 351);
		frame.getContentPane().add(textArea);
		
	}
}
