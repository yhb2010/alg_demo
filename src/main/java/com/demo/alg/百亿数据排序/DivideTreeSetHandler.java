package com.demo.alg.百亿数据排序;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DivideTreeSetHandler {

	/**
	 * 排序
	 * @param in 数据文件路径
	 * @param size 每个数据文件的大小（行数）
	 */
	public List<String> divide(String in, int size){
		File file = new File(in);
		if(!file.exists())
			return null;

		List<String> outs = new ArrayList<String>();

		try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));){
			int fileNo = 0; // 临时文件编号
			Set<Integer> set = new TreeSet<Integer>();
			while(true){
				String line = reader.readLine();

				// 读取结束！
				if(line == null){
					writeSetToTmpFile(set, fileNo, outs);
					break;
				}

				// 空行，跳过
				if("".equals(line.trim())){
					continue;
				}

				set.add(new Integer(line));

				// 数据量达到:
				if(set.size() >= size){
					writeSetToTmpFile(set, fileNo, outs);
					fileNo ++;
				}
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return outs;
	}

	// set数据写入到文件中：
	private void writeSetToTmpFile(Set<Integer> set, int fileNo, List<String> outs) {
		File file = new File("E:/zsl/data/tmp_" + fileNo);
		if(file.exists())
			file.delete();

		try (PrintWriter writer = new PrintWriter(file, "UTF-8");) {
			Iterator<Integer> iterator = set.iterator();
			while(iterator.hasNext()){
				writer.write(iterator.next() + "\n");
			}
			set.clear();
		}catch (Exception e){
			e.printStackTrace();
		}
		outs.add(file.getAbsolutePath());
	}

	/**
	 * 合并数据
	 * @param ins
	 */
	public String combine(List<String> ins) {
		if(ins == null || ins.isEmpty())
			return null;

		File file = new File("E:/zsl/data/sort");
		if(file.exists())
			file.delete();

		try(PrintWriter writer = new PrintWriter(file, "UTF-8");){
			List<BufferedReader> readers = new ArrayList<>();
			for (String in : ins) {
				readers.add(new BufferedReader(new InputStreamReader(new FileInputStream(in), "UTF-8")));
			}

			while(readers.size() > 0){
				BufferedReader reader0 = readers.get(0);
				while(true){
					String line = reader0.readLine();
					if(line == null){
						readers.remove(0);
						break;
					}
					if("".equals(line.trim()))
						continue;

					// 用个set记录从多个文件中取出的数据，这些数据需要继续排序：
					Set<Integer> set = new TreeSet<Integer>();

					int data = new Integer(line);

					// 先把data放入set：
					set.add(data);

					for(int i = readers.size() - 1; i > 0; i--){
						BufferedReader readeri = readers.get(i);
						while(true){
							// mark和reset方法：一个在前面做标记，另一个重置返回到做标记的位置。
							// mark(readAheadLimit)方法仅有一个参数：保证mark有效的情况下限制读取的字符数。当读取字符达到或超过此限制时，尝试重置流会失败。当限制数值大于输入buffer的默认大小时，将会动态分配一个容量不小于限制数值的buffer。因此，应该慎用大数值。
							// 设置一个标记，如果后边datai大于data了，需要reset到此处！
							readeri.mark(1024);

							String linei = readeri.readLine();
							if(linei == null){
								readers.remove(i);
								break;
							}
							if("".equals(linei.trim()))
								continue;

							int datai = new Integer(linei);

							// datai小于data，则把datai放入set，会自动排序
							if(datai < data){
								set.add(datai);
							}
							// datai等于data，则暂时退出，停止读取
							else if(datai == data){
								break;
							}
							// datai大于data，则往回退一行（退到标记处），停止读取
							else{
								readeri.reset();
								break;
							}
						}
					}

					// 按data查找，小于data的值，都已经存入set了，此时把set输出到文件中：
					Iterator<Integer> iterator = set.iterator();
					while(iterator.hasNext()){
						writer.write(iterator.next() + "\n");
					}
					set.clear();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return file.getAbsolutePath();
	}

	/**
	 * 从pos开始，获取count个数
	 * @param pos
	 * @param count
	 * @return
	 */
	public void limit(int pos, int count, String in){
		try{
			BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(in), "UTF-8"));
			bf.skip(pos);
			for(int i=0; i<count; i++){
				System.out.println(bf.readLine());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
