
public class ArrayLists {

    public static void main(String args[]) {
        // ArrayList<String> names = new ArrayList<String>();
        // names.add("A");
        // names.add(0, "B");
        // names.add("C");
        // names.remove(1);

        // System.out.print(names);
        // Using Wrappers instead of inserting primitive values into an ArrayList
        // ArrayList<Double> data = new ArrayList<Double>();
        // data.add(new Double(29.95));
        // double x = (data.get(0)).doubleValue();
        // Java 5.0 includes automatic conversion between primitive types and wrappers (Auto-boxing)
        // ArrayList<Double> data = new ArrayList<Double>();
        // data.add(29.95);
        // double x = data.get(0);
        // for each loop
        // double[] data = new double[10];
        // double sum = 0;
        // for (double e : data) {
        //     sum += e;
        // }
        // Copying arrays
        // Shallow copy
        // double[] data = new double[10];
        // double[] prices = data; // both point to the same array
        // Deep copy
        // double[] prices = (double[]) data.clone();
        // System.arraycopy(from, fromStart, to, toStart, count); or use System.arraycopy
        // Growing an array
        double[] data = new double[10];
        // 1. Create new array
        double[] newData = new double[2 * data.length];
        // 2. Copy all the elements into the new array
        System.arraycopy(data, 0, newData, 0, data.length);
        // 3. Store the reference to the new array in the array variable
        data = newData;
        
    }
}
