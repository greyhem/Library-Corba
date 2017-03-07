import lib.*;
import java.util.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
class LibServer extends _LibraryImplBase
{
	static int ds=2,ait=4;
    	Scanner sc = new Scanner(System.in);
    	public static void main(String[] args) 
	{
      	 try
       	{	// create and initialize the ORB
                    	ORB orb = ORB.init(args, null);
            		// create server and register it with the //ORB
            		LibServer libRef = new LibServer();
            		orb.connect(libRef);
            		// get the root naming context
            		org.omg.CORBA.Object objRef =
            		orb.resolve_initial_references("NameService");
            		NamingContext ncRef = NamingContextHelper.narrow(objRef); 
            		NameComponent nc = new NameComponent ("Library", "");
            		NameComponent path[] = {nc};
            
            		ncRef.rebind(path, libRef);
            		System.out.println ("Server Started");
 	           	Thread.currentThread().join();

	}
        	catch (Exception e)
        	{
            		System.out.println(e);
        	}
}

 
	public int issue(int book) {
       	int f=0;
        	if(book==1 && ds>0)
        	{
            		ds=ds-1;
            		f=1;
            		System.out.println("total ds book:"+ds);
        	}
        	else if(book==2 && ait>0)
        	{
            		ait=ait-1;
            		f=1;
            		System.out.println("total ait book:"+ait);
        	}
        	else
	{
           		f=2;
        	}
        	return f;
    }

    
    	public int Return(int book) {
       	int f=0;
        	if(book==1)
        	{
            		ds=ds+1;
            		f=1;
            		System.out.println("total ds book:"+ds);
        	}
        	else if(book==2)
        	{
            		ait=ait+1;
            		f=1;
            		System.out.println("total ait book:"+ait);
        	}
        	return f;
    }
}
