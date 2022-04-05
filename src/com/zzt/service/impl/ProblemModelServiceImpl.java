package com.zzt.service.impl;

import com.zzt.dao.impl.ProblemModelDaoImpl;
import com.zzt.entity.ProblemModel;
import com.zzt.service.ProblemModelService;

public class ProblemModelServiceImpl implements ProblemModelService {

	private static ProblemModelServiceImpl problemModelServiceImpl = new ProblemModelServiceImpl();
	
	private ProblemModelServiceImpl()
	{
		
	}
	public static ProblemModelServiceImpl getProblemModelServiceImpl()
	{
		return problemModelServiceImpl;
	}
	
	private ProblemModelDaoImpl problemModelDaoImpl = ProblemModelDaoImpl.getProblemModelDaoImpl();
	
	@Override
	public void addModel(String name, String type) {
		problemModelDaoImpl.addModel(name, type);
	}

	@Override
	public void deleteModel(String id) {
		// TODO Auto-generated method stub
		problemModelDaoImpl.deleteModel(id);
	}

	@Override
	public void correctModel(String id, ProblemModel problemModel) {
		// TODO Auto-generated method stub
		problemModelDaoImpl.correctModel(id, problemModel);
	}

	@Override
	public ProblemModel findProblemModel(String id) {
		// TODO Auto-generated method stub
		return problemModelDaoImpl.findProblemModel(id);
	}

}
