package main;

import components.HtmlComponent;
import vo.ClienteVO;

public class Main {

	public static void main(String[] args) {
		try {
			HtmlComponent.createHtml(ClienteVO.class);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
