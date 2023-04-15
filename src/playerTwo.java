import java.awt.*;


public class playerTwo extends entity{

    gamePanel gp;
    keyHandler keyH;


    public playerTwo(gamePanel gp, keyHandler keyH){

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
    }

    public void setDefaultValues(){

        speed = 4;
        width = 10;
        height = 80;

        x = gp.screenWidth-width;
        y = gp.screenHeight/2;

    }



    public void update(){


        if (keyH.upP2Pressed){
            y -= speed;
            collision();
        } else if (keyH.downP2Pressed){
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
