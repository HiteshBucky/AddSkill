import java.util.*;

class Subdomain_Visit_Count {


	public static List<String> solve(String[] domainList) {

		HashMap<String, Integer> map = new HashMap<>();

		List<String> res = new ArrayList<>();

		for (int i = 0; i < domainList.length; i++) {

			String[] arrIntDom = domainList[i].split(" ");

			int visits = Integer.parseInt(arrIntDom[0]);

			map.put(arrIntDom[1], map.getOrDefault(arrIntDom[1], 0) + visits);

			String[] arrSubDom2 = arrIntDom[1].split("\\.", 2);

			if (arrSubDom2.length == 2)
				map.put(arrSubDom2[1], map.getOrDefault(arrSubDom2[1], 0) + visits);

			String[] arrSubDom3 = arrIntDom[1].split("\\.", 3);

			if (arrSubDom3.length == 3)
				map.put(arrSubDom3[2], map.getOrDefault(arrSubDom3[2], 0) + visits);
		}

		for (String key : map.keySet())
			res.add(Integer.toString(map.get(key)) + " " + key);

		return res;
	}





	public static void main(String[] args) {



		String str[] = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
		System.out.println(solve(str));
	}
}