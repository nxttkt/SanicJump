package character;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Sanic {
    public int x,y,sanicSize,hp;
    private int jumpHeight = 100;
    
    public Sanic(int x, int y, int sanicSize,int hp){
        this.x = x;
        this.y = y;
        this.sanicSize = sanicSize;
        this.hp = hp;
    }
    
    public void jump(JPanel game){
        this.y -= jumpHeight;
        game.repaint();
        Timer timer = new Timer(450, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                y += jumpHeight;
                game.repaint();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}