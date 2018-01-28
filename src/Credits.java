import java.awt.*;
import java.awt.event.KeyEvent;

public class Credits extends extraFunctions{

    private int wordsScrollingY;

    Credits(){
        wordsScrollingY = 600;
    }

    public void drawCredits(Graphics2D g){
        changeColor(white, g);
        wordsScrollingY-=2;
        drawBoldText(300, wordsScrollingY, "Made By:", g);
        drawText(200, wordsScrollingY + 25, "Zane Lamb          Benjamin Upton", g);
        drawText(200, wordsScrollingY + 50, "Jordan Drumm       James Waddell", g);
        drawBoldText(200, wordsScrollingY + 100, "Textures: ", g);
        drawText(200, wordsScrollingY + 125, "- Goblin art from Luminous Arc", g);
        drawText(200, wordsScrollingY + 150, "- Wolf art from Naruto Ninja Council 3", g);
        drawText(200, wordsScrollingY + 175, "- Witch art from Lunar Legend", g);
        drawText(200, wordsScrollingY + 200, "- Wyvern art from Fire Emblem: Mystery of the Emblem", g);
        drawText(200, wordsScrollingY + 225, "- Skeleton art form Castlevania: Bloodlines", g);
        drawText(200, wordsScrollingY + 250, "- Giant art from Final Fantasy: Record Keeper", g);
        drawText(200, wordsScrollingY + 275, "- Vanguard art from Shining Force CD", g);
        drawText(200, wordsScrollingY + 300, "- Valliard art from Tales of Eternia", g);
        drawText(200, wordsScrollingY + 325, "- Brawler art from Tales of Eternia", g);
        drawText(200, wordsScrollingY + 350, "- Razuul art from Heroes of Might and Magic 2", g);
        drawText(200, wordsScrollingY + 375, "- Vampire art from Pocky and Rocky", g);
        drawText(200, wordsScrollingY + 400, "- Therox art from Shining Force 2", g);
        drawText(200, wordsScrollingY + 425, "- Elite art from Suidoken", g);
        drawText(200, wordsScrollingY + 450, "- Dark Cultist art from Nora to Toki no Koubou: Kiri no Mori no Majo", g);
        drawText(200, wordsScrollingY + 475, "- Troll art from Nora to Toki no Koubou: Kiri no Mori no Majo", g);
        drawText(200, wordsScrollingY + 500, "- Magic art from Final Fantasy 6", g);
        drawText(200, wordsScrollingY + 525, "- Crucifix art from deviantart.com", g);
        drawText(200, wordsScrollingY + 550, "- World tiles from timefantasy.net", g);

        drawText(200, wordsScrollingY + 575, "- A big thanks to www.spriters-resource.com which supplied -", g);
        drawText(230, wordsScrollingY + 600, "- most of the sprites used within our game. -", g);
        drawBoldText(200, wordsScrollingY + 650, "Music/Sound Effects: ", g);
        drawText(230, wordsScrollingY + 675, "- Epic War Music from NCM Epic Music Ender Guney", g);
        drawText(230, wordsScrollingY + 700, "- Keyboard Typing from AR Sound Effects", g);
        drawText(230, wordsScrollingY + 725, "- Medieval Song Village Consort from Always Music", g);
        drawText(230, wordsScrollingY + 750, "- Money bag from Jojikiba", g);
        drawText(230, wordsScrollingY + 775, "- Whoosh Transition from Gaming Sound Effects", g);
        drawText(230, wordsScrollingY + 800, "- Button Sounds from CCHub - Free Music and Footages", g);
        drawText(230, wordsScrollingY + 825, "- BPage Turning from Audio Enabled", g);
        drawText(230, wordsScrollingY + 850, "- Book Closing from Lightning Mcree", g);
        drawText(230, wordsScrollingY + 875, "- Lively Meadow from Matthew Pablo (opengameart.org)", g);
        drawText(230, wordsScrollingY + 900, "- Game coin  from Jojikiba", g);
        drawText(230, wordsScrollingY + 925, "- Melee sounds from remaxim (opengameart.org)", g);
        drawText(230, wordsScrollingY + 950, "- Weapon hits from Jute (opengameart.org)", g);
        if(wordsScrollingY <= 1550){
            drawText(200, 400, "Thank you for playing our game!", g);
            drawText(250, 450, "- Press <SPACE> to return to menu -", g);
        }
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



