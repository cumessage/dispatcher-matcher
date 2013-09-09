package com.prosper.matcher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import kevin.zhang.NLPIR;

public class App {
	
	public static void main(String[] args) throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream("nlpir.properties"));
		
		NLPIR nlpir = new NLPIR();
		if(!nlpir.NLPIR_Init(prop.getProperty("data_dir_parent_path").getBytes("gb2312"), 0, "0".getBytes())) {
			System.out.println("nlpir init fail");
			return;
		}
		
		//			 String sInput =
		// "张华平推出的NLPIR分词系统，又名ICTCLAS2013，新增新词识别、关键词提取、微博分词功能。";
		String sInput = "东方网12月4日消息：2009年10月21日,辽宁省阜新市委收到举报信,举报以付玉红为首吸毒、强奸、聚众淫乱"
				+ ",阜新市委政法委副书记于洋等参与吸毒、强奸、聚众淫乱等。对此,阜新市委高度重视,责成阜新市公安局立即成"
				+ "立调查组,抽调精干力量展开调查。　　调查期间,署名举报人上官宏祥又通过尹东方(女)向阜新市公安局刑警支队"
				+ "提供书面举报,举报于洋等参与吸毒、强奸、聚众淫乱。11月19日,正义网发表上官宏祥接受记者专访,再次实名举报"
				+ "于洋等参与吸毒、强奸、聚众淫乱,引起网民广泛关注。对此辽宁省政法委、省公安厅高度重视。当日,责成有关领导"
				+ "专程赴阜新听取案件调查情况。为加强对案件的督办和指导,省有关部门迅速成立工作组,赴阜新督办、指导案件调查"
				+ "工作,并将情况上报有关部门。　　经前一段调查证明,举报事实不存在,上官宏祥行为触犯《刑法》第243条,涉嫌诬告"
				+ "陷害罪。根据《刑事诉讼法》有关规定,阜新市公安局已于11月27日依法立案侦查。上官宏祥已于2009年12月1日到案,"
				+ "12月2日阜新市海州区人大常委会已依法停止其代表资格,阜新市公安局对其进行刑事拘留,并对同案人尹东方进行监视"
				+ "居住。现侦查工作正在进行中。";
		// System.out.println(sInput.getBytes("GB2312").length);
		// String sInput =
		// "NLPIR,NLPIR,NLPIR,NLPIR,NLPIR,NLPIR,NLPIR,NLPIR,NLPIR,NLPIR,NLPIR,NLPIR,NLPIR,NLPIR,NLPIR,NLPIR,NLPIR,NLPIR,NLPIR,NLPIR";
		// String sInput =
		//			 "你是我的玫瑰花,毛主席是我们的大恩人,大恩人，思念,也许这才是真正的爱性，希望每个人都能快快乐乐,现在的房价真的没法搞了，太贵了太贵了";
		// for(int i=0;i<10;i++){
		// sInput+=sInput;
		// }
		// 自适应分词
		byte[] resultBytes = nlpir.NLPIR_ParagraphProcess(sInput.getBytes("gb2312"), 1);
		String result = new String(resultBytes, 0, resultBytes.length, "gb2312");
		System.out.println(result);
	}
}
