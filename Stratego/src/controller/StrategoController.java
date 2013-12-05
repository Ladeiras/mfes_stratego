/*
 */
package controller;

import gui.StrategoView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Piece;
import model.Position;
import model.StrategoModel;

/**
 *
 * @author Paulo Faria Reis <paulo@fariareis.com>
 */
public class StrategoController implements ActionListener {

   private final StrategoModel strategoModel;
   private final StrategoView strategoView;

   public final static int NEWGAME = 1;
   public final static int PLANNING_P1 = 2;
   public final static int PLANNING_INTERVAL = 3;
   public final static int PLANNING_P2 = 4;
   public final static int READY_P1 = 5;
   public final static int PLAYING_P1 = 6;
   public final static int READY_P2 = 7;
   public final static int PLAYING_P2 = 8;
   public final static int ENDGAME = 9;

   public StrategoController(StrategoModel strategoModel, StrategoView strategoView) {
	this.strategoModel = strategoModel;
	this.strategoView = strategoView;

	/* Prepara controlos. */
	prepareControlButtons();

	/* Adiciona as 100 Pieces do tabuleiro */
	prepareBoardPieces();
   }

   /**
    * Prepara o tabuleiro de jogo.
    */
   private void prepareBoardPieces() {
	Piece boardPiece;
	for (int x = 0; x < 10; x++) {
	   for (int y = 0; y < 10; y++) {
		boardPiece = strategoModel.getPiece(x, y);
		boardPiece.addActionListener(this);
		strategoView.getGameMap().add(boardPiece);
	   }
	}
   }

   /**
    * Adds the ActionListeners to the JButton from the Control Panel.
    */
   private void prepareControlButtons() {
	/* Adiciona listener para o botão EXIT. */
	strategoView.exitButton.addActionListener(new java.awt.event.ActionListener() {
	   @Override
	   public void actionPerformed(java.awt.event.ActionEvent evt) {
		exitButtonActionPerformed(evt);
	   }
	});

	/* Adiciona listener para o botão TRYME. */
	strategoView.testButton.addActionListener(new java.awt.event.ActionListener() {
	   @Override
	   public void actionPerformed(java.awt.event.ActionEvent evt) {
		testButtonActionPerformed(evt);
	   }
	});

	/* Adiciona listener para o botão NEWGAME. */
	strategoView.newgameButton.addActionListener(new java.awt.event.ActionListener() {
	   @Override
	   public void actionPerformed(java.awt.event.ActionEvent evt) {
		newgameButtonActionPerformed(evt);
	   }
	});
   }

   /* Ação a executar no evento de clicar no botão EXIT. */
   private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
	strategoView.addMessage("Exiting now.");
	strategoView.dispose();
	System.exit(0);
   }

   /* Acção a executar com o Botão para testes. */
   private void testButtonActionPerformed(java.awt.event.ActionEvent evt) {
	strategoView.addMessage("Teste.");
	Position piecePosition = strategoModel.getPiece(5, 5).getPosition();
	strategoView.setGameStageText("Planning");
	strategoView.setPlayerTurnText("Blue");
	strategoView.setMoveFromText("(" + piecePosition.x + ", " + piecePosition.y + ")");
	strategoView.setMoveToText("(" + (piecePosition.x + 2) + ", " + (piecePosition.y - 2) + ")");

   }

   /**
    * Prepara cada fase do jogo
    *
    * @param gameStage
    */
   private void processGameStage(int gameStage) {
	switch (gameStage) {
	   case NEWGAME:
		strategoModel.setGameStage(NEWGAME);
		strategoView.setInfo("Game started", "Not Aplicable", "", "", "A new Game is prepared. Player 1 press 'NEXT PHASE' when ready.");
		for (int x = 0; x < 10; x++) {
		   for (int y = 0; y < 10; y++) {
			/**
			 * TODO: Alterar as 100 Pieces, utilizando os metodos:
			 * updatePiece(Position position, Piece piece) ou
			 * getPiece(Position position) e de seguida aplicar um dos
			 * métodos de acesso de Piece.
			 */
			strategoModel.getPiece(x, y).setBackground(Color.blue);
		   }
		}
		break;
	   case PLANNING_P1:
		strategoModel.setGameStage(PLANNING_P1);
		strategoView.setInfo("Planning phase", "Player 1", "", "", "Player 1, you may customize your army placement, press 'NEXT PHASE' to finish.");
		// TODO: Alterar o texto dos botões das peças do player 1 para o rank.
		break;
	   case PLANNING_INTERVAL:
		strategoModel.setGameStage(PLANNING_INTERVAL);
		strategoView.setInfo("Planning phase", "Not aplicable", "", "", "Player 2, press 'NEXT PHASE' when ready.");
		// TODO: Alterar o texto dos botões das peças do player 1 para neutro.
		break;
	   case PLANNING_P2:
		strategoModel.setGameStage(PLANNING_P2);
		strategoView.setInfo("Planning phase", "Player 2", "", "", "Player 2, you may customize your army placement, press 'NEXT PHASE' to finish.");
		// TODO: Alterar o texto dos botões das peças do player 2 para o rank.
		break;
	   case READY_P1:
		strategoModel.setGameStage(READY_P1);
		strategoView.setInfo("Playing", "Not aplicable", "", "", "Player 1, press 'NEXT PHASE' when ready.");
		// TODO: Alterar o texto dos botões das peças do player 2 para neutro.
		break;
	   case PLAYING_P1:
		strategoModel.setGameStage(PLAYING_P1);
		strategoView.setInfo("Playing", "Player 1", "", "", "Player 1, make your move.");
		// TODO: Alterar o texto dos botões das peças do player 1 para rank.
		break;
	   case READY_P2:
		strategoModel.setGameStage(READY_P2);
		strategoView.setInfo("Playing", "Not aplicable", "", "", "Player 2, press 'NEXT PHASE' when ready.");
		// TODO: Alterar o texto dos botões das peças do player 1 para neutro.
		break;
	   case PLAYING_P2:
		strategoModel.setGameStage(PLAYING_P2);
		strategoView.setInfo("Playing", "Player 2", "", "", "Player 2, make your move.");
		// TODO: Alterar o texto dos botões das peças do player 1 para rank.
		break;
	   case ENDGAME:
		strategoModel.setGameStage(ENDGAME);
		strategoView.setInfo("End", "Not aplicable", "", "", "The End.");
		// TODO: Alterar o texto dos botões de todas as peças para rank.
		break;
	}
   }


   /* Acção a executar com o botão NEWGAME. */
   private void newgameButtonActionPerformed(java.awt.event.ActionEvent evt) {
	processGameStage(NEWGAME);
   }

   /**
    * O desenrolar normal do jogo é processado aqui.
    *
    * @param e
    */
   @Override
   public void actionPerformed(ActionEvent e) {
	Piece boardPiece;
	boardPiece = (Piece) e.getSource();
	strategoView.addMessage("(" + boardPiece.getPosition().x + ", " + boardPiece.getPosition().y + ")");
	boardPiece.setBackground(Color.green);
   }

}
