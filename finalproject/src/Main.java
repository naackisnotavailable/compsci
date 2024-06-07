import okhttp3.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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

    public static List<Bar> fetchBars(String ticker) {
        String apiKey = "PKS0C2F5BMN4B3DN8GZ4";
        String apiSecret = "N8hK8QlmvmEFdg6CasRJkshtm98ZFyZn8QYzf9fg";

        OkHttpClient client = new OkHttpClient();
        String timeframe = "1Day";

        String url = "https://data.alpaca.markets/v2/stocks/" + ticker + "/bars?timeframe=" + timeframe + "&limit=252";

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
                return parseBars(responseData);
            } else {
                System.out.println("Error: " + response.code() + " " + response.message());
                System.out.println("Response: " + response.body().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Bar> parseBars(String jsonData) {
        List<Bar> bars = new ArrayList<>();
        JsonObject jsonObject = JsonParser.parseString(jsonData).getAsJsonObject();
        JsonArray barArray = jsonObject.getAsJsonArray("bars");

        for (int i = 0; i < barArray.size(); i++) {
            JsonObject barObject = barArray.get(i).getAsJsonObject();
            double close = barObject.get("c").getAsDouble();
            String dateStr = barObject.get("t").getAsString().split("T")[0];
            LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_DATE);
            bars.add(new Bar(date, close));
        }
        return bars;
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
            List<Bar> bars = fetchBars(ticker);

            if (bars != null) {
                GraphPanel graphPanel = new GraphPanel(bars);
                JFrame chartFrame = new JFrame("Stock Price Chart");
                chartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                chartFrame.setSize(800, 600);
                chartFrame.add(graphPanel);
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

class Bar {
    LocalDate date;
    double close;

    Bar(LocalDate date, double close) {
        this.date = date;
        this.close = close;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getClose() {
        return close;
    }
}

class GraphPanel extends JPanel {
    private List<Bar> bars;

    GraphPanel(List<Bar> bars) {
        this.bars = bars;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bars == null || bars.size() == 0) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int padding = 25;
        int labelPadding = 25;
        int pointWidth = 4;
        int numberYDivisions = 10;

        double minPrice = Double.MAX_VALUE;
        double maxPrice = Double.MIN_VALUE;
        for (Bar bar : bars) {
            if (bar.getClose() < minPrice) {
                minPrice = bar.getClose();
            }
            if (bar.getClose() > maxPrice) {
                maxPrice = bar.getClose();
            }
        }

        double xScale = ((double) width - 2 * padding - labelPadding) / (bars.size() - 1);
        double yScale = ((double) height - 2 * padding - labelPadding) / (maxPrice - minPrice);

        List<Point> graphPoints = new ArrayList<>();
        for (int i = 0; i < bars.size(); i++) {
            int x = (int) (i * xScale + padding + labelPadding);
            int y = (int) ((maxPrice - bars.get(i).getClose()) * yScale + padding);
            graphPoints.add(new Point(x, y));
        }

        g2.setColor(Color.WHITE);
        g2.fillRect(padding + labelPadding, padding, width - 2 * padding - labelPadding, height - 2 * padding - labelPadding);
        g2.setColor(Color.BLACK);

        for (int i = 0; i < numberYDivisions + 1; i++) {
            int x0 = padding + labelPadding;
            int x1 = pointWidth + padding + labelPadding;
            int y0 = height - ((i * (height - padding * 2 - labelPadding)) / numberYDivisions + padding + labelPadding);
            int y1 = y0;
            if (bars.size() > 0) {
                g2.setColor(Color.BLACK);
                String yLabel = String.format("%.2f", minPrice + (maxPrice - minPrice) * ((i * 1.0) / numberYDivisions));
                FontMetrics metrics = g2.getFontMetrics();
                int labelWidth = metrics.stringWidth(yLabel);
                g2.drawString(yLabel, x0 - labelWidth - 5, y0 + (metrics.getHeight() / 2) - 3);
            }
            g2.drawLine(padding + labelPadding, y0, width - padding, y1);
        }

        for (int i = 0; i < bars.size(); i++) {
            if (bars.size() > 1) {
                int x0 = i * (width - padding * 2 - labelPadding) / (bars.size() - 1) + padding + labelPadding;
                int x1 = x0;
                int y0 = height - padding - labelPadding;
                int y1 = y0 - pointWidth;
                if ((i % ((int) ((bars.size() / 20.0)) + 1)) == 0) {
                    g2.setColor(Color.BLACK);
                    String xLabel = bars.get(i).getDate().toString();
                    FontMetrics metrics = g2.getFontMetrics();
                    int labelWidth = metrics.stringWidth(xLabel);
                    g2.drawString(xLabel, x0 - labelWidth / 2, y0 + metrics.getHeight() + 3);
                }
                g2.drawLine(x0, height - padding - labelPadding, x1, padding);
            }
        }

        g2.drawLine(padding + labelPadding, height - padding - labelPadding, padding + labelPadding, padding);
        g2.drawLine(padding + labelPadding, height - padding - labelPadding, width - padding, height - padding - labelPadding);

        g2.setColor(Color.BLUE);
        for (int i = 0; i < graphPoints.size() - 1; i++) {
            int x1 = graphPoints.get(i).x;
            int y1 = graphPoints.get(i).y;
            int x2 = graphPoints.get(i + 1).x;
            int y2 = graphPoints.get(i + 1).y;
            g2.drawLine(x1, y1, x2, y2);
        }

        g2.setColor(Color.RED);
        for (Point point : graphPoints) {
            int x = point.x - pointWidth / 2;
            int y = point.y - pointWidth / 2;
            int ovalW = pointWidth;
            int ovalH = pointWidth;
            g2.fillOval(x, y, ovalW, ovalH);
        }
    }
}
