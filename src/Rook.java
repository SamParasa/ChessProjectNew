import javax.swing.*;
public class Rook extends Piece {
    public Rook(boolean isBlackPlayer) {
        super(isBlackPlayer);
        this.isBlackPlayer = isBlackPlayer;
        if (isBlackPlayer == true) {
            image = new ImageIcon("brook.gif");
        }
        if (isBlackPlayer == false) {
            image = new ImageIcon("wrook.gif");
        }
    }
    public  boolean canMove(int startx,int starty,int endx,int endy){
        if(Math.abs(startx-endx)==1 || Math.abs(starty-endy)==1){
            return true;
        }
        else if(Math.abs(startx-endx)==1 && Math.abs(starty-endy)==1){
            return false;
        }
        else if(Math.abs(startx-endx)==Math.abs(starty-endy)){
            return false;
        }


        else if (starty>endy) {
            for (int y = starty - 1; y > endy-1; y = y - 1) {
                if (Chess.position[startx][y] !=null) {
                    return false;
                }
                return true;
            }
        }
        else if(starty<endy) { //Check downwards
            for (int y = starty + 1; y < endy+1; y = y + 1) {
                if (Chess.position[startx][y] !=null) {    ///
                    return false;
                }
                return true;
            }
        }
        else if(startx > endx) { //Y isn't changing only X is - moving left
            for(int x = startx -1; x>endx-1; x=x-1){
                //if(Chess.position[starty][x] != null){
                if(Chess.position[x][endy] !=null){
                    return false;
                }
                return true;
            }
        }
        else if(startx < endx) {
            for(int x = startx + 1;x < endx+1; x=x+1){
                if (Chess.position[x][endy]!=null){
                    return false;
                }
                return true;
            }
        }
        if(starty == endy || startx == endx){
            return false;
        }

        return false;
    }
}