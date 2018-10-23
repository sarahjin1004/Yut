import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class GUI extends JPanel {   
	//private Container contents;
	//private JButton[][] board = new JButton[7][7];
	//public Player player;
	private static Image image1;
	private static Image image2;
	public static JFrame frame;
	public static String player = "White";
    public static void main(String[] args){
    	frame = new JFrame("Yut");
    	
    	frame.setSize(1000,700);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	final JLabel label = new JLabel("Hello");
    	final JLabel label2 = new JLabel(player+" rolled:");
    	ArrayList<JPanel> lst = new ArrayList<JPanel>();
    	//for black pieces
    	//JLabel lol = new JLabel("Hello");
    	image1 = new ImageIcon("img/mom.png").getImage();
    	image2 = new ImageIcon("img/dad.png").getImage();
    	
    	
    	
    	
    	//panel.setLocation(330,330);
    	//panel.setSize(100,100);
    	//frame.getContentPane().add(panel);
    	//lol.setBounds(350, 300, 200, 200);
    	//frame.getContentPane().add(lol);
    	
    	for (int i = 750; i < 950; i = i + 55) {
    		ImagePanel p = new ImagePanel(image1);
        	p.setSize(50,50);
        	//p.setBackground(Color.black);
        	p.setLocation(i, 120);
        	frame.getContentPane().add(p);
        	lst.add(p);
    	}
    	//for white pieces
    	for (int i = 750; i < 950; i = i + 55) {
    		ImagePanel p = new ImagePanel(image2);
        	p.setSize(50,50);
        	//p.setBackground(Color.white);
        	p.setLocation(i, 300);
        	frame.getContentPane().add(p);
        	lst.add(p);
    	}
    	
    	Movement mv = new Movement(lst);
    	label.setVisible(false);
    	label2.setVisible(false);
    	label.setFont(new Font("Arial", Font.PLAIN, 40));
    	label2.setFont(new Font("Arial",Font.PLAIN, 25));
    	label.setBounds(750, 580, 400, 100);
    	label2.setBounds(750, 540, 200, 100);
    	JButton button = new JButton("Roll!");
    	ActionListener myActionListener = new ActionListener() {
     	   public void actionPerformed(ActionEvent e) {
     		   String output = "";
     		   int num = helper();
     		   output += Integer.toString(num)+" ";
     		   while (num > 3) {
     			   num = helper();
     			   output += Integer.toString(num)+" ";
     		   }
     		   label.setText(output);
     		  //JOptionPane.showMessageDialog(frame.getComponent(0), Integer.toString(num));
     		   label.setVisible(true);
     		   if (player == "White")
     			   player = "Black";
     		   else
     			   player = "White";
     		   label2.setText(player+" rolled:");
     		   label2.setVisible(true);
     	   }
     	};
     	//DragCircle c = new DragCircle();
    	button.setBounds(750, 450, 200, 100);
    	button.addActionListener(myActionListener);  
    	frame.getContentPane().add(button);
    	frame.getContentPane().add(label);
    	frame.getContentPane().add(label2);
        frame.getContentPane().add(new GUI());
        frame.setVisible(true);
        //frame.getContentPane().add(c);
    }
    
    
    public static int helper() {
    	int n = (int)(Math.random()*400)+1;
    	if (n <101)
    		return 1;
    	if (n >= 101 && n < 252)
    		return 2;
    	if (n >=252 && n <353)
    		return 3;
    	if (n>=353 && n < 379)
    		return 4;
    	if (n >=379)
    		return 5;
    	return 0;
    }
    
  
    
    
    
    public void paint(Graphics g){
    	g.setColor(Color.gray);
    	g.fillRect(25, 25, 680, 625);
    	g.setColor(Color.white);
    	for (int i = 27; i < 650; i++) {
    		if (i != 27)
    			g.fillOval(i, 27, 54, 56);
    		i += 120;
    	}
    	for (int i = 27; i < 625; i++) {
    		if (i != 27)
    			g.fillOval(27, i, 54, 56);
    		i += 110;
    	}
    	for (int i = 27; i < 650; i++) {
    		if (i!=27)
    			g.fillOval(i, 580, 54, 56);
    		i += 120;
    	}
    	for (int i = 27; i < 625; i++) {
    		if (i != 27)
    			g.fillOval(632, i, 54, 56);
    		i += 110;
    	}
    	g.fillOval(530, 490, 54, 54);
    	g.fillOval(530, 135, 54, 54);
    	g.fillOval(130, 490, 54, 54);
    	g.fillOval(130, 135, 54, 54);
    	g.fillOval(450, 410, 54, 54);
    	g.fillOval(230, 410, 54, 54);
    	g.fillOval(230, 230, 54, 54);
    	g.fillOval(450, 230, 54, 54);
    	g.setColor(Color.pink);
    	g.fillOval(310, 290, 120, 120);
    	g.fillOval(27, 27, 80, 80);
    	g.fillOval(27, 565, 80, 80);
    	g.fillOval(620, 565, 80, 80);
    	g.fillOval(620, 27, 80, 80);
    	g.setColor(Color.black);
    	g.setFont(new Font("Arial",Font.BOLD, 40)); 
    	g.drawString("Start", 620, 660);
    	g.setFont(new Font("Arial",Font.PLAIN, 50)); 
    	g.drawString("Black:", 750, 70);
    	g.drawString("White:", 750, 250);
    	g.setFont(new Font("Arial",Font.PLAIN, 25)); 
    	g.drawString("# Pieces remaining:", 750, 100);
    	g.drawString("# Pieces remaining:", 750, 280);
    	//g.drawString(player+" rolled: ", 750, 600);
    	//image.paintIcon(this, g, 330, 330);
    	//g.drawImage(image, 330, 330, null);
    	
    }
    
}

