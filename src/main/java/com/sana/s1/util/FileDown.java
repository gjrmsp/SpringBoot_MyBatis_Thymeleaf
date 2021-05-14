package com.sana.s1.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

//Custom View 생성
//1. Abstract View 상속
@Component("down")
// FileDown 참조변수명 = new FileDown();
// 참조변수명.메서드명()
// 클래스명의 첫글자를 소문자로 바꾼것이 참조변수명
// @Component("custom")
public class FileDown extends AbstractView {

	@Autowired
	private ResourceLoader resourceLoader;

	//2. renderMergedOutputModel overriding	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// //model : ModelAndView의 Model 객체
		System.out.println("Custom View ~~~~~~~~");
		String fileName = (String)model.get("fileName");
		String filePath = (String)model.get("filePath");
		String oriName = (String)model.get("oriName");

		System.out.println("fileName : "+fileName);
		System.out.println("filePath : "+filePath);

		String path="classpath:/static/";

		File file = new File(resourceLoader.getResource(path).getFile(), filePath);
		System.out.println(file.getAbsolutePath());

		file = new File(file, fileName);

		//한글 처리
		response.setCharacterEncoding("UTF-8");

		//총 파일의 크기
		response.setContentLengthLong(file.length());

		//다운로드시 파일 이름을 인코딩 처리
		fileName = URLEncoder.encode(oriName, "UTF-8");

		//header 설정
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"" );
		response.setHeader("Content-Transfer-Encoding", "binary");

		//HDD에서 파일을 읽고
		FileInputStream fi = new FileInputStream(file);

		//Client로 전송 준비
		OutputStream os = response.getOutputStream();

		//전송
		FileCopyUtils.copy(fi, os);

		os.close();
		fi.close();
	}
}
