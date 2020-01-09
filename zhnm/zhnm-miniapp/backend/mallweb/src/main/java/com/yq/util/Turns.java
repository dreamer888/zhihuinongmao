package com.yq.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class Turns {
	
	public static void main(String[] args) {
		String[] color={"红色","白色","蓝色","金色"};

		String[] size={"4.7寸","5.1寸","6.0寸"};

		String[] version={"联通","电信","移动","全网通"};
		
		List arrayLists = new ArrayList<>();
		arrayLists.add(color);
		arrayLists.add(size);
		arrayLists.add(version);
		new Turns().attr(arrayLists);
    }
	public static List<Object> list(List<Object> list){
		String[] attr = new Turns().turns(list);
		for (String s : attr) {
			System.err.println(s);
	   }
		List<Object> attr_list = new ArrayList<Object>();
		for (String string : attr) {
			String[] array = string.split(",");
			attr_list.add(array);
	   }
		
		return attr_list ;
	}
	
	public static String attr(List<Object> list){
		String detail_attr = "" ;
		String[] attr = new Turns().turns(list);
		for (String detail : attr) {
			if(StringUtils.isEmpty(detail_attr)){
				detail_attr = detail ;
			}else{
				detail_attr = detail_attr + "qp" + detail ;
			}
			
	   }
		System.err.println(detail_attr);
		return detail_attr ;
	}
    /**
     * 两两遍历
     * @param array1
     * @param array2
     * @return
     */
    public static String[] doubleTurns(String [] array1,String[] array2){
        String [] target=new String[array1.length*array2.length];
        for (int i = 0,a1=0,a2=0; i <array1.length*array2.length; i++) {
            target[i]=array1[a1]+","+array2[a2];
            a2++;
            if(a2==array2.length){
                a2=0;
                a1++;
            }
        }
        return target;
    }
    /**
     * 遍历组合
     * @param arrays
     * @return
     */
    public static String[] turns(List<Object> list){
    	String[][] arrays  = list.toArray(new String[list.size()][]);
        if(arrays.length==1){
            return arrays[0];
        }
        if(arrays.length==0){
            return null;
        }
        //获得总结果数
        int count=0;
        for (int i = 0; i < arrays.length; i++) {
            count*=arrays[i].length;
        }
        String target[]=new String[count];
        //两两遍历
        for (int i = 0; i < arrays.length; i++) {
            if(i==0){
                target=doubleTurns(arrays[0],arrays[1]);
                i++;
            }else{
                target=doubleTurns(target,arrays[i]);
            }
        }
       
        return target;
    }
}