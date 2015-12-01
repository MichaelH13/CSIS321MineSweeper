import Tile.java

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
   
   public Field(int size)
   {
      System.out.println("Field(int size) NYD");
   }
   
   public Field(int size, int minePercentage)
   {
      System.out.println("Field(int size, int minePercentage) NYD");
   }
   
   public Field(int yRows, int xColumns)
   {
      System.out.println("Field(int yRows, int xColumns) NYD");
   }
   
   public Field(int yRows, int xColumns, int minePercentage)
   {
      System.out.println("Field(int yRows, int xColumns, int minePercentage) "
            + "NYD");
   }
   
   public Tile getTileAt(int yRow, int xColumn)
   {
      System.out.println("getTileAt(int yRow, int xColumn) NYD");
      
      return null;
   }
   
   public Tile[] getNeighbors(Tile t)
   {
      System.out.println("getNeighbors(Tile t) NYD");
      return null;
   }
   
   /**
    * Returns the number of "rows" in the field
    * @return the number of "rows"
    */
   public int getYRows()
   {
      return _yRows;
   }
   
   /**
    * Returns the number of "columns" in the field
    * @return the number of "columns"
    */
   public int getXColumns()
   {
      return _xColumns;
   }
   
   public boolean isWinner()
   {
      System.out.println("isWinner() NYD");
      return false;
   }
   
   public void revealTile(Tile t)
   {
      System.out.println("revealTile(Tile t) NYD");
   }
   
   /**
    * Returns a String representing the field in the form
    * -------
    * |t|t|t|
    * -------
    * |t|t|t|
    * -------
    * |t|t|t|
    * -------
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
            outputString.append("--");
         }
         outputString.append("-\n");
         
         // Row of pipe-separated dashes
         for (int j = 0; j < _xColumns; j++)
         {
            outputString.append("|");
            outputString.append(getTileAt(i, j));
         }
         outputString.append("|\n");
      }
      
      // Bottom border of dashes
      for (int j = 0; j < _xColumns; j++)
      {
         outputString.append("--");
      }
      outputString.append("-\n");
      
      return outputString.toString();
   }
}