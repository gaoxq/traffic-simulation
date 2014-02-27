package com.org.transport;
import java.awt.Point;
import java.util.ArrayList;

public class Road {
	//自己设定了路径的坐标
	static Point A = new Point(290, 100);
	static Point B = new Point(290, 175);
	static Point D = new Point(50, 190);
	static Point H = new Point(290, 550);	
	static Point E = new Point(50, 235);
	static Point F = new Point(275, 235);
	static Point T = new Point(1265, 550);	
	static Point O = new Point(1265, 100);	
	static Point R = new Point(1250, 235);	
	static Point a = new Point(1550, 190);
	static Point b = new Point(1550, 235);		
	static Point W = new Point(1325, 190);	
	static Point U = new Point(1310, 100);	
	static Point Q = new Point(1250, 190);	
	static Point K = new Point(350, 190);
	static Point G = new Point(290, 250);	
	static Point J = new Point(335, 175);
	static Point I = new Point(335, 100);
	static Point N = new Point(335, 550);
	static Point M = new Point(335, 250);
	static Point L = new Point(350, 235);
	static Point V = new Point(1310, 175);
	static Point R1 = new Point(290, 190);
	static Point R2 = new Point(290, 235);
	static Point R3 = new Point(335, 235);
	static Point R6 = new Point(1265, 235);
	static Point R8 = new Point(1310, 190);
	static Point Z = new Point(1310, 550);
	static Point Y = new Point(1310, 250);
	static Point R7 = new Point(1310, 235);
	static Point R4 = new Point(335, 190);
	static Point R5 = new Point(1265, 190);
	static Point P = new Point(1265, 175);
	static Point C = new Point(275, 190);
	ArrayList<Point> RoadList = new ArrayList<Point>();

	public Road(int begin, int end) {
		choose(begin, end);
	}
	//根据起始点和终点，产生一辆车要走的路。
	public ArrayList<Point> choose(int begin, int end) {
			//BSN-EHW
			//对于拐弯的路，记录起点，转折点，终点
			if (begin == 1 && end == 2) {
				RoadList.add(A); // A
				RoadList.add(R1); // R1
				RoadList.add(D); // D
			}
			//BSN-BSS
			//对于直行的车辆，记录起点，在红绿灯口出，终点
			else if(begin == 1 && end == 3) {
				RoadList.add(A); //A
				RoadList.add(B); //B
				RoadList.add(H); //H
			}
			//BSN-TBS
			else if(begin == 1 && end == 4) {
				RoadList.add(A); //A
				RoadList.add(R1); //R1
				RoadList.add(D); //D
				RoadList.add(E); //E
				RoadList.add(F); //F
				RoadList.add(R6); //R6
				RoadList.add(T); //T		
			}
			//BSN-EHE
			else if(begin == 1 && end == 5) {
				RoadList.add(A); //A
				RoadList.add(R1); //R1
				RoadList.add(D); //D
				RoadList.add(E); //E
				RoadList.add(F); //F
				RoadList.add(R); //R
				RoadList.add(b); //b
			}
			//BSN-TBN
			else if(begin == 1 && end == 6) {
				RoadList.add(A); //A
				RoadList.add(R1); //R1
				RoadList.add(D); //D
				RoadList.add(E); //E
				RoadList.add(F); //F
				RoadList.add(R); //R
				RoadList.add(b); //b				
				RoadList.add(a); //a
				RoadList.add(W); //W
				RoadList.add(R8); //R8
				RoadList.add(U); //U
			}
			//EHW-BSN
			//对于掉头的车，要记录拐点的坐标
			else if(begin == 2 && end == 1) {
				RoadList.add(E); //E
				RoadList.add(F); //F
				RoadList.add(R); //R	
				RoadList.add(Q); //Q
				RoadList.add(R4); //R4
				RoadList.add(I); //I
			}
			//EHW-BSS
			else if(begin == 2 && end == 3) {
				RoadList.add(E); //E
				RoadList.add(R2); //R2
				RoadList.add(H); //H
			}
			//EHW-TBS
			else if(begin == 2 && end == 4) {
				RoadList.add(E); //E
				RoadList.add(F); //F
				RoadList.add(R6); //R6
				RoadList.add(T); //T
			}
			//EHW-EHE
			else if(begin == 2 && end == 5) {
				RoadList.add(E); //E
				RoadList.add(F); //F
				RoadList.add(R); //R
				RoadList.add(b); //b
			}
			//EHW-TBN
			else if(begin == 2 && end == 6) {
				RoadList.add(E); //E
				RoadList.add(F); //F
				RoadList.add(R); //R
				RoadList.add(b); //b		
				RoadList.add(a); //a		
				RoadList.add(W); //W
				RoadList.add(R8); //R8
				RoadList.add(U); //U
			}
			//BSS-BSN
			else if(begin == 3 && end == 1) {
				RoadList.add(N); //N
				RoadList.add(M); //M
				RoadList.add(I); //I
			}
			//BSS-EHW
			else if(begin == 3 && end == 2) {
				RoadList.add(N); //N
				RoadList.add(R3); //R3
				RoadList.add(R); //R
				RoadList.add(Q); //Q
				RoadList.add(K); //K
				RoadList.add(D); //D
			}
			//BSS-TBS
			else if(begin == 3 && end == 4) {
				RoadList.add(N); //N
				RoadList.add(R3); //R3
				RoadList.add(R6); //R6
				RoadList.add(T); //T
			}
			//BSS-EHE
			else if(begin == 3 && end == 5) {
				RoadList.add(N); //N
				RoadList.add(R3); //R3
				RoadList.add(R); //R
				RoadList.add(b); //b
			}
			//BSS-TBN
			else if(begin == 3 && end == 6) {
				RoadList.add(N); //N
				RoadList.add(R3); //R3
				RoadList.add(R); //R
				RoadList.add(b); //b
				RoadList.add(a); //a
				RoadList.add(R8); //R8
				RoadList.add(U); //U
			}
			//TBS-BSN
			else if(begin == 4 && end == 1) {
				RoadList.add(Z); //Z
				RoadList.add(R7); //R7
				RoadList.add(b); //b
				RoadList.add(a); //a
				RoadList.add(W); //W
				RoadList.add(R4); //R4
				RoadList.add(I); //I
			}
			
			//TBS-EHW
			else if(begin == 4 && end == 2) {
				RoadList.add(Z); //Z
				RoadList.add(R7); //R7
				RoadList.add(b); //b
				RoadList.add(a); //a
				RoadList.add(W); //W
				RoadList.add(K); //K
				RoadList.add(D); //D
			}
			
			//TBS-BSS
			else if(begin == 4 && end == 3) {
				RoadList.add(Z); //Z
				RoadList.add(R7); //R7
				RoadList.add(b); //b
				RoadList.add(a); //a
				RoadList.add(W); //W
				RoadList.add(K); //K
				RoadList.add(D); //D
				RoadList.add(E); //E
				RoadList.add(R2); //R2
				RoadList.add(H); //H
			}		
			//TBS-EHE
			else if(begin == 4 && end == 5) {
				RoadList.add(Z); //Z
				RoadList.add(R7); //R7
				RoadList.add(b); //b
			}
			//TBS-TBN
			else if(begin == 4 && end == 6) {
				RoadList.add(Z); //Z
				RoadList.add(Y); //Y
				RoadList.add(U); //U
			}
			//EHE-BSN
			else if(begin == 5 && end == 1) {
				RoadList.add(a); //a
				RoadList.add(W); //W
				RoadList.add(K); //K
				RoadList.add(R4); //R4
				RoadList.add(I); //I
			}
			//EHE-EHW
			else if(begin == 5 && end == 2) {
				RoadList.add(a); //a
				RoadList.add(W); //W
				RoadList.add(K); //K
				RoadList.add(D); //D
			}
			//EHE-BSS
			else if(begin == 5 && end == 3) {
				RoadList.add(a); //a
				RoadList.add(W); //W
				RoadList.add(K); //K
				RoadList.add(D); //D
				RoadList.add(E); //E
				RoadList.add(R2); //R2
				RoadList.add(H); //H
			}
			//EHE-TBS
			else if(begin == 5 && end == 4) {
				RoadList.add(a); //a
				RoadList.add(W); //W
				RoadList.add(K); //K
				RoadList.add(L); //L
				RoadList.add(R6); //R6
				RoadList.add(T); //T
			}
			
			//EHE-TBN
			else if(begin == 5 && end == 6) {
				RoadList.add(a); //a
				RoadList.add(R8); //R8
				RoadList.add(U); //U
			}
			
			//TBN-BSN
			else if(begin == 6 && end == 1) {
				RoadList.add(O); //O
				RoadList.add(R5); //R5
				RoadList.add(R4); //R4
				RoadList.add(I);//I
			}
			
			//TBN-EHW
			else if(begin == 6 && end == 2) {
				RoadList.add(O); //O
				RoadList.add(R5); //R5
				RoadList.add(K); //K
				RoadList.add(D);//D
			}
			
			//TBN-BSS
			else if(begin == 6 && end == 3) {
				RoadList.add(O); //O
				RoadList.add(R5); //R5
				RoadList.add(K); //K
				RoadList.add(D);//D
				RoadList.add(E); //E
				RoadList.add(R2); //R2
				RoadList.add(H); //H
			}
			
			//TBN-TBS
			else if(begin == 6 && end == 4) {
				RoadList.add(O); //O
				RoadList.add(P); //P
				RoadList.add(T); //T
			}
			
			//TBN-EHE
			else if(begin == 6 && end == 5) {
				RoadList.add(O); //O
				RoadList.add(R5); //R5
				RoadList.add(K); //K
				RoadList.add(L); //L
				RoadList.add(R); //R
				RoadList.add(b); //b
			}
			//返回一条路径。
			return (ArrayList<Point>) RoadList;
		}
}
