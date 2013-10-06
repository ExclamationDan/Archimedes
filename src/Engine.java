// Daniel Martin Oct/6/2013
// Purpose: To create a single class for handling the game framework
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class Engine extends BasicGame
{
	// These will be removed. Camera/world class are todo.
	float XTrans = 0;
	float YTrans = 0;
	WorldSlice Slices[] = new WorldSlice[10];
		
	public static final Resource m_Resource = new Resource();
	

	public Engine(String gamename)
	{
		super(gamename);
		
	}

	@Override
	public void init(GameContainer gc) throws SlickException 
	{
		for (int i = 0; i < Slices.length; i++)
		{
			Slices[i] = new WorldSlice(i);
			Slices[i].Populate();
		}
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		//g.drawString("Test!", 100, 100);
		//SEnt.draw();
		
		// This is VERY temporary. It would be crazy to handle camera movement and drawing like this...
		if (gc.getInput().isKeyDown(Input.KEY_D))
		{
			XTrans -= 2;
		}
		else if (gc.getInput().isKeyDown(Input.KEY_A))
		{
			XTrans += 2;
		}
		if (gc.getInput().isKeyDown(Input.KEY_S))
		{
			YTrans -= 2;
		}
		else if (gc.getInput().isKeyDown(Input.KEY_W))
		{
			YTrans += 2;
		}
		
		g.translate(XTrans,YTrans);

		
		for (int i = 0; i < Slices.length; i++)
		{
			Slices[i].Draw();
		}
		g.setBackground(new Color(255,255,255));
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer Game = new AppGameContainer(new Engine("Placeholder"));
			Game.setDisplayMode(1024, 512, false);
			Game.start();

		}
		catch (SlickException ex)
		{
			Logger.getLogger(Engine.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	

}