package com.zzt.entity;

import java.util.List;

public class ProblemModel {
	private String id;              //模板的序号（唯一生成）
	private String name;            //模板的名称
	private String type;            //模板的类型
	private List<Problem> problemss;//模板的题目List

	private static ProblemModel problemModel = new ProblemModel();
	
	public static ProblemModel getProblemModel()
	{
		return problemModel;
	}
	
	private ProblemModel() {
	}

	public ProblemModel(String id, String name, String type,
			List<Problem> problemss) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.problemss = problemss;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Problem> getProblemss() {
		return problemss;
	}

	public void setProblemss(List<Problem> problemss) {
		this.problemss = problemss;
	}

}
