package loadfile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import Entity.plyno;

public class CreatePly extends CreateBase<plyno>
{

    private static final long serialVersionUID=-1897999143770006274L;
    public CreatePly(File obj)
    {
	this.obj=obj;
    }

    @Override
    public List<plyno> createplys() throws IOException
    {
	inFile=new InputStreamReader(new FileInputStream(this.obj),"ISO8859_1");
	brFile=new BufferedReader(inFile);
	while ((Line=brFile.readLine())!=null)
	{
	    plyno ply=new plyno();
	    ply.setPlyno(Line);
	    plys.add(ply);
	}

	return plys;
    }

}
