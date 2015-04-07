package main;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Font;

import loadfile.CreateCrc;
import loadfile.CreatePly;

/**
 * 
 * @author 50123
 * @category 火險中再篩選無查詢續號檔
 */
public class Frame
{

    private JFrame frame;
    private File ply;
    private File Crc;
    private JFileChooser fc=new JFileChooser();

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
	EventQueue.invokeLater(new Runnable()
	{
	    public void run()
	    {
		try
		{
		    Frame window=new Frame();
		    window.frame.setVisible(true);
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the application.
     */
    public Frame()
    {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
	frame=new JFrame();
	frame.setTitle("\u4E2D\u518D\u6A94\u7BE9\u9078");
	frame.setBounds(100,100,321,178);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	final JLabel lblNewLabel=new JLabel("\u8ACB\u9078\u64C7\u6F0F\u6389\u7684\u4FDD\u55AE\u865F(\u6279\u55AE\u865F)");
	lblNewLabel.setFont(new Font("新細明體",Font.PLAIN,12));
	lblNewLabel.setBounds(129,18,168,19);
	frame.getContentPane().add(lblNewLabel);
	frame.setLocationRelativeTo(null);
	final JLabel lblcrc=new JLabel("\u9078\u64C7\u91CD\u65B0\u7522\u751F\u4E2D\u518D\u6A94CRC");
	lblcrc.setFont(new Font("新細明體",Font.PLAIN,12));
	lblcrc.setBounds(129,60,151,19);
	frame.getContentPane().add(lblcrc);
	JButton button=new JButton("\u4FDD\u55AE\u865F");
	button.setBounds(14,13,101,29);
	frame.getContentPane().add(button);
	frame.setResizable(false);
	JButton button_1=new JButton("\u4E2D\u518D\u6A94");
	button_1.setBounds(14,55,101,29);
	frame.getContentPane().add(button_1);
	JButton button_2=new JButton("\u7BE9\u9078");
	button_2.setBounds(14,97,101,29);
	frame.getContentPane().add(button_2);

	button_1.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		fc.showOpenDialog(null);
		Crc=fc.getSelectedFile();
		if(Crc!=null)
		    lblcrc.setText(Crc.getAbsolutePath());
	    }
	});
	button_2.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		CreateData data=new CreateData();
		try
		{
		    data.setCrcs(new CreateCrc(Crc).createplys());
		    data.setPlys(new CreatePly(ply).createplys());
		    new Thread(data).start();
		}
		catch (Exception e1)
		{
		   JOptionPane.showMessageDialog(null,e1.getStackTrace());
		}
	    }
	});
	button.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent arg0)
	    {
		fc.showOpenDialog(null);
		ply=fc.getSelectedFile();
		if(ply!=null)
		    lblNewLabel.setText(ply.getAbsolutePath());
	    }
	});

    }
}
