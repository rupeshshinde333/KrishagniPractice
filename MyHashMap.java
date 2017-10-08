import java.util.Comparator;
import java.util.LinkedList;
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
	private static List<Container> recordList;
	
	public MyHashMap(){
		
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
	

	static class MyComparator 	implements Comparator
	{

		public int compare(Object o1, Object o2) {
			Object object1 = o1.toString();
			Object object2 = o2.toString();
			int i1 = ((String) object1).length();
			int i2 = ((String) object2).length();
			
			/*Integer i1 = (Integer) o1;
			Integer i2 = (Integer) o2;*/

			
			if(i1 < i2)
				return -1;
			else if(i1 > i2)
				return -1;
			else 
				return 0;
		}
		
	}
	
	public static int binarySearch(List l, Object key) {
			MyComparator m = new MyComparator();
			
	        int low = 0;
	        int high = l.size()-1;
	        int mid ;

	        while (low <= high) {
	            mid = (low + high) / 2;

	            if (m. compare(l.get(mid),key) < 0) {
	                low = mid + 1;
	            } else if ( m. compare(l.get(mid),key) > 0) {
	                high = mid - 1;
	            } else {
	                return (Integer) l.get(mid);
	            }
	        }

	        return -1;
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
		
		System.out.println(  binarySearch(recordList, "JOHN"));
		
		
		
	}

}

