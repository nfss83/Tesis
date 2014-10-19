/*
	TUIO Java Demo - part of the reacTIVision project
	http://reactivision.sourceforge.net/

	Copyright (c) 2005-2009 Martin Kaltenbrunner <mkalten@iua.upf.edu>

	This program is free software; you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation; either version 2 of the License, or
	(at your option) any later version.

	This program is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with this program; if not, write to the Free Software
	Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/

import TUIO.*;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.io.File;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
//import javazoom.jlgui.basicplayer.BasicPlayer;

public class TuioDemoComponent extends JComponent implements TuioListener {

	private Hashtable<Long,TuioDemoObject> objectList = new Hashtable<Long,TuioDemoObject>();
	private Hashtable<Long,TuioCursor> cursorList = new Hashtable<Long,TuioCursor>();
 private Image logo1;
  AudioClip audioClip; 
 private Image logo2;
   private Image logo3;
    private Image logo4;
     private Image logo5;
      private Image logo6;
     private Image logo7;
      private Image logo8;
     private Image logo9;
     private Image logo10;
     private Image logo11;
     BasicPlayer sonido = new BasicPlayer();

    int coorX=0;
    int coorY=0;
	public static final int finger_size = 15;
	public static final int object_size = 60;
	public static final int table_size = 760;
	
	public static int width, height;
	private float scale = 1.0f;
	public boolean verbose = false;
			int banderaa=0;
                        int banderae=0;
                        int banderai=0;
                        int banderao=0;
                        int banderau=0;
                        int banderaso=0;
                      



	public void setSize(int w, int h) {
		super.setSize(w,h);
		width = w;
		height = h;
		scale  = height/(float)TuioDemoComponent.table_size;	
	}
	
	public void addTuioObject(TuioObject tobj) {
            
		TuioDemoObject demo = new TuioDemoObject(tobj);
		objectList.put(tobj.getSessionID(),demo);

		if (verbose) 
			System.out.println("add obj "+tobj.getSymbolID()+" ("+tobj.getSessionID()+") "+tobj.getX()+" "+tobj.getY()+" "+tobj.getAngle());	
	}

	public void updateTuioObject(TuioObject tobj) {

                
		TuioDemoObject demo = (TuioDemoObject)objectList.get(tobj.getSessionID());
		demo.update(tobj);
		
		if (verbose) 
			System.out.println("set obj "+tobj.getSymbolID()+" ("+tobj.getSessionID()+") "+tobj.getX()+" "+tobj.getY()+" "+tobj.getAngle()+" "+tobj.getMotionSpeed()+" "+tobj.getRotationSpeed()+" "+tobj.getMotionAccel()+" "+tobj.getRotationAccel()); 	
	}
	
	public void removeTuioObject(TuioObject tobj) {
		objectList.remove(tobj.getSessionID());
		
		if (verbose) 
			System.out.println("del obj "+tobj.getSymbolID()+" ("+tobj.getSessionID()+")");	
	}

	public void addTuioCursor(TuioCursor tcur) {
	
		if (!cursorList.containsKey(tcur.getSessionID())) {
			cursorList.put(tcur.getSessionID(), tcur);
			repaint();
		}
		
		if (verbose) 
			System.out.println("add cur "+tcur.getCursorID()+" ("+tcur.getSessionID()+") "+tcur.getX()+" "+tcur.getY());	
	}

	public void updateTuioCursor(TuioCursor tcur) {

		repaint();
		
		if (verbose) 
			System.out.println("set cur "+tcur.getCursorID()+" ("+tcur.getSessionID()+") "+tcur.getX()+" "+tcur.getY()+" "+tcur.getMotionSpeed()+" "+tcur.getMotionAccel()); 
	}
	
	public void removeTuioCursor(TuioCursor tcur) {
	
		cursorList.remove(tcur.getSessionID());	
		repaint();
		
		if (verbose) 
			System.out.println("del cur "+tcur.getCursorID()+" ("+tcur.getSessionID()+")"); 
	}

	public void refresh(TuioTime frameTime) {
		repaint();
	}
	
	public void paint(Graphics g) {
           // g.drawRect(10, 40, 50,40);
		update(g);
	}
        

	public void update(Graphics g) {
	
            
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	
		g2.setColor(Color.black);
                g2.fillRect(0,0,width,height);
                g.setColor(Color.black);
               // g.drawRect(10, 40, 50,40);
logo1=	Toolkit.getDefaultToolkit().getImage("C:/Nueva carpeta/a.png");
logo2=	Toolkit.getDefaultToolkit().getImage("C:/Nueva carpeta/e.png");
logo3=	Toolkit.getDefaultToolkit().getImage("C:/Nueva carpeta/i.png");
logo4=	Toolkit.getDefaultToolkit().getImage("C:/Nueva carpeta/o.png");
logo5=	Toolkit.getDefaultToolkit().getImage("C:/Nueva carpeta/u.png");
logo6= Toolkit.getDefaultToolkit().getImage("C:/Nueva carpeta/avion.png");
logo7= Toolkit.getDefaultToolkit().getImage("C:/Nueva carpeta/ele.png");
logo8=Toolkit.getDefaultToolkit().getImage("C:/Nueva carpeta/iguana.jpg");
logo9=Toolkit.getDefaultToolkit().getImage("C:/Nueva carpeta/oso.png");
logo10=Toolkit.getDefaultToolkit().getImage("C:/Nueva carpeta/uva.png");
logo11=Toolkit.getDefaultToolkit().getImage("C:/Nueva carpeta/vion.png");

g.drawImage( logo1, 0,0, 150, 150, this );
g.drawImage( logo2, 170,0, 150, 150, this );
g.drawImage( logo3, 330,0, 150, 150, this );
g.drawImage( logo4, 480,0, 150, 150, this );
g.drawImage( logo5, 630,0, 150, 150, this );
               
    if (banderaa==1){
    
    g2.drawImage( logo6, 0,200, 100, 200, this );
    File fileAudio=new File("C:/Nueva carpeta/a.mp3");
    g2.drawImage(logo11,420, 380,this);
   if(coorX>170 && coorY>180  )
   {
   g2.drawImage(logo1,170, 190,this);
   } 
   if (banderaso==0)
        {    
            try {
                 sonido.open(fileAudio);
                 sonido.play();
                } catch (Exception e) {
                  System.out.println(e);
                  } 
            banderaso=1;
        }   
      }
                
    if (banderae==1){
    g2.drawImage( logo7, 0,200, 100, 300, this );
        try {
             
               if (banderaso==0)
                 {
                   File fileAudio2=new File("C:/Nueva carpeta/e.mp3");
                   sonido.open(fileAudio2);
                   sonido.play();
                 }
             }catch (Exception e) {
                System.out.println(e);
                 }
        banderaso=1;     
        }
   if (banderai==1){
    g2.drawImage( logo8, 0,200, 100, 300, this );
        try {
             
               if (banderaso==0)
                 {
                   File fileAudio2=new File("C:/Nueva carpeta/i.mp3");
                   sonido.open(fileAudio2);
                   sonido.play();
                 }
             }catch (Exception e) {
                System.out.println(e);
                 }
        banderaso=1;
             }
   if (banderao==1){
    g2.drawImage( logo9, 0,200, 100, 300, this );
        try {
             
               if (banderaso==0 )
                 {
                   File fileAudio2=new File("C:/Nueva carpeta/o.mp3");
                   sonido.open(fileAudio2);
                   sonido.play();
                 }
             }catch (Exception e) {
                System.out.println(e);
                 }
        banderaso=1;
                    
        
             }
   if (banderau==1){
    g2.drawImage( logo10, 0,200, 100, 300, this );
        try {
             
               if (banderaso==0)
                 {
                   File fileAudio2=new File("C:/Nueva carpeta/u.mp3");
                   sonido.open(fileAudio2);
                   sonido.play();
                 }
             }catch (Exception e) {
                System.out.println(e);
                 }
        banderaso=1;
        
        
             }


                  
		int w = (int)Math.round(width-scale*finger_size/2.0f);
		int h = (int)Math.round(height-scale*finger_size/2.0f);
		
		Enumeration<TuioCursor> cursors = cursorList.elements();
		while (cursors.hasMoreElements()) {
			TuioCursor tcur = cursors.nextElement();
			if (tcur==null) continue;
			Vector<TuioPoint> path = tcur.getPath();
			TuioPoint current_point = path.elementAt(0);
			if (current_point!=null) {
				// draw the cursor path
				g2.setPaint(Color.blue);
				for (int i=0;i<path.size();i++) {
					TuioPoint next_point = path.elementAt(i);
					g2.drawLine(current_point.getScreenX(w), current_point.getScreenY(h), next_point.getScreenX(w), next_point.getScreenY(h));
					System.out.println(current_point.getScreenX(w)+"-"+current_point.getScreenY(h)+"-"+next_point.getScreenX(w));
                                        current_point = next_point;
                                        
                                         
                                            coorX=current_point.getScreenX(w);
                                            coorY=current_point.getScreenY(h);
                                        
                                        if(current_point.getScreenX(w)<155 && current_point.getScreenY(h)<150)
                                        {
                                            
                                            if(banderaa!=1)
                                            {
                                            banderaso=0;
                                            }
                                            banderaa = 1;
                                            banderae=0;
                                            banderai=0;
                                            banderao=0;
                                            banderau=0;
                                                    
                                            
                                            
                                        }
                                        if(current_point.getScreenX(w)>165 && current_point.getScreenY(h)<150 && current_point.getScreenX(w)<320)
                                         {
                                            
                                            if(banderae!=1)
                                            {
                                                banderaso=0;
                                            }
                                            banderaa = 0;
                                            banderae=1;
                                            banderai=0;
                                            banderao=0;
                                            banderau=0;
                                            
                                         }   
                                         if(current_point.getScreenX(w)>330 && current_point.getScreenY(h)<480 && current_point.getScreenY(h)<150)
                                         {
                                            
                                            if(banderai!=1)
                                            {
                                            banderaso=0;
                                            }
                                            banderaa=0;
                                            banderae=0;
                                            banderai=1;
                                            banderao=0;
                                            banderau=0;
                                            
                                            
                                         }   
                                         
                                         if(current_point.getScreenX(w)>480 && current_point.getScreenY(h)<630 && current_point.getScreenY(h)<150)
                                         {
                                            if(banderao!=1)
                                            {
                                            banderaso=0;
                                            }
                                            banderaa=0;
                                            banderae=0;
                                            banderai=0;
                                            banderao=1;
                                            banderau=0;
                                            
                                         }  
                                         
                                         if(current_point.getScreenX(w)>630 && current_point.getScreenY(h)<780 && current_point.getScreenY(h)<150)
                                         {
                                            
                                            if(banderau!=1)
                                            {
                                            banderaso=0;
                                            }
                                            banderaa=0;
                                            banderae=0;
                                            banderai=0;
                                            banderao=0;
                                            banderau=1;
                                         }  
                                         
                                        
                                        
                                }
                                
                                
			}//fin if pulsación
			
                        if (banderaa==1)
                                        {
                                            g2.setColor(Color.black);
                                            g2.fillRect(0,0,width,height);
                                            g.setColor(Color.black);
                                            g.drawImage( logo1, 0,0, 150, 150, this );
                                            g.drawImage( logo2, 170,0, 150, 150, this );
                                            g.drawImage( logo3, 330,0, 150, 150, this );
                                            g.drawImage( logo4, 480,0, 150, 150, this );
                                            g.drawImage( logo5, 630,0, 150, 150, this );
                                            g2.drawImage( logo1, coorX, coorY,coorX+80, coorY+80, this );
                                            g2.drawImage( logo6, 0,200, 100, 200, this );
                                             g2.drawImage(logo11,420, 380,this);
                                            if(coorX>170 && coorY>180  )
                                            {
                                                g.drawImage(logo1,170, 190,this);
                                                try {
                                                    File fileAudio2=new File("C:/Nueva carpeta/71.mp3");
                                                    sonido.open(fileAudio2);
                                                    sonido.play();
                                                    
                                                } catch (Exception e) {
                                                    System.out.println(e);
                                                 
                                                }
                                               
                                            }

                                        }  
			// draw the finger tip
			g2.setPaint(Color.lightGray);
			int s = (int)(scale*finger_size);
			g2.fillOval(current_point.getScreenX(w-s/2),current_point.getScreenY(h-s/2),s,s);
			g2.setPaint(Color.black);
			g2.drawString(tcur.getCursorID()+"",current_point.getScreenX(w),current_point.getScreenY(h));
		}

		// draw the objects
		Enumeration<TuioDemoObject> objects = objectList.elements();
		while (objects.hasMoreElements()) {
			TuioDemoObject tobj = objects.nextElement();
			if (tobj!=null) tobj.paint(g2, width,height);
		}		
	}

    private AudioClip getAudioClip(URL toURL) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   
  
  
    
}
