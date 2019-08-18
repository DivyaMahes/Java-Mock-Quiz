package QuizPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Quiz implements ActionListener {
	
	JFrame frame=new JFrame("Java Quiz");
	JLabel q=new JLabel();
	JRadioButton b[]=new JRadioButton[4];
	ButtonGroup bg=new ButtonGroup();
	JButton Next=new JButton("Next");
	JButton Result=new JButton("Result");
	static int count=1,mark=0;
	
	public Quiz()
	{
		frame.setSize(600, 350);
		frame.add(q);
		frame.add(Next);
		frame.add(Result);
		
		q.setBounds(30,20,600,30);
		Next.setBounds(120, 250, 75, 40);
		Result.setBounds(250, 250, 75, 40);
		Result.setEnabled(false);
		
		for(int i=0,j=50;i<4;i++,j=j+50)
		{
			b[i]=new JRadioButton();
			frame.add(b[i]);
			bg.add(b[i]);
			b[i].setBounds(75,j,300,50);
		}
		
		set();
	
		Next.addActionListener(this);
		Result.addActionListener(this);	
		frame.setLocation(250,100);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource()==Next)
		{
			if(checkans(count))
			{
				mark=mark+1;
			}
			count=count+1;
			bg.clearSelection();
			set();
			if(count==10)
			  {
				  Result.setEnabled(true);
				  Next.setEnabled(false);
			  }
		}
		
		if(event.getSource()==Result)
		{
			if(checkans(count))
			  {
				  mark=mark+1;
			  }
			result();
			System.exit(0);
		}
	}
	
	private void set()
	{
		    if(count==1)
		    {
		    	q.setText("Q1:  Which of these is NOT a valid keyword or reserved word in Java ?");
		    	b[0].setText("default");b[1].setText("null");b[2].setText("String");b[3].setText("volatile");	 	
		    }
		    
		    if(count==2)
			{
				q.setText("Q2.  Which operator will always evaluate all the Operands ?");
				b[0].setText("||");b[1].setText("&&");b[2].setText("?:");b[3].setText("%");	
			}
		  
		  if(count==3)
			{
				q.setText("Q3. Which of these operators is used to allocate memory to array variable in Java?");
				b[0].setText("malloc");b[1].setText("alloc");b[2].setText("new");b[3].setText("new malloc");
			} 
		  if(count==4)
		    {
			  q.setText("Q4. Which is the legal range of values for a short ?");
			  b[2].setEnabled(true);b[3].setEnabled(true);
			  b[0].setText("-128 to 127");b[1].setText("-256 to 255");b[2].setText(" -32768 to 32767");b[3].setText("0 to 65535");	  
		    }
		  if(count==5)
			{
				q.setText("Q5. Which of these is necessary to specify at time of array initialization?");
				b[0].setText("Row");b[1].setText("Column");b[2].setText("Both Row & Column");b[3].setText("none");
			}
		  if(count==6)
			{
				q.setText("Q6. Which of these are selection statements in Java?");
				b[0].setText("if()");b[1].setText("for()");b[2].setText("continue");b[3].setText("break");
			}
		  if(count==7)
			{
				q.setText("Q7. When does method overloading is determined?");
				b[0].setText("Run time");b[1].setText("compile time");b[2].setText("Coding time");b[3].setText("Execution time");
			}
		  if(count==8)
			{
				q.setText("Q8. What is it called if an object has its own lifecycle and there is no owner?");
				b[0].setText("Aggregation");b[1].setText("Composition");b[2].setText("Encapsulation");b[3].setText("Association");
			}
		  if(count==9)
			{
				q.setText("Q9. Which component is used to compile, debug and execute java program?");
				b[0].setText("JVM");b[1].setText("JDK");b[2].setText("JIT");b[3].setText("JRE");
			}
		  if(count==10)
			{
				q.setText("Q10. Which of the below is invalid identifier with the main method?");
				b[0].setText("public");b[1].setText("static");b[2].setText("private");b[3].setText("final");
			}	
	}
	
	public void result()
	{
		JOptionPane.showMessageDialog(frame, "Your mark is: "+mark);
	}
	
	private boolean checkans(int count)
	{
			if(count==1)
				return b[2].isSelected();
			if(count==2)
				return b[3].isSelected();
			if(count==3)
				return b[2].isSelected();
			if(count==4)
				return b[2].isSelected();
			if(count==5)
				return b[0].isSelected();
			if(count==6)
				return b[0].isSelected();
			if(count==7)
				return b[1].isSelected();
			if(count==8)
				return b[3].isSelected();
			if(count==9)
				return b[1].isSelected();
			if(count==10)
				return b[2].isSelected();
			else
				return false;	
     }
	
	
	public static void main(String[] args) {
		new Quiz();	
	}
    }
