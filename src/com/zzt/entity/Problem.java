package com.zzt.entity;

public class Problem {
	private String id;       //问题的序号（唯一生成）
	private String title;    //问题的题目
	private String type;     //问题的类型
	private String options1; //问题的答案一
	private String options2; //问题的答案二
	private String options3; //问题的答案三

	private static Problem problem = new Problem();
	
	public static Problem getProblem()
	{
		return problem;
	}
	
	private Problem() {

	}

	public Problem(String id, String title, String type, String options1,
			String options2, String options3) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.options1 = options1;
		this.options2 = options2;
		this.options3 = options3;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOptions1() {
		return options1;
	}

	public void setOptions1(String options1) {
		this.options1 = options1;
	}

	public String getOptions2() {
		return options2;
	}

	public void setOptions2(String options2) {
		this.options2 = options2;
	}

	public String getOptions3() {
		return options3;
	}

	public void setOptions3(String options3) {
		this.options3 = options3;
	}

}
