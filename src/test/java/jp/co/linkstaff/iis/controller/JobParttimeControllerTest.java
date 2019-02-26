package jp.co.linkstaff.iis.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jp.co.linkstaff.iis.model.JobParttime;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
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
public class JobParttimeControllerTest {
	@LocalServerPort
    private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private JobParttimeController jobParttimeController;
	
	@Test
    public void contexLoads() throws Exception {
        assertThat(jobParttimeController).isNotNull();
    }
	/**
	 * test email address against job id such as email address  maruf@gmail.com against job id 1 
	 * @throws Exception
	 */
	@Test
	public void getContactEmail() throws Exception{
		JobParttime ft =  new JobParttime();
		ft.setContactEmail("maruf@gmail.com");
		ft.setAge("30");
		jobParttimeController.addJob(ft);
		Long id = ft.getParttimeJobId();
	   	ResponseEntity<JobParttime> response = restTemplate.getForEntity("/jobinfo/parttime/" + id, JobParttime.class);
	   	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	   	assertThat(response.getBody().getContactEmail()).isEqualTo("maruf@gmail.com");
	}
	/**
	 * test the value of various fields
	 * @throws Exception
	 */
	@Test
	public void updateFulltime() throws Exception{		
		JobParttime ft =  new JobParttime();
		ft.setContactEmail("maruf@gmail.com");
		ft.setAge("30");
	   	restTemplate.put("/job/fulltime/1",ft);
	}
}