package model.comments;

import java.sql.Date;

public class CommentsVO {
	private int cnum;
	private String cment;
	private Date cdate;
	private String c_user;
	private int c_post;
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public String getCment() {
		return cment;
	}
	public void setCment(String cment) {
		this.cment = cment;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public String getC_user() {
		return c_user;
	}
	public void setC_user(String c_user) {
		this.c_user = c_user;
	}
	public int getC_post() {
		return c_post;
	}
	public void setC_post(int c_post) {
		this.c_post = c_post;
	}
	@Override
	public String toString() {
		return "CommentVO [cnum=" + cnum + ", cment=" + cment + ", cdate=" + cdate + ", c_user=" + c_user + ", c_post="
				+ c_post + "]";
	}

	
	
	
}
