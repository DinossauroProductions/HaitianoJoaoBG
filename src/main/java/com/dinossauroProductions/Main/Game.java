package com.dinossauroProductions.Main;

import com.dinossauroProductions.Renderer.Sprite;

import com.dinossauroProductions.Utility.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


public class Game extends Canvas implements Runnable, KeyListener, MouseListener {

    public static float SCALE = 1f;
    public static int WIDTH = 960 /2, HEIGHT = 540 / 2;
    public static JFrame frame;
    private final BufferedImage image;
    public int FPS = 0;
    private final static float maxFPS = 60f;
    private boolean isRunning = true;
    private Thread thread;






    private Sprite spritetest;

    public synchronized void start() {
        thread = new Thread(this);
        isRunning = true;
        thread.start();
    }

    public Game(){

        WIDTH /= 1;
        HEIGHT /= 16;
        SCALE *= 16;


        addKeyListener(this);
        addMouseListener(this);
        setPreferredSize(new Dimension((int)(WIDTH*SCALE),(int)(HEIGHT*SCALE)));
        initFrame();
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        spritetest = new Sprite("/spritesheet_haitiano_joao.png");

    }

    @Override
    public void run() {

        long lastTime = System.nanoTime();
        double ns = (double) 1000000000 / maxFPS;
        double delta = 0;
        int frames = 0;
        double timer = System.currentTimeMillis();
        requestFocus();
        while(isRunning){
            long now = System.nanoTime();
            delta+= (now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1) {
                tick();
                render();
                frames++;
                delta--;
            }
            if(System.currentTimeMillis() - timer >= 1000){
                FPS = frames;
                frames = 0;
                timer+=1000;
            }
        }
        stop();

    }

    private void tick(){

    }
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = image.getGraphics();

        g.setColor(new Color(0, 50, 255));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        //render stuff

        //g.drawImage(spritetest.get(), 0, 0, null);
        //g.drawImage(Main.manager.mapReference.get(), 0, 0, null);


        //stop render

        g.dispose();
        g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, (int)(WIDTH*SCALE), (int)(HEIGHT*SCALE), null);

        bs.show();
    }
    private void stop(){
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void initFrame() {
        frame = new JFrame("Haitiano Joao BG");
        frame.add(this);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
