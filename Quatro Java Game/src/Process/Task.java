package Process;

// Frank
public abstract class Task
{

	public final void run()
	{
		if(validate())
		{
			execute();
		}
	}
	

	public abstract boolean validate();
	public abstract void execute();
}
