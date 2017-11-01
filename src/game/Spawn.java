package game;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private Metrics metrics;

    private int car2, speed2, scoreKeep, lambo, segg, gtr, mustag, camaro,top;
    private Random r = new Random();

    public Spawn(Handler handler, Metrics metrics) {
        this.handler = handler;
        this.metrics = metrics;
    }

    public void tick() {
        scoreKeep++;
        speed2++;
        car2++;
        lambo++;
        gtr++;
        segg++;
        mustag++;
        camaro++;
        top++;

        if (speed2 == 75 || speed2 == 1000) {
            //code inside
        } else if (speed2 == 400) {
            handler.addObject(new Car_speed_2_reverse(0, 110, ID.Car_speed_2_reverse, handler));
        }
        if (top == 500) {
            top = 0;
            handler.addObject(new Car6(0, 110, ID.Car, handler));
            
        }
        if (car2 == 100) {
            car2 = 0;
            handler.addObject(new trailer(1300, 160, ID.trailer, handler));
        }
        if (camaro == 60) {
            camaro = 0;
            handler.addObject(new Car5(1300, 160, ID.Car, handler));
        }

        if (lambo == 100) {
            lambo = 0;
            handler.addObject(new Car1(0, 360, ID.Car, handler));
        }
        if (gtr == 70) {
            gtr = 0;
            handler.addObject(new Car2(0, 410, ID.Car, handler));
        }
        if (segg == 70) {
            segg = 0;
            handler.addObject(new Car3(1300, 460, ID.Car, handler));
        }
        if (mustag == 60) {
            mustag = 0;
            handler.addObject(new Car4(1300, 510, ID.Car, handler));
        }

        /*	else if((speed2/200)%3 == 0){
         handler.addObject(new Car_speed_2_reverse(0, 410, ID.Car_speed_2_reverse, handler));
         handler.addObject(new Car_speed_2(900, 460, ID.Car_speed_2, handler));
         }
		
		

         /*if (scoreKeep == 0) {
         handler.addObject(new Car_speed_2(0, 510, ID.Car_speed_2, handler));
         handler.addObject(new trailer(900, 460, ID.trailer, handler));
         }
         if (scoreKeep == 100) {
         handler.addObject(new Car_speed_2_reverse(0, 410, ID.Car_speed_2_reverse, handler));
         handler.addObject(new Car_speed_2(900, 460, ID.Car_speed_2, handler));
         }
		
         if (scoreKeep >= 500) {
         scoreKeep = 0;
         handler.addObject(new trailer(900, 160, ID.trailer, handler));
         }

         /*	if (scoreKeep >= 500) {
         scoreKeep = 0;
         metrics.setLevel(metrics.getLevel() + 1);

         if (metrics.getLevel() == 2) {
         handler.addObject(new Enemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.Enemy, handler));
         } else if (metrics.getLevel() == 3) {
         handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.Enemy, handler));
         handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.Enemy, handler));
         } else if (metrics.getLevel() == 4) {
         handler.addObject(new Savior(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.Savior, handler));
         handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
         handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.Enemy, handler));
         handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.Enemy, handler));
         } else if (metrics.getLevel() == 8) {
         handler.addObject(new Savior(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.Savior, handler));
         handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
         handler.addObject(new Destroyer(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.Destroyer, handler));
         } else if (metrics.getLevel() == 9) {
         handler.addObject(new Savior(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.Savior, handler));
         handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.Enemy, handler));

         }
         else{
         handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.Enemy, handler));
         //game.setBuffer(1);
         }
         }*/
    }
}
