package com.zzt.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.zzt.dao.ProbelmModelDao;
import com.zzt.entity.ProblemModel;
import com.zzt.tool.GetDataClass;
import com.zzt.tool.WriteDataClass;

public class ProblemModelDaoImpl implements ProbelmModelDao {

	private static ProblemModelDaoImpl problemModelDaoImpl = new ProblemModelDaoImpl();
	
	private ProblemModelDaoImpl(){
		
	}
	
	public static ProblemModelDaoImpl getProblemModelDaoImpl()
	{
		return problemModelDaoImpl;
	}
	
	
	@Override
	public void addModel(String name, String type) {
		int max = -1 ;
		List<ProblemModel> problemModels = GetDataClass.getDataProblemModelClass();
		if(problemModels != null && !problemModels.isEmpty())
		{
			for(ProblemModel t : problemModels)
			{
				if(max < Integer.parseInt(t.getId()))
				{
					max = Integer.parseInt(t.getId());
				}
			}
			ProblemModel x =  ProblemModel.getProblemModel();
			x.setId(Integer.toString(max));
			x.setName(name);
			x.setType(type);
			problemModels.add(x);
			WriteDataClass.writeDataProblemModel(problemModels);
			return;
		}
		problemModels = new ArrayList<ProblemModel>();
		
		max = 1 ;
		ProblemModel x = ProblemModel.getProblemModel();
		x.setId(Integer.toString(max));
		x.setName(name);
		x.setType(type);
		problemModels.add(x);
		WriteDataClass.writeDataProblemModel(problemModels);
		return;
	}

	@Override
	public void deleteModel(String id) {
		List<ProblemModel> problemModels = GetDataClass.getDataProblemModelClass();
		if(problemModels != null && !problemModels.isEmpty())
		{
			int i = 0 ;
			for(ProblemModel t : problemModels)
			{
				if(t.getId().equals(id))
				{
					problemModels.remove(t);
				}
				i ++ ;
			}
			WriteDataClass.writeDataProblemModel(problemModels);
			return;
		}
	}

	@Override
	public void correctModel(String id ,ProblemModel problemModel) {
		List<ProblemModel> problemModels = GetDataClass.getDataProblemModelClass();
		if(problemModels != null && !problemModels.isEmpty())
		{
			int i = 0 ;
			for(ProblemModel t : problemModels)
			{
				if(t.getId().equals(id))
				{
					problemModels.set(i,problemModel);
				}
				i ++ ;
			}
			WriteDataClass.writeDataProblemModel(problemModels);
			return;
		}
	}

	@Override
	public ProblemModel findProblemModel(String id) {
		List<ProblemModel> problemModels = GetDataClass.getDataProblemModelClass();
		ProblemModel problemModel = ProblemModel.getProblemModel();
		if(problemModels != null && !problemModels.isEmpty())
		{
			int i = 0 ;
			for(ProblemModel t : problemModels)
			{
				if(t.getId().equals(id))
				{
					problemModel = t ;
				}
				i ++ ;
			}
			return problemModel;
		}
		return null;
	}

}
