package FancyCinemas.Dao.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

public class BaseDao {
    public String getElementField(String fileName, Integer colOfId, String name, Integer colOfField) {
        Scanner sc = null;
        // Read all the contents of database into the array
        try {
            sc = new Scanner(new File(fileName));
            sc.nextLine();
            //read in previous rows
            while (sc.hasNextLine()) {
                String[] lineInfo = sc.nextLine().split("/");
                if (lineInfo[colOfId].equals(name)) {
                    return lineInfo[colOfField];
                }
            }
        }
        // If have error when read in contents of database, stop and return false
        catch (Exception e) {
            return null;
        }
        return null;
    }

    public <E> E getElement(String fileName, Integer colOfId, String name, Function<String[],E>converter) {
        Scanner sc = null;
        // Read all the contents of database into the array
        try {
            sc = new Scanner(new File(fileName));
            sc.nextLine();
            //read in previous rows
            while (sc.hasNextLine()) {
                String[] lineInfo = sc.nextLine().split("/");
                if (lineInfo[colOfId].equals(name)) {
                    E e = converter.apply(lineInfo);
                    return e;
                }
            }
        }
        // If have error when read in contents of database, stop and return false
        catch (Exception e) {
            return null;
        }
        return null;
    }

    public <E> ArrayList<E> getAllElements(String fileName, Function<String[],E>converter) {
        Scanner sc = null;
        // array that store all the contents of database
        ArrayList<E> elements = new ArrayList<>();

        // Read all the contents of database into the array
        try {
            sc = new Scanner(new File(fileName));
            //skip the header
            sc.nextLine();
            //read in previous rows
            while (sc.hasNextLine()) {
                E e = converter.apply(sc.nextLine().split("/"));
                elements.add(e);
            }
        }
        // If have error when read in contents of database, stop and return false
        catch (Exception e) {
            return null;
        }
        return elements;
    }


    public Boolean insertNewRow(String fileName, String newRow) {
        Scanner sc = null;
        // array that store all the contents of database
        ArrayList<String> fileLines = new ArrayList<>();

        // Read all the contents of database into the array
        try {
            sc = new Scanner(new File(fileName));
            //add the header
            fileLines.add(sc.nextLine());
            //read in previous rows
            while (sc.hasNextLine()) {
                fileLines.add(sc.nextLine());
            }
            fileLines.add(newRow);
        }
        // If have error when read in contents of database, stop and return false
        catch (Exception e) {
            return false;
        }
        // Update the content of database
        FileWriter fw = null;
        try {
            fw = new FileWriter(fileName);
            for (String s : fileLines) {
                fw.write(s + "\n");
            }
        } catch (IOException e) {
            return false;
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    public Boolean deleteRow(String fileName, Integer colOfId, String name) {
        Scanner sc = null;
        // array that store all the contents of database
        ArrayList<String> fileLines = new ArrayList<>();

        // Read all the contents of database into the array
        try {
            sc = new Scanner(new File(fileName));
            //add the header
            fileLines.add(sc.nextLine());
            //read in previous rows
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] lineInfo = line.split("/");
                if (!lineInfo[colOfId].equals(name)) {
                    fileLines.add(line);
                }
            }
        }
        // If have error when read in contents of database, stop and return false
        catch (Exception e) {
            return false;
        }
        // Update the content of database
        FileWriter fw = null;
        try {
            fw = new FileWriter(fileName);
            for (String s : fileLines) {
                fw.write(s + "\n");
            }
        } catch (IOException e) {
            return false;
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    public Boolean updateElement(String fileName, String name, Integer noOfCol, Function<String, String> updateFunction) {
        Scanner sc = null;
        // array that store all the contents of database
        ArrayList<String> fileLines = new ArrayList<>();
        // Read all the contents of database into the array
        try {
            sc = new Scanner(new File(fileName));
            //add the header
            fileLines.add(sc.nextLine());
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] lineInfo = line.split("/");
                if (lineInfo[0].equals(name)) {
                    lineInfo[noOfCol] = updateFunction.apply(lineInfo[noOfCol]);
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < lineInfo.length; i++) {
                        if (i == lineInfo.length - 1) {
                            sb.append(lineInfo[i]);
                        } else {
                            sb.append(lineInfo[i] + "/");
                        }
                    }
                    fileLines.add(sb.toString());
                } else {
                    fileLines.add(line);
                }
            }
        } catch (Exception e) {
            return false;
        }

        // Update the content of database
        FileWriter fw = null;
        try {
            fw = new FileWriter(fileName);
            for (String s : fileLines) {
                fw.write(s + "\n");
            }
        } catch (IOException e) {
            return false;
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }


}
