package com.org.transport;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class Car {
	// 车的初始坐标
	private int carX = 0;
	private int carY = 0;
	private int a = 0;
	private int b = 0;
	private int c = 0;
	private int d = 0;
	private int x = 0;
	private int y = 0;
	private int i = 0;
	private int moveLength = 15;
	private String s1;
	private String s2;
	private boolean change1 = false;
	private boolean change2 = false;
	private int begin;
	private int end;
	Light l;
	Road road;
	HashMap<String, Integer> map = new HashMap<String, Integer>();

	public Car(int begin, int end, Light l) {
		this.l = l;
		this.begin = begin;
		this.end = end;
		road = new Road(begin, end);
		setCarTimer();
		carX = road.RoadList.get(0).x;
		carY = road.RoadList.get(0).y;
		a = road.RoadList.get(0).x;
		b = road.RoadList.get(1).x;
		c = road.RoadList.get(0).y;
		d = road.RoadList.get(1).y;
		x = b - a;
		y = d - c;
	}
	
	//hash存入需要等红灯的路口
	public HashMap saveHash() {
		map.put(String.valueOf(Road.B.x)+String.valueOf(Road.B.y), l.getl1());// B
		map.put(String.valueOf(Road.F.x)+String.valueOf(Road.F.y), l.getl2());// F
		map.put(String.valueOf(Road.M.x)+String.valueOf(Road.M.y), l.getl1());// M
		map.put(String.valueOf(Road.K.x)+String.valueOf(Road.K.y), l.getl2());// K
		map.put(String.valueOf(Road.P.x)+String.valueOf(Road.P.y), l.getl5());// P
		map.put(String.valueOf(Road.R.x)+String.valueOf(Road.R.y), l.getl6());// R
		map.put(String.valueOf(Road.Y.x)+String.valueOf(Road.Y.y), l.getl5());// Y
		map.put(String.valueOf(Road.W.x)+String.valueOf(Road.W.y), l.getl6());// W
		return map;
	}

	// 车的移动
	public void move() {
		moveLength = 15;
		if (carX == road.RoadList.get(i + 1).x
				&& carY == road.RoadList.get(i + 1).y
				&& i <= road.RoadList.size() - 3) {
			s1 = String.valueOf(carX) + String.valueOf(carY);
			s2 = String.valueOf(road.RoadList.get(i + 2).x)
					+ String.valueOf(road.RoadList.get(i + 2).y);

			if (!judgeInflexion()) { //判断是否到达掉头的拐点,若不是拐点,再判断红绿灯
				if (judgeLight(s1) == false) {//判断红绿灯
					moveLength = 0;
				}
			}
			
			i++;
			a = road.RoadList.get(i).x;
			b = road.RoadList.get(i + 1).x;
			c = road.RoadList.get(i).y;
			d = road.RoadList.get(i + 1).y;
			x = b - a;
			y = d - c;
		}
		//到达终点的处理
		if (carX - road.RoadList.get(i + 1).x == 0
				&& carY - road.RoadList.get(i + 1).y == 0) {
			carX = -10;
			carY = -10;
			road.RoadList.clear();
			return;
		}
		if (moveLength == 0) {
			i--;
		} else {
			if (!judgeInflexionClash()) { //若是否是拐点以及是否碰撞
				differentDirection();
			}
		}
	}
	//超不同方向走,在走之前判断前一个车的状态
	public void differentDirection() {
		if (y > 0) {
			//走之前先判断该方向的前一个车,若前一个车的状态是停止,则停止;否则向前走
			if (!Document.prior.containsKey(String.valueOf(carX)
					+ String.valueOf(carY + moveLength))) {
					carX = a;
					carY += moveLength;
				}
	
			
		} else if (y < 0) {
			if (!Document.prior.containsKey(String.valueOf(carX)
					+ String.valueOf(carY - moveLength))) {
					carX = a;
					carY -= moveLength;
			
			}
		} else if (x < 0) {
			if (!Document.prior.containsKey(String.valueOf(carX
					- moveLength)
					+ String.valueOf(carY))) {			
					carX -= moveLength;
					carY = c;

			}
		} else if (x > 0) {
			if (!Document.prior.containsKey(String.valueOf(carX
					+ moveLength)
					+ String.valueOf(carY))) {
					carX += moveLength;
					carY = c;
			}
		
		}
	}
	// 判断红绿灯
	public boolean judgeLight(String a) {

		if (map.containsKey(a)) {
			if (map.get(a) == 0) {
				return false;
			} else
				return true;
		}

		return true;
	}

	// 判断拐点是否碰撞
	public boolean judgeInflexionClash() {
		if (carX == 1250 && carY == 205) {
			if (Document.prior.containsKey("1265190")) {
				
				return true;
			}

		} else if (carX == 350 && carY == 220) {
			if (Document.prior.containsKey("335235")) {
				
				return true;
			}
		}
		return false;
	}

	// 判断是否是掉头的拐点，若是，则不判断红绿灯
	public boolean judgeInflexion() {
		if (s1.equals("1250235") && s2.equals("1250190"))
			change1 = true;
		else
			change1 = false;
		if (s1.equals("350190") && s2.equals("350235"))
			change2 = true;
		else
			change2 = false;
		return change1 || change2;

	}

	// 车的定时器
	public void setCarTimer() {
		Timer t1 = new Timer();
		// 在1秒之后执行,每隔1s执行一次
		t1.schedule(new carTimer(), 1 * 1000, 1 * 1000);
	}
	
	private class carTimer extends TimerTask {
		@Override
		public void run() {
			map.clear();
			map = saveHash();
			if (carX != -10 && carY != -10) {
				move();
			}
		}
	}
	
	public int getcarX() {
		return carX;
	}

	public int getcarY() {
		return carY;
	}
	public int getBegin() {
		return begin;
	}
	public int getEnd() {
		return end;
	}
}
