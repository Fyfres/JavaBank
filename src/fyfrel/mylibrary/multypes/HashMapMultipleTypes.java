package fyfrel.mylibrary.multypes;

import java.util.ArrayList;
import java.util.HashMap;


public class HashMapMultipleTypes extends HashMap {
    private ArrayList<Integer> integer_ = new ArrayList<Integer>();
    private int integerLength = 0;
    private ArrayList<Float> float_ = new ArrayList<Float>();
    private int floatLength = 0;
    private ArrayList<Double> double_ = new ArrayList<Double>();
    private int doubleLength = 0;
    private ArrayList<Byte> byte_ = new ArrayList<Byte>();
    private int byteLength = 0;
    private ArrayList<String> string_ = new ArrayList<String>();
    private int stringLength = 0;
    private ArrayList<Boolean> boolean_ = new ArrayList<Boolean>();
    private int booleanLength = 0;

    private int totalLength = 0;

    private HashMap<Integer, String[]> indexes = new HashMap<>();

    public void addValue(int toAdd) {
        this.integer_.add(toAdd);
        this.indexes.put(this.totalLength, new String[] {"Integer", String.valueOf(this.integerLength)});
        this.integerLength++;
        this.totalLength++;
    }

    public void addValue(String toAdd) {
        this.string_.add(toAdd);
        this.indexes.put(this.totalLength, new String[] {"String", String.valueOf(this.stringLength)});
        this.stringLength++;
        this.totalLength++;
    }

    public void addValue(Float toAdd) {
        this.float_.add(toAdd);
        this.indexes.put(this.totalLength, new String[] {"Float", String.valueOf(this.floatLength)});
        this.floatLength++;
        this.totalLength++;
    }

    public void addValue(Double toAdd) {
        this.double_.add(toAdd);
        this.indexes.put(this.totalLength, new String[] {"Double", String.valueOf(this.doubleLength)});
        this.doubleLength++;
        this.totalLength++;
    }

    public void addValue(Byte toAdd) {
        this.byte_.add(toAdd);
        this.indexes.put(this.totalLength, new String[] {"Byte", String.valueOf(this.byteLength)});
        this.byteLength++;
        this.totalLength++;
    }

    public void addValue(Boolean toAdd) {
        this.boolean_.add(toAdd);
        this.indexes.put(this.totalLength, new String[] {"Boolean", String.valueOf(this.booleanLength)});
        this.booleanLength++;
        this.totalLength++;
    }

    public Object getValue(int index) {
        ArrayList value = new ArrayList();
        switch (this.indexes.get(index)[0]) {
            case "Integer" :
                value.add(this.integer_.get(Integer.parseInt(this.indexes.get(index)[1])));
                break;
            case "String" :
                value.add(this.string_.get(Integer.parseInt(this.indexes.get(index)[1])));
                break;
            case "Float" :
                value.add(this.float_.get(Integer.parseInt(this.indexes.get(index)[1])));
                break;
            case "Double" :
                value.add(this.double_.get(Integer.parseInt(this.indexes.get(index)[1])));
                break;
            case "Byte" :
                value.add(this.byte_.get(Integer.parseInt(this.indexes.get(index)[1])));
                break;
            case "Boolean" :
                value.add(this.boolean_.get(Integer.parseInt(this.indexes.get(index)[1])));
                break;
            default :
                System.err.println("An error occurred while searching for the type of the returned value.");
                System.exit(0);
                break;
        }
        return value.get(0);
    }

    public int getSize() {
        return this.totalLength;
    }
}
