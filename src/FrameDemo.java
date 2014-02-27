
package com.org.transport;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FrameDemo extends JFrame {
	
	public FrameDemo() {
		MyPanel mp = new MyPanel();
		this.add(mp);
		this.setSize(1600, 700);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}


//定义一个MyPanel（是我自己的面板，是用于绘图和显示绘图的区域）
class MyPanel extends JPanel {
	
	Document z;
	JLabel title;
	public MyPanel() {
		this.setLayout(null);
		z = new Document();
		Timer timer = new Timer();
		timer.schedule(new RemindTask(), 0, 1 * 1000);
	}
	
	
	private class RemindTask extends TimerTask {
		public void run() {
			repaint();	
		}
	}

	// 覆盖JPanel的paint方法
		// Graphics是绘图的重要类，可以把他理解成一只画笔
	//public void paintComponent(Graphics g) {
	public void paintComponent(Graphics g) {
		// 调用父类函数完成初始化
		super.paintComponent(g);
		drawLine(g);
		drawLight(g, z.t);
		drawblocks(g);
		drawCar(g, z.CarList);

	}

	// 画出车
	public void drawCar(Graphics g, ArrayList<Car> carList) {
		//首先清空记录界面上一秒所有车的位置的哈希表
		z.prior.clear();
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	    //System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		for (int i = 0; i < carList.size(); i++) {
			int roadA = carList.get(i).getBegin();
			//如果是南北路口产生的车，设置为蓝色；否则为绿色
			if (roadA == 1 || roadA == 3 || roadA == 4 || roadA == 6)
				g.setColor(Color.blue);
			else
				g.setColor(Color.gray);
			g.fillRect(carList.get(i).getcarX(), carList.get(i).getcarY(), 10,
					8);
			// 每一个车达到终点，则从车的列表中remove
			if (carList.get(i).getcarX() == -10
					&& carList.get(i).getcarY() == -10) {
				carList.remove(i);
			}
			//记录当前车的位置，将当前车的位置加入哈希表，供下一秒判断一辆车的前一个位置是否有车
			String x = String.valueOf(carList.get(i).getcarX())
					+ String.valueOf(carList.get(i).getcarY());
			z.prior.put(x, 1);
			//System.out.print(carList.get(i).getcarX() + "," +carList.get(i).getcarY()+" ");
		}
		System.out.println();
	}

	// 画出路
	public void drawLine(Graphics g) {
		g.drawLine(50, 175, 275, 175);
		g.drawLine(275, 100, 275, 175);
		g.drawLine(50, 250, 275, 250);
		g.drawLine(275, 250, 275, 550);

		g.drawLine(350, 100, 350, 175);
		g.drawLine(350, 250, 350, 550);
		g.drawLine(1250, 100, 1250, 175);
		g.drawLine(350, 175, 1250, 175);

		g.drawLine(350, 250, 1250, 250);
		g.drawLine(350, 250, 350, 550);
		g.drawLine(1250, 100, 1250, 175);
		g.drawLine(350, 175, 1250, 175);

		g.drawLine(1250, 250, 1250, 550);
		g.drawLine(1325, 550, 1325, 250);
		g.drawLine(1325, 100, 1325, 175);
		g.drawLine(1325, 175, 1550, 175);
		g.drawLine(1325, 250, 1550, 250);
	}

	// 画出红绿灯
	public void drawLight(Graphics g, Light t) {

		if (t.getl1() == 0) {
			g.setColor(Color.red);
			g.fillOval(275, 165, 8, 8); // l1
			g.fillOval(342, 252, 8, 8);// l4
			g.setColor(Color.green);
			g.fillOval(352, 176, 8, 8);// l2
			g.fillOval(265, 242, 8, 8);// l3
		} else {
			g.setColor(Color.green);
			g.fillOval(275, 165, 8, 8); // l1
			g.fillOval(342, 252, 8, 8);// l4
			g.setColor(Color.red);
			g.fillOval(352, 176, 8, 8);// l2
			g.fillOval(265, 242, 8, 8);// l3
		}

		if (t.getl5() == 0) {
			g.setColor(Color.red);
			g.fillOval(1250, 165, 8, 8);// l5
			g.fillOval(1317, 252, 8, 8);// l8
			g.setColor(Color.green);
			g.fillOval(1327, 176, 8, 8);// l6
			g.fillOval(1240, 242, 8, 8);// l7
		} else {
			g.setColor(Color.green);
			g.fillOval(1250, 165, 8, 8);// l5
			g.fillOval(1317, 252, 8, 8);// l8
			g.setColor(Color.red);
			g.fillOval(1327, 176, 8, 8);// l6
			g.fillOval(1240, 242, 8, 8);// l7
		}
	}	

	// 画出隔离带
	public void drawblocks(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(60, 210, 215, 5);
		g.fillRect(360, 210, 880, 5);
		g.fillRect(1325, 210, 215, 5);

		}
	}
}