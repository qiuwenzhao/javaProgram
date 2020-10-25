package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileView;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class testFrame extends JFrame {
	private JFileChooser chooser;
	/**
	 * @wbp.nonvisual location=-21,14
	 */
	//private final JPanel panel_1 = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow frame = new mainWindow();
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
	public testFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1140, 650);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1, 0, 0};
		gridBagLayout.rowHeights = new int[]{1, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel label_1 = new JLabel("");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		getContentPane().add(label_1, gbc_label_1);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 20;
		gbc_panel.gridheight = 30;
		gbc_panel.gridx = 1;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		
		chooser=new JFileChooser();
		chooser.setCurrentDirectory(new File("D:\\新建文件夹\\" ));
		FileNameExtensionFilter filter=new FileNameExtensionFilter("Image Files","jpg","jpeg","gif");
		chooser.setFileFilter(filter);
		chooser.setMultiSelectionEnabled(true);
		
	}
}
