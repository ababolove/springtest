package com.example.github;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GithubprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GithubprojectApplication.class, args);
		System.out.println("github push 이후 추가합니다.");
		System.out.println("sub1 브랜치에 github push 이후 추가합니다.");
	}

}
