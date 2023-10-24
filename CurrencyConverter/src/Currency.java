
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class Currency implements ActionListener{

	JFrame frame = new JFrame();
	
	JLabel titleLabel = new JLabel("Currency Converter");
	JLabel toLabel = new JLabel("TO");
	JTextField amountfield = new JTextField();
	JTextField changedfield = new JTextField();
	JButton convertButton = new JButton("Convert");
	JComboBox<String> fromdropBox = new JComboBox<>();
	JComboBox<String> todropBox = new JComboBox<>();
	
	String[] dol = {"USD", "EUR", "GBP", "CHF", "JPY", "CNY"};
	
	ExchangeRate currency;
	
	Currency(){
		
		titleLabel.setBounds(50, 10, 350, 50);
		titleLabel.setFont(new Font("Ink Free", Font.BOLD, 35));
		
		amountfield.setBounds(60, 150, 80, 20);
		
		changedfield.setBounds(250, 150, 80, 20);
		
		toLabel.setBounds(185, 120, 80, 25);
		toLabel.setFont(new Font("Ink Free", Font.BOLD, 20));
		
		convertButton.setBounds(150, 200, 90, 35);
		convertButton.setFocusable(false);
		convertButton.setBackground(Color.orange);
		convertButton.setFont(new Font("Ink Free", Font.BOLD, 15));
		convertButton.addActionListener(this);
		
		fromdropBox = new JComboBox<String>(dol);
		fromdropBox.setBounds(60, 120, 80, 20);	
		fromdropBox.setBackground(Color.orange);
		
		todropBox = new JComboBox<String>(dol);
		todropBox.setBounds(250, 120, 80, 20);
		todropBox.setBackground(Color.orange);
		
		frame.add(toLabel);
		frame.add(convertButton);
		frame.add(changedfield);
		frame.add(amountfield);
		frame.add(titleLabel);
		frame.add(fromdropBox);
		frame.add(todropBox);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Currency Converter");
		frame.getContentPane().setBackground(new Color(240, 235, 210));
		frame.setSize(420, 320);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String fromName = ((String)fromdropBox.getSelectedItem());
		String toName = ((String)todropBox.getSelectedItem());
	
		if(e.getSource() == convertButton) {
			if(fromName.equals("USD")){
				try {
					currency = new ExchangeRate("USD");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(toName.equals("USD")) {
					changedfield.setText(exchange("USD"));
				}else if(toName.equals("EUR")) {
					changedfield.setText(exchange("EUR"));
				}else if(toName.equals("GBP")) {
					changedfield.setText(exchange("GBP"));
				}else if(toName.equals("CHF")) {
					changedfield.setText(exchange("CHF"));
				}else if(toName.equals("JPY")) {
					changedfield.setText(exchange("JPY"));
				}else if(toName.equals("CNY")) {
					changedfield.setText(exchange("CNY"));
				}
			}
			
			if(fromName.equals("EUR")){
				try {
					currency = new ExchangeRate("EUR");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(toName.equals("EUR")) {
					changedfield.setText(exchange("EUR"));
				}else if(toName.equals("USD")) {
					changedfield.setText(exchange("USD"));
				}else if(toName.equals("GBP")) {
					changedfield.setText(exchange("GBP"));
				}else if(toName.equals("CHF")) {
					changedfield.setText(exchange("CHF"));
				}else if(toName.equals("JPY")) {
					changedfield.setText(exchange("JPY"));
				}else if(toName.equals("CNY")) {
					changedfield.setText(exchange("CNY"));
				}
			}
			
			if(fromName.equals("GBP")){
				try {
					currency = new ExchangeRate("GBP");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(toName.equals("EUR")) {
					changedfield.setText(exchange("EUR"));
				}else if(toName.equals("USD")) {
					changedfield.setText(exchange("USD"));
				}else if(toName.equals("GBP")) {
					changedfield.setText(exchange("GBP"));
				}else if(toName.equals("CHF")) {
					changedfield.setText(exchange("CHF"));
				}else if(toName.equals("JPY")) {
					changedfield.setText(exchange("JPY"));
				}else if(toName.equals("CNY")) {
					changedfield.setText(exchange("CNY"));
				}
			}
			
			if(fromName.equals("CHF")){
				try {
					currency = new ExchangeRate("CHF");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(toName.equals("EUR")) {
					changedfield.setText(exchange("EUR"));
				}else if(toName.equals("USD")) {
					changedfield.setText(exchange("USD"));
				}else if(toName.equals("GBP")) {
					changedfield.setText(exchange("GBP"));
				}else if(toName.equals("CHF")) {
					changedfield.setText(exchange("CHF"));
				}else if(toName.equals("JPY")) {
					changedfield.setText(exchange("JPY"));
				}else if(toName.equals("CNY")) {
					changedfield.setText(exchange("CNY"));
				}
			}
			
			if(fromName.equals("JPY")){
				try {
					currency = new ExchangeRate("JPY");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(toName.equals("EUR")) {
					changedfield.setText(exchange("EUR"));
				}else if(toName.equals("USD")) {
					changedfield.setText(exchange("USD"));
				}else if(toName.equals("GBP")) {
					changedfield.setText(exchange("GBP"));
				}else if(toName.equals("CHF")) {
					changedfield.setText(exchange("CHF"));
				}else if(toName.equals("JPY")) {
					changedfield.setText(exchange("JPY"));
				}else if(toName.equals("CNY")) {
					changedfield.setText(exchange("CNY"));
				}
			}
			
			if(fromName.equals("CNY")){
				try {
					currency = new ExchangeRate("CNY");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(toName.equals("EUR")) {
					changedfield.setText(exchange("EUR"));
				}else if(toName.equals("USD")) {
					changedfield.setText(exchange("USD"));
				}else if(toName.equals("GBP")) {
					changedfield.setText(exchange("GBP"));
				}else if(toName.equals("CHF")) {
					changedfield.setText(exchange("CHF"));
				}else if(toName.equals("JPY")) {
					changedfield.setText(exchange("JPY"));
				}else if(toName.equals("CNY")) {
					changedfield.setText(exchange("CNY"));
				}
			}
		
		}	
	}
	
	public String exchange(String name) {

		double amount = Double.parseDouble(amountfield.getText());
		double rate = currency.getRate(name);
		return Double.toString(currency.change(amount, rate));
	}
}
