/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Paulo Faria Reis <paulo@fariareis.com>
 */
public class Rank {

   String rankName;

   public Rank(String rankName) {
	this.rankName = rankName;
   }

   public String getRankName() {
	return rankName;
   }

   public void setRankName(String rankName) {
	this.rankName = rankName;
   }

}