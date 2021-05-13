package com.sana.s1.util;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	@Autowired
	private ResourceLoader resourceLoader;

	public String save(MultipartFile multipartFile, String filePath) throws Exception {
		//filePath : /resources/static/ 제외한 하위경로

		//1. 경로 설정
		/**
		 * 	저장할 폴더가 시스템에 고정일 경우
		 *  String path ="c:/files"
		 *  File file = new File(path, filePath);
		 * */		

		/**		
		 	* ResourceLoader
		 	* classpath 경로를 받아오기위해 사용
				String path="classpath:/static/";
				File file = new File(resourceLoader.getResource(path).getFile(), filePath);
		*/	

		/**
		  	* ClassPathResource
		  	* classPath 경로를 받아오기위해 사용
		  	* ResourceLoader와 같지만
		  	* 시작 경로에서 classpath를 제외 
		 */		

		String path="static";
		ClassPathResource classPathResource = new ClassPathResource(path);
		File file = new File(classPathResource.getFile(), filePath);
		System.out.println(file.getAbsolutePath());

		if(!file.exists()) {
			file.mkdirs();
		}

		//2. 저장할 파일명을 생성
		String fileName = UUID.randomUUID().toString()+"_"+multipartFile.getOriginalFilename();
		file = new File(file, fileName);

		//transfer
		multipartFile.transferTo(file);
		//FileCopyUtils.copy(multipartFile.getBytes(), file);
		return fileName;
	}

}
