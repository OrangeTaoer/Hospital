package com.zzt.tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class FileTool {
	public static Boolean createFile(String path) {
		Boolean flag = false;
		File file = new File(path);
		try {
			file.createNewFile();
			flag = true;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	public static String readFile2(String path) {
		FileTool.createFile(path); // 根据文件路径判断是否创建文件，并执行操作
		String str = new String(); // 实例化想要返回的字符串
		BufferedReader br = null;// 定义字符流
		try {
			// 通过字符流读取数据
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					path)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();// 异常处理
		}
		String line = "";
		try {
			while ((line = br.readLine()) != null) {
				str += line;// 通过累加得到字符串
			}
		} catch (IOException e) {
			e.printStackTrace();// 异常处理
		}
		try {
			br.close(); // 关闭文件
		} catch (IOException e) {
			e.printStackTrace(); // 异常处理
		}
		return str; // 返回从文件中读取到的字符串
	}

	public static boolean saveFile2(String path, String content) {

		boolean flag = true; // 定义flag判断是否正常写入
		FileTool.createFile(path);// 根据文件路径判断是否创建文件，并执行操作
		FileWriter fw = null;// 定义字符流

		try {
			fw = new FileWriter(path);// 实例化字符流
		} catch (IOException e) {
			flag = false;// 若不正常则flag为假
			e.printStackTrace();// 异常处理
		}

		try {
			fw.write(content); // 写入文本
			fw.flush(); // 刷新操作
			fw.close(); // 关闭文件
		} catch (IOException e) {
			flag = false;// 若不正常则flag为假
			e.printStackTrace();// 异常处理
		}

		return flag;
	}
}
