package com.zd.entity;

public class Engage_interview {

	
	public Engage_interview() {
		super();
	}
	
	
	private int ein_id;
	private String human_name;
	private int interview_amount;
	private String human_major_kind_id;
	private String human_major_kind_name;
	private String human_major_id;
	private String human_major_name;
	private int image_degree;
	private int native_language_degree;
	private int foreign_language_degree;
	private int response_speed_degree;
	private int eQ_degree;
	private int iQ_degree;
	private String multi_quality_degree;
	private String register;
	private String checker;
	private String registe_time;
	private String check_time;
	private int resume_id;
	private String result;
	private String interview_comment;
	private String check_comment;
	private int interview_status;
	private int check_status;
	
	
	private Engage_resume engage_resume;
	
	
	public Engage_interview(int ein_id, String human_name, int interview_amount, String human_major_kind_id,
			String human_major_kind_name, String human_major_id, String human_major_name, int image_degree,
			int native_language_degree, int foreign_language_degree, int response_speed_degree, int eQ_degree,
			int iQ_degree, String multi_quality_degree, String register, String checker, String registe_time,
			String check_time, int resume_id, String result, String interview_comment, String check_comment,
			int interview_status, int check_status, Engage_resume engage_resume) {
		super();
		this.ein_id = ein_id;
		this.human_name = human_name;
		this.interview_amount = interview_amount;
		this.human_major_kind_id = human_major_kind_id;
		this.human_major_kind_name = human_major_kind_name;
		this.human_major_id = human_major_id;
		this.human_major_name = human_major_name;
		this.image_degree = image_degree;
		this.native_language_degree = native_language_degree;
		this.foreign_language_degree = foreign_language_degree;
		this.response_speed_degree = response_speed_degree;
		this.eQ_degree = eQ_degree;
		this.iQ_degree = iQ_degree;
		this.multi_quality_degree = multi_quality_degree;
		this.register = register;
		this.checker = checker;
		this.registe_time = registe_time;
		this.check_time = check_time;
		this.resume_id = resume_id;
		this.result = result;
		this.interview_comment = interview_comment;
		this.check_comment = check_comment;
		this.interview_status = interview_status;
		this.check_status = check_status;
		this.engage_resume = engage_resume;
	}

	public Engage_resume getEngage_resume() {
		return engage_resume;
	}

	public void setEngage_resume(Engage_resume engage_resume) {
		this.engage_resume = engage_resume;
	}

	public int geteQ_degree() {
		return eQ_degree;
	}
	public void seteQ_degree(int eQ_degree) {
		this.eQ_degree = eQ_degree;
	}
	public int getiQ_degree() {
		return iQ_degree;
	}
	public void setiQ_degree(int iQ_degree) {
		this.iQ_degree = iQ_degree;
	}
	public int getEin_id() {
		return ein_id;
	}
	public void setEin_id(int ein_id) {
		this.ein_id = ein_id;
	}
	public String getHuman_name() {
		return human_name;
	}
	public void setHuman_name(String human_name) {
		this.human_name = human_name;
	}
	public int getInterview_amount() {
		return interview_amount;
	}
	public void setInterview_amount(int interview_amount) {
		this.interview_amount = interview_amount;
	}

	public String getHuman_major_kind_name() {
		return human_major_kind_name;
	}
	public void setHuman_major_kind_name(String human_major_kind_name) {
		this.human_major_kind_name = human_major_kind_name;
	}
	
	public String getHuman_major_kind_id() {
		return human_major_kind_id;
	}

	public void setHuman_major_kind_id(String human_major_kind_id) {
		this.human_major_kind_id = human_major_kind_id;
	}

	public String getHuman_major_id() {
		return human_major_id;
	}

	public void setHuman_major_id(String human_major_id) {
		this.human_major_id = human_major_id;
	}

	public String getHuman_major_name() {
		return human_major_name;
	}
	public void setHuman_major_name(String human_major_name) {
		this.human_major_name = human_major_name;
	}
	public int getImage_degree() {
		return image_degree;
	}
	public void setImage_degree(int image_degree) {
		this.image_degree = image_degree;
	}
	public int getNative_language_degree() {
		return native_language_degree;
	}
	public void setNative_language_degree(int native_language_degree) {
		this.native_language_degree = native_language_degree;
	}
	public int getForeign_language_degree() {
		return foreign_language_degree;
	}
	public void setForeign_language_degree(int foreign_language_degree) {
		this.foreign_language_degree = foreign_language_degree;
	}
	public int getResponse_speed_degree() {
		return response_speed_degree;
	}
	public void setResponse_speed_degree(int response_speed_degree) {
		this.response_speed_degree = response_speed_degree;
	}
	public String getMulti_quality_degree() {
		return multi_quality_degree;
	}
	public void setMulti_quality_degree(String multi_quality_degree) {
		this.multi_quality_degree = multi_quality_degree;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getChecker() {
		return checker;
	}
	public void setChecker(String checker) {
		this.checker = checker;
	}
	public String getRegiste_time() {
		return registe_time;
	}
	public void setRegiste_time(String registe_time) {
		this.registe_time = registe_time;
	}
	public String getCheck_time() {
		return check_time;
	}
	public void setCheck_time(String check_time) {
		this.check_time = check_time;
	}
	public int getResume_id() {
		return resume_id;
	}
	public void setResume_id(int resume_id) {
		this.resume_id = resume_id;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getInterview_comment() {
		return interview_comment;
	}
	public void setInterview_comment(String interview_comment) {
		this.interview_comment = interview_comment;
	}
	public String getCheck_comment() {
		return check_comment;
	}
	public void setCheck_comment(String check_comment) {
		this.check_comment = check_comment;
	}
	public int getInterview_status() {
		return interview_status;
	}
	public void setInterview_status(int interview_status) {
		this.interview_status = interview_status;
	}
	public int getCheck_status() {
		return check_status;
	}
	public void setCheck_status(int check_status) {
		this.check_status = check_status;
	}
}
