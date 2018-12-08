package com.demo.alg.百亿数据排序;

import java.io.File;
import java.io.PrintWriter;
import java.util.Random;

public class DataProducer {

	public static void produce(int count, String out) {
		File file = new File(out);
		if(file.exists())
			file.delete();

		try (PrintWriter writer = new PrintWriter(file, "UTF-8");) {
			Random random = new Random();
			for(int i=0; i<count; i++){
				writer.write(random.nextInt(count) + "\n");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
