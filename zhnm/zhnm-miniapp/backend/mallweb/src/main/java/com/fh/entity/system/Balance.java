/**
 * 
 */
package com.fh.entity.system;

/**
 * @author zangmaoyuan
 *2018-6-6
 * 
 */
public class Balance {
	private int ID;
	private String BALANCE_IMEI;
	private String BALANCE_MODEL;
	private Boolean USED;
	private String VERSION;
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * @return the bALANCE_IMEI
	 */
	public String getBALANCE_IMEI() {
		return BALANCE_IMEI;
	}
	/**
	 * @param bALANCE_IMEI the bALANCE_IMEI to set
	 */
	public void setBALANCE_IMEI(String bALANCE_IMEI) {
		BALANCE_IMEI = bALANCE_IMEI;
	}
	/**
	 * @return the bALANCE_MODEL
	 */
	public String getBALANCE_MODEL() {
		return BALANCE_MODEL;
	}
	/**
	 * @param bALANCE_MODEL the bALANCE_MODEL to set
	 */
	public void setBALANCE_MODEL(String bALANCE_MODEL) {
		BALANCE_MODEL = bALANCE_MODEL;
	}
	/**
	 * @return the uSED
	 */
	public Boolean getUSED() {
		return USED;
	}
	/**
	 * @param uSED the uSED to set
	 */
	public void setUSED(Boolean uSED) {
		USED = uSED;
	}
	/**
	 * @return the vERSION
	 */
	public String getVERSION() {
		return VERSION;
	}
	/**
	 * @param vERSION the vERSION to set
	 */
	public void setVERSION(String vERSION) {
		VERSION = vERSION;
	}
	

}
