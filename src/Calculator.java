import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculator extends JFrame {

// zmienne wykorzystywane do obliczeñ
	int a;
	int b;
	int przyciskLiczba;
	double wynik;
	int dzialanie;
	boolean turn = false;
 

	JTextField textScreen = new JTextField();
	JTextField liczbaA = new JTextField();
	JTextField liczbaB = new JTextField();

	public Calculator() {

//podstawowe ustawienia okna 		
		super(""); // to akurat nie wiem po co
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Kalkulator");
		setSize(400, 400);
		setLocation(500, 200);
		setLayout(new GridLayout(5, 4));
		setVisible(true);

		// inne czcionki
		Font fontLiczby = new Font("Verdana", Font.BOLD, 15);
		Font fontWynik = new Font("Verdana", Font.BOLD, 15);
		textScreen.setFont(fontWynik);
		liczbaA.setFont(fontLiczby);
		liczbaB.setFont(fontLiczby);

		// guziki
		JButton BOblicz = new JButton("=");
		JButton BDodaw = new JButton("+");
		JButton BOdejm = new JButton("-");
		JButton BMnoz = new JButton("x");
		JButton BDziel = new JButton("/");
		JButton BReset = new JButton("C");
		BReset.setForeground(Color.RED);

		JButton BEmpty = new JButton(); // pewnie do usuniecia
		BEmpty.setEnabled(false);

		JButton Bnr0 = new JButton("0");
		JButton Bnr1 = new JButton("1");
		JButton Bnr2 = new JButton("2");
		JButton Bnr3 = new JButton("3");
		JButton Bnr4 = new JButton("4");
		JButton Bnr5 = new JButton("5");
		JButton Bnr6 = new JButton("6");
		JButton Bnr7 = new JButton("7");
		JButton Bnr8 = new JButton("8");
		JButton Bnr9 = new JButton("9");

// dodawanie elementów oznaczaace te¿ ich kolejnoœæ wyœwietlania

		add(liczbaA);
		add(liczbaB);
		add(BOblicz);
		add(textScreen);
		add(Bnr1);
		add(Bnr2);
		add(Bnr3);
		add(BDodaw);
		add(Bnr4);
		add(Bnr5);
		add(Bnr6);
		add(BOdejm);

		add(Bnr7);
		add(Bnr8);
		add(Bnr9);
		add(BMnoz);
		add(BReset);
		add(Bnr0);
		add(BEmpty);
		add(BDziel);

// akcje na guzikach liczbowych 

		Bnr1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				przypisanie(Integer.parseInt(Bnr1.getText()));
 
			}
		});

		Bnr2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				przypisanie(Integer.parseInt(Bnr2.getText()));
			}
		});

		Bnr3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				przypisanie(Integer.parseInt(Bnr3.getText()));
			}
		});

		Bnr4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				przypisanie(Integer.parseInt(Bnr4.getText()));
			}
		});

		Bnr5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				przypisanie(Integer.parseInt(Bnr5.getText()));
			}
		});

		Bnr6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				przypisanie(Integer.parseInt(Bnr6.getText()));
			}
		});

		Bnr7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				przypisanie(Integer.parseInt(Bnr7.getText()));
			}
		});

		Bnr8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				przypisanie(Integer.parseInt(Bnr8.getText()));
			}
		});

		Bnr9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				przypisanie(Integer.parseInt(Bnr9.getText()));
			}
		});

		Bnr0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				przypisanie(Integer.parseInt(Bnr0.getText()));
			}
		});

//Guziki dzialan matematycznych 

		BDodaw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				dzialanie = 0;
				turn = !turn;
			}
		});
		BOdejm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				dzialanie = 1;
				turn = !turn;
			}
		});
		BMnoz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				dzialanie = 2;
				turn = !turn;
			}
		});
		BDziel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				dzialanie = 4;
				turn = !turn;
			}
		});
		BReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				reset();

			}
		});
		BOblicz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				obliczanie();
				turn = !turn;
				textScreen.setText(String.format("%.3f", wynik));
				a = 0;
				b = 0;

			}
		});

	}

	public void przypisanie(int liczba) {

		if (turn) {
			b = 10 * b + liczba;
			liczbaB.setText(Integer.toString(b));

		} else {
			a = 10 * a + liczba;
			liczbaA.setText(Integer.toString(a));
		}

	}

	public void obliczanie() {

		switch (dzialanie) {
		case 0:
			wynik = a + b;
			break;

		case 1:
			wynik = a - b;
			break;

		case 2:
			wynik = a * b;
			break;

		case 3:
			wynik = a / b;
			break;
		case 4:
			wynik = (double) a / b;

			break;

		default:
			break;
		}

	}

	public void reset() {
		a = 0;
		b = 0;
		wynik = 0;
		dzialanie = 0;
		turn = false;
		int counterDigits = 0;

		liczbaA.setText("");
		liczbaB.setText("");
		textScreen.setText("");

	}

}


