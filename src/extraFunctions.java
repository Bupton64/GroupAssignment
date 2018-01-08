import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

import java.util.Stack;
import java.util.Random;

import javax.imageio.*;
import javax.sound.sampled.*;

public abstract class extraFunctions {

    Image backgroundImage;


    public boolean updateMapMovement(Collision collisionPoints, Character player){
        return false;
    }
    public void setUpCollision(Collision collisionPoints) {

    }



    // My Definition of some colors
    Color black = Color.BLACK;
    Color orange = Color.ORANGE;
    Color pink = Color.PINK;
    Color red = Color.RED;
    Color purple = new Color(128, 0, 128);
    Color blue = Color.BLUE;
    Color green = Color.GREEN;
    Color yellow = Color.YELLOW;
    Color white = Color.WHITE;

    // Clears the background, makes the whole window whatever the background color is
    public void clearBackground(int width, int height,Graphics g) {
        // Clear background
        g.clearRect(0, 0, width, height);
    }

    // Changes the drawing Color to the color c
    public void changeColor(Color c,Graphics g) {
        // Set colour
        g.setColor(c);
    }

    // This function draws text on the screen at (x,y)
    public void drawText(double x, double y, String s,Graphics2D g) {
        // Draw text on the screen
        g.setFont(new Font("Arial", Font.PLAIN, 40));
        g.drawString(s, (int)x, (int)y);
    }

    // This function draws bold text on the screen at (x,y)
    public void drawBoldText(double x, double y, String s, Graphics2D g) {
        // Draw text on the screen
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.drawString(s, (int)x, (int)y);
    }

    // with Font (font,size)
    public void drawText(double x, double y, String s, String font, int size, Graphics2D g) {
        // Draw text on the screen
        g.setFont(new Font(font, Font.PLAIN, size));
        g.drawString(s, (int)x, (int)y);
    }

    // This function draws bold text on the screen at (x,y)
    // with Font (font,size)
    public void drawBoldText(double x, double y, String s, String font, int size, Graphics2D g) {
        // Draw text on the screen
       g.setFont(new Font(font, Font.BOLD, size));
        g.drawString(s, (int)x, (int)y);
    }

    // Draws a line from (x1,y2) to (x2,y2)
    void drawLine(double x1, double y1, double x2, double y2, Graphics2D g) {
        // Draw a Line
        g.draw(new Line2D.Double(x1, y1, x2, y2));
    }

    // Draws a line from (x1,y2) to (x2,y2) with width l
    void drawLine(double x1, double y1, double x2, double y2, double l, Graphics2D g) {
        // Set the stroke
        g.setStroke(new BasicStroke((float)l));

        // Draw a Line
       g.draw(new Line2D.Double(x1, y1, x2, y2));

        // Reset the stroke
        g.setStroke(new BasicStroke(1.0f));
    }

    // This function draws a rectangle at (x,y) with width and height (w,h)
    void drawRectangle(double x, double y, double w, double h, Graphics2D g) {
        // Draw a Rectangle
        g.draw(new Rectangle2D.Double(x, y, w, h));
    }

    // This function draws a rectangle at (x,y) with width and height (w,h)
    // with a line of width l
    void drawRectangle(double x, double y, double w, double h, double l, Graphics2D g) {
        // Set the stroke
        g.setStroke(new BasicStroke((float)l));

        // Draw a Rectangle
        g.draw(new Rectangle2D.Double(x, y, w, h));

        // Reset the stroke
        g.setStroke(new BasicStroke(1.0f));
    }

    // This function fills in a rectangle at (x,y) with width and height (w,h)
    void drawSolidRectangle(double x, double y, double w, double h, Graphics2D g) {
        // Fill a Rectangle
        g.fill(new Rectangle2D.Double(x, y, w, h));
    }

    // This function draws a circle at (x,y) with radius
    void drawCircle(double x, double y, double radius, Graphics2D g) {
        // Draw a Circle
        g.draw(new Ellipse2D.Double(x-radius, y-radius, radius*2, radius*2));
    }

    // This function draws a circle at (x,y) with radius
    // with a line of width l
    void drawCircle(double x, double y, double radius, double l, Graphics2D g) {
        // Set the stroke
        g.setStroke(new BasicStroke((float)l));

        // Draw a Circle
        g.draw(new Ellipse2D.Double(x-radius, y-radius, radius*2, radius*2));

        // Reset the stroke
       g.setStroke(new BasicStroke(1.0f));
    }

    // This function draws a circle at (x,y) with radius
    void drawSolidCircle(double x, double y, double radius,Graphics2D g) {
        // Fill a Circle
        g.fill(new Ellipse2D.Double(x-radius, y-radius, radius*2, radius*2));
    }

    ////////////////////////////////////////////////
    ///
    /// Animations
    ///
    //////////////////////////////////////////////

    public int getAnimationFrame(double timer, double duration, int numFrames) {
        // Get frame
        int i = (int)floor(((timer % duration) / duration) * numFrames);
        // Check range
        if(i >= numFrames) {
            i = numFrames-1;
        }
        // Return
        return i;
    }

    public int floor(double value) {
        // Calculate and return floor
        return (int)Math.floor(value);
    }


    public Image loadImage(String filename) {
        try {
            // Load Image
            Image image = ImageIO.read(new File(filename));

            // Return Image
            return image;
        } catch (IOException e) {
            // Show Error Message
            System.out.println("Error: could not load image " + filename);
            System.exit(1);
        }

        // Return null
        return null;
    }

    public Image subImage(Image source, int x, int y, int w, int h) {
        // Check if image is null
        if(source == null) {
            // Print Error message
            System.out.println("Error: cannot extract a subImage from a null image.\n");

            // Return null
            return null;
        }

        // Convert to a buffered image
        BufferedImage buffered = (BufferedImage)source;

        // Extract sub image
        Image image = buffered.getSubimage(x, y, w, h);

        // Return image
        return image;
    }

    // Draws an image on the screen at position (x,y)
    public void drawImage(Image image, double x, double y,Graphics g) {
        // Check if image is null
        if(image == null) {
            // Print Error message
            System.out.println("Error: cannot draw null image.\n");
            return;
        }

        // Draw image on screen at (x,y)
        g.drawImage(image, (int)x, (int)y, null);
    }

    // Draws an image on the screen at position (x,y)
    public void drawImage(Image image, double x, double y, double w, double h,Graphics g) {
        // Check if image is null
        if(image == null) {
            // Print Error message
            System.out.println("Error: cannot draw null image.\n");
            return;
        }
        // Draw image on screen at (x,y) with size (w,h)
        g.drawImage(image, (int)x, (int)y, (int)w, (int)h, null);
    }
}
