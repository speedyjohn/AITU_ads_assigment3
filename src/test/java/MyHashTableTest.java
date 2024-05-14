import org.example.utils.classes.MyHashTable;
import org.example.utils.classes.MyTestingClass;
import org.example.utils.classes.Student;
import org.example.utils.classes.Utilities;

public class MyHashTableTest {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        for(int i = 0; i < 10000; i++){
            table.put(Utilities.testingClassGenerator(i), Utilities.studentGenerator(i));
        }

        int[] buckets = table.bucketsSize();
        int counter = 0;
        for(int i : buckets) if(i != 0){
            System.out.print(i + ", ");
            counter++;
        }
        System.out.println();
        System.out.println("Filled buckets: " + counter);
        System.out.println("\nFilled buckets percentage: "+ (counter * 100f / buckets.length));
        System.out.println("\nTotal buckets: " +  buckets.length);
    }
}