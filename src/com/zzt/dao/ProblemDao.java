package com.zzt.dao;

import com.zzt.entity.Problem;
import com.zzt.entity.ProblemModel;

public interface ProblemDao {
	
	//普通增删除改查问题：
	public abstract void addProblem1(Problem problem);
	public abstract void deleteProblem1(Problem problem);
	public abstract void correctProblem1(String id,Problem problem);
	public abstract Problem findProblem1(String id);
	
	//为模板增删查问题;
	public abstract void addProblem2(ProblemModel problemModel,Problem problem);
	public abstract void deleteProblem2(ProblemModel problemModel ,Problem problem);
	public abstract void findProblem2(ProblemModel problemModel , Problem problem);

}
