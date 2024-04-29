package com.kh.api.model.vo;

public class PigVO {

//	
//	"APC_VALUE": 연도별 비만율의 평균 연간 변화율
//	"APC_CI": APC 값의 신뢰 구간
//	"YEAR": 연도
//	"CI": 해당 연도의 비만율 범위 (신뢰 구간이 아닌 실제 범위)
//	"VALUE": 해당 연도의 비만율 값
//	"SERIESNAME": 데이터 시리즈 이름 (여성 등)
//	"APC_YEAR": APC 값 계산에 사용된 데이터의 연도 범위
    private String APC_VALUE;
    private String APC_CI;
    private String YEAR;
    private String CI;
    private String VALUE;
    private String SERIESNAME;
    private String APC_YEAR;
	public String getAPC_VALUE() {
		return APC_VALUE;
	}
	public void setAPC_VALUE(String aPC_VALUE) {
		APC_VALUE = aPC_VALUE;
	}
	public String getAPC_CI() {
		return APC_CI;
	}
	public void setAPC_CI(String aPC_CI) {
		APC_CI = aPC_CI;
	}
	public String getYEAR() {
		return YEAR;
	}
	public void setYEAR(String yEAR) {
		YEAR = yEAR;
	}
	public String getCI() {
		return CI;
	}
	public void setCI(String cI) {
		CI = cI;
	}
	public String getVALUE() {
		return VALUE;
	}
	public void setVALUE(String vALUE) {
		VALUE = vALUE;
	}
	public String getSERIESNAME() {
		return SERIESNAME;
	}
	public void setSERIESNAME(String sERIESNAME) {
		SERIESNAME = sERIESNAME;
	}
	public String getAPC_YEAR() {
		return APC_YEAR;
	}
	public void setAPC_YEAR(String aPC_YEAR) {
		APC_YEAR = aPC_YEAR;
	}
	public PigVO(String aPC_VALUE, String aPC_CI, String yEAR, String cI, String vALUE, String sERIESNAME,
			String aPC_YEAR) {
		super();
		APC_VALUE = aPC_VALUE;
		APC_CI = aPC_CI;
		YEAR = yEAR;
		CI = cI;
		VALUE = vALUE;
		SERIESNAME = sERIESNAME;
		APC_YEAR = aPC_YEAR;
	}
	public PigVO() {
		super();
	}
    
    
	
}
