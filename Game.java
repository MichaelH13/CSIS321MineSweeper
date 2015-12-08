import java.util.Scanner;
import java.util.zip.DataFormatException;

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
   private static Game _theGame;
   
   private boolean _hasDetonated;
   
   public static final String USAGE_INFO = "" +
      "Usage: \njava Minesweeper\njava Minesweeper [field size]\n"
      + "java Minesweeper [y dimension] [x dimension] or\n"
      + "java Minesweeper [y dimension] [x dimension] [bomb percent chance]\n"
      + "EX: java Minesweeper 7 5 45";
   
   public static final String LOSE_NOTIFICATION = ""
            + "     .... NO! ...                  ... MNO! ...\n"
            + "   ..... MNO!! ...................... MNNOO! ...\n"
            + " ..... MMNO! ......................... MNNOO!! .\n" 
            + "..... MNOONNOO!   MMMMMMMMMMPPPOII!   MNNO!!!! .\n"
            + " ... !O! NNO! MMMMMMMMMMMMMPPPOOOII!! NO! ....\n" 
            + "    ...... ! MMMMMMMMMMMMMPPPPOOOOIII! ! ...\n"
            + "   ........ MMMMMMMMMMMMPPPPPOOOOOOII!! .....\n" 
            + "   ........ MMMMMOOOOOOPPPPPPPPOOOOMII! ...\n"
            + "    ....... MMMMM..    OPPMMP    .,OMI! ....\n" 
            + "     ...... MMMM::   o.,OPMP,.o   ::I!! ...\n"
            + "         .... NNM:::.,,OOPM!P,.::::!! ....\n" 
            + "          .. MMNNNNNOOOOPMO!!IIPPO!!O! .....\n"
            + "         ... MMMMMNNNNOO:!!:!!IPPPPOO! ....\n" 
            + "           .. MMMMMNNOOMMNNIIIPPPOO!! ......\n"
            + "          ...... MMMONNMMNNNIIIOO!..........\n" 
            + "       ....... MN MOMMMNNNIIIIIO! OO ..........\n"
            + "    ......... MNO! IiiiiiiiiiiiI OOOO ...........\n" 
            + "  ...... NNN.MNO! . O!!!!!!!!!O . OONO NO! ........\n"
            + "   .... MNNNNNO! ...OOOOOOOOOOO .  MMNNON!........\n" 
            + "   ...... MNNNNO! .. PPPPPPPPP .. MMNON!........\n"
            + "      ...... OO! ................. ON! .......\n" 
            + "         ................................\n";
   
   public static final String WIN_NOTIFICATION = ""
            + "          ________                      __         ____.     ___.  ._.\n"
            + "         /  _____/______   ____ _____ _/  |_      |    | ____\\_ |__| |\n"
            + "        /   \\  __\\_  __ \\_/ __ \\\\__  \\\\   __\\     |    |/  _ \\| __ \\ |\n"
            + "        \\    \\_\\  \\  | \\/\\  ___/ / __ \\|  |   /\\__|    (  <_> ) \\_\\ \\|\n"
            + "         \\______  /__|    \\___  >____  /__|   \\________|\\____/|___  /_\n"
            + "                \\/            \\/     \\/                           \\/\\/\n";

   
   /**
    * Creates an instance of a game of Minesweeper
    * @throws DataFormatException 
    */
   public Game(int argCount, String[] args) throws DataFormatException
   {
      try
      {
         switch (argCount)
         {
            case 0: _theField = new Field();
                    break;
            case 1: _theField = new Field(Integer.parseInt(args[0]));
                    break;
            case 2: _theField = new Field(Integer.parseInt(args[0]), 
                  Integer.parseInt(args[1]));
                    break;
            case 3: _theField = new Field(Integer.parseInt(args[0]), 
                  Integer.parseInt(args[1]), Integer.parseInt(args[2]));
                    break;
            default: System.err.println("Too many arguments");
                     throw new NumberFormatException();
         }
      }
      catch (NumberFormatException e)
      {
         System.err.println(USAGE_INFO);
         throw new DataFormatException("INVALID ARGS");
      }
      
      _hasDetonated = false;
   }
   
   
   /**
    * Singleton pattern. Only one instance of a game allowed.
    * @return the game.
    */
   public static Game getTheGame()
   {
      return _theGame;
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

   
//   /**
//    * Reveals all tiles, showing what was a bomb, and notifies the player that
//    * they have lost the game
//    */
//   public void blowUp()
//   {
//      for (int i = 0; i < _theField.getYRows(); i++)
//      {
//         for (int j = 0; j < _theField.getXColumns(); j++)
//         {
//            _theField.revealTile(_theField.getTileAt(i, j));
//         }
//      }
//      _hasDetonated = true;
//      System.out.println(LOSE_NOTIFICATION);
//   }
//   
//   /**
//    * Reveals all tiles, showing mines, and notifies the player that they have 
//    * won the game
//    */
//   public void winner()
//   {
//      revealField()
//      System.out.println("winner() NYD");
//   }
   
   /**
    * Reveals all bombs and notifies the player of whether or not they won
    */
   public void resolveGame()
   {
      for (int i = 0; i < _theField.getYRows(); i++)
      {
         for (int j = 0; j < _theField.getXColumns(); j++)
         {
            if (_theField.getTileAt(i, j).isBomb())
               _theField.revealTile(_theField.getTileAt(i, j));
         }
      }
      
      if (_hasDetonated)
      {
         System.out.println(LOSE_NOTIFICATION);
      }
      else
      {
         System.out.println(WIN_NOTIFICATION);
      }
      
      System.out.println(_theField.toString());
   }
   
   /**
    * Makes a move on a given tile
    */
   public void makeMove(int yRow, int xColumn)
   {
      int moveResult = _theField.revealTile(_theField.getTileAt(yRow, xColumn));
      
      if (moveResult == Field.TILE_REVEALED_BOMB)
      {
         _hasDetonated = true;
      }
      
      if (moveResult == Field.TILE_PREVIOUSLY_REVEALED)
      {
         System.out.println("You have already used this tile");
      }
   }
   
   
   /**
    * Returns a boolean indicating whether the game has been completed
    * @return a boolean indicating whether the game has been completed
    */
   public boolean isOver()
   {
      boolean gameOver = _hasDetonated;
      
      if (!gameOver)
      {
         gameOver = _theField.isWinner();
      }
      
      return gameOver;
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
    * @throws DataFormatException 
    */
   public static void main(String[] args) throws DataFormatException
   {
      Scanner in = new Scanner(System.in);
      Game theGame = new Game(args.length, args);
      int yMove;
      int xMove;
      
      // Until the game ends, have the user select tiles until they hit a mine,
      // or they have revealed all non-mine tiles
      while (!theGame.isOver())
      {
         yMove = 0;
         xMove = 0;
         
         // Get a valid move
         while (yMove == 0 || xMove == 0)
         {
            try
            {
               System.out.println("Select a tile to reveal (y/vertical "
                     + "location x/horizontal location)");
               System.out.println(theGame.toString());
               
               yMove = in.nextInt();
               xMove = in.nextInt();
            }
            catch (NumberFormatException e)
            {
               System.out.println("Non-number received. Please enter a y/x "
                     + "pair in the format \"y x\", without quotation marks");
               yMove = 0;
               xMove = 0;
            }
            
            if ((yMove > _theField.getYRows() ||  xMove > 
            _theField.getXColumns()) || (yMove <= 0 || xMove <= 0))
            {
               System.out.println("Please select a tile within the bounds of"
                     + " the board");
               yMove = 0;
               xMove = 0;
            }
         }
         
         theGame.makeMove(yMove - 1, xMove - 1);
      }
      in.close();
      
      theGame.resolveGame();
      
      System.out.println("Thanks for playing!");
   }
   
}