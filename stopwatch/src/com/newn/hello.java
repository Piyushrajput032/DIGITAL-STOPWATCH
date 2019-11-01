package com.newn;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class hello {

	private JFrame frmStopwatch;
	private JLabel hour;
	static int milliseconds=0;
	static int seconds=0;
	static int minutes=0;
	static int hours=0;
	static boolean state=true; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hello window = new hello();
					window.frmStopwatch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public hello() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStopwatch = new JFrame();
		frmStopwatch.setFont(new Font("Algerian", Font.PLAIN, 21));
		frmStopwatch.setTitle("STOPWATCH");
		frmStopwatch.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hacker\\Desktop\\Textures\\2000px-Elephant_Bahujan_Samaj_Party.svg.png"));
		frmStopwatch.setBounds(100, 100, 450, 143);
		frmStopwatch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frmStopwatch.getContentPane().add(panel, BorderLayout.NORTH);
		
		hour = new JLabel("00:");
		hour.setFont(new Font("20th Century Font", Font.PLAIN, 38));
		hour.setBounds(new Rectangle(4, 4, 0, 0));
		panel.add(hour);
		
		JLabel minute = new JLabel("00:");
		minute.setFont(new Font("20th Century Font", Font.PLAIN, 38));
		minute.setBounds(new Rectangle(4, 4, 0, 0));
		panel.add(minute);
		
		JLabel second = new JLabel("00:");
		second.setFont(new Font("20th Century Font", Font.PLAIN, 38));
		second.setBounds(new Rectangle(4, 4, 0, 0));
		panel.add(second);
		
		JLabel millisecond = new JLabel("00");
		millisecond.setFont(new Font("20th Century Font", Font.PLAIN, 38));
		millisecond.setBounds(new Rectangle(4, 4, 0, 0));
		panel.add(millisecond);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(15);
		frmStopwatch.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JButton start = new JButton("START");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				state=true;
				Thread t= new Thread() {
					public void run() {
						for(;;) {
							if(state==true) {
								try {
									sleep(1);
									if(milliseconds>1000) {
										milliseconds=0;
										seconds++;
									}
									if(seconds>60) {
										milliseconds=0;
										seconds=0;
										minutes++;
									}
									if(minutes>60) {
										milliseconds=0;
										seconds=0;
										minutes=0;
										hours++;
									}
									millisecond.setText(":"+milliseconds);
									milliseconds++;
									second.setText(":"+seconds);

									minute.setText(":"+minutes);
									hour.setText(""+hours);

								}
								catch(Exception e) {
									
								}
							}
							else {
								break;
							}
						}
					}
				};
				t.start();
			
			}
		});
		
		
		start.setFont(new Font("Tahoma", Font.BOLD, 17));
		start.setForeground(Color.BLUE);
		panel_1.add(start);
		
		JButton stop = new JButton("STOP");
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state=false;
			}
		});
		stop.setFont(new Font("Tahoma", Font.BOLD, 17));
		stop.setForeground(Color.RED);
		panel_1.add(stop);
		
		JButton Restart = new JButton("RESTART");
		Restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state=false;
				hours=0;
				minutes=0;
				seconds=0;
				milliseconds=0;
				
				hour.setText("00 :");
				minute.setText("00 :");
				second.setText("00 :");
				millisecond.setText("00");
			}
		});
		Restart.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_1.add(Restart);
	}

}
