package chapter3;
public class testPretenureSizeThreshold{
private static final int _1MB = 1024 * 1024;

/**
 * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=3145728,超过这个数字就会直接分配到老年代
 */
public static void testPretenureSizeThreshold() {
	byte[] allocation;
	allocation = new byte[4 * _1MB];  //直接分配在老年代中
}
}
