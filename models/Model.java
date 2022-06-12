package models;

import views.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Model {

    private JDialog dialog;
    private View view;
    private List<FileData> fileData;

    private String fileName = "persons.txt";

    private DefaultTableModel dtm = new DefaultTableModel();

    public Model(){
        fileData = new ArrayList<>();
        this.view = view;

    }

   public boolean readFromFile() throws IOException {
        File f = new File(fileName);
        fileData.clear();
        if (f.exists()) {
            if (f.length() > 0 ) {
                try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
                    for (String line; (line = br.readLine()) != null;){
                        String name = line.split(";")[0];
                        int age = Integer.parseInt(line.split(";")[1]);
                        fileData.add(new FileData(name, age));
                        System.out.println("Was able to read lines: " + line);
                        System.out.println("List check: " + fileData);

                    }
                    return true;

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                f.createNewFile();
                System.out.println("Was not able to read the file content!");
            }
        }
        return false;
   }
    public void addToTable( JDialog dialog){
        String[] header = new String[]{"Name", "Age"};
        String[][] content = new String[fileData.size()][2];
        for (int x =0; x < getFileData().size(); x++){
            content[x][0] = getFileData().get(x).getName();
            content[x][1] = String.valueOf(getFileData().get(x).getAge());

        }

        JTable table = new JTable(content, header);
        dialog.add(new JScrollPane(table));
        dialog.setTitle("Persons with age");

    }
    private void writeToFileToFile(String name, int age){
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true))) {
            String line = name + ";" + age;
            fw.write(line);
            fw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }




    //______________Setter_____________//


    public void setDtm(DefaultTableModel dtm) {
        this.dtm = dtm;
    }

    public void setFileData(List<FileData> fileData) {
        this.fileData = fileData;
    }

    public List<FileData> getFileData() {
        return fileData;
    }

    public String getFileName() {
        return fileName;
    }

    public DefaultTableModel getDtm() {
        return dtm;
    }
}
