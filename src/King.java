import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class King extends Piece {
    public King(boolean isBlackPlayer) {
        super(isBlackPlayer);
        this.isBlackPlayer = isBlackPlayer;
        if (isBlackPlayer == true) {
            image= new ImageIcon("bking.gif");
        }
        if(isBlackPlayer==false){
            image=new ImageIcon("wking.gif");
        }
    }
    public  boolean canMove(int startx, int starty, int endx, int endy){
        if(Math.abs(startx-endx)==1 || Math.abs(starty-endy)==1){
            return true;
        }

        return false;
    }

}

