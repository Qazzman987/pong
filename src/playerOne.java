import java.awt.*;


public class playerOne extends entity{

    gamePanel gp;
    keyHandler keyH;


    public playerOne(gamePanel gp, keyHandler keyH){

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
    }

    public void setDefaultValues(){

        x = 0;
        y = gp.screenHeight/2;
        speed = 4;
        width = 10;
        height = 80;

    }



    public void update(){


        if (keyH.upP1Pressed){
            y -= speed;
            collision();
        } else if (keyH.downP1Pressed){
            y += speed;
            collision();
        }


    }

    public void collision(){
        if (y <= 0){
            y = 0;
        }
        if (y >= gp.screenHeight-80){
            y = gp.screenHeight-80;
        }
    }


    public void draw(Graphics2D g2){


        g2.setColor(new Color(255, 255, 255));
        g2.fillRect(x,y,width,height);

    }

}