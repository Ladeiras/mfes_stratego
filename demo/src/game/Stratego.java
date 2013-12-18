/*
 */
package game;

import jp.vdmtools.VDM.CGException;
import VDM.Piece;
import VDM.Play;

/**
 *
 * @author Paulo Faria Reis <paulo@fariareis.com>
 */
public class Stratego {

   /**
    * Ponto de entrada da aplicação. Cria uma instância da classe que formaliza
    * o modelo aplicacional MVC.
    *
    * @param args
 * @throws CGException 
    */
   public static void main(String args[]) throws CGException {
	  
//	   VDM.Play play = new Play();
//	   
//	   play.initializeBoard();
//	   VDM.Game.Position pos = new VDM.Game.Position(0, 0);
//	   VDM.Piece piece = (Piece) play.getBoard().get(pos);
//	   
//	   System.out.println(piece.code.str);
	   
	  
	StrategoGame strategoGame = new StrategoGame();
	strategoGame.run();
   }
}
