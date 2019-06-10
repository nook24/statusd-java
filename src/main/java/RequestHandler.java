import com.github.cliftonlabs.json_simple.JsonObject;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import monitoring.MonitoringCore;
import oshi.SystemInfo;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class RequestHandler implements HttpHandler {

    public void handle(HttpExchange t) throws IOException {

        MonitoringCore monitoring = new MonitoringCore();

        JsonObject jsonResponse = new JsonObject();
        JsonObject agent = new JsonObject();

        agent.put("Version", Statusd.getVersion());
        agent.put("Name", "Statusd-java");
        agent.put("Java_version", System.getProperty("java.version"));
        agent.put("Java_vendor", System.getProperty("java.vendor"));
        agent.put("Os_archc", System.getProperty("os.arch"));
        agent.put("Os_name", System.getProperty("os.name"));
        agent.put("Os_version", System.getProperty("os.version"));
        jsonResponse.put("Agent", agent);

        jsonResponse.put("CPU", monitoring.getCpuInfo());

        jsonResponse.put("OS", monitoring.getOsInfo());

        jsonResponse.put("Memory", monitoring.getMemoryInfo());

        jsonResponse.put("Disks", monitoring.getDiskInfo());

        t.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
        String response = jsonResponse.toJson();

        byte[] bytes = response.getBytes(StandardCharsets.UTF_8);

        t.sendResponseHeaders(200, bytes.length);
        OutputStream os = t.getResponseBody();
        os.write(bytes);
        os.close();
    }

}
