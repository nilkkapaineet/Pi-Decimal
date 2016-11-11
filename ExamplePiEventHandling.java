import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.applet.Applet;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;
import java.awt.*;

import java.util.*;



// -------------------------------------------------------------------------

public class ExamplePiEventHandling extends Applet implements MouseListener {
   StringBuffer strBuffer;
   
      int xCC = 550;
      int xDD = 552;
      int yCC = 250;
      int yDD = 250;
      int suunta = 1;
      int xA;
      int xB;
      int yA;
      int yB;
      int suunta2 = 1;
      
   public void init() {
      addMouseListener(this);
      strBuffer = new StringBuffer();
      addItem("initializing the apple ");      
   }

   public void start() {
      addItem("starting the applet ");
      setPreferredSize(new Dimension(800,800));
   }

   public void stop() {
      addItem("stopping the applet ");
   }

   public void destroy() {
      addItem("unloading the applet");
   }

   void addItem(String word) {
      System.out.println(word);
      strBuffer.append(word);
      repaint();
   }

   public void paint(Graphics g) {
      // Draw a Rectangle around the applet's display area.
      g.drawRect(0, 0, 
      getWidth() - 1,
      getHeight() - 1);
      
      // display the string inside the rectangle.
      g.drawString(strBuffer.toString(), 10, 20);
      
      PiDigits Pii = new PiDigits();
     int n=5000; 
     xCC = 600;
     xDD = 602;
     yCC = 40;
     yDD = 40;
     
      
      g.setColor(Color.red);
      
      double E=Math.PI;

      n=5000; 
      
     for (Integer number : Pii.pi_digi(n) ) {
        if (number<100) {

          rek(number, 100, xCC, yCC, xDD, yDD, g, suunta);

        } else {

          rek(number, 1000, xCC, yCC, xDD, yDD, g, suunta);

        }
      }
      
   }
   
   public void rek(int nn, int jakaja, int xC, int yC, int xD, int yD, Graphics g, int suunta) {
     g.drawLine(xC, yC, xD, yD);

     int k = nn/jakaja; 

     if (suunta == 1) { // tultiin idästä
       if (k > 0 && k <= 3) {  // jatketaan
         xCC = xD;
         yCC = yD;
         xDD -= 5;
         suunta = 1;
       } else if (k > 3 && k <= 6) { // vasemmalle
         xCC = xD;
         yCC = yD;
         yDD -= 5;
         suunta = 4;
       } else if (k > 6) { // oikealle
         xCC = xD;
         yCC = yD;
         yDD += 5;
         suunta = 2;
       } else { // palataan
         xCC = xD;
         yCC = yD;
         xDD += 5;
         suunta = 3;
       }
     } else if (suunta == 2) { // tultiin etelästä
       if (k > 0 && k <= 3) {  // jatketaan
         xCC = xD;
         yCC = yD;
         yDD += 5;
         suunta = 2;
       } else if (k > 3 && k <= 6) { // vasemmalle
         xCC = xD;
         yCC = yD;
         xDD -= 5;
         suunta = 1;
       } else if (k > 6) { // oikealle
         xCC = xD;
         yCC = yD;
         xDD += 5;
         suunta = 3;
       } else { // palataan
         xCC = xD;
         yCC = yD;
         yDD -= 5;
         suunta = 4;
       }
     } else if (suunta == 3) { // tultiin lännestä
       if (k > 0 && k <= 3) {  // jatketaan
         xCC = xD;
         yCC = yD;
         xDD += 5;
         suunta = 3;
       } else if (k > 3 && k <= 6) { // vasemmalle
         xCC = xD;
         yCC = yD;
         yDD -= 5;
         suunta = 1;
       } else if (k > 6) { // oikealle
         xCC = xD;
         yCC = yD;
         yDD += 5;
         suunta = 4;
       } else { // palataan
         xCC = xD;
         yCC = yD;
         xDD -= 5;
         suunta = 1;
       }
     } else { // tultiin pohjoisesta
       if (k > 0 && k <= 3) {  // jatketaan
         xCC = xD;
         yCC = yD;
         yDD += 5;
         suunta = 4;
       } else if (k > 3 && k <= 6) { // vasemmalle
         xCC = xD;
         yCC = yD;
         xDD += 5;
         suunta = 3;
       } else if (k > 6) { // oikealle
         xCC = xD;
         yCC = yD;
         xDD -= 5;
         suunta = 1;
       } else { // palataan
         xCC = xD;
         yCC = yD;
         yDD -= 5;
         suunta = 2;
       }
     }
       

     nn = nn - k*jakaja;
     k = nn/jakaja;
     jakaja = jakaja/10;
     
     if (nn>9) {
       rek(nn, jakaja, xCC, yCC, xDD, yDD, g, suunta);
     } 
     
     /*
     else {
       if (k > 0 && k <= 3) {
       xCC = xD;
       yCC = yD;
       xDD += 5;

     } else if (k > 3 && k <= 6) {
       xCC = xD;
       yCC = yD;
       yDD += 5;

     } else if (k > 6) {
       xCC = xD;
       yCC = yD;
       yDD -= 5;

     } else {
       xCC = xD;
       yCC = yD;
       xDD -= 5;

     }
     }
     */
   }

   
   public void mouseEntered(MouseEvent event) {
   }
   public void mouseExited(MouseEvent event) {
   }
   public void mousePressed(MouseEvent event) {
   }
   public void mouseReleased(MouseEvent event) {
   }
   public void mouseClicked(MouseEvent event) {
      //addItem("mouse clicked! ");
   }

   // ----------------------------------------------------------------------
   
   public class PiDigits {  
    private static final int SCALE = 10000;  
    private static final int ARRINIT = 2000;  
  
    
    // -----------------------
    
    public ArrayList<Integer> pi_digi(int digits){  
        StringBuffer pi = new StringBuffer();  
        ArrayList al = new ArrayList();
        
        int[] arr = new int[digits + 1];  
        int carry = 0;  
  
        for (int i = 0; i <= digits; ++i)  
            arr[i] = ARRINIT;  
  
        for (int i = digits; i > 0; i-= 14) {  
            int sum = 0;  
            for (int j = i; j > 0; --j) {  
                sum = sum * j + SCALE * arr[j];  
                arr[j] = sum % (j * 2 - 1);  
                sum /= j * 2 - 1;  
            }  
  
            pi.append(String.format("%04d", carry + sum / SCALE));  
            al.add(carry + sum / SCALE);
            
            carry = sum % SCALE;  
        }  
        return al;  
    } 
   }
}