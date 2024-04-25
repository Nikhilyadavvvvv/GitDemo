package com.gym.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.gym.model.Feedback;
import com.gym.service.FeedbackService;
import jakarta.validation.Valid;


@Controller
public class FeedbackController {

 @Autowired
 private FeedbackService feedser;

 @PostMapping("/feedbacks")
 public String saveFeedback(@Valid @ModelAttribute("feedback") Feedback feedback, BindingResult result) {
 return feedser.savefeedback(feedback, result);
 }

 @GetMapping("/feedbacks")
 public String listFeedbacks(Model model) {
 model.addAttribute("feedbacks", feedser.findallfeed());
 return "feedback/feedback";
 }
 
 @GetMapping("/admin/feedbacks")
 public String listAllFeedbacks(Model model) {
 model.addAttribute("feedbacks", feedser.findallfeed());
 return "Admin/AdminFeed";
 }
 

 @GetMapping("/feedback/new")
 public String showCreateForm(Model model) {
 Feedback feedback = new Feedback();
 model.addAttribute("feedback", feedback);
 return "feedback/create_feedback";
 }
}

