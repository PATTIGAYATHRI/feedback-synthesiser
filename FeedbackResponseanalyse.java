package com.ai.feedback.controller;

import com.ai.feedback.dto.FeedbackResponse;
import com.ai.feedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*") // connect with frontend
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService service;

    @PostMapping("/analyze")
    public FeedbackResponse analyze(@RequestBody String text) {
        return service.analyzeFeedback(text);
    }
}
