/**
 * O código gerado pelo VDM deve ficar nesta classe, o Controller faz chamadas a
 * métodos desta classe para ddecidir a acção a tomar, independentemente do tipo
 * de interface com o utilizador.
 */
package model;

/**
 *
 * @author Paulo Faria Reis <paulo@fariareis.com>
 */
public class StrategoModel {

   private final Piece[][] gamePieces;

   public StrategoModel() {
	this.gamePieces = new Piece[10][10];
	for (int x = 0; x < 10; x++) {
	   for (int y = 0; y < 10; y++) {
		this.gamePieces[x][y] = new Piece(new Position(x, y), new Rank("vazio"), new Color("incolor"), new Code("nulo"));
	   }
	}

   }

   /**
    *
    * @param x
    * @param y
    * @return
    */
   public Piece getPiece(int x, int y) {
	return this.gamePieces[x][y];
   }

   /**
    *
    * @param position
    * @return
    */
   public Piece getPiece(Position position) {
	return this.gamePieces[position.x][position.y];
   }

   // Piece(Position position, Rank rank, Color color, Code code)
   public void updatePiece(Position position, Piece piece) {
	this.gamePieces[position.x][position.y].setRank(piece.getRank());
	this.gamePieces[position.x][position.y].setColor(piece.getColor());
	this.gamePieces[position.x][position.y].setCode(piece.getCode());
   }
}
