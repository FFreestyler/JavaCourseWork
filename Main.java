import java.io.*;
import java.util.*;

class ConsoleReader implements Runnable {

  public Boolean flag;

  public ConsoleReader(Boolean flag) {
    this.flag = flag;
  }

  public Boolean getFlag() {
    return flag;
  }

  public void run() {
    Scanner sc = new Scanner(System.in);
    while (flag) {
      String read = sc.nextLine();
      if (read.equals("exit")) {
        flag = false;
      }
    }
    sc.close();
  }
}

class Main {

  static Boolean flag = true;

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public static void main(String args[])
    throws IOException, InterruptedException {
    ConsoleReader rc = new ConsoleReader(flag);
    Runnable r = rc;
    Thread t = new Thread(r);
    t.start();
    while (rc.getFlag()) {
      parseUsage("mem");
      parseUsage("cpu");
      parseTotalDiskUsage("df -h --total | grep total | awk '{print $5}'");
    }
    t.join();
  }

  public static void parseUsage(String usage)
    throws IOException, InterruptedException {
    ProcessBuilder pb = new ProcessBuilder("ps", "-eo", "%" + usage);
    pb.redirectError();
    Process proc = pb.start();
    BufferedReader bf = new BufferedReader(
      new InputStreamReader(proc.getInputStream())
    );
    String s;
    ArrayList<String> UsageList = new ArrayList<>();
    Double num = .0;
    while ((s = bf.readLine()) != null) {
      if (s.contains("%" + usage.toUpperCase())) {
        continue;
      }
      UsageList.add(s.replaceAll("\\s+", ""));
    }
    for (String str : UsageList) {
      num += Double.parseDouble(str);
    }
    //System.out.println(usage + ": " + num);
  }

  public static void parseTotalDiskUsage(final String command)
    throws IOException {
    ProcessBuilder pb = new ProcessBuilder("bash", "-c", command);
    pb.redirectError();
    Process proc = pb.start();
    BufferedReader bf = new BufferedReader(
      new InputStreamReader(proc.getInputStream())
    );
    String s;
    while ((s = bf.readLine()) != null) {
      //System.out.println("Disk: " + s);
    }
  }
}
