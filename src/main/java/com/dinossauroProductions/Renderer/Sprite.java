package com.dinossauroProductions.Renderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;

public class Sprite{

    private BufferedImage image;

    public Sprite(BufferedImage sprite){
        this.image = sprite;
    }

    public Sprite(String path){
        try {

            image = ImageIO.read(getClass().getResource(path));

        } catch (IOException e) {

            System.out.println("Imagem de path "+path+" n�o foi encontrada.");
            e.printStackTrace();
        }
        /*
        Objects.requireNonNull(path);

        URL url = Image.class.getClassLoader().getResource(path);
        if (url == null) {
            String fmt = "cannot find resource [%s]";
            throw new IllegalStateException(String.format(fmt, path));
        }

        try (InputStream stream = url.openStream()) {
            this.image = ImageIO.read(stream);
        }
        catch (IOException e) {
            String fmt = "cannot read resource [%s] at [%s]";
            String err = String.format(fmt, path, url);
            throw new IllegalStateException(err, e);
        }

         */
    }

    public BufferedImage get(){
        return image;
    }

    public void set(BufferedImage image){
        this.image = image;
    }

}
