package com.ai.feedback.dto;

public class FeedbackResponse {

    private String sentiment;
    private String theme;
    private String insight;
    private String competitorBenchmark;

    public FeedbackResponse(String sentiment, String theme, String insight, String competitorBenchmark) {
        this.sentiment = sentiment;
        this.theme = theme;
        this.insight = insight;
        this.competitorBenchmark = competitorBenchmark;
    }

    public String getSentiment() { return sentiment; }
    public String getTheme() { return theme; }
    public String getInsight() { return insight; }
    public String getCompetitorBenchmark() { return competitorBenchmark; }
}
