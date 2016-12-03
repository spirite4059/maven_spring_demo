package com.maven01.web.bean;

public class BaseB implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	/** ID */
	private int id;

	public BaseB() {
	}

	public BaseB(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	/**
	 * 比较属性值是否相等
	 * @return
	 */
	public boolean valueEq(Object source,Object target){
		if(source==null && target==null){
			return true;
		}
		else if(source==null && target!=null){
			return false;
		}
		else if(source!=null && target==null){
			return false;
		}else{
			if(source.equals(target)){
				return true;
			}
			return false;
		}
	}
	
	/**
	 * 比较属性值是否相等
	 * 
	 * @return
	 */
	public String contentEq(Object source, Object target, String fieldName) {
		if (source == null && target == null) {
			return "";
		} else if (source == null && target != null) {
			return "[" + fieldName + " :''->" + target + "]  ";
		} else if (source != null && target == null) {
			return "[" + fieldName + " :" + source + "->'']  ";
		} else {
			if (!source.equals(target)) {
				return "[" + fieldName + " :" + source + "->" + target + "]  ";
			}
			return "";
		}
	}

}
