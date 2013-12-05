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
   private String pieceLabel;

   public Piece(Position position, String pieceLabel, Rank rank, Color color, Code code) {
	super(pieceLabel);
	this.pieceLabel = pieceLabel;
	this.position = position;
	this.rank = rank;
	this.color = color;
	this.code = code;
	this.setBackground(java.awt.Color.WHITE);
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

   public String getPieceLabel() {
	return pieceLabel;
   }

   public void setPieceLabel(String pieceLabel) {
	this.pieceLabel = pieceLabel;
   }
}
