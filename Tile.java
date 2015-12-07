<<<<<<< HEAD
//import Game;
=======
>>>>>>> origin/master
/**
 * @author Keiko
 *
 * Class for representing a Minesweeper Tile.
 */
public class Tile
{
    /**
     * Constructor for Tile class
     *
     * @param yRow The tile's row
     * @param xColumn The tile's column
     * @param isBomb True of the tile is a bomb
     */
    public Tile(int yRow, int xColumn, boolean isBomb)
    {
        _y = yRow;
        _x = xColumn;
        _isBomb = isBomb;
        
        // Tile should start out not revealed
        _isRevealed = false;
    }
    
    /**
     * A method to determine if a tile has been revealed
     *
     * @return True if the tile is revealed
     */
    public boolean isRevealed()
    {
        return _isRevealed;
    }
    
    /**
     * A method to determine if the tile is a bomb
     *
     * @return True if the tile is a bomb
     */
    public boolean isBomb()
    {
        return _isBomb;
    }
    
    /**
     * A method to get the x coordinate of the tile
     *
     * @return The tile's x coordinate
     */
    public int getX()
    {
        return _x;
    }
    
    /**
     * A method to get the y coordinate of the tile
     *
     * @return The tile's y coordinate
     */
    public int getY()
    {
        return _y;
    }
    
    public int getVolatileNeighbors()
    {
    // Get the neighbors of the Tile
       Tile[] neighbors = Game.getField().getNeighbors(this);
       
       int volatileNeighbors = 0;
       
       // Count volatile neighbors
       for (Tile neighbor : neighbors)
       {
          if (neighbor.isBomb())
          {
             volatileNeighbors++;
          }
       }
       
       return volatileNeighbors;
    }
    
    /**
     * Marks a tile as revealed
     */
    public void reveal()
    {
       _isRevealed = true;
    }
    
    /**
     * A method to get the string representation of the Tile
     *
     * @return The Tile turned into a string
     */
    public String toString()
<<<<<<< HEAD
    {   
        String bombToString = " # |";
=======
    {
        // Get the neighbors of the Tile
        Tile[] neighbors = Game.getTheGame().getField().getNeighbors(this);
        
        int volatileNeighbors = 0;
        
        String bombToString = " # |";
>>>>>>> origin/master
        
        /*
         * If the tile has been revealed, count the number of neighbors that 
         * are bombs if the space itself is not a bomb. Otherwise, just 
         * display a "!"
         */
        if (_isRevealed)
        {
           if (!isBomb())
           {
              
              bombToString = (" " + getVolatileNeighbors() + " |");
           }
           else
           {
              bombToString = (" ! |");
           }
        }
        
        // Return the string representation of the tile
        return bombToString;
    }
    
    private boolean _isBomb;
    private boolean _isRevealed;
    private int _x;
    private int _y;
}