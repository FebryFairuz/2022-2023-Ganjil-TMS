package com.ibik.api.academicservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.ibik.api.academicservices.filesServices.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class AcademicServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademicServicesApplication.class, args);
	}

}
