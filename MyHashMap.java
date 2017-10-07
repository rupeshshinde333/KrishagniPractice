import java.util.ArrayList;
import java.util.List;

public class MyHashMap {

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
	private List<Container> recordList;
	
	public MyHashMap(){
		
		this.recordList=new ArrayList<Container>();
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
		return null;
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
	
	
	public static void main(String[] args) {
		MyHashMap hm = new MyHashMap();
		System.out.println(hm.isEmpty());
		hm.put("JOHN", 1);
		hm.put("JOHN", 2);
		hm.put("KEY", "VALUE");
		System.out.println(hm.isEmpty());
		
		System.out.println(hm.get("KEY"));
		System.out.println(hm.get("JOHN"));
		
	}

}