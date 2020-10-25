package UI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class PictureArea extends JLabel {
	    int x_pos, y_pos;
	    int x_2,y_2;
	    int mark=0;
	    
	public void paintComponent(Graphics g) {
		//这是一个专门用来在容器内画图，通过repaint调用;
		
        super.paintComponent(g);
        //g.drawString("current location is:["+x_pos+","+y_pos+"]",x_pos,y_pos);//鍦ㄧ晫闈笂鏄剧ず
        //System.out.printf("current location is:["+x_pos+","+y_pos+"]\n",x_pos,y_pos);//鍦ㄦ帶鍒跺彴鏄剧ず
        g.setColor(Color.RED);
        if(mark==1) {
			mark=0;
			return;
        }
        g.drawRect(x_pos , y_pos , x_2-x_pos, y_2-y_pos);
        //g.fillOval(x_pos,y_pos,8,8);


    }

}
