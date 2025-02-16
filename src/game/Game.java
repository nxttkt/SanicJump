package game;

import character.Sanic;
import character.Wave;
import event.Event;
import java.awt.BasicStroke;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class Game extends JPanel implements KeyListener{
    int gameSpeed = 30;
    long lastPress = 0;
    Sanic sanic = new Sanic(50,300,50,100);
    Wave[] waveSet = makeWaveSet(4);
    
    public Game(){
        this.setBounds(0,0,1000,600); // Windows
        this.addKeyListener(this);
        this.setFocusable(true); // 
        this.setLayout(null);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        g2.drawRect(sanic.x, sanic.y, sanic.sanicSize, sanic.sanicSize);
        g2.drawString(sanic.hp+"%", 20, 20);
        g2.setColor(Color.black);
        for(Wave wave: waveSet) {
            g2.drawRect(wave.x, wave.y, wave.width, wave.height);
            if(Event.checkHit(sanic, wave)) {
                g2.setStroke(new BasicStroke(10.0f));
                g2.setColor(Color.RED);
                g2.drawRect(0, 0, 1000, 900);
                sanic.hp -= 5;
            }
        }

      
    }
    
    private Wave[] makeWaveSet(int waveNumber) {
        Wave[] waveSet = new Wave[waveNumber];
        for(int i=0;i<waveNumber;i++) {
            double waveLocation = 1000+Math.floor(Math.random()*1000);
            waveSet[i] = new Wave((int)waveLocation,300,30,40,30,this);
        }
        return waveSet;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(System.currentTimeMillis()-lastPress>600) {
            if(e.getKeyCode()==87 || e.getKeyCode()==32 || e.getKeyCode()==38){
                sanic.jump(this);
                this.repaint();
            }
        lastPress = System.currentTimeMillis();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
