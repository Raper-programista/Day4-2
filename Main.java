import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) {
	    List<String> l = Lista.getList();
	   	AccessRooms r = new AccessRooms();
	   //	r.uploadList(l);



		System.out.println(r.uploadList(l));
	}
}