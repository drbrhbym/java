import java.io.*;

public class SerializedDemo2 implements Serializable {

	private static final long serialVersionUID = 1L;
	String s;
	transient int n;

	public SerializedDemo2(String s, int n) {
		this.s = s;
		this.n = n;
	}

	public static void main(String[] args) {
		try {
			SerializedDemo2 st = new SerializedDemo2("Good luck", 3);
			System.out.println("s = " + st.s + ", n = " + st.n);
			FileOutputStream fos = new FileOutputStream("res/out1.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(st);
			FileInputStream fis = new FileInputStream("res/out1.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			SerializedDemo2 st1 = (SerializedDemo2) ois.readObject();
			System.out.println("s = " + st1.s + ", n = " + st1.n);
			oos.close();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}