import java.awt.*;
import java.awt.event.*;
import java.lang.String;






public class StartScreen extends extraFunctions {
    Image paper = loadImage("paper.png");
    Image StartBackground;
    int cursorPositionY = 100;

    public void initStart(){
        StartBackground = subImage(paper, 0, 0, 768, 1028);
    }



    public void drawStartScreen(Graphics2D g){
        clearBackground(800, 600, g);
        changeBackgroundColor(black,g);
        drawImage(StartBackground, 250, 30, 350, 500, g);
        changeColor(black, g);
        drawBoldText(450, cursorPositionY, "<", "Felix Titling", 20, g );
        changeColor(red, g);
        drawBoldText(300, 100, "New Game", "Felix Titling", 20, g);
        changeColor(grey, g);
        drawBoldText(300, 100+90, "Load game", "Felix Titling", 20, g);
        drawBoldText(300, 100+180, "Save game", "Felix Titling", 20, g);
        changeColor(red, g);
        drawBoldText(300, 100+270, "Credits", "Felix Titling", 20, g);
        drawBoldText(300, 100+360, "Exit", "Felix Titling", 20, g);

    }
    public void keyPressed(KeyEvent e) {



            if ((e.getKeyCode() == KeyEvent.VK_DOWN) && cursorPositionY < 460) {
                cursorPositionY += 90;

            }
            if ((e.getKeyCode() == KeyEvent.VK_UP) && cursorPositionY > 100) {
                cursorPositionY -= 90;

            }
            if ((e.getKeyCode() == KeyEvent.VK_SPACE) && cursorPositionY == 460) {
                System.exit(23);
            }

        }

}
