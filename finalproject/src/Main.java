import okhttp3.*;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    
    public static void graph(String ticker) {
        String apiKey = "YOUR_API_KEY";
        String apiSecret = "YOUR_API_SECRET";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://paper-api.alpaca.markets/v2/stocks/" + ticker + "/bars?limit=10")
                .get()
                .addHeader("APCA-API-KEY-ID", apiKey)
                .addHeader("APCA-API-SECRET-KEY", apiSecret)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String responseData = response.body().string();
            // Convert the response data to an array
            // You can use a JSON parsing library like Gson or Jackson to parse the response data into an array
            // Example using Gson:
            
            // Process the array and display it on the GUI
            // You can use a library like JavaFX or Swing to create the GUI and display the data
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void buildGUI() {
        JFrame frame = new JFrame("Stock Trading GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        JLabel tickerLabel = new JLabel("Stock Ticker:");
        JTextField tickerTextField = new JTextField(10);

        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityTextField = new JTextField(10);

        JButton buyButton = new JButton("Buy");
        JButton sellButton = new JButton("Sell");

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ticker = tickerTextField.getText();
                int quantity = Integer.parseInt(quantityTextField.getText());
                buy(ticker, quantity);
            }
        });

        sellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ticker = tickerTextField.getText();
                int quantity = Integer.parseInt(quantityTextField.getText());
                sell(ticker, quantity);
            }
        });

        frame.add(tickerLabel);
        frame.add(tickerTextField);
        frame.add(quantityLabel);
        frame.add(quantityTextField);
        frame.add(buyButton);
        frame.add(sellButton);

        frame.setVisible(true);
    }
    
}