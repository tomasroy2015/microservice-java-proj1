package jp.co.linkstaff.iis.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.hamcrest.Matchers.is;
import java.time.LocalDate;
import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import jp.co.linkstaff.iis.model.JobSpot;
import jp.co.linkstaff.iis.service.JobSpotService;

/**
 * 
 * @author Roy
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class JobSpotControllerTest {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private JobSpotController jobSpotController;
	@Autowired
	private JobSpotService jobSpotService;

	@Autowired
	private MockMvc mockMvc;

	private Long jobId;
	private JobSpot savedjob;
	
	@Autowired
    protected WebApplicationContext wac;

	@Test
	public void contexLoads() throws Exception {
		assertThat(jobSpotController).isNotNull();
	}
	@Before
	public void setup() throws Exception {

		this.mockMvc = standaloneSetup(this.jobSpotController).build();// Standalone context

		JobSpot job = new JobSpot();
		int year = LocalDate.now().getYear(); 
		int month = LocalDate.now().getMonthValue(); 
		int day = LocalDate.now().getDayOfMonth();
		String dateName = Integer.toString(year)+Integer.toString(month)+Integer.toString(day);
		String jobCode = "SP-" +dateName+ (int) (Math.random() * 5000 + 1);
		job.setJobCode(jobCode);
		job.setContactEmail("test@linkstaff.co.jp");
		job.setWorkAddress1("Tokyo");
		job.setWorkStationCode1("01");
		job.setSubject("内科,消化器外科,救命救急科,眼科");
		job.setWorkContent("訪問診療,臨床研修指定病院,専門不問,託児所有り");
		job.setShiftPattern("日当直");
		job.setContactTel("07048264369");
		job.setSpotDate(Calendar.getInstance().getTime());
		job.setCreatedAt(Calendar.getInstance().getTime());
		job.setIsPublic(true);
		job.setWorkDay("月,水,木,金");
        jobSpotService.addNewJob(job);

		// test created job
		jobId = job.getSpotJobId();
		savedjob = jobSpotService.getJobSpot(jobId);
    }
	/**
	 * test job search functionality using save data
	 * using different parameter
	 * 
	 * @throws Exception
	 */
	@Test
	public void searchJobs() throws Exception {
		/**
		* test searchjob using immidiate saved job parameters
		*/
		String url = "/jobinfo/spot/search/true/0/10?stations="+savedjob.getWorkStationCode1()+
								"&prefs="+savedjob.getWorkAddress1()+
								"&contents="+savedjob.getWorkContent()+
								"&subjects="+savedjob.getSubject()+
								"&keyword="+savedjob.getSearchKeyword()+
								"&shiftpatterns="+savedjob.getShiftPattern()+
								"&spotdates="+savedjob.getSpotDate();
		
		// ResponseEntity<Page<JobSpot>> response = restTemplate.getForEntity(url,J);
        
		// assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		// assertThat(response.getBody().getJobCode()).isEqualTo(jobCode);
		
		// // Mocking service
		// when(jobSpotService.searchJobs(savedjob.getWorkStationCode1().split(","),  savedjob.getWorkAddress1().split(","), savedjob.getWorkContent().split(","),savedjob.getSubject().split(","), savedjob.getSearchKeyword(), new String[]{"test"},new String[]{"test"}, savedjob.getShiftPattern().split(","), savedjob.getSpotDate().toString().split(","), true, pageable)).thenReturn(value);
		 this.mockMvc.perform(get(url)
		 .contentType(MediaType.APPLICATION_JSON))
		 .andExpect(status().isOk())
		 .andExpect(jsonPath("$.content[0].contactEmail", is(savedjob.getContactEmail())));
		// delete tested job from DB
		jobSpotService.deleteJob(jobId);

	}
}
