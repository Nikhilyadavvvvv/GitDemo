package com.gym.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.gym.model.Feedback;
import com.gym.repos.FeedbackRepository;
import jakarta.validation.Valid;

@Service
public class FeedbackService {
 @Autowired
private FeedbackRepository feedrepo;
public String savefeedback(@Valid @ModelAttribute("feedback") Feedback feedback, BindingResult result) {

 String res="";

 if (result.hasErrors()) {

       res="FeedBack/create_feedback";

     }

 feedrepo.save(feedback);

     res="redirect:/feedbacks";

     return res;

 }

 public List<Feedback> findallfeed() {

 return feedrepo.findAll();

 }

public void deleteFeed(String email) {
	Feedback feedback = feedrepo.findByEmail(email).get(0);
	feedrepo.delete(feedback);
}

}