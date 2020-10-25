package UI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MousePanel extends ImgPanel//JPanel
{
	public PictureArea pictureArea ;//显示图片的标签并且可以画图
   
    boolean mark;

   

    public MousePanel() {
    	pictureArea=new PictureArea();
    	this.setLayout(null);
		
	    // pictureArea = new JLabel();
	     pictureArea.setBackground(Color.BLACK);
	     pictureArea.setForeground(Color.BLUE);
		pictureArea.setBounds(14, 13, 1080, 466);
		pictureArea.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black),BorderFactory.createLineBorder(Color.black)) );//为标签加上边框
		//getContentPane().add(pictureArea);
		
    	
    	pictureArea.addMouseListener(new MouseListener() {
            //mouseClicked():
            public void mouseClicked(MouseEvent e) {

                //x_pos = e.getX();
                //y_pos = e.getY();
                //repaint();
            }

            //mouseEntered():
            public void mouseEntered(MouseEvent e) {
            }

            //mouseExited():
            public void mouseExited(MouseEvent e) {
            }

            //mousePressed():
            public void mousePressed(MouseEvent e) {
            	//repaint();
               pictureArea.x_pos=e.getX();
               pictureArea.y_pos=e.getY();
                System.out.println(pictureArea.x_pos+","+pictureArea.y_pos);
               

            }

            //mouseReleased():
            public void mouseReleased(MouseEvent e) {
           
            	pictureArea.x_2=e.getX();
            	pictureArea.y_2=e.getY();
                   repaint();
            }
        });
        pictureArea.addMouseMotionListener(new MouseMotionListener() {
            public void mouseMoved(MouseEvent e) {
            }

            public void mouseDragged(MouseEvent e) {
            }
        });
        this.add(pictureArea);
    }

    
}
