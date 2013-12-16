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
   private int gameStage;

   public StrategoModel() {
	this.gameStage = 1;
	this.gamePieces = new Piece[10][10];
	for (int x = 0; x < 10; x++) {
	   for (int y = 0; y < 10; y++) {
		this.gamePieces[x][y] = new Piece(new Position(x, y), "empty", new Rank("vazio"), new Color("Azul"), new Code("nulo"));
	   }
	}
   }

   public void prepareNewGame() {
	this.gameStage = 1;
	for (int x = 0; x < 10; x++) {
	   for (int y = 0; y < 10; y++) {
		this.gamePieces[x][y].setRank(new Rank("Peão"));
		this.gamePieces[x][y].setCode(new Code("Código"));
		this.gamePieces[x][y].setColor(new Color("Vermelho"));
		this.gamePieces[x][y].setPieceLabel("Limpo");
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

   // Piece(Position position, String pieceLabel, Rank rank, Color color, Code code)
   public void updatePiece(Position position, Piece piece) {
	this.gamePieces[position.x][position.y].setPieceLabel(piece.getPieceLabel());
	this.gamePieces[position.x][position.y].setRank(piece.getRank());
	this.gamePieces[position.x][position.y].setColor(piece.getColor());
	this.gamePieces[position.x][position.y].setCode(piece.getCode());
   }

   /**
    * Get the current game stage.
    *
    * @return
    */
   public int getGameStage() {
	return gameStage;
   }

   /**
    * Sets the new game stage.
    *
    * @param gameStage
    */
   public void setGameStage(int gameStage) {
	this.gameStage = gameStage;
   }

}
