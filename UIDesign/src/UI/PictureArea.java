package UI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class PictureArea extends JLabel {
	    int x_pos, y_pos;
	    int x_2,y_2;
	    int mark=0;
	    
	public void paintComponent(Graphics g) {
		//����һ��ר�������������ڻ�ͼ��ͨ��repaint����;
		
        super.paintComponent(g);
        //g.drawString("current location is:["+x_pos+","+y_pos+"]",x_pos,y_pos);//在界面上显示
        //System.out.printf("current location is:["+x_pos+","+y_pos+"]\n",x_pos,y_pos);//在控制台显示
        g.setColor(Color.RED);
        if(mark==1) {
			mark=0;
			return;
        }
        g.drawRect(x_pos , y_pos , x_2-x_pos, y_2-y_pos);
        //g.fillOval(x_pos,y_pos,8,8);


    }

}
