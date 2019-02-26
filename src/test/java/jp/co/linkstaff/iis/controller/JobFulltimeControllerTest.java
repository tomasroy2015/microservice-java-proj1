package jp.co.linkstaff.iis.controller;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import java.time.LocalDate;
import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import jp.co.linkstaff.iis.model.JobFulltime;
import jp.co.linkstaff.iis.service.JobFulltimeService;
/**
 * 
 * @author Roy
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class JobFulltimeControllerTest {
	@LocalServerPort
    private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private JobFulltimeController jobfulltimeController;
	@Autowired
	private JobFulltimeService jobfulltimeService;
	

	@Autowired
	private MockMvc mockMvc;

	private Long jobId;
	private JobFulltime savedjob;
	
	@Autowired
	protected WebApplicationContext wac;
	
	@Test
    public void contexLoads() throws Exception {
        assertThat(jobfulltimeController).isNotNull();
	}
	
	@Before
	public void setup() throws Exception {

		this.mockMvc = standaloneSetup(this.jobfulltimeController).build();// Standalone context

		JobFulltime job = new JobFulltime();
		int year = LocalDate.now().getYear(); 
		int month = LocalDate.now().getMonthValue(); 
		int day = LocalDate.now().getDayOfMonth();
		String dateName = Integer.toString(year)+Integer.toString(month)+Integer.toString(day);
		String jobCode = "JB-" +dateName+ (int) (Math.random() * 5000 + 1);
		job.setJobCode(jobCode);
		job.setContactEmail("test@linkstaff.co.jp");
		job.setWorkAddress1("Tokyo");
		job.setWorkStationCode1("01");
		job.setSubject("内科,消化器外科,救命救急科,眼科");
		job.setWorkContent("訪問診療,臨床研修指定病院,専門不問,託児所有り");
		job.setContactTel("07048264369");
		job.setCreatedAt(Calendar.getInstance().getTime());
		job.setIsPublic(true);
        jobfulltimeService.addNewJob(job);

		// test created job
		jobId = job.getFulltimeJobId();
		savedjob = jobfulltimeService.getJobFulltime(jobId);
	}
	
	/**
	 * test email address against job id such as email address  maruf@gmail.com against job id 1 
	 * @throws Exception
	 */
	@Test
	public void getContactEmail() throws Exception{
		JobFulltime ft =  new JobFulltime();
		ft.setContactEmail("test@linkstaff.co.jp");
		ft.setAge("30");
		jobfulltimeService.addNewJob(ft);
		Long id = ft.getFulltimeJobId();
	   	ResponseEntity<JobFulltime> response = restTemplate.getForEntity("/jobinfo/fulltime/" + id, JobFulltime.class);
	   	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	   	assertThat(response.getBody().getContactEmail()).isEqualTo("test@linkstaff.co.jp");
	}	 

	@Test
	public void searchJobs() throws Exception {
		/**
		* test searchjob using immidiate saved job parameters
		*/
		String url = "/jobinfo/fulltime/search/true/0/10?keyword="+savedjob.getSearchKeyword()+
		                        "&stations="+savedjob.getWorkStationCode1()+
								"&prefs="+savedjob.getWorkAddress1()+
								"&contents="+savedjob.getWorkContent()+
								"&subjects="+savedjob.getSubject();
		//  ResponseEntity<Page<JobFulltime>> response = restTemplate.getForEntity(url,J);
        
		//  assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		//  assertThat(response.getBody().getJobCode()).isEqualTo(jobCode);
		
		// // Mocking service
		// when(jobSpotService.searchJobs(savedjob.getWorkStationCode1().split(","),  savedjob.getWorkAddress1().split(","), savedjob.getWorkContent().split(","),savedjob.getSubject().split(","), savedjob.getSearchKeyword(), new String[]{"test"},new String[]{"test"}, savedjob.getShiftPattern().split(","), savedjob.getSpotDate().toString().split(","), true, pageable)).thenReturn(value);
		 this.mockMvc.perform(get(url)
		 .contentType(MediaType.APPLICATION_JSON))
		 .andExpect(status().isOk())
		 .andExpect(jsonPath("$.content[0].contactEmail", is(savedjob.getContactEmail())));
		// delete tested job from DB
		jobfulltimeService.deleteJob(jobId);

	}
}
