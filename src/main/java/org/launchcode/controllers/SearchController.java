package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results
    @RequestMapping(value = "results")
    public String searchDisplayForm(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        ArrayList<HashMap<String, String>> jobs;
        if (searchType.equals("all")) {
            jobs = JobData.findAll();

        } else {

            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
        }
            model.addAttribute("title", jobs.size() + " Result(s)");
            model.addAttribute("jobs", jobs);
            model.addAttribute("columns", ListController.columnChoices);

        return "search";

        }
    }




//        return "search/results";

//    public String listColumnValues(Model model, @RequestParam String column) {
////        In the case of "all" it will fetch all job data, and then render the list-jobs.html view template
//        if (column.equals("all")) {
//            ArrayList<HashMap<String, String>> jobs = JobData.findAll();
//            model.addAttribute("title", "All Jobs");
//            model.addAttribute("jobs", jobs);
//            return "list-jobs";
//        } else {
////        In all other cases, it fetches only the values for the given column and passes them to the list-column.html view template.
//            ArrayList<String> items = JobData.findAll(column);
//            model.addAttribute("title", "All " + columnChoices.get(column) + " Values");
//            model.addAttribute("column", column);
//            model.addAttribute("items", items);
//            return "list-column";
//        }
//
//
//        @RequestMapping(value = "jobs")
//        public String listJobsByColumnAndValue(Model model,
//                @RequestParam String column, @RequestParam String value) {
//
//            ArrayList<HashMap<String, String>> jobs = JobData.findByColumnAndValue(column, value);
//            model.addAttribute("title", "Jobs with " + columnChoices.get(column) + ": " + value);
//            model.addAttribute("jobs", jobs);
//
//            return "list-jobs";
//        }
//    }
//
//
//
//}
