/**
 * 
 */
package com.fh.entity.system;

/**
 * @author zangmaoyuan
 *2018-6-6
 * 
 */
public class Category {
	private String CATEGORY_ID;
	private String CATEGORY_NAME;
	private String CATEGORY_EN_NAME;
	private String CATEGORY_IMG;
	private String SUPER_ID;
	private int SORT;
	/**
	 * @return the cATEGORY_ID
	 */
	public String getCATEGORY_ID() {
		return CATEGORY_ID;
	}
	/**
	 * @param cATEGORY_ID the cATEGORY_ID to set
	 */
	public void setCATEGORY_ID(String cATEGORY_ID) {
		CATEGORY_ID = cATEGORY_ID;
	}
	/**
	 * @return the cATEGORY_NAME
	 */
	public String getCATEGORY_NAME() {
		return CATEGORY_NAME;
	}
	/**
	 * @param cATEGORY_NAME the cATEGORY_NAME to set
	 */
	public void setCATEGORY_NAME(String cATEGORY_NAME) {
		CATEGORY_NAME = cATEGORY_NAME;
	}
	/**
	 * @return the cATEGORY_EN_NAME
	 */
	public String getCATEGORY_EN_NAME() {
		return CATEGORY_EN_NAME;
	}
	/**
	 * @param cATEGORY_EN_NAME the cATEGORY_EN_NAME to set
	 */
	public void setCATEGORY_EN_NAME(String cATEGORY_EN_NAME) {
		CATEGORY_EN_NAME = cATEGORY_EN_NAME;
	}
	/**
	 * @return the cATEGORY_IMG
	 */
	public String getCATEGORY_IMG() {
		return CATEGORY_IMG;
	}
	/**
	 * @param cATEGORY_IMG the cATEGORY_IMG to set
	 */
	public void setCATEGORY_IMG(String cATEGORY_IMG) {
		CATEGORY_IMG = cATEGORY_IMG;
	}
	/**
	 * @return the sUPER_ID
	 */
	public String getSUPER_ID() {
		return SUPER_ID;
	}
	/**
	 * @param sUPER_ID the sUPER_ID to set
	 */
	public void setSUPER_ID(String sUPER_ID) {
		SUPER_ID = sUPER_ID;
	}
	/**
	 * @return the sORT
	 */
	public int getSORT() {
		return SORT;
	}
	/**
	 * @param sORT the sORT to set
	 */
	public void setSORT(int sORT) {
		SORT = sORT;
	}

}
