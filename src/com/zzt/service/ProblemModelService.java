package com.zzt.service;

import com.zzt.entity.ProblemModel;

public interface ProblemModelService {
	//增加模板
	public abstract void addModel(String name,String type);
	
	//删除模板
	public abstract void deleteModel(String id);
	
	//修改模板信息
	public abstract void correctModel(String id ,ProblemModel problemModel);

	//查询模板
	public abstract ProblemModel findProblemModel(String id);

}
