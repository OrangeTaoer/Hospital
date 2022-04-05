package com.zzt.controller.impl;

import com.zzt.controller.ProblemModelController;
import com.zzt.entity.ProblemModel;
import com.zzt.service.impl.ProblemModelServiceImpl;

public class ProblemModelControllerImpl implements ProblemModelController {

	
	private static ProblemModelControllerImpl problemModelControllerImpl= new ProblemModelControllerImpl();
	
	private ProblemModelControllerImpl()
	{
		
	}
	public static ProblemModelControllerImpl getProblemModelControllerImpl()
	{
		return problemModelControllerImpl;
	}
	
	private ProblemModelServiceImpl problemModelServiceImpl = ProblemModelServiceImpl.getProblemModelServiceImpl();
	
	@Override
	public void addModel(String name, String type) {
		problemModelServiceImpl.addModel(name, type);
	}

	@Override
	public void deleteModel(String id) {
		problemModelServiceImpl.deleteModel(id);
	}

	@Override
	public void correctModel(String id, ProblemModel problemModel) {
		problemModelServiceImpl.correctModel(id, problemModel);
	}

	@Override
	public ProblemModel findProblemModel(String id) {
		return problemModelServiceImpl.findProblemModel(id);
	}

}
