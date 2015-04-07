package main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Entity.crcdata;
import Entity.plyno;

public class CreateData implements Runnable
{
    private List<crcdata> crcs=new ArrayList<crcdata>();
    private List<plyno> plys=new ArrayList<plyno>();
    private List<crcdata> outs=new ArrayList<crcdata>();
    private File outFile=null;

    public void data(List<crcdata> crcs)
    {
	this.crcs=crcs;
    }

    public void setCrcs(List<crcdata> createplys)
    {
	this.crcs=createplys;

    }

    public void setPlys(List<plyno> plys)
    {
	this.plys=plys;
    }

    @Override
    public void run()
    {
	try
	{
	    CreateDatas();
	}
	catch (IOException e)
	{
	    // TODO 自動產生的 catch 區塊
	    e.printStackTrace();
	}
    }

    private void CreateDatas() throws IOException
    {
	outFile=new File("D:\\CRC.txt");
	outFile.createNewFile();
	PrintWriter writer=new PrintWriter(outFile,"MS950");

	for(plyno p : plys)
	{
	    for(crcdata c : crcs)
	    {
		if(p.getPlyno().equals(c.getPlyno()))
		{
		    outs.add(c);
		}
		if(p.getPlyno().equals(c.getEndno()))
		{
		    outs.add(c);
		}
	    }
	}

	for(crcdata outfile : outs)
	{
	    writer.write(outfile.getData()+"\n");
	}
	writer.close();
	JOptionPane.showMessageDialog(null,"轉檔完成D:\\CRC.txt");
    }

}
