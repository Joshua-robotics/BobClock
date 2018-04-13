import java.awt.Font;
import java.awt.Color;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.Timer;
import javax.swing.SwingConstants;

import java.util.*;

import java.text.*;

 

public class DigitalClock {

	ImageIcon ic = new   ImageIcon("~/BobClock/BOB_Logo_Orange.png");
 

  public static void main(String[] arguments) {

 

    ClockLabel dateLable = new ClockLabel("date");

    ClockLabel timeLable = new ClockLabel("time");

    ClockLabel dayLable = new ClockLabel("day");

 

    JFrame.setDefaultLookAndFeelDecorated(true);

    JFrame f = new JFrame("BoBClock");

    f.setSize(1080,900);

    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    f.setLayout(new GridLayout(3, 1));

 

    f.add(dateLable);

    f.add(timeLable);

    f.add(dayLable);

 

	f.getContentPane().setBackground(Color.decode("#fe5b0a"));

 

    f.setVisible(true);

  }

}

 

class ClockLabel extends JLabel implements ActionListener {

 

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

String type;

  SimpleDateFormat sdf;

 

  public ClockLabel(String type) {

    this.type = type;
    
    setForeground(Color.decode("#022d6e"));

 

    switch (type) {

      case "date" : sdf = new SimpleDateFormat("  MMMM dd yyyy");

                    setFont(new Font("rail-way", Font.PLAIN, 50));

                    setHorizontalAlignment(SwingConstants.LEFT);

                    break;

      case "time" : sdf = new SimpleDateFormat("hh:mm:ss a");

                    setFont(new Font("rail-way", Font.PLAIN, 100));

                    setHorizontalAlignment(SwingConstants.CENTER);

                    break;

      case "day"  : sdf = new SimpleDateFormat("EEEE  ");

                    setFont(new Font("rail-way", Font.PLAIN, 32));

                    setHorizontalAlignment(SwingConstants.RIGHT);

                    break;

      default     : sdf = new SimpleDateFormat();

                    break;

    }

 

    Timer t = new Timer(1000, this);

    t.start();

  }

 

  public void actionPerformed(ActionEvent ae) {

    Date d = new Date();

    setText(sdf.format(d));

  }

}