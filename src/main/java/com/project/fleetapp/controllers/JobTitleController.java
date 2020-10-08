package com.project.fleetapp.controllers;

import com.project.fleetapp.models.Country;
import com.project.fleetapp.models.JobTitle;
import com.project.fleetapp.models.State;
import com.project.fleetapp.services.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class JobTitleController {

	@Autowired
	private JobTitleService jobTitleService;

	@RequestMapping(value="/jobTitles", method=RequestMethod.GET)
	public String getJobTitles(Model model) {

		List<JobTitle> jobTitleList= jobTitleService.getJobTitles();

		model.addAttribute("jobTitles", jobTitleList);

		return "jobTitle";
	}


	@RequestMapping(value = "/jobTitles/addNew", method = RequestMethod.POST)
	public String addNew(JobTitle jobTitle) {

		jobTitleService.save(jobTitle);

		return "redirect:/jobTitles";
	}


	@RequestMapping(value="/jobTitles/findById")
	@ResponseBody
	public Optional<JobTitle> findById(int id) {
		return jobTitleService.findById(id);
	}


	@RequestMapping(value="/jobTitles/update", method ={RequestMethod.PUT, RequestMethod.GET})
	public String update(JobTitle jobTitle) {

		jobTitleService.save(jobTitle);

		return "redirect:/jobTitles";
	}

	@RequestMapping(value="/jobTitles/delete", method ={RequestMethod.DELETE, RequestMethod.GET})
	public String update(Integer id) {

		jobTitleService.delete(id);

		return "redirect:/jobTitles";
	}

	/*@RequestMapping(value="/jobTitles", method=RequestMethod.GET)
	public String getJobTitle() {
		return "job_title";
	}*/
}
