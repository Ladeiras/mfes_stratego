/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Paulo Faria Reis <paulo@fariareis.com>
 */
public class StrategoView extends JFrame {

   /* Painel do titulo */
   private JPanel titlePanel;
   private JLabel gamenameLabel;

   /* Painel do mapa de jogo */
   private JPanel gameMap;

   /* Painel de controlo */
   private JPanel controlPanel;
   /* Área de mensagem */
   private JScrollPane jScrollPane1;
   private JTextArea logger;
   /* Botões de controlo */
   public JButton newgameButton;
   public JButton exitButton;
   public JButton testButton;

   public StrategoView() {
	try {
	   for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		if ("Nimbus".equals(info.getName())) {
		   javax.swing.UIManager.setLookAndFeel(info.getClassName());
		   break;
		}
	   }
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
	   java.util.logging.Logger.getLogger(StrategoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	initComponents();
   }

   /**
    * Inicialização dos componentes.
    */
   @SuppressWarnings("unchecked")
   private void initComponents() {
	titlePanel = new javax.swing.JPanel();
	gamenameLabel = new javax.swing.JLabel();
	controlPanel = new javax.swing.JPanel();
	jScrollPane1 = new javax.swing.JScrollPane();
	logger = new javax.swing.JTextArea();
	newgameButton = new javax.swing.JButton();
	exitButton = new javax.swing.JButton();
	testButton = new javax.swing.JButton();
	gameMap = new javax.swing.JPanel();

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

	exitButton.setFont(gamenameLabel.getFont());
	exitButton.setText("Exit");

	testButton.setFont(gamenameLabel.getFont());
	testButton.setText("Try Me");

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
	GridLayout board10x10 = new GridLayout(10, 10);
	gameMap.setLayout(board10x10);

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
   }

   /**
    * Adiciona mensagem à textarea de mensagens.
    *
    * @param message
    */
   public void addMessage(String message) {
	logger.setText(message + "\n" + logger.getText());
   }

   public JPanel getGameMap() {
	return this.gameMap;
   }

}
