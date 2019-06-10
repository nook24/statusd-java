
import com.github.cliftonlabs.json_simple.JsonObject;
import com.sun.net.httpserver.HttpServer;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.Sensors;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.util.Util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class Statusd {

    private static long previousTime;

    public static String getVersion() {
        return "1.0.0-alpha";
    }

    public static void main(String[] args) {
        // Ausgabe Hello World!
        System.out.println("Hello World!");

        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();

        JsonObject foobar = new JsonObject();
        foobar.put("Name", "statusd-java");
        foobar.put("Version", "1.0.0-alpha");

        System.out.println(foobar.toJson());

        Sensors sensors = hal.getSensors();
        System.out.println(sensors.getCpuTemperature());

        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/", new RequestHandler());
            server.setExecutor(null); // creates a default executor
            server.start();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {

            CentralProcessor cpu = hal.getProcessor();
            System.out.println(cpu.getName());

            GlobalMemory mem = hal.getMemory();

            System.out.println(mem.getTotal());

            OperatingSystem os = si.getOperatingSystem();

            OSProcess[] processes = os.getProcesses(0, null);

            System.out.println("PID    %CPU    %MEM    VSZ    RSS   Name");
            for (OSProcess process : processes) {
                System.out.printf("%s    0    0    %s    %s    %s\n", process.getProcessID(), process.getVirtualSize(), process.getResidentSetSize(), process.getName());
            }

            for (int i = 0; i < 10; i++) {
                cpuUtilizationPerProcess();
                Util.sleep(5000);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    public static void cpuUtilizationPerProcess() {
        SystemInfo systemInfo = new SystemInfo();
        CentralProcessor processor = systemInfo.getHardware().getProcessor();
        int cpuNumber = processor.getLogicalProcessorCount();

        int processId = systemInfo.getOperatingSystem().getProcessId();
        OSProcess process = systemInfo.getOperatingSystem().getProcess(processId);
        long currentTime = process.getKernelTime() + process.getUserTime();
        long timeDifference = currentTime - previousTime;

        double processCpu = (100 * (timeDifference / 5000d)) / cpuNumber;
        previousTime = currentTime;

        System.out.format("K: %d, U: %d, diff: %d, %%CPU: %.1f%n", process.getKernelTime(), process.getUserTime(),
                timeDifference, processCpu);
    }
}