import java.awt.*;


public class PongBall extends entity{

    gamePanel gp;
    keyHandler keyH;

    boolean right = false;
    boolean left = false;
    boolean up = false;
    boolean down = false;



    public PongBall(gamePanel gp, keyHandler keyH){

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
    }

    public void setDefaultValues(){

        x = gp.screenWidth/2;
        y = gp.screenHeight/2;

        x = x-10;
        y = y-10;

        speedX = 4;
        speedY = 4;
        width = 20;
        height = 20;

        start_trajectory();

    }

    public void start_trajectory(){

        int ran = ((int)(Math.random()*2+1));

        if (ran == 1){
            right = true;
            System.out.println("right");
        } else if (ran == 2){
            left = true;
            System.out.println("left");
        }

        ran = ((int)(Math.random()*2+1));

        if (ran == 1){
            up = true;
            System.out.println("up");
        } else if (ran == 2){
            down = true;
            System.out.println("down");
        }

        trajectory();
    }

    public void trajectory(){

        if (right){
            speedX = speedX;
        }
        if (left){
            speedX = speedX/-1;
        }
        if (up){
            speedY = speedY;
        }
        if (down){
            speedY = speedY/-1;
        }

    }

    public void collision(){
        if (x <= 0){
            System.out.println("game over p1");
            speedX = speedX/-1;
            gp.p2Score += 1;

        }
        if (x >= gp.screenWidth-width){
            System.out.println("game over p2");
            speedX = speedX/-1;
            gp.p1Score += 1;
        }

        if (y <= 0){
            speedY = speedY/-1;
        }
        if (y >= gp.screenHeight-height){
            speedY = speedY/-1;
        }

    }



    public void update(){

        x += speedX;
        y += speedY;

        collision();


    }


    public void draw(Graphics2D g2){

        g2.setColor(new Color(255, 255, 255));
        g2.fillRect(x,y,width,height);


    }

}