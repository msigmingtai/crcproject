package loadfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import Entity.crcdata;

public class CreateCrc extends CreateBase<crcdata>
{

    /**
     * 
     */
    private static final long serialVersionUID=-8726551051094835677L;

    public CreateCrc(File obj)
    {
	this.obj=obj;
    }

    @Override
    public List<crcdata> createplys() throws IOException
    {

	inFile=new InputStreamReader(new FileInputStream(this.obj),"ISO8859_1");
	brFile=new BufferedReader(inFile);
	while ((Line=brFile.readLine())!=null)
	{
	    crcdata crc=new crcdata();
	    crc.setPlyno(Line.substring(7,17));
	    crc.setEndno(Line.substring(25,35));
	    crc.setData(new String(Line.getBytes("ISO8859_1"),"MS950"));
	    plys.add(crc);
	}

	return plys;
    }
}
