import Field.java;

/**
 * @author Michael
 * @author Nik
 * @author Shane
 * @author Connor
 * 
 *         Class for controlling a game of Minesweeper.
 */
public class Game
{
   private static Field _theField;
   
   /**
    * Creates an instance of a game of Minesweeper
    */
   public Game()
   {
      // TODO
      System.out.println("Game() NYD");
   }
   
   /**
    * Returns a reference to the field
    * 
    * @return a reference to the field
    */
   public static Field getField()
   {
      return _theField;
   }
   
   /**
    * 
    * @param f
    * @return
    */
   public boolean didRevealBomb(Field f)
   {
      // TODO
      System.out.println("didRevealBomb(f) NYD");
      
      return false;
   }
   
   /**
    * 
    */
   public void blowUp()
   {
      // TODO
      System.out.println("blowUp() NYD");
   }
   
   /**
    * 
    */
   public void winner()
   {
      // TODO
      System.out.println("winner() NYD");
   }
   
   /**
    * Makes a move on a given tile
    * @return
    */
   public void makeMove(yRow, xColumn)
   {
      _theField.revealTile(_theField.tileAt(yRow, xColumn));
   }
   
   /**
    * Returns a String representation of the field, courtesy of the Field's
    * toString method
    * 
    * @return a String representation of the field
    */
   public String toString()
   {
      return _theField.toString();
   }

   /**
    * The main algorithm to play a game of Minesweeper in the command line
    * @param args
    */
   public static void main(String[] args)
   {
      System.out.println("MUST FIGURE OUT HOW TO RUN ECLIPSE WITH GIT.");
   }
   
}