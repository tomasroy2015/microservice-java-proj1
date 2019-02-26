package jp.co.linkstaff.iis.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jp.co.linkstaff.iis.model.JobMedicheck;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
/**
 * 
 * @author Roy
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class JobMedicheckControllerTest {
	@LocalServerPort
    private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private JobMedicheckController jobMedicheckController;
	
	@Test
    public void contexLoads() throws Exception {
        assertThat(jobMedicheckController).isNotNull();
    }
	/**
	 * test email address against job id such as email address  maruf@gmail.com against job id 3 
	 * @throws Exception
	 */
	@Test
	public void getContactEmail() throws Exception{
		JobMedicheck ft =  new JobMedicheck();
		ft.setContactEmail("maruf@gmail.com");
		ft.setAge("30");
		jobMedicheckController.addJob(ft);
		Long id = ft.getMedicheckJobId();
	   	ResponseEntity<JobMedicheck> response = restTemplate.getForEntity("/jobinfo/medicheck/" + id, JobMedicheck.class);
	   	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	   	assertThat(response.getBody().getContactEmail()).isEqualTo("maruf@gmail.com");
	}
	/**
	 * test the value of various fields
	 * @throws Exception
	 */
	@Test
	public void updateMedicheck() throws Exception{		
		JobMedicheck ft =  new JobMedicheck();
		ft.setContactEmail("test@gmail.com");
		ft.setAge("30");
	   	restTemplate.put("/jobinfo/medicheck/2",ft);
	}
}
