/*
 */
package controller;

import gui.StrategoView;
import model.StrategoModel;

/**
 *
 * @author Paulo Faria Reis <paulo@fariareis.com>
 */
public class StrategoController {

   private final StrategoModel strategoModel;
   private final StrategoView strategoView;

   public StrategoController(StrategoModel strategoModel, StrategoView strategoView) {
	this.strategoModel = strategoModel;
	this.strategoView = strategoView;

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

}
