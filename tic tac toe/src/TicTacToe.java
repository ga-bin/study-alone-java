import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {
	
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel(); // jpanel은 조각난 프레임
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn;
	
	// 생성자
	TicTacToe() {
		// Jframe 윈도우 종료시 프로세스까지 종료
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		// jframe의 conteentpane 객체 들고와야 background설정 가능
		// contentpane은 일종의 포토샵의  layout이라고 생각하면 된다.
		frame.setLayout(new BorderLayout());
		// A border layout lays out a container, arranging and resizing its components to fit in five regions
		//  north, south, east, west, and center.
		frame.setVisible(true);
		textfield.setBackground(new Color(25, 25, 25));
		textfield.setForeground(new Color(25, 255, 0));
		textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		// 가운데 정렬
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true); // 배경색 적용
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0, 0, 800, 100);
		// public void setBounds​(int x, int y, int width, int height)
		// Moves and resizes this component.
		
		title_panel.add(textfield);
		frame.add(title_panel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	// firstTurn(유저 or 컴퓨터)
	public void firstTurn() {
	
	}
	
	// 승리조건 있는지, 현재 승리한 플레이어가 있는지
	public void check() {
		
	}
	
	// x가 이길경우 호출할 메소드
	// x의 선택 매개변수로 받고 각각의 승리조건 표시하기
	public void xWins(int a, int b, int c) {
	
	}
	
	// o가 이길경우 호추랗ㄹ 메소드 
	public void oWins(int a, int b, int c) {
		
	}
}
