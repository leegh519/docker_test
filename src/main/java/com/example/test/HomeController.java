package com.example.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/hello")
	String hello() {
		return "hello";
	}

	@GetMapping("/file/{name}")
	String file(@PathVariable String name) {
		try {
			File file = ResourceUtils.getFile("/app/test" + File.separator + name + ".txt");
			if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(name + "\n");
            bw.close();
            return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error reading file";
		}
	}
	
	@GetMapping("/file1/{name}")
    public String fileread(@PathVariable String name) {
        try {
            File file = ResourceUtils.getFile("/app/test" + File.separator + name + ".txt");
            if (!file.exists()) {
                return "File not found";
            }
            return new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
        } catch (Exception e) {
            e.printStackTrace();
            return "Error reading file";
        }
    }
}
