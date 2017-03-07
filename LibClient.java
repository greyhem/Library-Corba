import java.util.Scanner;
import lib.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
public class LibClient {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try
        {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);
            // get the root naming context
            org.omg.CORBA.Object objRef =
            orb.resolve_initial_references("NameService");
            NamingContext ncRef = NamingContextHelper.narrow(objRef); 
          // lookup the Object Reference in Naming
            NameComponent nc = new NameComponent ("Library", "");
            NameComponent path[] = {nc};
            Library Ref = LibraryHelper.narrow(ncRef.resolve(path));
            System.out.println("---MENU---\nEnter your choice:\n1)ISSUE\n2)RETURN");
            int i=sc.nextInt();
                if(i==1)
                {
                    System.out.println("Enter the book you want to issue:\n1)ds\n2)ait");
                    int book=sc.nextInt();
                    int f=Ref.issue(book);
                    if(f==1)
                    {
                        System.out.println("successfully issued...");
                    }	
                    else if(f==2)
                        System.out.println("this book is not avilable in library....");
                }
                else if(i==2)
                {
                    System.out.println("Enter the book you want to Return:\n1)ds\n2)ait");
                    int book=sc.nextInt();
                    int f=Ref.Return(book);
                    if(f==1)
                    {
                        System.out.println("successfully Return...");
                    }
                    else System.out.println("Invalid book...");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
}
}
