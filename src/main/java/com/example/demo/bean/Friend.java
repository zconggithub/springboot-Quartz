package com.example.demo.bean;

public class Friend {
    private Integer fid;

    private Integer tid;

    private String fname;

    private String ftel;

    private Integer age;

    private String sex;

    private Long monthSal;

    private Long annualBonus;

    private String address;

    private String idCard;

    private String email;

    private String other;

    private String censusRegister;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFtel() {
        return ftel;
    }

    public void setFtel(String ftel) {
        this.ftel = ftel;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getMonthSal() {
        return monthSal;
    }

    public void setMonthSal(Long monthSal) {
        this.monthSal = monthSal;
    }

    public Long getAnnualBonus() {
        return annualBonus;
    }

    public void setAnnualBonus(Long annualBonus) {
        this.annualBonus = annualBonus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getCensusRegister() {
        return censusRegister;
    }

    public void setCensusRegister(String censusRegister) {
        this.censusRegister = censusRegister;
    }

	public Friend(Integer fid, Integer tid, String fname, String ftel, Integer age, String sex, Long monthSal,
			Long annualBonus, String address, String idCard, String email, String other, String censusRegister) {
		super();
		this.fid = fid;
		this.tid = tid;
		this.fname = fname;
		this.ftel = ftel;
		this.age = age;
		this.sex = sex;
		this.monthSal = monthSal;
		this.annualBonus = annualBonus;
		this.address = address;
		this.idCard = idCard;
		this.email = email;
		this.other = other;
		this.censusRegister = censusRegister;
	}
    
    public Friend(){}

	@Override
	public String toString() {
		return "Friend [fid=" + fid + ", tid=" + tid + ", fname=" + fname + ", ftel=" + ftel + ", age=" + age + ", sex="
				+ sex + ", monthSal=" + monthSal + ", annualBonus=" + annualBonus + ", address=" + address + ", idCard="
				+ idCard + ", email=" + email + ", other=" + other + ", censusRegister=" + censusRegister + "]";
	}
    
    
    
    
    
}