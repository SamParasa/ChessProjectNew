import javax.swing.*;
public class Bishop extends Piece {

    public Bishop(boolean isBlackPlayer) {
        super(isBlackPlayer);
        this.isBlackPlayer = isBlackPlayer;
        if (isBlackPlayer == true) {
            image = new ImageIcon("bbishop.gif");
        }
        if (isBlackPlayer == false) {
            image = new ImageIcon("wbishop.gif");
        }
    }

    public boolean canMove(int startx, int starty, int endx, int endy) {
        if(Math.abs(starty - endy) !=Math.abs(startx - endx)){
            return false;
        }

            if (startx > endx && starty > endy) {
                for (int x = startx - 1, y = starty - 1; x > endx && y > endy; x--, y--) {
                    if (Chess.position[x][y] != null && !Chess.position[endx][endy].isBlackPlayer) {
                        return false;
                    }
                    if(!Chess.position[endx][endy].isBlackPlayer){
                        return false;
                    }
                }
            } else if (startx < endx && starty < endy) {
                for (int x = startx + 1, y = starty + 1; x < endx && y < endy; x++, y++) {
                    if (Chess.position[x][y] != null && !Chess.position[endx][endy].isBlackPlayer) {
                        return false;
                    }
                    if(!Chess.position[endx][endy].isBlackPlayer) {
                        return false;
                    }
                }
            } else if (startx > endx && starty < endy) {
                for (int x = startx - 1, y = starty + 1; x > endx && y < endy; x--, y++) {
                    if (Chess.position[x][y] != null && !Chess.position[endx][endy].isBlackPlayer) {
                        return false;
                    }
                    if(!Chess.position[endx][endy].isBlackPlayer) {
                        return false;
                    }
                }
            } else if (startx < endx && starty > endy) {
                for (int x = startx + 1, y = starty - 1; x < endx && y > endy; x++, y--) {
                    if (Chess.position[x][y] != null && !Chess.position[endx][endy].isBlackPlayer) {
                        return false;
                    }
                    if(!Chess.position[endx][endy].isBlackPlayer) {
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


