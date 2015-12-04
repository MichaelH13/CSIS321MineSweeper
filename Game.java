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
   
   public static final String USAGE_INFO = "" +
      "Usage: \njava Minesweeper\njava Minesweeper [field size]\n"
      + "java Minesweeper [y dimension] [x dimension] or\n"
      + "java Minesweeper [y dimension] [x dimension] [bomb percent chance]\n"
      + "EX: java Minesweeper 7 5 45";
   
   public static final String LOSE_NOTIFICATION = "" +    
"     .... NO! ...                  ... MNO! ...\n" +
"   ..... MNO!! ...................... MNNOO! ...\n" +
" ..... MMNO! ......................... MNNOO!! .\n" +
"..... MNOONNOO!   MMMMMMMMMMPPPOII!   MNNO!!!! .\n" +
" ... !O! NNO! MMMMMMMMMMMMMPPPOOOII!! NO! ....\n" +
"    ...... ! MMMMMMMMMMMMMPPPPOOOOIII! ! ...\n" +
"   ........ MMMMMMMMMMMMPPPPPOOOOOOII!! .....\n" +
"   ........ MMMMMOOOOOOPPPPPPPPOOOOMII! ...\n" +
"    ....... MMMMM..    OPPMMP    .,OMI! ....\n" +
"     ...... MMMM::   o.,OPMP,.o   ::I!! ...\n" +
"         .... NNM:::.,,OOPM!P,.::::!! ....\n" +
"          .. MMNNNNNOOOOPMO!!IIPPO!!O! .....\n" +
"         ... MMMMMNNNNOO:!!:!!IPPPPOO! ....\n" +
"           .. MMMMMNNOOMMNNIIIPPPOO!! ......\n" +
"          ...... MMMONNMMNNNIIIOO!..........\n" +
"       ....... MN MOMMMNNNIIIIIO! OO ..........\n" +
"    ......... MNO! IiiiiiiiiiiiI OOOO ...........\n" +
"  ...... NNN.MNO! . O!!!!!!!!!O . OONO NO! ........\n" +
"   .... MNNNNNO! ...OOOOOOOOOOO .  MMNNON!........\n" +
"   ...... MNNNNO! .. PPPPPPPPP .. MMNON!........\n" +
"      ...... OO! ................. ON! .......\n" +
"         ................................\n";
   
   public static final String WIN_NOTIFICATION = "" + 
"        ________                      __         ____.     ___.  ._.\n" +
"         /  _____/______   ____ _____ _/  |_      |    | ____\_ |__| |\n" +
"        /   \  __\_  __ \_/ __ \\__  \\   __\     |    |/  _ \| __ \ |\n" +
"        \    \_\  \  | \/\  ___/ / __ \|  |   /\__|    (  <_> ) \_\ \|\n" +
"         \______  /__|    \___  >____  /__|   \________|\____/|___  /_\n" +
"                \/            \/     \/                           \/\/\n";
   
   /**
    * Creates an instance of a game of Minesweeper
    */
   public Game(int argCount, String[] args)
   {
      switch (argCount)
      case 0 : _theField = new Field();
      case 1 : _theField = new Field(Integer.parseInt(args[0]))
      case 2 : _theField = new Field(Integer.parseInt(args[0]), 
            Integer.parseInt(args[1]));
      case 3 : _theField = new Field(Integer.parseInt(args[0]), 
            Integer.parseInt(args[1]), Integer.parseInt(args[2]));
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
    * Reveals all tiles, showing what was a bomb, and notifies the player that
    * they have lost the game
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
      Game theGame = new Game(args.length, args);
   }
   
}