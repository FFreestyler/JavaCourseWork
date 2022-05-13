import static java.lang.System.out;

import java.io.*;
import java.net.*;
import java.security.cert.LDAPCertStoreParameters;
import java.util.*;

class Main {

  public static void main(String args[])
    throws IOException, InterruptedException {
    parseData();
  }

  public static void parseData() throws IOException, InterruptedException {
    ProcessBuilder pb = new ProcessBuilder(
      "ps",
      "-eo",
      "%cpu",
      "--sort",
      "-%cpu"
    );
    pb.redirectError();
    Process proc = pb.start();
    BufferedReader bf = new BufferedReader(
      new InputStreamReader(proc.getInputStream())
    );
    String s;
    ArrayList<String> CPUList = new ArrayList<>();
    Double num = .0;
    while ((s = bf.readLine()) != null) {
      if (s.contains("%CPU")) {
        continue;
      }
      CPUList.add(s.replaceAll("\\s+", ""));
    }
    for (String str : CPUList) {
      //System.out.println(str);
      num += Double.parseDouble(str);
    }
    System.out.println(num);
  }
}
