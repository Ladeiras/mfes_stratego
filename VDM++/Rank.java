//
// THIS FILE IS AUTOMATICALLY GENERATED!!
//
// Generated at 2013-11-28 by the VDM++ to JAVA Code Generator
// (v9.0.2 - Thu 14-Mar-2013 12:36:47 +0900)
//
// Supported compilers: jdk 1.4/1.5/1.6
//

// ***** VDMTOOLS START Name=HeaderComment KEEP=NO
// ***** VDMTOOLS END Name=HeaderComment

// This file was genereted from "C:\\Users\\Jo�o\\Documents\\GitHub\\mfes_stratego/Rank.rtf".

// ***** VDMTOOLS START Name=package KEEP=NO
// ***** VDMTOOLS END Name=package

// ***** VDMTOOLS START Name=imports KEEP=NO
import jp.vdmtools.VDM.UTIL;
import jp.vdmtools.VDM.Sentinel;
import jp.vdmtools.VDM.EvaluatePP;
import jp.vdmtools.VDM.CGException;
// ***** VDMTOOLS END Name=imports



public class Rank implements EvaluatePP {

// ***** VDMTOOLS START Name=name KEEP=NO
  public volatile Character name = null;
// ***** VDMTOOLS END Name=name

// ***** VDMTOOLS START Name=sentinel KEEP=NO
  volatile Sentinel sentinel;
// ***** VDMTOOLS END Name=sentinel


// ***** VDMTOOLS START Name=RankSentinel KEEP=NO
  class RankSentinel extends Sentinel {

    public final int nr_functions = 0;


    public RankSentinel () throws CGException {}


    public RankSentinel (EvaluatePP instance) throws CGException {
      init(nr_functions, instance);
    }

  }
// ***** VDMTOOLS END Name=RankSentinel
;

// ***** VDMTOOLS START Name=evaluatePP#1|int KEEP=NO
  public Boolean evaluatePP (int fnr) throws CGException {
    return Boolean.TRUE;
  }
// ***** VDMTOOLS END Name=evaluatePP#1|int


// ***** VDMTOOLS START Name=setSentinel KEEP=NO
  public void setSentinel () {
    try {
      sentinel = new RankSentinel(this);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=setSentinel


// ***** VDMTOOLS START Name=vdm_init_Rank KEEP=NO
  private void vdm_init_Rank () {
    try {
      setSentinel();
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=vdm_init_Rank


// ***** VDMTOOLS START Name=Rank KEEP=NO
  public Rank () throws CGException {
    vdm_init_Rank();
  }
// ***** VDMTOOLS END Name=Rank

}
;