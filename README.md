<!DOCTYPE html>
<html>
<head>
  <title>Feedback Synthesizer</title>

  <style>
    body {
      margin: 0;
      font-family: "Segoe UI", sans-serif;
      background: radial-gradient(circle at top, #0f172a, #020617);
      color: white;
      text-align: center;
    }

    /* HEADER */
    .header {
      padding: 25px;
    }

    .header h2 {
      margin: 0;
      font-size: 30px;
      background: linear-gradient(90deg, #38bdf8, #a78bfa, #22c55e);
      -webkit-background-clip: text;
      -webkit-text-fill-color: transparent;
    }

    .ai-tag {
      font-size: 13px;
      color: #94a3b8;
    }

    /* INPUT */
    textarea {
      width: 60%;
      height: 85px;
      margin: 10px;
      padding: 12px;
      border-radius: 12px;
      border: 1px solid rgba(255,255,255,0.1);
      background: rgba(255,255,255,0.05);
      color: white;
      outline: none;
      backdrop-filter: blur(10px);
    }

    textarea::placeholder {
      color: #64748b;
    }

    /* BUTTON */
    button {
      padding: 12px 28px;
      border: none;
      border-radius: 12px;
      cursor: pointer;
      font-size: 15px;
      color: white;
      background: linear-gradient(90deg, #7c3aed, #06b6d4);
      transition: 0.3s;
      margin: 10px;
    }

    button:hover {
      transform: scale(1.07);
      box-shadow: 0 0 20px rgba(124,58,237,0.6);
    }

    /* GRID */
    .pipeline {
      display: grid;
      grid-template-columns: repeat(3, 1fr);
      gap: 15px;
      margin: 25px;
    }

    /* CARDS */
    .box {
      background: rgba(255,255,255,0.06);
      border: 1px solid rgba(255,255,255,0.08);
      padding: 18px;
      border-radius: 16px;
      backdrop-filter: blur(14px);
      transition: 0.3s;
      min-height: 110px;
    }

    .box:hover {
      transform: translateY(-6px);
      box-shadow: 0 10px 25px rgba(0,0,0,0.5);
    }

    .step-title {
      font-size: 12px;
      color: #38bdf8;
      letter-spacing: 1px;
      text-transform: uppercase;
      margin-bottom: 8px;
    }

    /* INSIGHT */
    .highlight {
      color: #22c55e;
      font-weight: bold;
    }

    /* RESPONSIVE */
    @media(max-width: 900px) {
      .pipeline {
        grid-template-columns: 1fr;
      }

      textarea {
        width: 85%;
      }
    }
  </style>
</head>

<body>

<div class="header">
  <h2>Feedback Synthesizer</h2>
  <p class="ai-tag">Automated competitive benchmarking and analysis system</p>
</div>

<textarea id="inputText" placeholder="Enter user feedback..."></textarea><br>

<button onclick="processFeedback()">Analyze Feedback</button>

<div class="pipeline">

  <div class="box">
    <div class="step-title">Data Ingestion</div>
    <p id="step1"></p>
  </div>

  <div class="box">
    <div class="step-title">Preprocessing</div>
    <p id="step2"></p>
  </div>

  <div class="box">
    <div class="step-title">Sentiment</div>
    <p id="step3"></p>
  </div>

  <div class="box">
    <div class="step-title">Theme Detection</div>
    <p id="step4"></p>
  </div>

  <div class="box">
    <div class="step-title">Hindsight Insight</div>
    <p id="step5" class="highlight"></p>
  </div>

  <div class="box">
    <div class="step-title">AI Competitor Benchmark</div>
    <p id="step6"></p>
  </div>

</div>

<script>

function processFeedback() {

  let input = document.getElementById("inputText").value;

  document.getElementById("step1").innerText = input;

  let clean = input.toLowerCase().replace(/[^a-z\s]/g, "");
  document.getElementById("step2").innerText = clean;

  let sentiment = "Neutral";

  if (clean.includes("bad") || clean.includes("slow") || clean.includes("error") || clean.includes("crash")) {
    sentiment = "Negative";
  } 
  else if (clean.includes("good") || clean.includes("great") || clean.includes("fast")) {
    sentiment = "Positive";
  }

  document.getElementById("step3").innerText = sentiment;

  let theme = "General";

  if (clean.includes("login")) theme = "Login Issue";
  else if (clean.includes("slow")) theme = "Performance";
  else if (clean.includes("ui")) theme = "UI Design";

  document.getElementById("step4").innerText = theme;

  // HINDSIGHT
  let insight = "No major issue detected.";

  if (sentiment === "Negative" && theme === "Performance") {
    insight = "⚠ Performance drop detected after update";
  }
  else if (sentiment === "Negative") {
    insight = "⚠ User dissatisfaction increasing";
  }
  else if (sentiment === "Positive") {
    insight = "✅ Strong positive user trend";
  }

  document.getElementById("step5").innerText = insight;

  // COMPETITOR AI MODEL (AUTO)
  let competitorBenchmark = {
    sentiment: "Neutral",
    performance: "stable"
  };

  if (theme === "Performance") {
    competitorBenchmark.sentiment = "Negative";
    competitorBenchmark.performance = "slower than your app";
  } 
  else if (theme === "Login Issue") {
    competitorBenchmark.sentiment = "Negative";
    competitorBenchmark.performance = "similar issues detected";
  } 
  else {
    competitorBenchmark.sentiment = "Positive";
    competitorBenchmark.performance = "slightly better UX but less stable";
  }

  let comparison = "";

  if (sentiment === "Positive" && competitorBenchmark.sentiment === "Negative") {
    comparison = "🔥 Your app dominates competitor performance";
  }
  else if (sentiment === "Negative" && competitorBenchmark.sentiment === "Positive") {
    comparison = "⚠ Competitor currently leads in user satisfaction";
  }
  else if (sentiment === competitorBenchmark.sentiment) {
    comparison = "⚖ Both apps are at similar market level";
  }
  else {
    comparison = "📊 Mixed competitive signals detected";
  }

  comparison += "\n📌 Benchmark: " + competitorBenchmark.performance;

  document.getElementById("step6").innerText = comparison;
}

</script>

</body>
</html>
