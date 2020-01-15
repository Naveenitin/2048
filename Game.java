import javax.swing.*;
import java.awt.event.*;
class Move
{	int [][]a=new int[4][4];
	public void random()
	{	int [][]t=new int[16][2];
		int count=0;
		for(int i=0;i<4;i++)
		{	
			for(int j=0;j<4;j++)
			{
				if(a[i][j]==0)
				{
					t[count][0]=i;
					t[count++][1]=j;
				}
			}
		}
		int p=(int) (Math.random()*count);
		a[t[p][0]][t[p][1]]=2;
	}
	public void left()
	{	int t;
		for(int i=0;i<4;i++)
		{	
			for(int j=0;j<3;j++)
			{	if(a[i][j]==0)
				{	t=j+1; 
					while(t<4  )
					{	if(a[i][t]!=0)
						{	a[i][j]=a[i][t];
							a[i][t]=0;
							break;
						}
						t++;
					}
				}
			}
		}
		
		for(int i=0;i<4;i++)
		{	 
			for(int j=0;j<3;j++)
			{	if(a[i][j]!=0 &&a[i][j]==a[i][j+1])
				{	a[i][j]=2*a[i][j];
					a[i][j+1]=0;
					t=j+2;
					while(t<4 )
					{
						a[i][t-1]=a[i][t];
						a[i][t]=0;
						t++;
					}
				}
			}
		}
		random();
	}
	public void right()
	{	int t;
		for(int i=0;i<4;i++)
		{	
			for(int j=3;j>0;j--)
			{	if(a[i][j]==0)
				{	t=j-1; 
					while(t>=0)
					{	if(a[i][t]!=0)
						{	a[i][j]=a[i][t];
							a[i][t]=0;
							break;
						}
						t--;
					}
				}
			} 
		}
		
		for(int i=0;i<4;i++)
		{	 
			for(int j=3;j>0;j--)
			{	if(a[i][j]!=0 &&a[i][j]==a[i][j-1])
				{	a[i][j]=2*a[i][j];
					a[i][j-1]=0;
					t=j-2;
					while(t>=0) 
					{
						a[i][t+1]=a[i][t];
						a[i][t]=0;
						t--;
					}
				}
			}
		}
		random();
	}
	public void up()
	{	int t;
		for(int j=0;j<4;j++)
		{	
			for(int i=0;i<3;i++)
			{	if(a[i][j]==0)
				{	t=i+1; 
					while(t<4  )
					{	if(a[t][j]!=0)
						{	a[i][j]=a[t][j];
							a[t][j]=0;
							break;
						}
						t++;
					}
				}
			}
		}
		
		for(int j=0;j<4;j++)
		{	 
			for(int i=0;i<3;i++)
			{	if(a[i][j]!=0 &&a[i][j]==a[i+1][j])
				{	a[i][j]=2*a[i][j];
					a[i+1][j]=0;
					t=i+2;
					while(t<4 )
					{
						a[t-1][j]=a[t][j];
						a[t][j]=0;
						t++;
					}
				}
			}
		}
		random();
		}
	public void down()
	{	int t;
		for(int j=0;j<4;j++)
		{	
			for(int i=3;i>0;i--)
			{	if(a[i][j]==0)
				{	t=i-1; 
					while(t>=0)
					{	if(a[t][j]!=0)
						{	a[i][j]=a[t][j];
							a[t][j]=0;
							break;
						}
						t--;
					}
				}
			} 
		}
		
		for(int j=0;j<4;j++)
		{	 
			for(int i=3;i>0;i--)
			{	if(a[i][j]!=0 &&a[i][j]==a[i-1][j])
				{	a[i][j]=2*a[i][j];
					a[i-1][j]=0;
					t=i-2;
					while(t>=0) 
					{
						a[t+1][j]=a[t][j];
						a[t][i]=0;
						t--;
					}
				}
			}
		}
		random();
	}
}
class G extends Move implements ActionListener
{	JTextField [][]tf;
	JFrame f;
	JButton l,r,u,d;
	public void mainWindow()
	{	random();
		random();
	
		f=new JFrame("Naveen");
		
		tf=new JTextField[4][4];
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				tf[i][j]=new JTextField();
				tf[i][j].setBounds(100+j*100,100+i*100,100,100);
				tf[i][j].setEditable(false);
				//tf[i][j].setText()
				f.add(tf[i][j]);
				
			}
		}
		
		l=new JButton("left");
		r=new JButton("right");
		u=new JButton("up");
		d=new JButton("down");
		
		display();
		
		l.setBounds(600,300,100,100);
		r.setBounds(800,300,100,100);
		u.setBounds(700,200,100,100);
		d.setBounds(700,300,100,100);
		
		f.add(l);
		f.add(r);
		f.add(u);
		f.add(d);
		
		l.addActionListener(this);
		r.addActionListener(this);
		u.addActionListener(this);
		d.addActionListener(this);
		
		f.setSize(900,700);
		f.setLayout(null);
		f.setVisible(true);
		
	}
	public void display()
	{
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{	if(a[i][j]==0)
					tf[i][j].setText("");
				else
					tf[i][j].setText(""+a[i][j]);
			}
		}
	}
	 
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==l)
		{
			left();
			display();
		}
		else if(e.getSource()==r)
		{
			right();
			display();
		}
		else if(e.getSource()==u)
		{
			up();
			display();
		}
		else if(e.getSource()==d)
		{
			down();
			display();
		}
	}
}
	
public class Game 
{
	public static void main(String []arg)
	{
		
		G g=new G();
		g.mainWindow();
		System.out.println("Naveen");
	}
}