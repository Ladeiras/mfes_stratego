/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author Paulo Faria Reis <paulo@fariareis.com>
 */
public class GameMap extends JPanel {

   public GameMap() {
	GridLayout board10x10 = new GridLayout(10, 10);
	this.setLayout(board10x10);
   }

}
