package LockScreen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager {

    private Set<String> initialProcesses;
    public void startMonitoring() throws Exception {
        initialProcesses = getActiveProcesses();
        while (true) {
            Set<String> currentProcesses = getActiveProcesses();
            for (String process : currentProcesses) {
                if (!initialProcesses.contains(process)) {
                    terminateProcess(process);
                }
            }
            Thread.sleep(1000);
        }
    }

    private Set<String> getActiveProcesses() throws Exception {
        Set<String> processes = new HashSet<>();
        Process process = Runtime.getRuntime().exec("tasklist");
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        Pattern pattern = Pattern.compile("^(?<name>\\S+)");
        while ((line = reader.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String name = matcher.group("name");
                processes.add(name);
            }
        }
        return processes;
    }

    private void terminateProcess(String processName) {
        try {
            Process killProcess = Runtime.getRuntime().exec("taskkill /IM " + processName + " /F");
            BufferedReader reader = new BufferedReader(new InputStreamReader(killProcess.getInputStream()));
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(killProcess.getErrorStream()));
            String line;
            while ((line = reader.readLine()) != null) {
            }
            while ((line = errorReader.readLine()) != null) {
            }
            killProcess.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
