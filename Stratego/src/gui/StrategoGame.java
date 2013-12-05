/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import game.Code;
import game.Color;
import game.Piece;
import game.Position;
import game.Rank;

/**
 *
 * @author Paulo Faria Reis <paulo@fariareis.com>
 */
public class StrategoGame extends javax.swing.JFrame {

   int valor;
   Piece[][] mapPositions;

   /**
    * Creates new form StartegoGame
    */
   public StrategoGame() {
	initComponents();
	initCustomComponents();
	valor = 1;
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      titlePanel = new javax.swing.JPanel();
      gamenameLabel = new javax.swing.JLabel();
      controlPanel = new javax.swing.JPanel();
      jScrollPane1 = new javax.swing.JScrollPane();
      logger = new javax.swing.JTextArea();
      newgameButton = new javax.swing.JButton();
      exitButton = new javax.swing.JButton();
      testButton = new javax.swing.JButton();
      gameMap = new gui.GameMap();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setBackground(new java.awt.Color(204, 204, 255));

      titlePanel.setBackground(new java.awt.Color(204, 204, 255));

      gamenameLabel.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
      gamenameLabel.setForeground(new java.awt.Color(0, 102, 51));
      gamenameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      gamenameLabel.setText("STRATEGO");

      javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
      titlePanel.setLayout(titlePanelLayout);
      titlePanelLayout.setHorizontalGroup(
         titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(gamenameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      titlePanelLayout.setVerticalGroup(
         titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(gamenameLabel)
      );

      controlPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 153, 255), new java.awt.Color(51, 153, 255), new java.awt.Color(51, 153, 255), new java.awt.Color(51, 153, 255)));

      logger.setColumns(20);
      logger.setRows(5);
      logger.setEnabled(false);
      jScrollPane1.setViewportView(logger);

      newgameButton.setFont(gamenameLabel.getFont());
      newgameButton.setText("New Game");
      newgameButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            newgameButtonActionPerformed(evt);
         }
      });

      exitButton.setFont(gamenameLabel.getFont());
      exitButton.setText("Exit");
      exitButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            exitButtonActionPerformed(evt);
         }
      });

      testButton.setFont(gamenameLabel.getFont());
      testButton.setText("Try Me");
      testButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            testButtonActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
      controlPanel.setLayout(controlPanelLayout);
      controlPanelLayout.setHorizontalGroup(
         controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
         .addComponent(newgameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addComponent(testButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      controlPanelLayout.setVerticalGroup(
         controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
            .addComponent(newgameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(testButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
      );

      gameMap.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(51, 153, 255)));

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addGroup(layout.createSequentialGroup()
            .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(gameMap, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(gameMap, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   /**
    * Called from the constructor. Takes care of custom components.
    */
   private void initCustomComponents() {

	/* TODO: Para um inicio mais rápido do jogo, podemos criar função que coloca as peças
	 * 'aleatóriamente' e criar um estado opcional do jogo para troca de peças.
	 */
	this.mapPositions = new Piece[10][10];
	for (int linha = 0; linha < 10; linha++) {
	   for (int coluna = 0; coluna < 10; coluna++) {
		this.mapPositions[linha][coluna] = new Piece(new Position(linha, coluna), new Rank(), new Color(), new Code(), "v: " + valor++);
		gameMap.add(this.mapPositions[linha][coluna]);
	   }
	}
	pack();
   }

   private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
	logMessage("Exiting now.");
	System.exit(0);
   }//GEN-LAST:event_exitButtonActionPerformed

   private void newgameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newgameButtonActionPerformed
	logMessage("Create new game.");
	// TODO: Colocar código para iniciar o tabuleiro.
	for (int linha = 0; linha < 10; linha++) {
	   for (int coluna = 0; coluna < 10; coluna++) {
		this.mapPositions[linha][coluna].setName("v1: " + valor++);
	   }
	}
   }//GEN-LAST:event_newgameButtonActionPerformed

   private void testButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testButtonActionPerformed

   }//GEN-LAST:event_testButtonActionPerformed

   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
	/* Set the Nimbus look and feel */
	//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
	 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
	 */
	try {
	   for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		if ("Nimbus".equals(info.getName())) {
		   javax.swing.UIManager.setLookAndFeel(info.getClassName());
		   break;
		}
	   }
	} catch (ClassNotFoundException ex) {
	   java.util.logging.Logger.getLogger(StrategoGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	   java.util.logging.Logger.getLogger(StrategoGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	   java.util.logging.Logger.getLogger(StrategoGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	   java.util.logging.Logger.getLogger(StrategoGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	   public void run() {
		new StrategoGame().setVisible(true);
	   }
	});
   }

   public void logMessage(String message) {
	logger.setText(message + "\n" + logger.getText());
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JPanel controlPanel;
   private javax.swing.JButton exitButton;
   private gui.GameMap gameMap;
   private javax.swing.JLabel gamenameLabel;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTextArea logger;
   private javax.swing.JButton newgameButton;
   private javax.swing.JButton testButton;
   private javax.swing.JPanel titlePanel;
   // End of variables declaration//GEN-END:variables
}