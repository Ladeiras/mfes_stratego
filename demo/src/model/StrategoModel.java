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
   private Piece firstPieceSelected = null;
   private Piece secondPieceSelected = null;
   private int x1,y1,x2,y2;

   /**
    *
    */
   public StrategoModel() {
	   this.x1 = -1;
	   this.y1 = -1;
	   this.x2 = -1;
	   this.y2 = -1;
	
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

   /**
    *
    * @return
    */
   public Piece getFirstPieceSelected() {
	return firstPieceSelected;
   }

   /**
    *
    * @param firstPieceSelected
    */
   public void setFirstPieceSelected(Piece firstPieceSelected) {
	this.firstPieceSelected = firstPieceSelected;
   }

   /**
    *
    * @return
    */
   public Piece getSecondPieceSelected() {
	return secondPieceSelected;
   }

   /**
    *
    * @param secondPieceSelected
    */
   public void setSecondPieceSelected(Piece secondPieceSelected) {
	this.secondPieceSelected = secondPieceSelected;
   }

	public int getx1(){return this.x1;}
	public int gety1(){return this.y1;}
	public int getx2(){return this.x2;}
	public int gety2(){return this.y2;}
	
	public void setx1(int n){this.x1 = n;}
	public void sety1(int n){this.y1 = n;}
	public void setx2(int n){this.x2 = n;}
	public void sety2(int n){this.y2 = n;}
	
	public void select(int x, int y)
	{
		if((x==x1 && y==y1) || (x==x2 && y==y2))
		{
			x1=x;y1=y;
			x2=-1;y2=-1;
		}
		else if((x1!=-1 && y1!=-1) && (x2==-1 && y2==-1))
		{
			x2=x;y2=y;
		}
		else if((x1==-1 && y1==-1) && (x2==-1 && y2==-1))
		{
			x1=x;y1=y;
		}
		else if((x1!=-1 && y1!=-1) && (x2!=-1 && y2!=-1))
		{
			x1=x;y1=y;
			x2=-1;y2=-1;
		}
	}

}
