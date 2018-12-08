package com.demo.alg.百亿数据排序;

import java.util.List;

public class Test {

	// 测试：
	public static void main(String[] args) {
		// 数据量：
		int dataCount = 100000000;
		// 分页数（拆分文件数）：
		int pageCount = 10;
		// 每页数据量：
		int perPageCount = dataCount / pageCount;

		// 生成一亿数据：
		DataProducer.produce(dataCount, "E:/zsl/data/data");

		DivideTreeSetHandler handler = new DivideTreeSetHandler();

		// 拆分排序：
		List<String> tmps = handler.divide("E:/zsl/data/data", perPageCount);

		// 合并排序：
		String tmp = handler.combine(tmps);

		// 获取数据：
		handler.limit(10, 10, tmp);
	}

}
