package com.cannon.basegame;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

import com.cannon.basegame.not_mine.BasicTWLGameState;
import com.cannon.basegame.not_mine.RootPane;


public class PauseState extends BasicTWLGameState{

	PausePanel pausePanel;
	private boolean paused = true;
	
	public PauseState() {
		// TODO Auto-generated constructor stub
	}
	
	protected RootPane createRootPane(){
		RootPane rp = super.createRootPane();
		pausePanel = new PausePanel(this);
		rp.add(pausePanel);
		
		return rp;
	}
	
	protected void layoutRootPane(){
		pausePanel.setPosition(SlimeGame.WIDTH - SlimeGame.WIDTH / 2 - pausePanel.getWidth() / 2, pausePanel.getHeight() / 2);
		pausePanel.adjustSize();
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		GameState mainGameState = game.getState(SlimeGame.MAINGAMESTATE);
		mainGameState.render(container, game, g);
		Rectangle rect = new Rectangle(((MainGameState)mainGameState).getCamera().getX(),((MainGameState)mainGameState).getCamera().getY(),SlimeGame.WIDTH,SlimeGame.HEIGHT);
		g.setColor(new Color(0.2f,0.2f,0.2f,0.6f));
		g.fill(rect);		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		if(!paused){
			game.enterState(SlimeGame.MAINGAMESTATE);
			paused = true;
		}
		
	}

	@Override
	public int getID() {
		return SlimeGame.PAUSESTATE;
	}
	
	public void keyReleased(int key, char c){
		super.keyReleased(key, c);
		switch(key){
		case Input.KEY_P:
			paused = false;
			break;
			
		}
	}

}
