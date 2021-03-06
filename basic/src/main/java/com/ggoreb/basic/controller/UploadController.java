package com.ggoreb.basic.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class UploadController {
	@GetMapping("/upload1")
	public String upload1() {
		// 파일 저장 위치
		// 1. NAS (Network Attach Storage)
		// 2. static resources folder
		
		String path = this.getClass().getClassLoader().getResource("").getPath();
		System.out.println(path);
		System.out.println(new File("").getAbsolutePath());
		return "upload1";
	}

	@PostMapping("/upload1")
	@ResponseBody
	public String upload1Post(MultipartHttpServletRequest mRequest) {
		Iterator<String> iter = mRequest.getFileNames();
		while (iter.hasNext()) {
			String name = iter.next();
			System.out.println(name);

			List<MultipartFile> mFile = mRequest.getFiles(name);
			for (MultipartFile f : mFile) {
				long time = System.currentTimeMillis();
				String fName = f.getOriginalFilename();
				// String -> substring, replace, indexOf, split
				String prefix = fName.substring(0, fName.indexOf("."));
				String suffix = fName.substring(fName.indexOf("."));
				fName = prefix + "_" + time + suffix;
				try {
					String aPah = new File("").getAbsolutePath();
					f.transferTo(new File("d:/work/sts4/basic/" + fName));
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println(fName);
			}
		}
		return "와우";
	}
}