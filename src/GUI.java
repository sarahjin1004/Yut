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
	private static ImageIcon image1;
	private static ImageIcon image2;
	//private static 
	public static JFrame frame;
	public static String player = "Black";
    public static void main(String[] args){
    	frame = new JFrame("Yut");
    	
    	frame.setSize(1000,700);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	//final JLabel label = new JLabel("Hello");
    	final JLabel label2 = new JLabel(player+" rolled:");
    	ArrayList<JLabel> lst = new ArrayList<JLabel>();
    	//for black pieces
    	//JLabel lol = new JLabel("Hello");
    	image1 = new ImageIcon("img/dog.png");
    	image2 = new ImageIcon("img/cat.png");
    	Image yut1 = new ImageIcon("img/1.png").getImage();
	Image yut2 = new ImageIcon("img/2.png").getImage();    	
    	Image yut3 = new ImageIcon("img/3.png").getImage();
	Image yut4 = new ImageIcon("img/4.png").getImage();
	Image yut5 = new ImageIcon("img/5.png").getImage();
    	
    	//panel.setLocation(330,330);
    	//panel.setSize(100,100);
    	//frame.getContentPane().add(panel);
    	//lol.setBounds(350, 300, 200, 200);
    	//frame.getContentPane().add(lol);
	JLabel start = new JLabel("Start");
        start.setLocation(620,660);
        start.setFont(new Font("Arial", Font.BOLD, 40));
	frame.getContentPane().add(start);
	JLayeredPane layeredPane = new JLayeredPane();
	for (int i = 750; i < 950; i = i + 55) {
                JLabel p = new JLabel("");
                p.setIcon(image1);
                p.setSize(50,50);
                //p.setBackground(Color.black);
                p.setLocation(i, 120);
//              layeredPaneParent.setLayer(p, 5);
//                layeredPane.add(p, 0);
//              layeredPane.setLayer(p, 0);
                frame.getContentPane().add(p);
                lst.add(p);
        }
	for (int i = 750; i < 950; i = i + 55) {
                JLabel p = new JLabel("");
                p.setIcon(image2);
                p.setSize(50,50);
                //p.setBackground(Color.white);
                p.setLocation(i, 300);
//              layeredPaneParent.setLayer(p, 0);
//                layeredPane.add(p, 0);
//              layeredPane.setLayer(p, 0);
                frame.getContentPane().add(p);
                lst.add(p);
        }
	//JLabel start = new JLabel("Start");
	//start.setLocation(620,660);
	//start.setFont(new Font("Arial", Font.BOLD, 40)); 
	//frame.getContentPane().add(start);
	ImageIcon boardimage = new ImageIcon("img/board.png");
 	JLabel board = new JLabel("");    	
	board.setLocation(25,25);
	board.setSize(680,625);
	board.setIcon(boardimage);
//	LayeredPaneParent layeredPaneParent = new LayeredPaneParent();
//	layeredPaneParent.setLayer(board, 10);
	layeredPane.add(board);
	layeredPane.setLayer(board, 10);
//	frame.getContentPane().add(layeredPane);
	//frame.getContentPane().add(board);
    	final ImagePanel y1 = new ImagePanel(yut1);
	y1.setSize(200,200);
	y1.setLocation(790,550);
	y1.setVisible(false);
	final ImagePanel y2 = new ImagePanel(yut2);
        y2.setSize(200,200);
        y2.setLocation(790,550);
        y2.setVisible(false);
	final ImagePanel y3 = new ImagePanel(yut3);
        y3.setSize(200,200);
        y3.setLocation(790,550);
        y3.setVisible(false);
	final ImagePanel y4 = new ImagePanel(yut4);
        y4.setSize(200,200);
        y4.setLocation(790,550);
        y4.setVisible(false);
	final ImagePanel y5 = new ImagePanel(yut5);
        y5.setSize(200,200);
        y5.setLocation(790,550);
        y5.setVisible(false);
	frame.getContentPane().add(y1);
	frame.getContentPane().add(y2);
	frame.getContentPane().add(y3);
	frame.getContentPane().add(y4);
	frame.getContentPane().add(y5);
    	Movement mv = new Movement(lst);
    	//label.setVisible(false);
    	label2.setVisible(false);
    	//label.setFont(new Font("Arial", Font.PLAIN, 40));
    	label2.setFont(new Font("Arial",Font.PLAIN, 25));
    	//label.setBounds(750, 580, 400, 100);
    	label2.setBounds(750, 450, 200, 100);
    	JButton button = new JButton("Roll!");
    	ActionListener myActionListener = new ActionListener() {
     	   public void actionPerformed(ActionEvent e) {
     		   //String output = "";
     		   int num = helper();
		   if (num ==1){ 
			 y2.setVisible(false);
			y3.setVisible(false);
			y4.setVisible(false);
			y5.setVisible(false);
			y1.setVisible(true);
		   }
		   if (num == 2) {
			 y2.setVisible(true);
                        y3.setVisible(false);
                        y4.setVisible(false);
                        y5.setVisible(false);
                        y1.setVisible(false);
		}
		   if (num ==3) {
			y2.setVisible(false);
                        y3.setVisible(true);
                        y4.setVisible(false);
                        y5.setVisible(false);
                        y1.setVisible(false);
		}
		   if (num == 4) {
			y2.setVisible(false);
                        y3.setVisible(false);
                        y4.setVisible(true);
                        y5.setVisible(false);
                        y1.setVisible(false);
		}
		   if (num == 5) {
			y2.setVisible(false);
                        y3.setVisible(false);
                        y4.setVisible(false);
                        y5.setVisible(true);
                        y1.setVisible(false);
		}
     		   //output += Integer.toString(num)+" ";
     		   //while (num > 3) {
     		   //	   num = helper();
     		   //	   output += Integer.toString(num)+" ";
     		   //}
     		   //label.setText(output);
     		  //JOptionPane.showMessageDialog(frame.getComponent(0), Integer.toString(num));
     		   //label.setVisible(true);
		   label2.setText(player+" rolled:");
		   label2.setVisible(true);
     		   if (player == "White" && num <=3)
     			   player = "Black";
     		   else if (player == "Black" && num <=3)
     			   player = "White";
     	   }
     	};
     	//DragCircle c = new DragCircle();
    	button.setBounds(750, 380, 200, 100);
    	button.addActionListener(myActionListener);  
    	frame.getContentPane().add(button);
    	//frame.getContentPane().add(label);
	frame.getContentPane().add(start);
    	frame.getContentPane().add(label2);
        frame.getContentPane().add(new GUI());
	frame.getContentPane().add(layeredPane);
        frame.setVisible(true);
//	frame.getContentPane().add(layeredPane);
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
    	//g.setColor(Color.gray);
    	//g.fillRect(25, 25, 680, 625);
    	//g.setColor(Color.white);
    	//for (int i = 27; i < 650; i++) {
    	//	if (i != 27)
    	//		g.fillOval(i, 27, 54, 56);
    	//	i += 120;
    	//}
    //	for (int i = 27; i < 625; i++) {
    //		if (i != 27)
    //			g.fillOval(27, i, 54, 56);
    //		i += 110;
    //	}
    //	for (int i = 27; i < 650; i++) {
    //		if (i!=27)
    //			g.fillOval(i, 580, 54, 56);
    //		i += 120;
    //	}
    //	for (int i = 27; i < 625; i++) {
    //		if (i != 27)
    //			g.fillOval(632, i, 54, 56);
    //		i += 110;
    //	}
    //	g.fillOval(530, 490, 54, 54);
    //	g.fillOval(530, 135, 54, 54);
    //	g.fillOval(130, 490, 54, 54);
    //	g.fillOval(130, 135, 54, 54);
    //	g.fillOval(450, 410, 54, 54);
    //	g.fillOval(230, 410, 54, 54);
    //	g.fillOval(230, 230, 54, 54);
    //	g.fillOval(450, 230, 54, 54);
    //	g.setColor(Color.pink);
    //	g.fillOval(310, 290, 120, 120);
    //	g.fillOval(27, 27, 80, 80);
    //	g.fillOval(27, 565, 80, 80);
    //	g.fillOval(620, 565, 80, 80);
    //	g.fillOval(620, 27, 80, 80);
    //	g.setColor(Color.black);
   // 	g.setFont(new Font("Arial",Font.BOLD, 40)); 
    //	g.drawString("Start", 620, 660);
    //	g.setFont(new Font("Arial",Font.PLAIN, 50)); 
    //	g.drawString("Black:", 750, 70);
    //	g.drawString("White:", 750, 250);
    //	g.setFont(new Font("Arial",Font.PLAIN, 25)); 
    //	g.drawString("# Pieces remaining:", 750, 100);
    //	g.drawString("# Pieces remaining:", 750, 280);
    //	//g.drawString(player+" rolled: ", 750, 600);
    //	//image.paintIcon(this, g, 330, 330);
    //	//g.drawImage(image, 330, 330, null);
    	
    }
    
}


