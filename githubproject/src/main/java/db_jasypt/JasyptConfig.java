package db_jasypt;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@Configuration					// 나 설정파일이야. xml을 대신하는 자바 설정 파일
@EnableEncryptableProperties	// 나 암호화, 복호화 메소드가 있는 클래스야.
public class JasyptConfig {
	

	@Autowired
	Environment environment;
	@Bean("jasyptEncryptor")	//@Configuration 이랑 Bean은 세트야. 항상 같이써야돼.
	public StringEncryptor stringEncryptor() {		//StringEncryptor 복호화.
	
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
 //       config.setPassword("1234");					// 암호화 했던 비밀번호. 1234 안보이게 아래줄로 바꿈
        config.setPassword(environment.getProperty("jasypt.encryptor.password"));
        //application.properties + jasyptConfig.java  => github에 푸쉬할거야.
        //암호화된 비번 1234 직접 소스상 기록되어 있는데, 외부 환경변수값으로 읽어오게 바꾸자.
        //자바클래스 실행 - 환경변수를 읽어서 사용 => 런애즈, 런 컨피규 - 아규먼트 vm칸에 입력 
        
        
        
        config.setAlgorithm("PBEWithMD5AndDES");	// 알고리즘
        config.setKeyObtentionIterations("1000");	// 알고리즘반복횟수
        config.setPoolSize("1");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");        
        encryptor.setConfig(config);
        
        
        
/*        
        System.out.println(" == JasyptConfig 실행 결과 == ");
        System.out.println( encryptor.decrypt("wXR0e/eryXF3TtZNXxuFFMo5X7PAWnoyXB7kdVRB2a07EmFMYQkBEQ=="));			// => 이 암호의 원본을 알려줘
        System.out.println( encryptor.decrypt("T0OFCmBQUPD+JdLkDFcMHuRybrpFN0SgmT5jl9mOgYgSiMqIjZKT8fiM0nZ/EHvF"));			
        System.out.println( encryptor.decrypt("NH7dHPQ5pGYrJCwTfJKheA=="));			
        System.out.println( encryptor.decrypt("O1Aj0Hs5FpdVj8bMNd8zwA=="));
        System.out.println(" == JasyptConfig 실행 결과 == ");
*/        
        return encryptor;
        
     
	}
}
