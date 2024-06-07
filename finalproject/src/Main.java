import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import okhttp3.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        buildGUI();
    }

    public static void buy(String ticker, int quantity) {
        String apiKey = "PKS0C2F5BMN4B3DN8GZ4";
        String apiSecret = "N8hK8QlmvmEFdg6CasRJkshtm98ZFyZn8QYzf9fg";

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"symbol\":\"" + ticker + "\",\"qty\":" + quantity + ",\"side\":\"buy\",\"type\":\"market\",\"time_in_force\":\"gtc\"}");
        Request request = new Request.Builder()
                .url("https://paper-api.alpaca.markets/v2/orders")
                .post(body)
                .addHeader("APCA-API-KEY-ID", apiKey)
                .addHeader("APCA-API-SECRET-KEY", apiSecret)
                .addHeader("Content-Type", "application/json")
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sell(String ticker, int quantity) {
        String apiKey = "PKS0C2F5BMN4B3DN8GZ4";
        String apiSecret = "N8hK8QlmvmEFdg6CasRJkshtm98ZFyZn8QYzf9fg";

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"symbol\":\"" + ticker + "\",\"qty\":" + quantity + ",\"side\":\"sell\",\"type\":\"market\",\"time_in_force\":\"gtc\"}");
        Request request = new Request.Builder()
                .url("https://paper-api.alpaca.markets/v2/orders")
                .post(body)
                .addHeader("APCA-API-KEY-ID", apiKey)
                .addHeader("APCA-API-SECRET-KEY", apiSecret)
                .addHeader("Content-Type", "application/json")
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String graph(String ticker) {
        String apiKey = "PKS0C2F5BMN4B3DN8GZ4";
        String apiSecret = "N8hK8QlmvmEFdg6CasRJkshtm98ZFyZn8QYzf9fg";

        OkHttpClient client = new OkHttpClient();
        String timeframe = "1Day";

        String url = "https://data.alpaca.markets/v2/stocks/" + ticker + "/bars?timeframe=" + timeframe + "&limit=252";
        System.out.println("Request URL: " + url);  // Log the URL

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("APCA-API-KEY-ID", apiKey)
                .addHeader("APCA-API-SECRET-KEY", apiSecret)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.code() == 200) {
                String responseData = response.body().string();
                System.out.println("Response Data: " + responseData);  // Log the response
                return responseData;
            } else {
                System.out.println("Error: " + response.code() + " " + response.message());
                System.out.println("Response: " + response.body().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void buildGUI() {
        JFrame frame = new JFrame("Stock Trading GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new FlowLayout());

        JLabel tickerLabel = new JLabel("Stock Ticker:");
        JTextField tickerTextField = new JTextField(10);

        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityTextField = new JTextField(10);

        JButton buyButton = new JButton("Buy");
        JButton sellButton = new JButton("Sell");
        JButton graphButton = new JButton("Graph");

        buyButton.addActionListener(e -> {
            String ticker = tickerTextField.getText();
            int quantity = Integer.parseInt(quantityTextField.getText());
            buy(ticker, quantity);
        });

        sellButton.addActionListener(e -> {
            String ticker = tickerTextField.getText();
            int quantity = Integer.parseInt(quantityTextField.getText());
            sell(ticker, quantity);
        });

        graphButton.addActionListener(e -> {
            String ticker = tickerTextField.getText();
            String graphData = graph(ticker);

            if (graphData != null) {
                // Parse JSON response
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(graphData, JsonObject.class);
                JsonArray bars = jsonObject.getAsJsonArray("bars");

                // Create a time series chart
                TimeSeries series = new TimeSeries(ticker);
                for (int i = 0; i < bars.size(); i++) {
                    JsonObject bar = bars.get(i).getAsJsonObject();
                    double close = bar.get("c").getAsDouble();
                    String dateStr = bar.get("t").getAsString().split("T")[0];
                    String[] dateParts = dateStr.split("-");
                    int year = Integer.parseInt(dateParts[0]);
                    int month = Integer.parseInt(dateParts[1]);
                    int day = Integer.parseInt(dateParts[2]);
                    series.add(new Day(day, month, year), close);
                }

                TimeSeriesCollection dataset = new TimeSeriesCollection(series);
                JFreeChart chart = ChartFactory.createTimeSeriesChart(
                        "Stock Prices",
                        "Date",
                        "Price",
                        dataset,
                        false,
                        true,
                        false
                );

                XYPlot plot = chart.getXYPlot();
                XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, false);
                plot.setRenderer(renderer);

                ChartPanel chartPanel = new ChartPanel(chart);
                JFrame chartFrame = new JFrame("Stock Price Chart");
                chartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                chartFrame.setSize(800, 600);
                chartFrame.add(chartPanel);
                chartFrame.setVisible(true);
            }
        });

        frame.add(tickerLabel);
        frame.add(tickerTextField);
        frame.add(quantityLabel);
        frame.add(quantityTextField);
        frame.add(buyButton);
        frame.add(sellButton);
        frame.add(graphButton);

        frame.setVisible(true);
    }
}
