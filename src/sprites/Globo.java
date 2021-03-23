package sprites;

import javafx.scene.image.Image;

public class Globo extends Sprite {
    public double velX, velY;
    public int dirX, dirY;
    public int level;
    public boolean eliminar = false;

    public Globo(Image image) {
        super(image);
        setX(Math.random()*600);
        setY(400);  //Eje vertical
        this.velX = 1.0f;
        this.velY = 0.5f;
        this.dirX = 1;
        this.dirY = 1;
    }

    @Override
    public void move() {
        if (level == 3){
            velY = 1F;
        }else if(level == 5){
            velY= 2F;
        }else if(level == 7){
            velY= 4F;
        }
        if(dirY == 1) {
            setY(getPosY() + velX);
            if(getPosY()>=600-getHeight()) {
                dirY = (-1)*dirY;
                setY(getPosY() + velY);
            }
        }else {
            setY(getPosY() - velY);
            if(getPosY() <= 0) {
                dirY = (-1)*dirY;
                level++;
            }
        }
    }
}