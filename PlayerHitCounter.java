import edu.udo.cs.swtsf.core.Game;
import edu.udo.cs.swtsf.core.Target;
import edu.udo.cs.swtsf.core.TargetObserver;
import edu.udo.cs.swtsf.view.HudElement;
import edu.udo.cs.swtsf.view.HudElementOrientation;
import edu.udo.cs.swtsf.view.ViewManager;

public class PlayerHitCounter extends HudElement implements TargetObserver{

	private int counter;
		
	public PlayerHitCounter() {
		setOrientation(HudElementOrientation.TOP);
		setImagePath("HUD/Counter");
		setImageCutout(0, 0, 32, 32);	
		counter = -1;		
	}
	
	public void onAfterHitpointsChanged(Target target, int delta) {
		if(delta < 0) {
		counter = counter+1;
		setText(Integer.toString(counter));		
		}
	}		
	
	protected void afterAdded(ViewManager view, Game game) {		
		onAfterHitpointsChanged(game.getPlayer(), -1);
	}	
	
}
