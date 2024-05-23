/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import com.farzine.swing.blurHash.BlurHash;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;


public class Test {

    public static void main(String[] args) {
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\alfez\\OneDrive\\Pictures\\Saved Pictures\\Screenshots\\aa.png"));
            String blurhashStr = BlurHash.encode(image);
            System.out.println(blurhashStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
