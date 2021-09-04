package day25;

public class melonVO {

   private int rank;
   private String name;
   private String singer;


   @Override
   public String toString() {
      return "melonVO [rank=" + rank + ", name=" + name + ", singer=" + singer + "]";
   }
   public int getRank() {
      return rank;
   }
   public void setRank(int rank) {
      this.rank = rank;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getSinger() {
      return singer;
   }
   public void setSinger(String singer) {
      this.singer = singer;
   }
}