package com.mycompany.app;

import com.google.common.graph.Graph;
import org.checkerframework.checker.units.qual.A;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class visuals {
    public static int width = 1024;
    public static int height = 576;
    public static void visual(boolean isMoldy, String filename, ArrayList<ArrayList<Float>> colours) {
        CustomPaintComponent cpc = new CustomPaintComponent();
        cpc.setVariables(isMoldy, filename, colours);
        Frame frame = new Frame();

        frame.add(cpc);

        frame.setSize(width, height);

        frame.setVisible(true);
    }
    static class CustomPaintComponent extends Component {
        private boolean isMoldy;
        private String filename;
        private ArrayList<ArrayList<Float>> colours;
        public void setVariables(boolean isMoldy, String filename, ArrayList<ArrayList<Float>> colours){
            this.isMoldy = isMoldy;
            this.filename = filename;
            this.colours = colours;

        }
        public void paint(Graphics g) {
            String title;
            Graphics2D g2d = (Graphics2D)g;

            BufferedImage img = null;
            try {
                img = ImageIO.read(new File(filename));
            } catch (IOException ignored) {
            }

            int img_w = img.getWidth();
            int img_h = img.getHeight();

            while (img_w > width / 2 && img_h > height / 2){
                img_w /= 2;
                img_h /= 2;
            }

            g2d.drawImage(img, (width / 4) - (img_w / 2), (height / 2) - (img_h / 2), img_w, img_h, null);

            if (isMoldy) {
                title = "MOLDY";
            } else {
                title = "NOT MOLDY";
            }

            Font font = new Font("Serif", Font.PLAIN, 100);
            g2d.setFont(font);

            g2d.drawString(title, 100, 100);

            int split = 241 / colours.size();
            int current_shift = 0;

            for (ArrayList<Float> colour : colours) {
                g2d.setColor(new Color(colour.get(0) / 255, colour.get(1) / 255, colour.get(2) / 255));
                g2d.fillRect(683 + (current_shift * split), 75, split, 376);
                current_shift++;
            }
        }

    }

}
