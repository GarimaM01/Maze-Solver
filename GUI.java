/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Meteor
 */
public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MazePanel mazePane;
	private JMenuBar menuBar;
	private JMenu game;
	private JMenu level;
	private JMenuItem[] levels;
	private JMenu help;
	private JMenu computer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setSize(645, 692);
		setResizable(false);

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Maze Game");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(15,15,15,15));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// Menu Bar
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// Menu
		game = new JMenu("Play Game");
		level = new JMenu("Level");
		computer = new JMenu("Computer");
				
		menuBar.add(game);
		menuBar.add(level);
		menuBar.add(computer);
		

		JMenuItem newGame = new JMenuItem(new AbstractAction("New Game") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				mazePane.refresh(mazePane.getCellsMaze());
				repaint();
			}
		});

		JMenuItem restart = new JMenuItem(new AbstractAction("Restart Game") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});

		JMenuItem hint = new JMenuItem(new AbstractAction("Hint") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				mazePane.hint();
			}
		});

		JMenuItem autoMove = new JMenuItem(new AbstractAction("Auto Move") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				mazePane.autoMove((Graphics2D) mazePane.getGraphics());
			}
		});

		JMenuItem algorithm = new JMenuItem(new AbstractAction("Algorithm") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				mazePane.algorithm((Graphics2D) mazePane.getGraphics());
			}
		});
		
		levels = new JMenuItem[10];
		for(int i = 0; i < levels.length; i++) {
			levels[i] = new JMenuItem("Level " + (i + 1));
			levels[i].setActionCommand((i + 1) + "");
			levels[i].addActionListener(new LevelsAction());
			level.add(levels[i]);
		};

		game.add(newGame);
		game.add(restart);
		game.add(hint);

		computer.add(autoMove);
		computer.add(algorithm);
		
		

		mazePane = new MazePanel(11);
		contentPane.add(mazePane, BorderLayout.CENTER);
	}
	
	class LevelsAction extends AbstractAction{
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			int number = Integer.valueOf(e.getActionCommand()) * 10 + 1;
//			System.out.println(number);
			mazePane.refresh(number);
			repaint();
		}
		
	}
}
