
import java.util.*;

/**
 * 根据 HashMap 的 value 进行排序
 * @author Winter Lau
 * @date 2009-11-24 下午01:35:37
 */
public class test {

	public static void main(String[] args) {
		
		HashMap datas = new HashMap(){{
			put("Winter Lau", 100);
			put("Yier", 150);
			put("Nothing", 30);
			put("Zolo", 330);
		}};
		
		ByValueComparator bvc = new ByValueComparator(datas);
		
		//第一种方法
		TreeMap sorted_map = new TreeMap(bvc);
		sorted_map.putAll(datas);
		
		for(String name : sorted_map.keySet()){
			System.out.printf("%s -> %d\n", name, datas.get(name));
		}

		//第二种方法
		List keys = new ArrayList(datas.keySet());
		Collections.sort(keys, bvc);
		for(String key : keys) {
			System.out.printf("%s -> %d\n", key, datas.get(key));
		}
	}

	static class ByValueComparator implements Comparator {
		HashMap base_map;

		public ByValueComparator(HashMap base_map) {
			this.base_map = base_map;
		}

		@Override
		public int compare(String arg0, String arg1) {
			if (!base_map.containsKey(arg0) || !base_map.containsKey(arg1)) {
				return 0;
			}

			if (base_map.get(arg0) < base_map.get(arg1)) {
				return 1;
			} else if (base_map.get(arg0) == base_map.get(arg1)) {
				return 0;
			} else {
				return -1;
			}
		}
	}

}