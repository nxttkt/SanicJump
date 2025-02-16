package character;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Wave {
    public int x,y,width,height,speed;
    private int recall;
    
    public Wave(int x,int y,int w, int h, int speed, JPanel game){
        this.x = x;
        this.recall = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.speed = speed;
        move(game);
    }
    
    public void move(JPanel game){
        Timer timer = new Timer(50,new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){
                x -= speed;
                game.repaint();
                if(x<0) {
                    x = recall;
            }
            }
        });
        timer.start();
    }
    
}
