package differ;

import java.io.*;

/**
 * Created by def on 27.10.15.
 */
public class Differ {
    private PhoneData oldData;
    public static void main(String[] args) {
        if (args.length == 2) {
            Differ differ = new Differ();
            try {
                differ.process(args[0], args[1], "diff.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("arg1 oldFile, arg2 newFile");
        }
    }

    public void process(String oldFile, String newFile, String diffFile) throws IOException {
        oldData = new PhoneData();
        loadFile(oldFile);
        checkNewFile(newFile, diffFile);
    }

    private void loadFile(String file) throws IOException {
        FileInputStream fis = new FileInputStream(file);

        //Construct BufferedReader from InputStreamReader
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line = null;
        while ((line = br.readLine()) != null) {
            oldData.addData(line);
        }

        br.close();
    }

    private void checkNewFile(String file, String outFile) throws IOException {
        FileInputStream fis = new FileInputStream(file);

        //Construct BufferedReader from InputStreamReader
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        File fout = new File(outFile);
        FileOutputStream fos = new FileOutputStream(fout);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        String line = null;
        while ((line = br.readLine()) != null) {
            if (!oldData.contains(line)) {
                bw.write(line);
                bw.newLine();
            }
        }
        bw.close();
        br.close();
    }


}
