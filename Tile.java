//import Game;
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
        
        // Tile should start out not revealed or tagged as suspicious
        _isRevealed = false;
        _isTaggedAsMine = false;
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
     * Returns whether or not the player has tagged this tile as a possible mine
     * @return a boolean indicating whether or not the user has flagged this 
     * tile
     */
    public boolean isTaggedAsMine()
    {
       return _isTaggedAsMine;
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
    
    /**
     * Counts how many neighbors of the tile are mines
     * @return the nearby mine count
     */
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
    
    public void flipFlag()
    {
       _isTaggedAsMine = !_isTaggedAsMine;
    }
    
    /**
     * A method to get the string representation of the Tile
     *
     * @return The Tile turned into a string
     */
    public String toString()
    {   
        String bombToString = "   |";
        
        /*
         * If the tile has been revealed, count the number of neighbors that 
         * are bombs if the space itself is not a bomb. If the space is a bomb, 
         * display a "!"
         */
        if (_isRevealed)
        {
           if (!isBomb())
           {
              
              bombToString = (" " + (getVolatileNeighbors() == 0 ? "." : 
                 getVolatileNeighbors()) + " |");
           }
           else
           {
              bombToString = (" ! |");
           }
        }
        else if (_isTaggedAsMine)
        {
           bombToString = (" \u2691 |");
        }
        
        // Return the string representation of the tile
        return bombToString;
    }
    
    private boolean _isBomb;
    private boolean _isRevealed;
    private boolean _isTaggedAsMine;
    private int _x;
    private int _y;
}