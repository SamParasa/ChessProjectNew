import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;

public class BoardMouseListener implements MouseListener{
    int startx, starty;

    @Override
    public void mouseClicked(MouseEvent e) {
    }

        public void mousePressed (MouseEvent e){
        int pressx= e.getX();
        startx=pressx/Chess.PIECESIZE;
        int pressy= e.getY();
        starty=pressy/Chess.PIECESIZE;

    }

    public void mouseReleased(MouseEvent e){
        int endx=e.getX()/Chess.PIECESIZE;
        int endy=e.getY()/Chess.PIECESIZE;

        if(startx== endx && starty==endy){
            return;
        }
        if(Chess.position[startx][starty].canMove(startx,starty,endx,endy)==false){
            return;
        }

        Chess.position[endx][endy]=Chess.position[startx][starty];
        Chess.position[startx][starty]=null;
        Chess.board.repaint();

        while(true){
            System.out.println(" Hi");
            startx=(int)(Math.random()*8);
            starty=(int)(Math.random()*8);
            endx=(int)(Math.random()*8);
            endy=(int)(Math.random()*8);


            if(Chess.position[startx][starty]==null)
            {
                continue;
            }

            else if(!Chess.position[startx][starty].isBlackPlayer ) {
            continue;
            }

            else if(Chess.position[endx][endy]  != null ) {

                if (Chess.position[endx][endy].isBlackPlayer) {
                    continue;
                } else if (Chess.position[endx][endy].isBlackPlayer) {
                    continue;
                }
                else if(Chess.position[startx][starty].canMove(startx,starty,endx,endy)==false){
                    continue;
                }

                else if( Chess.position[endx][endy].canMove(startx,starty,endx,endy)==false){
                    continue;
                }
            }

            else if(startx==endx && starty==endy){
                continue;
            }
            Chess.position[endx][endy]=Chess.position[startx][starty];
            Chess.position[startx][starty]=null;
            Chess.board.repaint();
            break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
