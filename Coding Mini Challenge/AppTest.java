

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
// import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
// import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.awt.event.ActionEvent;
// import javax.swing.JLabel;
import javax.swing.JTextField;
// import javax.swing.SwingConstants;

public class AppTest {

	private JFrame frmCalculator;
	private JTextField textDisplay;
	private double num1;
	private double num2;
	private int sign;
	private double result;
	Operations op = new Operations();
	private boolean c = true;
	private String answer;
	private boolean percent = false;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppTest window = new AppTest();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.setResizable(false);
		frmCalculator.setTitle("My Calculator");
		frmCalculator.getContentPane().setBackground(Color.WHITE);
		frmCalculator.getContentPane().setLayout(null);

		textDisplay = new JTextField();
		textDisplay.setEditable(false);
		textDisplay.setFont(new Font("Tahoma", Font.BOLD, 20));
		textDisplay.setBounds(10, 11, 230, 58);
		frmCalculator.getContentPane().add(textDisplay);
		textDisplay.setColumns(10);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (c == true) {
					String enterNumber = textDisplay.getText() + btn7.getText();
					textDisplay.setText(enterNumber);
				} else {
					textDisplay.setText(null);
					String enterNumber = textDisplay.getText() + btn7.getText();
					textDisplay.setText(enterNumber);
					c = true;
				}

			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn7.setBounds(10, 140, 50, 50);
		frmCalculator.getContentPane().add(btn7);

		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (c == true) {
					String enterNumber = textDisplay.getText() + btn8.getText();
					textDisplay.setText(enterNumber);
				} else {
					textDisplay.setText(null);
					String enterNumber = textDisplay.getText() + btn8.getText();
					textDisplay.setText(enterNumber);
					c = true;
				}
			}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn8.setBounds(70, 140, 50, 50);
		frmCalculator.getContentPane().add(btn8);

		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (c == true) {
					String enterNumber = textDisplay.getText() + btn9.getText();
					textDisplay.setText(enterNumber);
				} else {
					textDisplay.setText(null);
					String enterNumber = textDisplay.getText() + btn9.getText();
					textDisplay.setText(enterNumber);
					c = true;
				}
			}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn9.setBounds(130, 140, 50, 50);
		frmCalculator.getContentPane().add(btn9);

		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Double.parseDouble(textDisplay.getText());
				textDisplay.setText(null);
				sign = 1;
			}
		});
		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnPlus.setBounds(190, 140, 50, 50);
		frmCalculator.getContentPane().add(btnPlus);

		JButton btnBackspace = new JButton("\uF0E7");
		btnBackspace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String backspace = null;
				if (textDisplay.getText().length()>0) {
					StringBuilder stb = new StringBuilder(textDisplay.getText());
					stb.deleteCharAt(textDisplay.getText().length() -1);
					backspace = stb.toString();
					textDisplay.setText(backspace);
				}
			}
		});
		btnBackspace.setFont(new Font("Dialog", Font.BOLD, 20));
		btnBackspace.setBounds(10, 80, 110, 50);
		frmCalculator.getContentPane().add(btnBackspace);

		JButton btnCancel = new JButton("C");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textDisplay.setText(null);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancel.setBounds(130, 80, 50, 50);
		frmCalculator.getContentPane().add(btnCancel);

		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (percent == true) {
					double tempNum2 = Double.parseDouble(textDisplay.getText());
					num2 = (num1 * tempNum2)/100;
					percent = false;
				}
				else if(sign == 7) {					
					
				}
				else {
					num2 = Double.parseDouble(textDisplay.getText());
				}

				switch (sign) {
				case 1: // add
					result = op.add(num1, num2);
					break;
				case 2: // subtract
					result = op.subtract(num1, num2);
					break;
				case 3: // multiply
					result = op.multiply(num1, num2);
					break;
				case 4: // divide
					result = op.division(num1, num2);
					break;
				case 5: // factorial
					BigInteger fact = BigInteger.valueOf((int)num1);
					 					
					result = op.Factorial(fact);					
					break;
				case 6: // nCr
					int castIntNum1 = (int)num1;
					int castIntNum2 = (int)num2;
					result = op.nCr(castIntNum1, castIntNum2);
					break;
				case 7: // square root
					result = op.SquareRoot(num1);					
					break;
				default:
					
				}
				
				answer = String.format("%.2f", result);
				textDisplay.setText(answer);				
				c = false;
			}
		});
		btnEqual.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEqual.setBounds(190, 381, 50, 50);
		frmCalculator.getContentPane().add(btnEqual);

		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (c == true) {
					String enterNumber = textDisplay.getText() + btn4.getText();
					textDisplay.setText(enterNumber);
				} else {
					textDisplay.setText(null);
					String enterNumber = textDisplay.getText() + btn4.getText();
					textDisplay.setText(enterNumber);
					c = true;
				}
			}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn4.setBounds(10, 199, 50, 50);
		frmCalculator.getContentPane().add(btn4);

		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (c == true) {
					String enterNumber = textDisplay.getText() + btn5.getText();
					textDisplay.setText(enterNumber);
				} else {
					textDisplay.setText(null);
					String enterNumber = textDisplay.getText() + btn5.getText();
					textDisplay.setText(enterNumber);
					c = true;
				}
			}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn5.setBounds(70, 200, 50, 50);
		frmCalculator.getContentPane().add(btn5);

		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (c == true) {
					String enterNumber = textDisplay.getText() + btn6.getText();
					textDisplay.setText(enterNumber);
				} else {
					textDisplay.setText(null);
					String enterNumber = textDisplay.getText() + btn6.getText();
					textDisplay.setText(enterNumber);
					c = true;
				}
			}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn6.setBounds(130, 199, 50, 50);
		frmCalculator.getContentPane().add(btn6);

		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Double.parseDouble(textDisplay.getText());
				textDisplay.setText(null);
				sign = 2;
			}
		});
		btnMinus.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMinus.setBounds(190, 199, 50, 50);
		frmCalculator.getContentPane().add(btnMinus);

		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (c == true) {
					String enterNumber = textDisplay.getText() + btn1.getText();
					textDisplay.setText(enterNumber);
				} else {
					textDisplay.setText(null);
					String enterNumber = textDisplay.getText() + btn1.getText();
					textDisplay.setText(enterNumber);
					c = true;
				}
			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn1.setBounds(10, 260, 50, 50);
		frmCalculator.getContentPane().add(btn1);

		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (c == true) {
					String enterNumber = textDisplay.getText() + btn2.getText();
					textDisplay.setText(enterNumber);
				} else {
					textDisplay.setText(null);
					String enterNumber = textDisplay.getText() + btn2.getText();
					textDisplay.setText(enterNumber);
					c = true;
				}
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn2.setBounds(70, 260, 50, 50);
		frmCalculator.getContentPane().add(btn2);

		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (c == true) {
					String enterNumber = textDisplay.getText() + btn3.getText();
					textDisplay.setText(enterNumber);
				} else {
					textDisplay.setText(null);
					String enterNumber = textDisplay.getText() + btn3.getText();
					textDisplay.setText(enterNumber);
					c = true;
				}
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn3.setBounds(130, 260, 50, 50);
		frmCalculator.getContentPane().add(btn3);

		JButton btnMultiply = new JButton("*");
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Double.parseDouble(textDisplay.getText());
				textDisplay.setText(null);
				sign = 3;
			}
		});
		btnMultiply.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMultiply.setBounds(190, 260, 50, 50);
		frmCalculator.getContentPane().add(btnMultiply);

		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (c == true) {
					String enterNumber = textDisplay.getText() + btn0.getText();
					textDisplay.setText(enterNumber);
				} else {
					textDisplay.setText(null);
					String enterNumber = textDisplay.getText() + btn0.getText();
					textDisplay.setText(enterNumber);
					c = true;
				}
			}
		});
		btn0.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn0.setBounds(10, 321, 50, 50);
		frmCalculator.getContentPane().add(btn0);

		JButton btnDecimal = new JButton(".");
		btnDecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (c == true) {
					String enterNumber = textDisplay.getText() + btnDecimal.getText();
					textDisplay.setText(enterNumber);
				} else {
					textDisplay.setText(null);
					String enterNumber = textDisplay.getText() + btnDecimal.getText();
					textDisplay.setText(enterNumber);
					c = true;
				}
			}
		});
		btnDecimal.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDecimal.setBounds(70, 321, 50, 50);
		frmCalculator.getContentPane().add(btnDecimal);

		JButton btnPercentage = new JButton("%");
		btnPercentage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				percent = true;
			}
		});
		btnPercentage.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPercentage.setBounds(130, 321, 50, 50);
		frmCalculator.getContentPane().add(btnPercentage);

		JButton btnDivide = new JButton("/");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Double.parseDouble(textDisplay.getText());
				textDisplay.setText(null);
				sign = 4;
			}
		});
		btnDivide.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDivide.setBounds(190, 320, 50, 50);
		frmCalculator.getContentPane().add(btnDivide);
		
		JButton btnFactorial = new JButton("!");
		btnFactorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				num1 = Double.parseDouble(textDisplay.getText());
				sign = 5;
			}
		});
		btnFactorial.setFont(new Font("Dialog", Font.BOLD, 20));
		btnFactorial.setBounds(10, 381, 50, 50);
		frmCalculator.getContentPane().add(btnFactorial);
		
		JButton btnNCr = new JButton("nCr");
		btnNCr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Double.parseDouble(textDisplay.getText());
				textDisplay.setText(null);
				sign = 6;
			}
		});
		btnNCr.setFont(new Font("Dialog", Font.BOLD, 8));
		btnNCr.setBounds(70, 381, 50, 50);
		frmCalculator.getContentPane().add(btnNCr);
		
		JButton btnSqrt = new JButton("\u221A");
		btnSqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Double.parseDouble(textDisplay.getText());
				textDisplay.setText(null);
				sign = 7;
			}
		});
		btnSqrt.setFont(new Font("Dialog", Font.BOLD, 19));
		btnSqrt.setBounds(130, 382, 50, 50);
		frmCalculator.getContentPane().add(btnSqrt);
		
		JButton btnPlusMinus = new JButton("\u00B1");
		btnPlusMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnPlusMinus.setFont(new Font("Dialog", Font.BOLD, 20));
		btnPlusMinus.setBounds(190, 79, 50, 50);
		frmCalculator.getContentPane().add(btnPlusMinus);
		frmCalculator.setBounds(100, 100, 256, 474);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

final class Operations {

	private double result = 0;

	public double add(double a, double b) {

		result = a + b;
		return result;
	}

	public double subtract(double a, double b) {

		result = a - b;
		return result;
	}

	public double multiply(double a, double b) {

		result = a * b;
		return result;
	}

	public double division(double a, double b) {
		if (b != 0) {
			result = a / b;
			return result;
		}
		return 0;
	}
	
	public long Factorial(BigInteger n) {
		//int fact = 1;		
		BigInteger result = BigInteger.ONE;

	    while (!n.equals(BigInteger.ZERO)) {
	        result = result.multiply(n);
	        n = n.subtract(BigInteger.ONE);
	    }
	    return result.longValue();
	}
	
	public int nCr(int n,int r) {
		long num = Factorial(BigInteger.valueOf(n));
		long den = Factorial(BigInteger.valueOf(r)) * (Factorial(BigInteger.valueOf(n).subtract(BigInteger.valueOf(r))));
		
		int nCr =(int) (num / den);
		return nCr;
	}
	
	public double SquareRoot(double a) {
		return Math.sqrt(a);
	}
}
