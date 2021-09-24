package model.likeInfo;

import java.sql.Date;

public class LikeInfoVO {
   private String l_user;
   private int l_post;
   private Date ldate;
   
   public String getL_user() {
      return l_user;
   }
   public void setL_user(String l_user) {
      this.l_user = l_user;
   }
   public int getL_post() {
      return l_post;
   }
   public void setL_post(int l_post) {
      this.l_post = l_post;
   }
   public Date getLdate() {
	return ldate;
   }
	public void setLdate(Date ldate) {
		this.ldate = ldate;
	}
	@Override
	public String toString() {
		return "LikeInfoVO [l_user=" + l_user + ", l_post=" + l_post + ", ldate=" + ldate + "]";
	}


}