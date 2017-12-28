package com.krishagni.map;

import java.util.LinkedList;
import java.util.List;

public class LinkedHashMap {

	 class Container{
		
		Container(){}
		Object key;
		Object value;
		public void insert(Object k, Object v){
			this.key=k;
			this.value=v;
		}
	}
	
	private Container c;
	private static List<Container> recordList;
	
	public LinkedHashMap(){
		
		this.recordList=new LinkedList<Container>();
	}
	
	public void put(Object k, Object v){
		this.c=new Container();
		c.insert(k, v);
		
		for(int i=0; i<recordList.size(); i++){
			Container c1=recordList.get(i);
			if(c1.key.equals(k)){
				
				recordList.remove(i);
				break;
			}
		}
		recordList.add(c);
	}
	
	public Object get(Object k){
		for(int i=0; i<this.recordList.size(); i++){
			Container con = recordList.get(i);
			if (k.toString()==con.key.toString()) {
				
				return con.key +" " + con.value;
			}
			
		}
		return -1;
	}
	
	public Object remove(Object k){
		for(int i=0; i<recordList.size(); i++){
			Container c1=recordList.get(i);
			if(c1.key.equals(k)){
				
				recordList.remove(i);
				break;
			}
		}
		return "Deleted";
	}
	
	public boolean isEmpty()
	{	
		for(int i=0; i<this.recordList.size(); i++){
			Container con = recordList.get(i);
		if(con.key == null)
		{
			return true;
		}
		else
		{
			return false;
		}
		}
		return true;
	}
	
	public boolean containsKey(Object k){
		for(int i=0; i<this.recordList.size(); i++){
			Container con = recordList.get(i);
			if (k.toString()==con.key.toString()) {
				
				return true;
			}
			
		}
		return false;
	}
		

	
	public static void main(String[] args) {
		LinkedHashMap hm = new LinkedHashMap();
		
		System.out.println(hm.isEmpty());
		
		hm.put("Paresh", 1);
		hm.put("Paresh", 2);
		hm.put("Rupesh", 5);
		hm.put("KEY", "VALUE");
		
		System.out.println(hm.isEmpty());
		System.out.println(hm.get("KEY"));
		System.out.println(hm.get("Paresh"));
		System.out.println(hm.get("Rupesh"));
		System.out.println(hm.remove("KEY"));
		System.out.println(hm.get("KEY"));
		System.out.println(hm.containsKey("Rupesh"));
		System.out.println(hm.containsKey(10));
		
	}

}
