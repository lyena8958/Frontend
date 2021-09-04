package day09_0702;
// 
//복권당첨 게임("정렬"알고리즘)
//
//구매횟수: 3
//
//1~30으로 구성된 정수가
//"중복없이"
//[ _ _ _ _ _ _ _ _ _ _ ]에 저장
//3 2 1 4 5 10 9 8 7 6
//오름차순 정렬
//1 2 3 4 5 6 7 8 9 10
//_ _ _ _ _ _ _ _ _ _ << 사용자 시야
//
//기회3번 == 구매횟수
//
//[ _ _ _ _ 30 _ _ 8 _ _ ] >> 문자열배열
//
//기회2번
//.
//.
import java.util.Random;
import java.util.Scanner;

public class test10 {

	public static void main(String[] args) {
		
		// 강사님 답
		Scanner sc=new Scanner(System.in);
      System.out.print("구매횟수: ");
      int cnt=sc.nextInt();
      
      Random rand=new Random();
      
      int[] data=new int[10];
      for(int i=0;i<data.length;i++) {
         while(true) {
            data[i]=rand.nextInt(30)+1;
            System.out.println(data[i]);
            Boolean flag=true;
            
            for(int j=0;j<i;j++) { // j<=i-1
               if(data[i]==data[j]) {
                  flag=false;
                  System.out.println("중복발생!");
                  break;
               }
            }
            
            if(flag) { // 중복되지않았다면,
               break;
            }
            
            
         }
      }
      
      //값 확인하기 위한 반복문
//      for(int v:data) {
//    	  System.out.print(v+" ");
//      }
      
      for(int i = 0; i < data.length-1;i++) {
    	  for(int j = 0; j<data.length-1;j++) {
    		  // 비교 작업은 반드시 데이터개수 -1회 작동한다!!!
    		  if(data[j] > data[j+1]) {
    			  int tmp = data[j];
    			  data[j] = data[j+1];
    			  data[j+1] = tmp;
    		  }
    	  }  
      }
    //값 확인하기 위한 반복문
//      for(int v:data) {
//    	  System.out.print(v+" ");
      
//      }
//      
      String[] showData = new String[10];
      for(int i = 0; i < showData.length;i++) {
    	  showData[i] = "_";
      }
      while(cnt>0) { // cnt가 0이상이면!!
    	  System.out.print("[ ");
    	  for(String v:showData) {
    		  System.out.print(v+" ");
    	  }
    	  System.out.println("]");
    	  System.out.print("정답입력: ");
    	  int ans = sc.nextInt();
    	  
    	  Boolean  flag = true; // 일단 못맞췄다는 가정하에
    	  
		  // 정렬알고리즘 0부터  순차적으로 찾는것 (결과가 틀리지않는다.) 
    	  for(int i = 0; i <data.length;i++) {
    		  if(ans==data[i]) {
    			   flag = false; 
    			  System.out.println("정답있음!");
    			  showData[i] = String.valueOf(ans); // test11.java 참고(정수->문자변환)
    			  // showData[i]="*"
    			  break;
    		  }
    	  }
    	  
    	  if( flag) {
    		  cnt--;
    	  }
    	  
    	  flag = true; // 재사용
    	  for(int i = 0; i < showData.length;i++) {
    		  if(showData[i]=="_") {
    			  flag = false;
    			  break;
    		  }
    	  }
    	  if(flag) {
    		  System.out.println("WIN!!!!!!!!!!");
    		  break;
    	  }
    	  
    	  
    	  if(cnt==0) {
        	  System.out.println("GameOver....");
          }
    	 
      }
     

		
		// 예나
		/*
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		int dieCnt = 3;
		System.out.println("복권 구매 횟수: ");
		int cnt = sc.nextInt();
		
		// 사용자 시야 안내
		char str = '_';
		
		int[] Number = new int[10];
		
		// 랜덤 복권 번호입력 + 중복값 변경
		for(int i = 0; i < 10; i++) {
		Number[i] = rand.nextInt(30)+1; // 1~30까지
		for(int j = 0; j <i; j++) { // j<10하면 생성되지않은 값들이 나와 오류생김
		if(Number[i]==Number[j]) {
			i--; // 중복 i번째 다시 반복을 위한 감소
			break;
			}
		}
		}
		
		// 오름차순 정렬
		for(int i = 0; i < 9; i++) {
		for(int j = 0; j < 9; j++) {
				if(Number[j] > Number[j+1]) {
					int tmp = Number[j];
					Number[j] = Number[j+1];
					Number[j+1] = tmp;
					}
		}
		}
		for(int j = 0; j < 10; j++) {
			System.out.print(Number[j]+" ");
		}
				
while(true) {
	int[] checkCnt = new int[10];
	int user;
	Boolean flag= false;
	
	System.out.print("정답을 맞출 숫자를 입력하세요(1~30사이) ");
	System.out.println();
	user = sc.nextInt();
	
	// 맞춘 값을 새로운 배열에 넣는 반복문

	for(int v:Number) {
		if(user==v) {
			System.out.println("찾았다!");
			checkCnt[i] = Number[i];
		}
		else {
			flag = true;
		}
	}
	if(flag) {
		dieCnt--;
	}
	
	//사용자 출력반복
	for(int i = 0; i < Number.length;i++) {
		
		if(checkCnt[i]==0) {
		
		System.out.print(str+" ");
		}
		else {
			System.out.print(checkCnt[i]+" ");
		}
	}
	
	if(dieCnt < 0) {
		System.out.println("기회가 모두 소진 되어 프로그램이 종료됩니다.");
		break;
	}
	System.out.println("기회가 "+dieCnt+"번 남았습니다!!!");*/
		/*
		int[] arr = new int[cnt];
		for(int i = 0; i <arr.length;i++) {
			arr[i] = rand.nextInt(3)+1;
		}
		for(int v:arr) {
			System.out.println(v);
		}*/

		
		 // 0~0 10
		// 1~ 0 10
		// 2~0 10
	//} 

}
}
