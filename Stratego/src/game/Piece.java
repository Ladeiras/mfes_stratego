/*
 * Esta classe tem as propriedades de uma peça necessárias para a componente gráfica.
 * Pode fazer sentido 'unir' com a componente lógica do VDM.
 */
package game;

import javax.swing.JButton;

/**
 *
 * @author Paulo Faria Reis <paulo@fariareis.com>
 */
public class Piece extends JButton {

   Position position;
   Rank rank;
   Color color;
   Code code;

   public Piece(Position position, Rank rank, Color color, Code code, String name) {
	super(name);
	this.position = position;
	this.rank = rank;
	this.color = color;
	this.code = code;
   }

   public Position getPosition() {
	return position;
   }

   public void setPosition(Position position) {
	this.position = position;
   }

   public Rank getRank() {
	return rank;
   }

   public void setRank(Rank rank) {
	this.rank = rank;
   }

   public Color getColor() {
	return color;
   }

   public void setColor(Color color) {
	this.color = color;
   }

   public Code getCode() {
	return code;
   }

   public void setCode(Code code) {
	this.code = code;
   }

   public void setName(String name) {
	super.setText(name);
   }

}
