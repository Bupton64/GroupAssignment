import java.awt.*;
import java.awt.event.KeyEvent;

public class Credits extends extraFunctions{

    private int wordsScrollingY;

    Credits(){
        wordsScrollingY = 600;
    }

    public void drawCredits(Graphics2D g){
        clearBackground(800, 600, g);
        changeBackgroundColor(black, g);
        changeColor(white, g);
        if(wordsScrollingY > -955) {
            wordsScrollingY -= 2;
        }
        drawBoldText(330, wordsScrollingY, "Made By:", g);
        drawText(220, wordsScrollingY + 25, "Zane Lamb","Times New Roman", 25, g);
        drawText(220, wordsScrollingY + 50, "Jordan Drumm","Times New Roman", 25, g);
        drawText(450, wordsScrollingY + 25, "Benjamin Upton","Times New Roman", 25, g);
        drawText(450, wordsScrollingY + 50, "James Waddell","Times New Roman", 25, g);
        drawBoldText(325, wordsScrollingY + 100, "Textures: ", g);
        drawText(20, wordsScrollingY + 125, "- Goblin art from Luminous Arc", "Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 150, "- Wolf art from Naruto Ninja Council 3","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 175, "- Witch art from Lunar Legend","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 200, "- Wyvern art from Fire Emblem: Mystery of the Emblem","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 225, "- Skeleton art form Castlevania: Bloodlines","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 250, "- Giant art from Final Fantasy: Record Keeper","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 275, "- Vanguard art from Shining Force CD","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 300, "- Valliard art from Tales of Eternia","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 325, "- Brawler art from Tales of Eternia","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 350, "- Razuul art from Heroes of Might and Magic 2","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 375, "- Vampire art from Pocky and Rocky","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 400, "- Therox art from Shining Force 2","Times New Roman", 20,g);
        drawText(20, wordsScrollingY + 425, "- Elite art from Suidoken","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 450, "- Dark Cultist art from Nora to Toki no Koubou: Kiri no Mori no Majo","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 475, "- Troll art from Nora to Toki no Koubou: Kiri no Mori no Majo","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 500, "- Magic art from Final Fantasy 6","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 525, "- Crucifix art from deviantart.com","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 550, "- World tiles from timefantasy.net","Times New Roman", 20, g);

        drawText(160, wordsScrollingY + 575, "- A big thanks to www.spriters-resource.com who supplied -","Times New Roman", 20, g);
        drawText(230, wordsScrollingY + 600, "- most of the sprites used within our game. -","Times New Roman", 20, g);
        drawBoldText(200, wordsScrollingY + 650, "Music/Sound Effects: ", g);
        drawText(20, wordsScrollingY + 675, "- Epic War Music from NCM Epic Music Ender Guney","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 700, "- Keyboard Typing from AR Sound Effects","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 725, "- Medieval Song Village Consort from Always Music","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 750, "- Money bag from Jojikiba","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 775, "- Whoosh Transition from Gaming Sound Effects","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 800, "- Button Sounds from CCHub - Free Music and Footages","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 825, "- BPage Turning from Audio Enabled","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 850, "- Book Closing from Lightning Mcree","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 875, "- Lively Meadow from Matthew Pablo (opengameart.org)","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 900, "- Game coin  from Jojikiba","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 925, "- Melee sounds from remaxim (opengameart.org)","Times New Roman", 20, g);
        drawText(20, wordsScrollingY + 950, "- Weapon hits from Jute (opengameart.org)","Times New Roman", 20, g);

        drawText(50, wordsScrollingY + 1150, "Thank you for playing our game!", g);
        drawText(50, wordsScrollingY + 1250, "- Press <SPACE> to return to menu -", g);

        System.out.println(wordsScrollingY);
    }

    //Goblin art from Luminous Arc
    //Wolf art from Naruto Ninja Council 3
    //Witch art from Lunar Legend
    //Wyvern art from Fire Emblem: Mystery of the Emblem
    //Skeleton art form Castlevania: Bloodlines
    //Giant art from Final Fantasy: Record Keeper
    //Vanguard art from Shining Force CD
    //Valliard art from Tales of Eternia
    //Brawler art from Tales of Eternia
    //Razuul art from Heroes of Might and Magic 2
    // Vampire art from Pocky and Rocky
    // Therox art from Shining Force 2
    // Elite art from Suidoken
    // Dark Cultist art from Nora to Toki no Koubou: Kiri no Mori no Majo
    // Troll art from art from Nora to Toki no Koubou: Kiri no Mori no Majo
    //www.spriters-resource.com
    public int keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            return 4;
        }
        return 0;
    }
}



