import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class Snake extends PApplet{
   ArrayList<PVector> snake = new ArrayList<>();
    PVector position;
    PVector food;
int lenght=6;
    PVector direction= new PVector(0,0);
    int size=20;
    int w;
    int h;
    int speed=20;
   public void settings(){
       size(1000,700);
   }
    public void setup(){
        size(1000,700);
        w= width/size;
        h=height/size;
        position= new PVector(w/2,h/2);
        food=new PVector((int)random(w) ,(int)random(h));
        noStroke();
        fill(0);
    }
    public void draw(){
       background(200);
       drawSnake();
       drawFood();
    //rect(pos.x*size,pos.y*size,size,size);
   if(frameCount % speed == 0) {
       updateSnake();
}
   }
    public void updateSnake(){
        snake.add(new PVector(position.x,position.y));
        while(snake.size()> lenght){
            snake.remove(0);
        }
        position.add(direction);
        if(position.x == food.x && position.y == food.y){
            newFood();
            lenght+=1;
            speed=constrain(speed-1,0,20);
        }
        for (int i=0; i< snake.size(); i++){
            if(position.x== snake.get(i).x && position.y==snake.get(i).y){
                resetGame();
            }
        }

        if(position.x<0){ position.x= w-1;}
        if(position.x>w){ position.x= 0;}
        if(position.y<0){ position.y= h-1;}
        if(position.y>h){ position.y= 0;}
    }

    private void resetGame() {
        lenght=6;
         size=20;
        position= new PVector(w/2,h/2);
        newFood();
       //snake= new ArrayList<PVector>();

    }

    public void drawSnake(){
       fill(0);
    rect(position.x*size,position.y*size,size,size);
    for (int i=0; i< snake.size(); i++){
        rect(snake.get(i).x*size,snake.get(i).y*size,size,size);
    }
}
    public void drawFood() {
       fill(255,0,0);
        rect(food.x*size,food.y*size,size,size);
    }
    public void newFood(){
        food = new PVector((int)(random(w)), (int)(random(h)));
    }
   public  void keyPressed(){
       if(key == CODED){
           if(keyCode==UP){direction=new PVector(0,-1);}
           if(keyCode==DOWN){direction=new PVector(0,1);}
           if(keyCode==LEFT){direction=new PVector(-1,0);}
           if(keyCode==RIGHT){direction=new PVector(1,0);}
       }
    }
}
