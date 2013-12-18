/**
 * Jogo Stratego com a lógica programada em VDM++ e gerado código JAVA, e a
 * interface gráfica em Java SWING.
 *
 * @author Paulo Faria Reis <paulo@fariareis.com>
 * @author João Ladeiras <>
 * @date Dezembro 2013
 * @version 0.1
 */
package game;

import controller.StrategoController;
import gui.StrategoView;
import model.StrategoModel;

/**
 * Classe base da aplicação.
 */
public class StrategoGame {

   public StrategoModel strategoModel;
   public StrategoView strategoView;
   public StrategoController strategoController;

   public StrategoGame() {
	strategoModel = new StrategoModel();
	strategoView = new StrategoView();
	strategoController = new StrategoController(strategoModel, strategoView);
   }

   public void run() {
	java.awt.EventQueue.invokeLater(new Runnable() {
	   @Override
	   public void run() {
		strategoView.setVisible(true);
	   }
	});
   }
}
