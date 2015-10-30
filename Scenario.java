import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scenario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scenario extends World
{

    /**
     * Constructor for objects of class Scenario.
     * 
     */
    public Scenario()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(20, 20, 21); 
        Greenfoot.setSpeed( 35 );
        Snake.l.clear();
        
        Snake s = new Snake(); 
        addObject( s, 10, 10 );
        s.addFood();
        
        for( int i = 1; i < 3; i++ ) addObject( new Snake(), 10-i, 10 );
        
    }
    
}
