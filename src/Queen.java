import javax.swing.*;
public class Queen extends Piece {
    public Queen(boolean isBlackPlayer) {
        super(isBlackPlayer);
        this.isBlackPlayer = isBlackPlayer;
        if (isBlackPlayer == true) {
            image= new ImageIcon("bqueen.gif");
        }
        if(isBlackPlayer==false){
            image=new ImageIcon("wqueen.gif");
        }
    }
    public  boolean canMove(int startx, int starty, int endx, int endy){

        if (Math.abs(starty - endy) == Math.abs(startx - endx)) {
            for (int y = starty - 1; y > endy; y--) {
                for (int x = startx - 1; x > endx; x--)
                    if (Chess.position[x][y] != null) {
                        return false;
                    }
            }

            if (startx > endx && starty > endy) {
                for (int x = startx - 1, y = starty - 1; x > endx && y > endy; x++, y--) {
                    if (Chess.position[x][y] != null) {
                        return false;
                    }
                }
            } else if (startx < endx && starty < endy) {
                for (int x = startx + 1, y = starty + 1; x < endx && y < endy; x++, y++) {
                    if (Chess.position[x][y] != null) {
                        return false;
                    }
                }
            } else if (startx > endx && starty < endy) {
                for (int x = startx - 1, y = starty + 1; x > endx && y < endy; x--, y++) {
                    if (Chess.position[x][y] != null) {
                        return false;
                    }
                }
            } else if (startx < endx && starty > endy) {
                for (int x = startx + 1, y = starty - 1; x < endx && y > endy; x++, y--) {
                    if (Chess.position[x][y] != null) {
                        return false;
                    }
                }
            }
        }
        else if(Math.abs(starty - endy) !=Math.abs(startx - endx)){
            return false;
        }
        else if (starty>endy) { //Check Upwards
            for (int y = starty - 1; y > endy; y = y - 1) {
                if (Chess.position[startx][y] !=null) {
                    return false;
                }
            }
        }
        else if(starty<endy) { //Check downwards
            for (int y = starty + 1; y < endy; y = y + 1) {
                if (Chess.position[startx][y] !=null) {    ///
                    return false;
                }
            }
        }
        else if(startx > endx) { //Y isn't changing only X is - moving left
            for(int x = startx -1; x>endx; x=x-1){
                //if(Chess.position[starty][x] != null){
                if(Chess.position[x][endy] !=null){
                    return false;
                }
            }
        }
        else if(startx < endx) {//X- moving right
            for(int x = startx + 1;x < endx; x=x+1){
                if (Chess.position[x][endy]!=null){
                    return false;
                }
            }
        }

        if (starty == endy || startx == endx) {
            return false;
        }

        return true;
    }

}