package MovieDatas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import dto.MovieVo;

public class MovieChart {
	
	public static List<MovieVo> getCGVdata() throws Exception {
		Document doc = Jsoup.connect("http://www.cgv.co.kr/movies/?lt=1&ft=0").get();
		
		Elements titles = doc.select("div.box-contents strong.title");
		
		Elements percents = doc.select("div.box-contents div.score strong.percent span");
		
		List<MovieVo> list = new ArrayList<MovieVo>();
		
		for(int i=0; i<19; i++) {
			Element title = titles.get(i);
			Element percent = percents.get(i);
			System.out.println(title.text() + " " + percent.text());
			
			String t = title.text();
			// 44.2% -> 44.2 만가지고오고싶다
			double p =Double.parseDouble(percent.text().replace("%", ""));
			
			list.add(new MovieVo( t,p ));
		}		
		return list;
	}

}
