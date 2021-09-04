package day25;

public class Test4 {

	public static void main(String[] args) {
		String str = "<span>ÈÄ´ú´ú´ú ³²±ØÀüÀÚ</span>";
		// <>Ç¥½Ã°¡ º¸±â½ÈÀ»¶§
		str = str.substring(6, str.length()-7);
		System.out.println(str);

	}

}
