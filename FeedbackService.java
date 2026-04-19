package com.ai.feedback.service;

import com.ai.feedback.model.Feedback;
import com.ai.feedback.dto.FeedbackResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackService {

    private final List<Feedback> store = new ArrayList<>();

    public FeedbackResponse analyzeFeedback(String text) {

        Feedback fb = new Feedback(text);
        store.add(fb);

        String clean = text.toLowerCase();

        // SENTIMENT ANALYSIS
        String sentiment = "Neutral";
        if (clean.contains("bad") || clean.contains("slow") || clean.contains("error") || clean.contains("crash")) {
            sentiment = "Negative";
        } else if (clean.contains("good") || clean.contains("great") || clean.contains("fast")) {
            sentiment = "Positive";
        }

        // THEME DETECTION
        String theme = "General";
        if (clean.contains("login")) theme = "Login Issue";
        else if (clean.contains("slow")) theme = "Performance";
        else if (clean.contains("ui")) theme = "UI Design";

        // INSIGHTS ENGINE
        String insight = "No major issue detected.";
        if (sentiment.equals("Negative") && theme.equals("Performance")) {
            insight = "⚠ Performance drop detected after update";
        } else if (sentiment.equals("Negative")) {
            insight = "⚠ User dissatisfaction increasing";
        } else if (sentiment.equals("Positive")) {
            insight = "✅ Strong positive user trend";
        }

        // COMPETITOR BENCHMARKING (SIMULATED AI)
        String competitor;
        if (theme.equals("Performance")) {
            competitor = "Competitor is slower than your app";
        } else if (theme.equals("Login Issue")) {
            competitor = "Competitor has similar login issues";
        } else {
            competitor = "Competitor slightly better UX but less stable";
        }

        return new FeedbackResponse(sentiment, theme, insight, competitor);
    }

    public List<Feedback> getAllFeedback() {
        return store;
    }
}
