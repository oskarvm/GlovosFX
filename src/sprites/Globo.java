package sprites;

import javafx.scene.image.Image;

public class Globo extends Sprite {
    public double velX, velY;
    public int dirX, dirY;
    public int level;
    public boolean eliminarAltura = false;
    public boolean eliminarConClick = false;

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
    public void move(int nivelglobos) {
        if (nivelglobos == 1){
            velY = 0.2F;
        }else if(nivelglobos == 2){
            velY = 0.3F;
        }else if(nivelglobos == 3){
            velY = 0.4F;
        }else if(nivelglobos == 4){
            velY = 0.5F;
        }else if(nivelglobos == 5){
            velY = 0.6F;
        }else if(nivelglobos == 6){
            velY = 0.7F;
        }
        else if(nivelglobos == 7){
            velY = 0.8F;
        }
        else if(nivelglobos == 8){
            velY = 1F;
        }
        else if(nivelglobos == 9){
            velY = 1.2F;
        }
        else if(nivelglobos == 10){
            velY = 1.5F;
        }
        else if(nivelglobos >= 11){
            velY = 2F;
        }

        setY(getPosY() - velY);
        if(getPosY() <= 0) {
            dirY = (-1)*dirY;
            level++;
        }

    }
}