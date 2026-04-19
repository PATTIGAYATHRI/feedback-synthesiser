import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class FeedbackController {

    @PostMapping("/analyze")
    public Map<String, String> analyzeFeedback(@RequestBody Map<String, String> request) {

        String input = request.get("text").toLowerCase();

        Map<String, String> response = new HashMap<>();

        // ----------------------------
        // SENTIMENT ANALYSIS
        // ----------------------------
        String sentiment = "Neutral";

        if (input.contains("bad") || input.contains("slow") ||
            input.contains("error") || input.contains("crash")) {
            sentiment = "Negative";
        } 
        else if (input.contains("good") || input.contains("great") ||
                 input.contains("fast") || input.contains("excellent")) {
            sentiment = "Positive";
        }

        // ----------------------------
        // THEME DETECTION
        // ----------------------------
        String theme = "General";

        if (input.contains("login")) {
            theme = "Login Issue";
        } 
        else if (input.contains("slow")) {
            theme = "Performance";
        } 
        else if (input.contains("ui")) {
            theme = "UI Design";
        }

        // ----------------------------
        // HINDSIGHT INSIGHT
        // ----------------------------
        String insight = "No major issue detected.";

        if (sentiment.equals("Negative") && theme.equals("Performance")) {
            insight = "Performance drop detected after update.";
        } 
        else if (sentiment.equals("Negative") && theme.equals("Login Issue")) {
            insight = "Login failure trend increasing after release.";
        } 
        else if (sentiment.equals("Positive")) {
            insight = "Users are satisfied with recent improvements.";
        }

        // ----------------------------
        // COMPETITOR BENCHMARK (AUTO AI)
        // ----------------------------
        String competitor = "";
        String benchmarkNote = "";

        if (theme.equals("Performance")) {
            competitor = "Competitor has slower performance.";
            benchmarkNote = "Your app performs better in speed.";
        } 
        else if (theme.equals("Login Issue")) {
            competitor = "Competitor has similar login issues.";
            benchmarkNote = "Both apps need improvement in authentication.";
        } 
        else {
            competitor = "Competitor has slightly better UI but weaker stability.";
            benchmarkNote = "Mixed competitive position.";
        }

        // ----------------------------
        // RESPONSE JSON
        // ----------------------------
        response.put("sentiment", sentiment);
        response.put("theme", theme);
        response.put("insight", insight);
        response.put("competitor", competitor);
        response.put("benchmark", benchmarkNote);

        return response;
    }
}
