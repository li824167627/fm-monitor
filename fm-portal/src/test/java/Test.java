import java.text.ParseException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.northend.util.MD5Util;

public class Test {

	public static void main(String[] args) throws ParseException {
		long startTime = System.currentTimeMillis();
		Set<String> set = new HashSet<>();
		for (int i = 0; i < 200000; i++) {
			set.add(MD5Util.md5("" + i));
		}

		Set<String> set2 = new HashSet<>();
		for (int i = 0; i < 30000; i++) {
			set2.add(MD5Util.md5("" + i));
		}

		set.retainAll(set2);
		System.out.println(System.currentTimeMillis() - startTime);
		System.out.println(set.size());
	}

}
