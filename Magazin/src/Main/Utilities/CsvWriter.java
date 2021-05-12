package Main.Utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class CsvWriter {
    String filePath;
    StringBuilder sb;

    public void setFilePath(String filePath) {
        this.filePath = filePath;

        sb = new StringBuilder();
        start();
    }

    public void add(String str){
        Timestamp ts = Timestamp.from(Instant.now());
        reportRecord(this.sb, str, ts.toString());
    }

    void start(){
        this.sb.append("nume_actiune,timestamp\n");
    }

    public static StringBuilder reportRecord( StringBuilder sb , String c1, String c2) {
        sb.append(c1);
        sb.append(",");
        sb.append(c2);
        sb.append("\n");
        return sb;
    }

    public void write(){
        String toWrite = this.sb.toString();
        try(PrintWriter printWriter = new PrintWriter(this.filePath)){
            printWriter.write(toWrite);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        System.out.println("Report generated;");
    }
}
