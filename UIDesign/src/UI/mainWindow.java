package UI;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileView;

import UI.MousePanel;

import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Color;

public class mainWindow extends JFrame {
	//private JLabel pictureArea ;//��ʾͼƬ�ı�ǩ
	private JFileChooser chooser;//�ļ�ѡ����
     ArrayList<String> imgList;//����ͼƬ�ľ���·��
     private MousePanel mousePanel;//һ�����Լ�����궯�� ������;
     private int currtIndex=0;//ָʾ��ǰ�б��ֵ
     int mark;//�������ѡ���˵ڼ���
    
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
	public mainWindow() {
		//�����ļ����е�ַ�ĳ�ʼ������
		imgList=new ArrayList();
		
		
		mousePanel = new MousePanel();
		//mousePanel.add(pictureArea);
		mousePanel.setBounds(14, 34, 1094, 479);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1140, 650);
		getContentPane().setLayout(null);
		
		//��������;
		
		JButton savePoint = new JButton("\u4FDD\u5B58\u5750\u6807");
		savePoint.setBounds(435, 526, 100, 46);
		try {
			savePoint.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mousePanel.pictureArea.mark=1;
					mousePanel.repaint();
					 try {


				            //���ļ�
				            File f = new File("D:\\test\\" + "result" + ".txt");
				            if (!f.exists()) {
				                f.createNewFile();
				            }
				            FileWriter fw = new FileWriter(f,true);
				            fw.write("[" + mousePanel.pictureArea.x_pos + "," + mousePanel.pictureArea.y_pos + "],[" + mousePanel.pictureArea.x_2 + "," + mousePanel.pictureArea.x_2 + "]"+"\n");
				            //fw.flush();
				              fw.close();
				        } catch (IOException e1) {
				            // TODO Auto-generated catch block
				            e1.printStackTrace();
				        }
					 
				}
			    Robot rbt = new Robot();
			    Point p =new Point(mousePanel.pictureArea.getX(),mousePanel.pictureArea.getY());
			           //  rbt.mousePress(InputEvent.BUTTON1_MASK);
			});
		} catch (AWTException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		getContentPane().add(savePoint);
		
		//�����ת��һ��ͼ��
		JButton nextImage = new JButton("\u4E0B\u4E00\u4E2A\u56FE\u50CF");
		nextImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mousePanel.pictureArea.mark=1;
				mousePanel.repaint();
				if(currtIndex>=imgList.size()-1) {
			         return;
					}
				mousePanel.pictureArea.setIcon(null);
				currtIndex++;
				ImageIcon picture=new ImageIcon(imgList.get(currtIndex));
				picture.setImage(picture.getImage().getScaledInstance(mousePanel.pictureArea.getWidth(),mousePanel.pictureArea.getHeight(),Image.SCALE_DEFAULT));
				mousePanel.pictureArea.setIcon(picture);
			
			}
		});
		
		
		
		
		
		nextImage.setBounds(582, 526, 150, 46);
		getContentPane().add(nextImage);
	     
		getContentPane().add(mousePanel);
		//getContentPane().add(pictureArea);
		
		JButton openSingleFile = new JButton("\u6253\u5F00\u5355\u4E2A\u6587\u4EF6");
		openSingleFile.addActionListener(new ActionListener() {
               
            //����һ��������
			public void actionPerformed(ActionEvent arg0) {
				
				      importSingleFile();
				      //mousePanel.add(pictureArea);
				     // mousePanel.setVisible(true);
				
			}
			private void importSingleFile() {
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int result=chooser.showOpenDialog(mainWindow.this);
				if(result==JFileChooser.APPROVE_OPTION) {
				
					String name=chooser.getSelectedFile().getPath();
					System.out.println(name);
					ImageIcon picture=new ImageIcon(name);
					picture.setImage(picture.getImage().getScaledInstance(mousePanel.pictureArea.getWidth(),mousePanel.pictureArea.getHeight(),Image.SCALE_DEFAULT));
					mousePanel.pictureArea.setIcon(picture);
					
					//��������ļ��еĵ���
					File file1 = new File(name);
					File file=file1.getParentFile();
					System.out.println(file.getAbsolutePath());
					if (file.isDirectory()) {
						   //currtIndex++;
					        System.out.println("�ļ�");
					        String[] filelist = file.list();
					        for (int i = 0; i < filelist.length; i++) {
					                File readfile = new File(file.getAbsolutePath()+"\\"+filelist[i] );
					               // System.out.println(readfile.getAbsolutePath());
					                if (!readfile.isDirectory()) {
					                	 //System.out.println(readfile.getAbsolutePath());
					                     imgList.add(readfile.getAbsolutePath());

					                } else if (readfile.isDirectory()) {
					                        continue;//������ļ���������
					                }
					        }

					}
					
			
					
				}
			}
		});
		
		openSingleFile.setBounds(25, 526, 150, 46);
		getContentPane().add(openSingleFile);
		
		chooser=new JFileChooser();
		chooser.setCurrentDirectory(new File("D:\\�½��ļ���\\" ));
		FileNameExtensionFilter filter=new FileNameExtensionFilter("Image Files","jpg","jpeg","gif");
		chooser.setFileFilter(filter);
		chooser.setMultiSelectionEnabled(true);
		
		JButton chooseDirectory = new JButton("\u9009\u62E9\u6587\u4EF6\u5939");
		chooseDirectory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int result=chooser.showOpenDialog(mainWindow.this);
				if(result==JFileChooser.APPROVE_OPTION) {
					String name=chooser.getSelectedFile().getPath();
					System.out.println(name);
					
					//��������ļ�������ļ�����
					
					File file = new File(name);
					if (file.isDirectory()) {
					      //  System.out.println("�ļ���");
					        String[] filelist = file.list();
					        for (int i = 0; i < filelist.length; i++) {
					                File readfile = new File(name + "\\" + filelist[i]);
					                if (!readfile.isDirectory()) {
					                     imgList.add(readfile.getPath());

					                } else if (readfile.isDirectory()) {
					                        continue;//������ļ���������
					                }
					        }

					}
					//��ʾimgList�е��ļ�
				
					ImageIcon picture=new ImageIcon(imgList.get(currtIndex));
					picture.setImage(picture.getImage().getScaledInstance(mousePanel.pictureArea.getWidth(),mousePanel.pictureArea.getHeight(),Image.SCALE_DEFAULT));
					mousePanel.pictureArea.setIcon(picture);
               
				    
				    
					
			
					
				}
			}
		});
		chooseDirectory.setBounds(214, 526, 150, 46);
		getContentPane().add(chooseDirectory);
		
		JPanel panel = new JPanel();
		panel.setBounds(57, 66, 339, 224);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
	}
}
