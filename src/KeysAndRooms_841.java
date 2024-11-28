import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class KeysAndRooms_841 {

    public boolean canVisitAllRooms(List<List<Integer> /* keys*/ > rooms) {
    	if (rooms == null && rooms.size() == 0) return false;
    	if (rooms.size() == 1) return true;
    	
    	boolean[] visitedRooms = new boolean[rooms.size()];
    	visitedRooms[0] = true;
    	
    	List<Integer> keys = removeKeys(rooms, 0);
    	HashSet<Integer> collectedKeys = new HashSet<>();
    	
    	while (true) {
    		if (keys.isEmpty()) break;
    		
    		for (Integer k: keys) {
    			visitedRooms[k] = true;
    			List<Integer> found = removeKeys(rooms, k);
    			collectedKeys.addAll(found);
    		}
    		keys.clear();
    		keys.addAll(collectedKeys);
    		collectedKeys.clear();
    	}
    	
    	for (boolean b: visitedRooms) 
    		if (!b) return false;
    	return true;
    }
    
    List<Integer> removeKeys(List<List<Integer>> rooms, int idx) {
    	List<Integer> val = rooms.get(idx);
    	rooms.set(idx, Collections.EMPTY_LIST);
    	return val;
    }
    
}
