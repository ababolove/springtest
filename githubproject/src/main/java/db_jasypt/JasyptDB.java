package db_jasypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;



//여기는 암호화 된 문자 받으려고 받은거라 사실 필요한 파일은 아님. 그냥 확인용
//강사님은 백업하곳 삭제하셨어
public class JasyptDB {
	public static void main(String args[]) {
		StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();	//암호화
		jasypt.setPassword("1234");												//비밀번호설정 -> 원문 보려면 필요한 비밀번호
		String driver = jasypt.encrypt("com.mysql.cj.jdbc.Driver");				//이거 암호화할거야
		String url = jasypt.encrypt("jdbc:mysql://localhost:3306/backenddb");
		String username = jasypt.encrypt("backend");
		String password = jasypt.encrypt("backend");
		System.out.println("com.mysql.cj.jdbc.Driver => 암호화 => " + driver);  
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		//동적으로, 암호화된 값 계속 바뀐다. => 나중에 프로젝트 .ignore에 추가할거야.
		
	}
}



/* 
 1. pom.xml에 jasypt 라이브러리 추가
 2. driver, url, username, password 암호화 문자열 확인
 3. application.properries 파일에 
 	예 spring.datasource.driver-class-name=ENC(wXR0e/eryXF3TtZNXxuFFMo5X7PAWnoyXB7kdVRB2a07EmFMYQkBEQ==)
 	예 spring.datasource.url-class-name=ENC(T0OFCmBQUPD+JdLkDFcMHuRybrpFN0SgmT5jl9mOgYgSiMqIjZKT8fiM0nZ/EHvF)
 	예 spring.datasource.username-class-name=ENC(NH7dHPQ5pGYrJCwTfJKheA==)
 	예 spring.datasource.password-class-name=ENC(O1Aj0Hs5FpdVj8bMNd8zwA==)   
 */