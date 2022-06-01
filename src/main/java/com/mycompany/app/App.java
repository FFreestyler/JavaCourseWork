package com.mycompany.app;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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

public class App {

  static Boolean flag = true;

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public static void main(String args[])
    throws IOException, InterruptedException {
    DataBase db = new DataBase();
    db.dropTable();
    db.createNewTable();
    ConsoleReader rc = new ConsoleReader(flag);
    Runnable r = rc;
    Thread t = new Thread(r);
    t.start();
    while (rc.getFlag()) {
      double mem = parseUsage("mem");
      double cpu = parseUsage("cpu");
      Double disk = parseTotalDiskUsage(
        "df -h --total | grep total | awk '{print $5}'"
      );
      db.pushRecords(cpu, mem, disk);
      Thread.sleep(1000);
    }
    t.join();
  }

  public static double parseUsage(String usage)
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
    return num > 100 ? 100 : num;
  }

  public static Double parseTotalDiskUsage(final String command)
    throws IOException {
    ProcessBuilder pb = new ProcessBuilder("bash", "-c", command);
    pb.redirectError();
    Process proc = pb.start();
    BufferedReader bf = new BufferedReader(
      new InputStreamReader(proc.getInputStream())
    );
    String s;
    s = bf.readLine();
    String value = "";
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != '%') value += s.charAt(i);
    }
    return Double.parseDouble(value);
  }
}
