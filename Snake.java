import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import javax.swing.JOptionPane;

public class Snake extends Actor
{

    static List < Snake > l = new ArrayList< Snake >();
    public int dir;
    
    public int points;

    public void addedToWorld( World world ){

        l.add( this );
        
    }

    public void act() {

        if( l.get( 0 ) == this ){

            controle();

            if( isTouching( Snake.class ) ) {

                JOptionPane.showMessageDialog( null, "Você se fudeu! \n Pontos: "+ points );
                Greenfoot.stop();
                Greenfoot.setWorld( new Scenario() );

            }

            if( isTouching( Food.class ) ){
                
                getWorld().removeObject( getOneIntersectingObject( Food.class ) );
                points ++;
                
                addFood();
                addTail();

            }

        }else{

            Snake sn = prev();
            dir = getRotation();
            setRotation( sn.dir );

        }

        move( 1 ); 

    }   

    public void addTail(){

        Snake s = new Snake();
        Snake sn = l.get( l.size() - 1 );
        getWorld().addObject( s, sn.getX(), sn.getY() );
        s.setRotation( sn.getRotation() );

    }
    
    public void addFood(){
    
        while( true ){
        
            int x = Greenfoot.getRandomNumber( 20 ),
            y = Greenfoot.getRandomNumber( 20 );
            
            if( getWorld().getObjectsAt( x, y, Snake.class ).size() == 0 ){
            
                getWorld().addObject( new Food(), x, y );
                break;
            
            }
        
        }
    
    }

    public Snake prev(){

        return l.get( l.indexOf( this ) - 1 );

    } 

    public void controle(){

        dir = getRotation();

        if( key( "w" ) && dir != 90 ){

            setRotation( 270 );

        }else if( key( "a" ) && dir != 0 ){

            setRotation( 180 );

        }else if(  key( "s" ) && dir != 270 ){

            setRotation( 90 );
            
        }else if(  key( "d" ) && dir != 180 ){

            setRotation( 0 );

        }

    }

    public boolean key( String s ){

        return Greenfoot.isKeyDown( s );

    }

}
