package 解题群.铃盛软件;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @date 2021-04-27
 * @author yqz
 */
public class Utils {

	/**
	 * Question1, sort by firstName , lastName and  ext,
	 * if firstName is the same then sort by lastName and
	 * ext, please note lastName and ext can be empty string or null
	 **/
	public static List<Extension> sortByName(List<Extension> extensions) {
		if (extensions==null || extensions.size()==0) {
			return extensions;
		}
		extensions.sort((e1, e2) -> {
			if (e1.getFirstName().equals(e2.getFirstName())) {
				String l1 = Optional.ofNullable(e1.getLastName()).orElse("");
				String l2 = Optional.ofNullable(e2.getLastName()).orElse("");
				if (l1.equals(l2)) {
					String ext1 = Optional.ofNullable(e1.getLastName()).orElse("");
					String ext2 = Optional.ofNullable(e2.getLastName()).orElse("");
					return ext1.compareTo(ext2);
				} else {
					return l1.compareTo(l2);
				}
			} else {
				return e1.getFirstName().compareTo(e2.getFirstName());
			}
		});
		return extensions;
	}


	/**
	 * Question2, sort extType, extType is a string and can
	 * be "User", "Dept", "AO", "TMO", "Other",
	 * sort by User > Dept > AO > TMO > Other;
	 * There might be new extType value, it will be in last order is it's not in prefined list.
	 **/
	public static List<Extension> sortByExtType(List<Extension> extensions) {
		if (extensions==null || extensions.size()==0) {
			return extensions;
		}
		String[] extTypes={"User", "Dept", "AO", "TMO", "Other"};
		Map<String, Integer> extTypeMap = new HashMap<>(6);
		for (int i = 0; i < extTypes.length; i++) {
			extTypeMap.put(extTypes[i],i);
		}
		extensions.sort((e1, e2) -> {
			Integer c1 = extTypeMap.getOrDefault(e1.getExtType(), 5);
			Integer c2 = extTypeMap.getOrDefault(e2.getExtType(), 5);
			return c1.compareTo(c2);
		});
		return extensions;
	}

	/**
	 * Question3, sum all sales items by quarter, sum the amount for the same quarter item.
	 **/
	public static List<QuarterSalesItem> sumByQuarter(List<SaleItem> saleItems) {
		if (saleItems==null || saleItems.size()==0) {
			return new ArrayList<>();
		}
		return saleItems.stream()
				.collect(Collectors.groupingBy(saleItem -> transferMonthToQuarter(saleItem.getMonth()), Collectors.summarizingDouble(SaleItem::getAmount)))
				.entrySet()
				.stream()
				.map(entry -> {
					QuarterSalesItem quarterSalesItem = new QuarterSalesItem();
					quarterSalesItem.setQuarter(entry.getKey());
					quarterSalesItem.setAmount(entry.getValue().getSum());
					return quarterSalesItem;
				}).collect(Collectors.toList());
	}

	/**
	 * Question4, max all sales items by quarter, get the max amount from the item belongs to the same quarter
	 *
	 **/
	public static List<QuarterSalesItem> maxByQuarter(List<SaleItem> saleItems) {
		if (saleItems==null || saleItems.size()==0) {
			return new ArrayList<>();
		}
		return saleItems.stream()
				.collect(Collectors.groupingBy(saleItem -> transferMonthToQuarter(saleItem.getMonth()), Collectors.toList()))
				.entrySet()
				.stream()
				.map(entry -> {
					Double maxAmount = entry.getValue()
							.stream()
							.max(Comparator.comparingDouble(SaleItem::getAmount))
							.map(SaleItem::getAmount)
							.orElse(0.0);

					QuarterSalesItem quarterSalesItem = new QuarterSalesItem();
					quarterSalesItem.setQuarter(entry.getKey());
					quarterSalesItem.setAmount(maxAmount);
					return quarterSalesItem;
				}).collect(Collectors.toList());

	}
    
	//Question5
	/**
	 * We have all Keys like 0-10000 with random order, it can be other keys in real cases;
	 * usedKeys is an array to store all used keys like :[2,3,4] with random order;
	 * We want to get all unused keys, in this example it would be: [0,1,5,6,7,8,9,....]
	 */
	
	public static int[] getUnUsedKeys(int[] allKeys, int[] usedKeys) {
		//transfer userKeys to hash
		if (Objects.isNull(allKeys) || Objects.isNull(usedKeys)) {
			return allKeys;
		}
		Set<Integer> usedKeySet = Arrays.stream(usedKeys)
				.boxed()
				.collect(Collectors.toSet());
		return Arrays.stream(allKeys).boxed()
				.filter((key) -> !usedKeySet.contains(key))
				.mapToInt(Integer::intValue)
				.toArray();
	}

	/**
	 * transfer month to quarter
	 * @param month
	 * @return quarter
	 */
	private static int transferMonthToQuarter(int month){
		final int maxMonth=12;
		final int minMonth=1;
		if (month<minMonth || month>maxMonth) {
			throw new IllegalArgumentException("illegal month");
		}
		return (month-1)/3+1;
	}

	public static void main(String[] args) {
		//构造List<Extension> extensions
		List<Extension> extensions = new ArrayList<>();
		//lastName和ext为空
		Extension extension = new Extension();
		extension.setFirstName("qiaozhu");
		extensions.add(extension);
		//lastName为空
		Extension extension1 = new Extension();
		extension1.setFirstName("qiaozhu");
		extension1.setLastName("ye");
		extensions.add(extension1);
		//ext为空
		Extension extension2 = new Extension();
		extension2.setFirstName("qiaozhu");
		extension2.setLastName("ye");
		extension2.setExt("test");
		extensions.add(extension2);
		System.out.println(Utils.sortByName(extensions));

		extension.setExtType("User");
		extension1.setExtType("Other");
		extension2.setExtType("test");
		System.out.println(Utils.sortByExtType(extensions));

		List<SaleItem> saleItems=new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			SaleItem saleItem = new SaleItem();
			saleItem.setMonth(i+1);
			saleItem.setAmount(i+0.1);
			saleItems.add(saleItem);
		}
		System.out.println(Utils.sumByQuarter(saleItems));
		System.out.println(Utils.maxByQuarter(null));


		System.out.println(Utils.getUnUsedKeys(new int[]{0, 1, 2, 3, 4, 5}, new int[]{2, 3, 4}));
		System.out.println(Utils.getUnUsedKeys(new int[]{0, 1, 2, 3, 4, 5}, new int[]{}));
		System.out.println(Utils.getUnUsedKeys(new int[]{0, 1, 2, 3, 4, 5}, null));
	}
	
}
