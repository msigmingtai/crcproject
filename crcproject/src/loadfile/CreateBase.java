package loadfile;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class CreateBase<T> implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID=-2257966975390150799L;
    public List<T> plys=new ArrayList<T>();
    public InputStreamReader inFile;
    public BufferedReader brFile;
    public File obj;
    public String Line;

    public abstract List<T> createplys() throws IOException;
    /**
     * @param args
     */

}
