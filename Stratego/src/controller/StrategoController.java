/*
 */
package controller;

import gui.StrategoView;
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

   /* Acção a executar com o botão NEWGAME. */
   private void newgameButtonActionPerformed(java.awt.event.ActionEvent evt) {
	strategoView.addMessage("Create new game.");
	// TODO: Colocar código para iniciar o tabuleiro.
	for (int x = 0; x < 10; x++) {
	   for (int y = 0; y < 10; y++) {
		strategoView.getGameMap().add(strategoModel.getPiece(x, y));
	   }
	}
   }

   @Override
   public void actionPerformed(ActionEvent e) {
	Piece boardPiece;
	//boardPiece = e.getSource();

   }

}
