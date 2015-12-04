import java.util.Random;

//import Tile.java

/**
 * @author Michael
 * @author Nik
 * @author Shane
 * @author Connor
 * 
 *         Class for aggregation and manipulation of Tile objects that
 *         constitute a Field.
 */
public class Field
{
   private int _yRows;
   private int _xColumns;
   private Tile[][] _field;
   
   public static final int DEFAULT_BOMB_RATE = -1;
   public static final int DEFAULT_FIELD_SIZE = 7;
   
   // Return values for revealed tiles
   public static final int TILE_REVEALED_NORMAL = 0;
   public static final int TILE_REVEALED_BOMB = 1;
   public static final int TILE_PREVIOUSLY_REVEALED = 2;
   
   /**
    * Creates a Field with the default size and bomb odds
    */
   public Field()
   {
      this(DEFAULT_FIELD_SIZE);
   }
   
   /**
    * Creates a Field with the given square size and default bomb odds
    */
   public Field(int size)
   {
      this(size, size);
   }
   
   /**
    * Creates a Field with given rows and columns, and default bomb odds
    */
   public Field(int yRows, int xColumns)
   {
      this(yRows, xColumns, DEFAULT_BOMB_RATE);
   }
   
   /**
    * Creates a field with given dimensions and bomb odds
    */
   public Field(int yRows, int xColumns, int minePercentage)
   {
      _yRows = yRows;
      _xColumns = xColumns;
      _field = new Tile[_yRows][_xColumns];
      Random random = new Random();
      boolean isBomb = false;
      
      // Fill the field with tiles
      for (int i = 0; i < _yRows; i++)
      {
         for (int j = 0; j < _xColumns; j++)
         {
            if (random.nextInt(100) <= minePercentage)
            {
               isBomb = true;
            }
            
            _field[i][j] = new Tile(i, j, isBomb);
         }
      }
   }
   
   
   /**
    * Returns the tile at given coordinates
    * 
    * @
    */
   public Tile getTileAt(int yRow, int xColumn)
   {
      return _field[yRow][xColumn];
   }
   
   
   public Tile[] getNeighbors(Tile t)
   {
      Tile[] neighbors = null;
      
      // If the Tile t is at the corner of the field, it only has 3 neighbors.
      if (t.getX() == 0 && t.getY() == 0 
            || t.getX() == _xColumns - 1 && t.getY() == 0 
            || t.getX() == _xColumns - 1 && t.getY() == _yRows - 1 
            || t.getX() == 0 && t.getY() == _yRows - 1)
      {
         neighbors = new Tile[3];
         
         if (t.getX() == 0 && t.getY() == 0)
         {
            neighbors[0] = getTileAt(0,1); 
            neighbors[1] = getTileAt(1,1); 
            neighbors[2] = getTileAt(1,0); 
         } // if
         
         if (t.getX() == _xColumns - 1 && t.getY() == 0)
         {
            neighbors[0] = getTileAt(1,t.getX() - 1); 
            neighbors[1] = getTileAt(1,t.getX() - 2); 
            neighbors[2] = getTileAt(0,t.getX() - 1); 
         } // if
         
         if (t.getX() == _xColumns - 1 && t.getY() == _yRows - 1)
         {
            neighbors[0] = getTileAt(t.getY()-1, t.getX() - 2); 
            neighbors[1] = getTileAt(t.getY()-2, t.getX() - 2); 
            neighbors[2] = getTileAt(t.getY()-2, t.getX() - 1); 
         } // if
         
         if (t.getX() == 0 && t.getY() == _yRows - 1)
         {
            neighbors[0] = getTileAt(t.getY()-2, 0); 
            neighbors[1] = getTileAt(t.getY()-2, 1); 
            neighbors[2] = getTileAt(t.getY()-1, 1); 
         } // if
      } // if
      
      
      // If the Tile t is at the edge of the field, it has 5 neighbors. 
      else if (t.getY() == 0 
            || t.getX() == _xColumns - 1 
            || t.getY() == _yRows - 1 
            || t.getX() == 0)
      {
         neighbors = new Tile[5];
         
         if (t.getY() == 0)
         {
            neighbors[0] = getTileAt(0, t.getX()+1); //_field[_xColumns + 1][0];
            neighbors[1] = getTileAt(1, t.getX()+1); //_field[1][1];
            neighbors[2] = getTileAt(1, t.getX()); //_field[0][1];
            neighbors[3] = getTileAt(1, t.getX()-1); //_field[1][0];
            neighbors[4] = getTileAt(0, t.getX()-1); //_field[1][1];
         }
         
         if (t.getX() == _xColumns - 1)
         {
            neighbors[0] = getTileAt(t.getY()-1,t.getX()-1);
            neighbors[1] = getTileAt(t.getY()-1, t.getX());
            neighbors[2] = getTileAt(t.getY()+1, t.getX());
            neighbors[3] = getTileAt(t.getY()+1, t.getX()-1);
            neighbors[4] = getTileAt(t.getY(), t.getX()-1);
         }
         
         if (t.getY() == _yRows - 1)
         {
            neighbors[0] = getTileAt(t.getY()-1, t.getX()-1);
            neighbors[1] = getTileAt(t.getY()-1, t.getX());
            neighbors[2] = getTileAt(t.getY()-1,t.getX()+1);
            neighbors[3] = getTileAt(t.getY(),t.getX()+1);
            neighbors[4] = getTileAt(t.getY(),t.getX()-1);
         }
         
         if (t.getX() == 0)
         {
            neighbors[0] = getTileAt(t.getY()-1, 0);
            neighbors[1] = getTileAt(t.getY()-1, 1);
            neighbors[2] = getTileAt(t.getY(), 1);
            neighbors[3] = getTileAt(t.getY()+1, 1);
            neighbors[4] = getTileAt(t.getY()+1,0);
         } // if
      } // else if
      
      // Otherwise the Tile t should have 8 neighbors. 
      else
      {
         neighbors = new Tile[8];
         
         neighbors[0] = getTileAt(t.getY()-1, t.getX()-1);
         neighbors[1] = getTileAt(t.getY()-1, t.getX());
         neighbors[2] = getTileAt(t.getY()-1, t.getX()+1);
         neighbors[3] = getTileAt(t.getY(), t.getX()+1);
         neighbors[4] = getTileAt(t.getY()+1, t.getX()+1);
         neighbors[5] = getTileAt(t.getY()+1, t.getX());
         neighbors[6] = getTileAt(t.getY()+1, t.getX()-1);
         neighbors[7] = getTileAt(t.getY(), t.getX()-1);
      } // else
      
      return neighbors;
   }
   
   
   /**
    * Returns the number of "rows" in the field
    * 
    * @return the number of "rows"
    */
   public int getYRows()
   {
      return _yRows;
   }
   
   /**
    * Returns the number of "columns" in the field
    * 
    * @return the number of "columns"
    */
   public int getXColumns()
   {
      return _xColumns;
   }
   
   /**
    * Returns true if all non-bomb tiles have been revealed, false otherwise
    * 
    * @return true if all non-bomb tiles have been revealed, false otherwise
    */
   public boolean isWinner()
   {
      boolean win = true;
      
      /*
       * Check all tiles
       * If a bomb has been revealed or a non-bomb has not been revealed, the 
       * game has not been won
       */
      for (int i = 0; i < _yRows; i++)
      {
         for (int j = 0; j < _xColumns; j++)
         {
            if ( (_field[i][j].isBomb() == true 
                  && _field[i][j].isRevealed() == true) 
                  || (_field[i][j].isBomb() == false 
                  && _field[i][j].isRevealed() == false) )
            {
               win = false;
            }
         }
      }
      
      return win;
   }
   
   /**
    * Used to reveal a selected tile. Returns an int indicating the outcome
    * of the reveal attempt
    * 
    * @return an int representing the outcome of the reveal
    */
   public int revealTile(Tile t)
   {
      int returnStatus = TILE_REVEALED_NORMAL;
      
      if (!t.isRevealed())
      {
      // If the tile was not revealed before, it is now
         t.reveal(); 
         
         if (t.isBomb())
         {
            returnStatus = TILE_REVEALED_BOMB;
         }
         else
         {
            if (t.getVolatileNeighbors() == 0)
            {
               
            }
         }
      }
      else
      {
         returnStatus = TILE_PREVIOUSLY_REVEALED;
      }
      
      return returnStatus;
   }
   
   
   /**
    * Returns a String representing the field in the form
    * -------------
    * | t | t | t |
    * -------------
    * | t | t | t |
    * -------------
    * | t | t | t |
    * -------------
    * 
    * @return a String representing the field
    */
   public String toString()
   {
      // The string to be returned
      StringBuilder outputString = new StringBuilder();
      
      // For each row of values, append a row of separation dashes, then the 
      // row of values, with values pipe-separated
      for (int i = 0; i < _yRows; i++)
      {
         // Row of sep dashes
         for (int j = 0; j < _xColumns; j++)
         {
            outputString.append("----");
         }
         outputString.append("-\n");
         
         // Open the row of tiles
         outputString.append(i + 1);
         
         // Row of pipe-separated tiles
         for (int j = 0; j < _xColumns; j++)
         {
            outputString.append(getTileAt(i, j).toString());
         }
         outputString.append("\n");
      }
      
      // Bottom border of dashes
      for (int j = 0; j < _xColumns; j++)
      {
         outputString.append("----");
      }
      outputString.append("-\n");
      
      return outputString.toString();
   }
}