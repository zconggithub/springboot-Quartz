package com.example.demo.bean;

public class CompanyInfo {
    private Integer id;
    
    private Integer fid;
    
    private String companyName;

    private String compantAddress;

    private String other;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompantAddress() {
        return compantAddress;
    }

    public void setCompantAddress(String compantAddress) {
        this.compantAddress = compantAddress;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}
    
}