package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    static final int WIDTH = 1300;
    static final int HEIGHT = 700;
    private Thread thread;// creating a thread
    private boolean running = false;

    // instance of the handler
    private Handler handler;
    private Metrics metrics;
    private Random r;
    private Spawn spawner;
    public static int bufferStrategy = 3;

    // game constructor
    public Game() {
        this.requestFocus();
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));

        new window(WIDTH, HEIGHT, "Automobile Collision Advisory Simulation", this);// setting the dimentions
        // according to "this "
        // instance

        r = new Random();
        metrics = new Metrics();
        spawner = new Spawn(handler, metrics);
        // adding a new object
        handler.addObject(new Road(800, 300, ID.Road, handler));
        handler.addObject(new Player(0, 110, ID.Player, handler));

        //handler.addObject(new Car1(0, 360, ID.Car));
        //handler.addObject(new Car2(0, 410, ID.Car));
        //handler.addObject(new Car3(0, 460, ID.Car));
        //handler.addObject(new Car4(0, 510, ID.Car));
        //handler.addObject(new Player(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.Player, handler));
        //handler.addObject(new Enemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.Enemy, handler));
        // handler.addObject(new Enemy(r.nextInt(WIDTH), r.nextInt(HEIGHT),
        // ID.Enemy, handler));
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            running = false;
            thread.join();// to stop the thread

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        // creating a game loop
        // this defines how thwe game will behave

        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
                frames++;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                // System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        // handling tick
        handler.tick();
        metrics.tick();
        spawner.tick();

    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            this.createBufferStrategy(bufferStrategy);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Handling render
        handler.render(g);
        metrics.render(g);
        g.dispose();
        bs.show();

    }

    //setting buffer strategy
    public void setBuffer(int buffer) {
        this.bufferStrategy = buffer;
    }

    // ensuring the prayer does not close boards
    public static int clamp(int var, int min, int max) {
        if (var >= max) {
            return var = max;
        } else if (var < +min) {
            return var = min;
        } else {
            return var;
        }
    }

    public static void main(String[] args) {
        new Game();
    }

}
