package com.zzt.entity;

public class UserEvaluate implements Comparable<UserEvaluate> {

	private String patientName;
	private String patientGender;
	private ProblemModel problemModel;
	private Employee evaluator;
	private String time;
	private String suggest;
	private Integer points;

	private static UserEvaluate userEvaluate = new UserEvaluate();

	public static UserEvaluate getUserEvaluate() {
		return userEvaluate;
	}

	private UserEvaluate() {

	}

	public UserEvaluate(String patientName, String patientGender,
			ProblemModel problemModel, Employee evaluator, String time,
			String suggest, Integer points) {
		super();
		this.patientName = patientName;
		patientGender = patientGender;
		this.problemModel = problemModel;
		this.evaluator = evaluator;
		this.time = time;
		this.suggest = suggest;
		this.points = points;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		patientGender = patientGender;
	}

	public ProblemModel getProblemModel() {
		return problemModel;
	}

	public void setProblemModel(ProblemModel problemModel) {
		this.problemModel = problemModel;
	}

	public Employee getEvaluator() {
		return evaluator;
	}

	public void setEvaluator(Employee evaluator) {
		this.evaluator = evaluator;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSuggest() {
		return suggest;
	}

	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@Override
	public int compareTo(UserEvaluate arg0) {

		return this.getPoints().compareTo(arg0.getPoints());
	}

}
