/*
 */
package controller;

import gui.StrategoView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jp.vdmtools.VDM.CGException;
import model.Piece;
import model.StrategoModel;

/**
 *
 * @author Paulo Faria Reis <paulo@fariareis.com>
 */
public class StrategoController implements ActionListener {

   private final StrategoModel strategoModel;
   private final StrategoView strategoView;
   private VDM.Play play;

//   public final static int NEWGAME = 1;
//   public final static int PLANNING_P1 = 2;
//   public final static int PLANNING_INTERVAL = 3;
//   public final static int PLANNING_P2 = 4;
//   public final static int READY_P1 = 5;
//   public final static int PLAYING_P1 = 6;
//   public final static int READY_P2 = 7;
//   public final static int PLAYING_P2 = 8;
//   public final static int ENDGAME = 9;
   
   public final static int NEWGAME = 1;
   public final static int PLANNING = 2;
   public final static int PLAYING = 3;
   public final static int ENDGAME = 4;

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
		//parsePiece(x, y);
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

	/* Adiciona listener para o botão NEXT PHASE. */
	strategoView.nextStageButton.addActionListener(new java.awt.event.ActionListener() {
	   @Override
	   public void actionPerformed(java.awt.event.ActionEvent evt) {
		nextPhaseButtonActionPerformed(evt);
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
   private void nextPhaseButtonActionPerformed(java.awt.event.ActionEvent evt) {
	String message = "Advancing game stage, from\n";
	int currentGameStage = strategoModel.getGameStage();
	int nextGameStage = currentGameStage + 1;
//	switch (nextGameStage) {
//	   case PLANNING_P1:
//		strategoView.enableNextStageButton();
//		message += "new game to player 1 planning.";
//		break;
//	   case PLANNING_INTERVAL:
//		message += "player 1 planning to planning interval.";
//		break;
//	   case PLANNING_P2:
//		message += "planning interval to player 2 planning.";
//		break;
//	   case READY_P1:
//		message += "player 2 planning to waiting for player 1.";
//		break;
//	   case PLAYING_P1:
//		strategoView.disableNextStageButton();
//		message += "waiting for player 1 to player 1 move.";
//		break;
//	   case READY_P2:
//		strategoView.enableNextStageButton();
//		message += "player 1 move to waiting for player 2.";
//		break;
//	   case PLAYING_P2:
//		strategoView.disableNextStageButton();
//		message += "waiting for player 2 to player 2 move.";
//		break;
//	   case ENDGAME:
//		strategoView.enableNextStageButton();
//		message = "The game is over.";
//		break;
//
//	}
	
	switch (nextGameStage) {
	   case PLANNING:
		strategoView.enableNextStageButton();
		message += "new game to planning.";
		break;
	   case PLAYING:
		strategoView.disableNextStageButton();
		message += "playing.";
		break;
	   case ENDGAME:
		strategoView.enableNextStageButton();
		message = "The game is over.";
		break;

	}
	
	strategoView.addMessage(message);
	strategoModel.setGameStage(nextGameStage);

   }

   /**
    * Prepara cada fase do jogo
    *
    * @param gameStage
    */
   private void processGameStage(int gameStage, Piece selectedPiece) {
	   int x1,y1,x2,y2;
	/* Se ainda não foi escolhida uma peça, a que foi recebida é a primeira, casop contrário é a segunda. */	   
	boolean toProcess = true;
	if (strategoModel.getFirstPieceSelected() == null) {
	   strategoModel.setFirstPieceSelected(selectedPiece);
	   //strategoView.addMessage("Select destination.");
	   if (strategoModel.getGameStage() != 1) {
		toProcess = false;
	   }
	} else {
	   strategoModel.setSecondPieceSelected(selectedPiece);
	   toProcess = true;
	}

	if (toProcess) {
	   switch (gameStage) {
		case NEWGAME:
		   strategoModel.setGameStage(NEWGAME);
		   strategoView.setInfo("Planning phase", "Not Aplicable","","","Press 'NEXT PHASE' when ready.");
		   
		   	try {
				this.play = new VDM.Play();
				this.play.initializeBoard();
			} catch (CGException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   refreshBoard();
		   strategoView.enableNextStageButton();
		   
		   break;
		case PLANNING:
		   strategoModel.setGameStage(PLANNING);
		   strategoView.setInfo("Planning phase", "Not Aplicable","","","Press 'NEXT PHASE' to finish.");
		   
		   if(strategoModel.getx1()!=-1 && strategoModel.gety1()!=-1 && strategoModel.getx2()!=-1 && strategoModel.gety2()!=-1)
		   {
			   x1 = strategoModel.getx1();
			   y1 = strategoModel.gety1();
			   x2 = strategoModel.getx2();
			   y2 = strategoModel.gety2();
			   
				   try {
					if(play.validSwap(x1, y1, x2, y2));
						play.swap(x1, y1, x2, y2);
				} catch (CGException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   }
		   
		   refreshBoard();
		   break;
//		case PLANNING_INTERVAL:
//		   strategoModel.setGameStage(PLANNING_INTERVAL);
//		   strategoView.setInfo("Planning phase", "Not aplicable", "", "", "Player 2, press 'NEXT PHASE' when ready.");
//		   // TODO: Alterar o texto dos botões das peças do player 1 para neutro.
//		   break;
//		case PLANNING_P2:
//		   strategoModel.setGameStage(PLANNING_P2);
//		   strategoView.setInfo("Planning phase", "Player 2", "", "", "Player 2, you may customize your army placement, press 'NEXT PHASE' to finish.");
//		   // TODO: Alterar o texto dos botões das peças do player 2 para o rank.
//		   break;
//		case READY_P1:
//		   strategoModel.setGameStage(READY_P1);
//		   strategoView.setInfo("Playing", "Not aplicable", "", "", "Player 1, press 'NEXT PHASE' when ready.");
//		   // TODO: Alterar o texto dos botões das peças do player 2 para neutro.
//		   break;
		case PLAYING:
		   strategoModel.setGameStage(PLAYING);
			   
		   // TODO: Alterar o texto dos botões das peças do player 1 para rank.
		   
		   if(strategoModel.getx1()!=-1 && strategoModel.gety1()!=-1 && strategoModel.getx2()!=-1 && strategoModel.gety2()!=-1)
		   {
			   x1 = strategoModel.getx1();
			   y1 = strategoModel.gety1();
			   x2 = strategoModel.getx2();
			   y2 = strategoModel.gety2();
			   
				   try {
						play.play(x1, y1, x2, y2);
				} catch (CGException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   }
		   refreshBoard();
		   
		   try {
				strategoView.setInfo("Playing", "Player "+play.getTurn(), "", "", "Player "+play.getTurn()+" turn.");
				
				if(play.getEnded())
					processGameStage(ENDGAME, null);
			} catch (CGException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   
		   break;
//		case READY_P2:
//		   strategoModel.setGameStage(READY_P2);
//		   strategoView.setInfo("Playing", "Not aplicable", "", "", "Player 2, press 'NEXT PHASE' when ready.");
//		   // TODO: Alterar o texto dos botões das peças do player 1 para neutro.
//		   break;
//		case PLAYING_P2:
//		   strategoModel.setGameStage(PLAYING_P2);
//		   strategoView.setInfo("Playing", "Player 2", "", "", "Player 2, make your move.");
//		   // TODO: Alterar o texto dos botões das peças do player 1 para rank.
//		   strategoView.addMessage("Player 2 moved.");
//		   strategoView.enableNextStageButton();
//		   break;
		case ENDGAME:
		   strategoModel.setGameStage(ENDGAME);
			   try {
				strategoView.setInfo("End", "Not aplicable", "", "", "Player "+play.getWinner()+" won!");
			} catch (CGException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   // TODO: Alterar o texto dos botões de todas as peças para rank.
		   break;
	   }
	}
   }
   
   private void refreshBoard()
   {
	   //strategoModel.getPiece(x, y).setBackground(Color.BLACK);
	   
	   VDM.Piece piece = null;
		
	   for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
			try {
				piece = (VDM.Piece) this.play.getBoard().get(new VDM.Game.Position(x,y));
			} catch (CGException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(piece.color.name.equals("red"))
				strategoModel.getPiece(x, y).setBackground(Color.red);
			else if(piece.color.name.equals("blue"))
				strategoModel.getPiece(x, y).setBackground(Color.cyan);
			else if(piece.color.name.equals("null") && piece.rank.name.equals("null"))
				strategoModel.getPiece(x, y).setBackground(Color.white);
			else if(piece.rank.name.equals("water"))
				strategoModel.getPiece(x, y).setBackground(Color.green);
			
			strategoModel.getPiece(x, y).setText(piece.code.str.substring(0, 1));
			}
	   }
   }

/* Acção a executar com o botão NEWGAME. */
   private void newgameButtonActionPerformed(java.awt.event.ActionEvent evt) {
	processGameStage(NEWGAME, null);
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
	
	
	strategoModel.select(boardPiece.getPosition().x,boardPiece.getPosition().y);
	
	processGameStage(strategoModel.getGameStage(), boardPiece);
   }

}
