import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
	/*
 
	For any queries connect me at abdulraffay2494@gmail.com
 
	*/

	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[17];
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton, equButton, delButton, clrButton, negButton, sqButton,unrButton, facButton,piButton,modButton;
	JPanel panel;
	
	Font myFont = new Font("SimSun",Font.BOLD,25);
	
	double num1=0,num2=0,result=0;
	char operator;
	ImageIcon icon;
	
	Calculator(){
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		textfield.setBackground(new Color(110,110,110));
		
		icon = new ImageIcon("calculator.png");
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("C");
		negButton = new JButton("(-)");
		sqButton = new JButton("x²");
		unrButton = new JButton("√");
		facButton = new JButton("x!");
		piButton = new JButton("π");
		modButton = new JButton("mod");


		functionButtons[0] = divButton;//divButton
		functionButtons[1] = mulButton;//mulButton
		functionButtons[2] = addButton;//addButton
		functionButtons[3] = subButton;//subButton
		functionButtons[4] = decButton;//ok
		functionButtons[5] = equButton;//ok
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		functionButtons[9] = modButton;//modButton
		functionButtons[10] = facButton;//facButton
		functionButtons[11] = piButton;//piButton
		functionButtons[12] = negButton;//negButton
		functionButtons[13] = sqButton;//sqButton
		functionButtons[14] = delButton;//ok
		functionButtons[15] = clrButton;//ok
		functionButtons[16] = unrButton;//unrButton
		
		for(int i =0;i<17;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
			functionButtons[i].setBorderPainted(false);
			functionButtons[i].setOpaque(true);
        	functionButtons[i].setBackground(new Color(110,110,110));


		}
		
		for(int i =0;i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
			numberButtons[i].setBorderPainted(false);
        	numberButtons[i].setBackground(new Color(130,130,130));
       	 	numberButtons[i].setOpaque(true);
			
		}
		
		// negButton.setBounds(50,100,100,50);
		// delButton.setBounds(150,100,100,50);
		// clrButton.setBounds(250,100,100,50);
		equButton.setBackground(new Color(166, 119, 18));
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 350);
		panel.setLayout(new GridLayout(6,4,0,0));

		panel.add(delButton);
		panel.add(clrButton);
		panel.add(sqButton);//sq
		panel.add(unrButton);//unr
		panel.add(modButton);//mod
		panel.add(facButton);//fac
		panel.add(piButton);//pi
		panel.add(negButton);//neg
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(divButton);//div
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(mulButton);//mul
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(addButton);//add
		panel.add(decButton);//ok
		panel.add(numberButtons[0]);
		panel.add(subButton);//sub
		panel.add(equButton);//ok
		
		frame.setIconImage(icon.getImage()); //set icon to this image
		frame.getContentPane().setBackground(new Color(23, 20, 13));
		frame.add(panel);
		// frame.add(negButton);
		// frame.add(delButton);
		// frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == modButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = '^';
			textfield.setText("");
		}
		if(e.getSource()==decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='+';
			textfield.setText("");
		}
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='-';
			textfield.setText("");
		}
		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='*';
			textfield.setText("");
		}
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='/';
			textfield.setText("");
		}
		if(e.getSource()==equButton) {
			num2=Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			case'^':
				result = num1%num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clrButton) {
			textfield.setText("");
		}
		if(e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		if(e.getSource()==negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
		if(e.getSource()==sqButton){
			double temp = Double.parseDouble(textfield.getText());
			temp *= temp;
			textfield.setText(String.valueOf(temp));
		}
		if(e.getSource() == unrButton){
			double temp = Double.parseDouble(textfield.getText());
			temp = Math.pow(temp,.5);
			textfield.setText(String.valueOf(temp));

		}
		if(e.getSource() == facButton){
			int temp = Integer.valueOf(textfield.getText());
			int prod = 1;
			for(int i = 2;i<=temp;i++){
				prod *= i;
			}
			textfield.setText(String.valueOf(prod));

		}
		if(e.getSource() == piButton){
			//num1 = Double.parseDouble(textfield.getText());
			textfield.setText("3.14159");
		}
	}
}
