/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package json2class;

public class Library {
    public static Message j2c(String json) {
	try{
	    Message m = new Message(json);
	    System.out.println(json);
	    m.print();
            return m;
        }
	catch(Exception e){
	    return null;
	}

    }
}
