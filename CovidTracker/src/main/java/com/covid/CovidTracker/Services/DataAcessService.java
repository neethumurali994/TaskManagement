package com.covid.CovidTracker.Services;


import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.covid.CovidTracker.Model.CaseStatus;

@Service
public class DataAcessService {

	
	private final String virus_url = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";     
	private List<CaseStatus>  allList= new ArrayList<CaseStatus>();
	public List<CaseStatus> getAllList() {
		return allList;
	}
	public void setAllList(List<CaseStatus> allList) {
		this.allList = allList;
	}
	@PostConstruct
	@Scheduled(cron = "* * 1 * * *")
	public void getDetailAccess() throws IOException, InterruptedException {
	    List<CaseStatus>  allListInside = new ArrayList<CaseStatus>();
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(virus_url)).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		//System.out.println(response.body());
		StringReader reader = new StringReader(response.body());
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
		for (CSVRecord record : records) {
			 CaseStatus newcase = new CaseStatus();
			String Province_State = record.get("Province/State");
			String Country_Region = record.get("Country/Region");
			int length = record.size();
			String Cases = record.get(length-1);
			newcase.setCountry(Country_Region);
			newcase.setState(Province_State);
			newcase.setNewCases(Integer.parseInt(Cases));
			allListInside.add(newcase);
		}
		System.out.println(allListInside);
		this.allList = allListInside;
	}
}