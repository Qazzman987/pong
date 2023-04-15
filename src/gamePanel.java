import javax.swing.*;
import java.awt.*;

public class gamePanel extends JPanel implements Runnable{

    final int originalTileSize = 16; // 48x48 tile
    final int scale = 3;

    final public int tileSize = originalTileSize * scale; //48x48
    //ratio 4:3
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;

    //    4:3

    final int screenWidth = tileSize * maxScreenCol;//768
    final int screenHeight = tileSize * maxScreenRow;//576

    int FPS = 60;

    keyHandler keyH = new keyHandler();

    Thread gameThread;

    playerOne playerOne = new playerOne(this,keyH);
    playerTwo playerTwo = new playerTwo(this,keyH);
    PongBall pongBall = new PongBall(this,keyH);

    int p1Score = 0;
    int p2Score = 0;



    public gamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); //for rendering
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public void run() {

        double drawInterval  = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null){

            update();

            repaint();//paintComponent

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if (remainingTime <  0){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }

    public void update(){

        playerOne.update();
        playerTwo.update();
        pongBall.update();

        collision();

    }

    public void collision(){
        int p1x = playerOne.x;
        int p1y = playerOne.y;
        int p2x = playerTwo.x;
        int p2y = playerTwo.y;
        int pbx = pongBall.x;
        int pby = pongBall.y;

        int p1Width = playerOne.width;
        int p1Height = playerOne.height;
        int p2Width = playerTwo.width;
        int p2Height = playerTwo.height;
        int pbWidth = pongBall.width;
        int pbHeight = pongBall.height;


        Rectangle p1Hitbox = new Rectangle(p1x, p1y, p1Width, p1Height);
        Rectangle p2Hitbox = new Rectangle(p2x, p2y, p2Width, p2Height);
        Rectangle pbHitbox = new Rectangle(pbx, pby, pbWidth, pbHeight);

        if (p1Hitbox.intersects(pbHitbox)){
            System.out.println("p1 pb col");
            pongBall.speedX = pongBall.speedX/-1;

        }
        if (p2Hitbox.intersects(pbHitbox)){
            System.out.println("p2 pb col");
            pongBall.speedX = pongBall.speedX/-1;
        }


    }


    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        playerOne.draw(g2);
        playerTwo.draw(g2);
        pongBall.draw(g2);


        g2.drawString(String.valueOf(p1Score), 200,20);
        g2.drawString(String.valueOf(p2Score), screenWidth-200,20);


        g2.dispose(); // good practice to save memory

    }








}