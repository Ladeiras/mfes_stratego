/*
 * Esta classe tem as propriedades de uma peça necessárias para a componente gráfica.
 * Pode fazer sentido 'unir' com a componente lógica do VDM.
 */
package model;

import javax.swing.JButton;

/**
 *
 * @author Paulo Faria Reis <paulo@fariareis.com>
 */
public class Piece extends JButton {

   private Position position;
   private Rank rank;
   private Color color;
   private Code code;

   public Piece(Position position, Rank rank, Color color, Code code) {
	super(rank.getRankName());
	this.position = position;
	this.rank = rank;
	this.color = color;
	this.code = code;
   }

   @Deprecated
   public Position getPosition() {
	return position;
   }

   @Deprecated
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

//   @Override
//   public void setName(String name) {
//	super.setText(name);
//   }
//
//   @Override
//   public String getName() {
//	return super.getName();
//   }
}
